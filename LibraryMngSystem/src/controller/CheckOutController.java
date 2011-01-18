/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.AccessBook;
import model.AccessBorrow;
import model.AccessEmp;
import model.AccessFee;
import model.LibUtil;
import model.LibValid;
import view.CheckOutDialog;
import entity.BorrowDetail;
import entity.Employee;
import entity.Fee;

/**
 * Check out controller, control check out dialog
 * 
 * @author CuongNQ
 */
public class CheckOutController {

	// Defined
	private CheckOutDialog view;
	private DefaultTableModel bothModel;
	private DefaultTableModel outModel;
	private ManageController parent;
	private Vector vt;
	private HashSet set;
	private TreeMap map;
	private int empID;
	private Fee fee;
	private float borFee, lateFee;
	private BorrowDetail borDetail;
	private int page;
	private Integer totalRow;
	private boolean isSearchEmp;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param bothModel
	 * @param outModel
	 * @param parent
	 */
	public CheckOutController(CheckOutDialog view, DefaultTableModel bothModel,
			DefaultTableModel outModel, ManageController parent) {
		this.view = view;
		this.bothModel = bothModel;
		this.outModel = outModel;
		this.parent = parent;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {

		// Set default page
		page = 1;
		totalRow = 1;
		// Get fee setting
		fee = AccessFee.getInstance().getFee();
		borFee = fee.getBorFee();
		lateFee = fee.getLateFee();
		view.getLblFee().setText(
				"$" + Float.toString(borFee) + "/Day | $"
						+ Float.toString(lateFee) + "/Late Day");

		// Set default issue date and due date
		view.getTxtIssueDate().setDate(new java.util.Date());
		view.getTxtDueDate().setDate(
				new java.util.Date(new java.util.Date().getTime() + 432000000));

		// Create new map
		map = new TreeMap();
		// Create new set
		set = new HashSet();
		// Set selection mode;
		view.getTblBoth().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Add check out model
		view.getTblCheckOut().setModel(outModel);

		// Add event cancel btn
		view.getBtnCancel().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				borDetail = null;
				parent.removeModel(outModel);
				view.dispose();
			}
		});

		// Add window event
		view.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent evt) {
				borDetail = null;
				parent.removeModel(outModel);
			}
		});

		// Add event search book btn
		view.getBtnSearchBook().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				page = 1;
				searchBook();
			}
		});

		// Add event search employee btn
		view.getBtnSearchEmp().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				page = 1;
				searchEmp();
			}
		});

		// Add event check out btn
		view.getBtnCheckOut().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!set.isEmpty() && empID > 0) {
					int sure = JOptionPane.showConfirmDialog(view,
							"You sure all information is correct!",
							"Checking-out", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);

					if (sure == JOptionPane.OK_OPTION) {
						checkOut();
						parent.removeModel(outModel);
						view.dispose();
					}
				} else {
					JOptionPane.showMessageDialog(view,
							"All information not correct!", "Check-out",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		// Add event double click to select book
		view.getTblBoth().addMouseListener(new MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				// If double click display edit employee dialog
				if (evt.getClickCount() == 2) {
					if (!isSearchEmp) {
						selectBook();
					} else {
						selectEmployee();
					}
				}
			}
		});

		// Add event double click to deselect book
		view.getTblCheckOut().addMouseListener(new MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				// If double click display edit employee dialog
				if (evt.getClickCount() == 2) {
					deselectBook();
				}
			}
		});

		// Add event navigation btn
		view.getBtnNext().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (page == LibUtil.getInstance().getPage(totalRow)
						|| LibUtil.getInstance().getPage(totalRow) == 0) {
					return;
				} else {
					page++;
					if (isSearchEmp) {
						searchEmp();
					} else {
						searchBook();
					}
				}
			}
		});
		view.getBtnBack().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (page != 1 && LibUtil.getInstance().getPage(totalRow) != 0) {
					page--;
				}
				if (isSearchEmp) {
					searchEmp();
				} else {
					searchBook();
				}
			}
		});
		view.getBtnFirst().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				page = 1;
				if (isSearchEmp) {
					searchEmp();
				} else {
					searchBook();
				}
			}
		});
		view.getBtnLast().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				page = LibUtil.getInstance().getPage(totalRow);
				if (isSearchEmp) {
					searchEmp();
				} else {
					searchBook();
				}
			}
		});
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * Check out process
	 */
	private void checkOut() {
		// Add borrow details for each book
		java.util.Iterator it = set.iterator();
		while (it.hasNext()) {
			borDetail = new BorrowDetail();
			borDetail.setBookID(Integer.parseInt(it.next().toString()));
			borDetail.setIssueDate(view.getTxtIssueDate().getDate().getTime());
			borDetail.setDueDate(view.getTxtDueDate().getDate().getTime());
			map.put(borDetail.getBookID(), borDetail);
		}
		AccessBorrow.getInstance().checkOut(empID, map);
	}

	/**
	 * Select employee to check out
	 */
	private void selectEmployee() {
		// Get field employee selected
		String empID = view.getTblBoth()
				.getValueAt(view.getTblBoth().getSelectedRow(), 0).toString();
		this.empID = new Integer(empID);
		Employee emp = AccessEmp.getInstance().getEmpInfo(this.empID);
		// Set all information
		view.getLblID().setText(new Integer(emp.getEmpID()).toString());
		view.getLblName().setText(emp.getName());
		String DOB = new Date(emp.getDOB()).toString();

		view.getLblDOB().setText(LibUtil.getInstance().convertDate(DOB));
		if (emp.getGender() == 1) {
			view.getLblGender().setText("Male");
		} else {
			view.getLblGender().setText("Female");
		}
		view.getLblAddress().setText(emp.getAddress());
		view.getLblPhone().setText(emp.getPhone());
		view.getLblDepart().setText(emp.getDepartment());
		if (emp.getPermission() == 1) {
			view.getLblPermission().setText("Librarian");
		} else {
			view.getLblPermission().setText("Employee");
		}
	}

	/**
	 * Deselect book
	 */
	private void deselectBook() {
		// Get field book selected
		String field = view.getTblCheckOut()
				.getValueAt(view.getTblCheckOut().getSelectedRow(), 0)
				.toString();
		outModel.removeRow(view.getTblCheckOut().getSelectedRow());
		set.remove(field);
		view.getTblCheckOut().setFocusable(false);
	}

	/**
	 * Select a book to check out
	 */
	private void selectBook() {
		vt = new Vector();
		Integer noInLib;
		// Add info book to checkout table
		for (int i = 0; i < 8; i++) {
			// Get field book selected
			String field = view.getTblBoth()
					.getValueAt(view.getTblBoth().getSelectedRow(), i)
					.toString();
			// if it field is no in copy, get it
			if (i == 7) {
				String[] temp = field.split("/");
				noInLib = Integer.parseInt(temp[1]);
				// If of store book
				if (noInLib == 0) {
					JOptionPane.showMessageDialog(view, "Out of stock!",
							"Warning!", JOptionPane.INFORMATION_MESSAGE);
					// If out of stock remove it on set
					set.remove(view.getTblBoth()
							.getValueAt(view.getTblBoth().getSelectedRow(), 0)
							.toString());
					return;
				}
			} else if (i == 0) {// get bookID
				// if it have added return
				if (!set.add(field)) {
					return;
				} else {
					vt.addElement(field);
				}
			} else {
				vt.addElement(field);
			}
		}
		outModel.addRow(vt);
	}

	/**
	 * Search employee by Id or name
	 */
	public void searchEmp() {

		isSearchEmp = true;
		// Clear column
		bothModel.setColumnCount(0);
		parent.removeModel(bothModel);
		// Set employee model
		bothModel.addColumn("ID");
		bothModel.addColumn("Name");
		bothModel.addColumn("Gender");
		bothModel.addColumn("Email");
		bothModel.addColumn("Department");
		bothModel.addColumn("Permission");

		// Add employee model to table
		view.getTblBoth().setModel(bothModel);
		// Change title
		view.getScrPanBoth().setBorder(
				javax.swing.BorderFactory
						.createTitledBorder("Employee Information"));
		if (!LibValid.getInstance().EmpID(view.getTxtEmpID().getText())) {
			JOptionPane.showMessageDialog(view, "Employee Number not valid!",
					"Search", JOptionPane.ERROR_MESSAGE);
		} else {
			new Thread(new Runnable() {

				public void run() {
					totalRow = AccessEmp.getInstance().searchEmp(bothModel,
							view.getTxtEmpID().getText(),
							view.getTxtEmpName().getText(), (page - 1));
					view.getLblPage().setText(
							"Page " + page + "/"
									+ LibUtil.getInstance().getPage(totalRow));
				}
			}).start();
		}
	}

	/**
	 * Method search Book
	 */
	private void searchBook() {

		isSearchEmp = false;
		// Clear column
		bothModel.setColumnCount(0);
		parent.removeModel(bothModel);
		// Set book model
		bothModel.addColumn("ID");
		bothModel.addColumn("Call Number");
		bothModel.addColumn("ISBN");
		bothModel.addColumn("Title");
		bothModel.addColumn("Author");
		bothModel.addColumn("Publisher");
		bothModel.addColumn("Subject");
		bothModel.addColumn("Copies/Store");
		// Add book model to table
		view.getTblBoth().setModel(bothModel);
		// Change title
		view.getScrPanBoth().setBorder(
				javax.swing.BorderFactory
						.createTitledBorder("Book Information"));
		new Thread(new Runnable() {

			public void run() {
				totalRow = AccessBook.getInstance().searchBook(bothModel,
						view.getTxtCallNumber().getText(),
						view.getTxtISBN().getText(),
						view.getTxtTitle().getText(),
						view.getTxtAuth().getText(), (page - 1));
				view.getLblPage().setText(
						"Page " + page + "/"
								+ LibUtil.getInstance().getPage(totalRow));
			}
		}).start();
	}

	/**
	 * @return the view
	 */
	public CheckOutDialog getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(CheckOutDialog view) {
		this.view = view;
	}

	/**
	 * @return the borDetail
	 */
	public BorrowDetail getBorDetail() {
		return borDetail;
	}

	/**
	 * @param borDetail
	 *            the borDetail to set
	 */
	public void setBorDetail(BorrowDetail borDetail) {
		this.borDetail = borDetail;
	}
}
