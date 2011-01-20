/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.AccessBorrow;
import model.AccessEmp;
import model.AccessFee;
import model.LibUtil;
import model.LibValid;
import view.CheckInDialog;
import entity.CheckIn;
import entity.Employee;
import entity.Fee;

/**
 * Check in controller, control check in dialog
 * 
 * @author CuongNQ
 */
public class CheckInController {

	// Defined
	private CheckInDialog view;
	private DefaultTableModel searchModel;
	private DefaultTableModel inModel;
	private ManageController parent;
	private CheckIn checkin;
	private Vector<Object> vt;
	private Set<?> keyset;
	private Iterator<?> it;
	private HashSet<Object> set;
	private TreeMap<Object, CheckIn> map;
	private float borFee, lateFee;
	private int page;
	private int totalRow;
	private boolean isSearchEmp;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param searchModel
	 * @param inModel
	 * @param parent
	 */
	public CheckInController(CheckInDialog view, DefaultTableModel searchModel,
			DefaultTableModel inModel, ManageController parent) {
		this.view = view;
		this.searchModel = searchModel;
		this.inModel = inModel;
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
		Fee fee = AccessFee.getInstance().getFee();
		borFee = fee.getBorFee();
		lateFee = fee.getLateFee();
		view.getLblFee().setText(
				Messages.getString("CheckInController.6")
						+ Float.toString(borFee)
						+ Messages.getString("CheckInController.7") //$NON-NLS-1$ 
						+ Float.toString(lateFee)
						+ Messages.getString("CheckInController.8")); //$NON-NLS-1$

		// Create new map
		map = new TreeMap<Object, CheckIn>();
		// Create new set
		set = new HashSet<Object>();

		// Set default issue day and return day
		view.getTxtReturnDate().setDate(new java.util.Date());
		// Set selection mode
		view.getTblBoth().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Add search model
		view.getTblBoth().setModel(searchModel);

		// Add check in model
		view.getTblCheckIn().setModel(inModel);

		// Add event cancel btn
		view.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				checkin = null;
				removeModel();
				view.dispose();
			}
		});

		// Add event search borID btn
		view.getBtnSearchBor().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				searchBorID();
			}
		});

		// Add event search book info btn
		view.getBtnSearchBook().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				searchByBookInfo();
			}
		});

		// Add event search emp info btn
		view.getBtnSearchEmp().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = 1;
				searchByEmpInfo();
			}
		});

		// Add event double click to select borrow detail
		view.getTblBoth().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				getInfoSelected();
				// If double click display edit employee dialog
				if (evt.getClickCount() == 2) {
					selectBook();
				}
			}
		});

		// Add event double click to deselect borrow detail
		view.getTblCheckIn().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				// If double click display edit employee dialog
				if (evt.getClickCount() == 2) {
					deselectBook();
				}
			}
		});

		// Add window event
		view.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent evt) {
				checkin = null;
				removeModel();
			}
		});

		// Add event check in btn
		view.getBtnCheckIn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (inModel.getRowCount() > 0) {
					int sure = JOptionPane.showConfirmDialog(
							view,
							Messages.getString("CheckInController.9"), //$NON-NLS-1$
							Messages.getString("CheckInController.10"),
							JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);

					if (sure == JOptionPane.OK_OPTION) {
						checkIn();
						removeModel();
						view.dispose();
					}
				} else {
					JOptionPane.showMessageDialog(view,
							Messages.getString("CheckInController.11"),
							Messages.getString("CheckInController.12"), //$NON-NLS-1$ 
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		// Add event enter key press
		view.getTxtAuth().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					searchByBookInfo();
				}
			}
		});
		view.getTxtBorID().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					searchBorID();
				}
			}
		});
		view.getTxtCallNumber().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					searchByBookInfo();
				}
			}
		});
		view.getTxtEmpID().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					searchByEmpInfo();
				}
			}
		});
		view.getTxtEmpName().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					searchByEmpInfo();
				}
			}
		});
		view.getTxtISBN().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					searchByBookInfo();
				}
			}
		});
		view.getTxtTitle().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					searchByEmpInfo();
				}
			}
		});

		// Add event navigation btn
		view.getBtnNext().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (page == LibUtil.getInstance().getPage(totalRow)
						|| LibUtil.getInstance().getPage(totalRow) == 0) {
					return;
				} else {
					page++;
					if (isSearchEmp) {
						searchByEmpInfo();
					} else {
						searchByBookInfo();
					}
				}
			}
		});
		view.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (page != 1 && LibUtil.getInstance().getPage(totalRow) != 0) {
					page--;
				}
				if (isSearchEmp) {
					searchByEmpInfo();
				} else {
					searchByBookInfo();
				}
			}
		});
		view.getBtnFirst().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = 1;
				if (isSearchEmp) {
					searchByEmpInfo();
				} else {
					searchByBookInfo();
				}
			}
		});
		view.getBtnLast().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = LibUtil.getInstance().getPage(totalRow);
				if (isSearchEmp) {
					searchByEmpInfo();
				} else {
					searchByBookInfo();
				}
			}
		});
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * Check in process
	 */
	private void checkIn() {
		for (int i = 0; i < inModel.getRowCount(); i++) {
			// Get field borID selected
			int borID = Integer.parseInt(view.getTblCheckIn().getValueAt(i, 0)
					.toString());
			// Get field bookID selected
			String bookID = view.getTblCheckIn().getValueAt(i, 1).toString();
			// Get return date
			long returnDate = view.getTxtReturnDate().getDate().getTime();
			// Get total fee
			float totalFee = Float.parseFloat(view.getTblCheckIn()
					.getValueAt(i, 6).toString());
			// Update on database
			AccessBorrow.getInstance().checkIn(borID, Integer.parseInt(bookID),
					returnDate, totalFee);
		}
	}

	/**
	 * Remove book for check in
	 */
	private void deselectBook() {
		String bookID = view.getTblCheckIn()
				.getValueAt(view.getTblCheckIn().getSelectedRow(), 1)
				.toString();
		String borId = view.getTblCheckIn()
				.getValueAt(view.getTblCheckIn().getSelectedRow(), 0)
				.toString();
		inModel.removeRow(view.getTblCheckIn().getSelectedRow());
		set.remove(borId + Messages.getString("CheckInController.0") + bookID); //$NON-NLS-1$
	}

	/**
	 * Get borrow from map to search table
	 */
	private void getBorrow() {
		keyset = map.keySet();
		it = keyset.iterator();
		while (it.hasNext()) {
			checkin = map.get(it.next());
			vt = new Vector<Object>();
			vt.add(checkin.getBorID());
			vt.add(checkin.getEmpID());
			vt.add(checkin.getBookID());
			vt.add(checkin.getCallNumber());
			vt.add(checkin.getTitle());
			vt.add(checkin.getAuth());
			vt.add(checkin.getPublisher());
			vt.add(LibUtil.getInstance().convertDate(
					new Date(checkin.getDueDate()).toString()));
			searchModel.addRow(vt);
		}
	}

	/**
	 * @return the check in
	 */
	public CheckIn getCheckin() {
		return checkin;
	}

	/**
	 * Get employee information & issue date
	 */
	private void getInfoSelected() {
		// Get field employee selected
		String empID = view.getTblBoth()
				.getValueAt(view.getTblBoth().getSelectedRow(), 1).toString();
		Employee emp = AccessEmp.getInstance().getEmpInfo(
				Integer.parseInt(empID));
		// Set all employee information
		view.getLblID().setText(new Integer(emp.getEmpID()).toString());
		view.getLblName().setText(emp.getName());
		String DOB = new Date(emp.getDOB()).toString();

		view.getLblDOB().setText(LibUtil.getInstance().convertDate(DOB));
		if (emp.getGender() == 1) {
			view.getLblGender().setText(
					Messages.getString("CheckInController.1")); //$NON-NLS-1$
		} else {
			view.getLblGender().setText(
					Messages.getString("CheckInController.2")); //$NON-NLS-1$
		}
		view.getLblAddress().setText(emp.getAddress());
		view.getLblPhone().setText(emp.getPhone());
		view.getLblDepart().setText(emp.getDepartment());
		if (emp.getPermission() == 1) {
			view.getLblPermission().setText(
					Messages.getString("CheckInController.3")); //$NON-NLS-1$
		} else {
			view.getLblPermission().setText(
					Messages.getString("CheckInController.4")); //$NON-NLS-1$
		}
		// Get field borID selected
		String borID = view.getTblBoth()
				.getValueAt(view.getTblBoth().getSelectedRow(), 0).toString();
		// Get field bookID selected
		String bookID = view.getTblBoth()
				.getValueAt(view.getTblBoth().getSelectedRow(), 2).toString();
		// Set all check-in information
		checkin = map.get(borID
				+ Messages.getString("CheckInController.5") + bookID); //$NON-NLS-1$
		view.getTxtIssueDate().setDate(
				new java.util.Date(checkin.getIssueDate()));
	}

	/**
	 * @return the view
	 */
	public CheckInDialog getView() {
		return view;
	}

	/**
	 * Clear all model
	 */
	private void removeModel() {
		parent.removeModel(searchModel);
		parent.removeModel(inModel);
	}

	/**
	 * Search Borrow by borrow ID
	 */
	private void searchBorID() {
		if (!LibValid.getInstance().BorID(view.getTxtBorID().getText())) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("CheckInController.13"), //$NON-NLS-1$
					Messages.getString("CheckInController.14"),
					JOptionPane.ERROR_MESSAGE);
		} else {
			parent.removeModel(searchModel);
			map.clear();
			if (view.getTxtBorID().getText().length() > 0) {
				AccessBorrow.getInstance().searchCheckOutByBorID(map,
						Integer.parseInt(view.getTxtBorID().getText()));
				getBorrow();
			}
		}
	}

	/**
	 * Search book
	 */
	private void searchByBookInfo() {
		isSearchEmp = false;
		parent.removeModel(searchModel);
		map.clear();
		totalRow = AccessBorrow.getInstance().searchCheckOutByBookInfo(map,
				view.getTxtCallNumber().getText(), view.getTxtISBN().getText(),
				view.getTxtTitle().getText(), view.getTxtAuth().getText(),
				(page - 1));
		view.getLblPage().setText(
				Messages.getString("CheckInController.15") + page
						+ Messages.getString("CheckInController.16")
						+ LibUtil.getInstance().getPage(totalRow));
		getBorrow();
	}

	/**
	 * Search employee
	 */
	private void searchByEmpInfo() {
		isSearchEmp = true;
		if (!LibValid.getInstance().EmpID(view.getTxtEmpID().getText())) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("CheckInController.17"), //$NON-NLS-1$
					Messages.getString("CheckInController.18"),
					JOptionPane.ERROR_MESSAGE);
		} else {
			parent.removeModel(searchModel);
			map.clear();
			totalRow = AccessBorrow.getInstance().searchCheckOutByEmpInfo(map,
					view.getTxtEmpID().getText(),
					view.getTxtEmpName().getText(), (page - 1));
			view.getLblPage().setText(
					Messages.getString("CheckInController.19") + page
							+ Messages.getString("CheckInController.20") //$NON-NLS-1$ 
							+ LibUtil.getInstance().getPage(totalRow));
			getBorrow();
		}
	}

	/**
	 * Calculate borrow info and select book prepare to check in
	 */
	private void selectBook() {
		// Get field borID selected
		String borID = view.getTblBoth()
				.getValueAt(view.getTblBoth().getSelectedRow(), 0).toString();
		// Get field bookID selected
		String bookID = view.getTblBoth()
				.getValueAt(view.getTblBoth().getSelectedRow(), 2).toString();
		// If this book is'n selected
		if (set.add(borID + Messages.getString("CheckInController.21") + bookID)) { //$NON-NLS-1$
			// Set all check-in information
			checkin = map.get(borID
					+ Messages.getString("CheckInController.22") + bookID); //$NON-NLS-1$
			// Set issue date
			view.getTxtIssueDate().setDate(
					new java.util.Date(checkin.getIssueDate()));
			// Create a new vector to add checkin info from checkin object
			vt = new Vector<Object>();
			vt.add(checkin.getBorID());
			vt.add(checkin.getBookID());
			vt.add(checkin.getCallNumber());
			vt.add(checkin.getTitle());
			// Calculate Borrow information
			int DueDay = (int) ((checkin.getDueDate() - checkin.getIssueDate()) / (24 * 60 * 60 * 1000));
			int DayBor = (int) (view.getTxtReturnDate().getDate().getTime() - checkin
					.getIssueDate()) / (24 * 60 * 60 * 1000);
			// If day borrow is great than due day, set it default due day
			if (DayBor > DueDay) {
				DayBor = DueDay;
			}
			int DayLate = (int) (view.getTxtReturnDate().getDate().getTime() - checkin
					.getDueDate()) / (24 * 60 * 60 * 1000);
			float BorrowFee = DayBor * borFee;
			float Fine = 0;
			vt.add(DayBor
					+ Messages.getString("CheckInController.23") + BorrowFee); //$NON-NLS-1$
			if (DayLate > 0) {
				Fine = DayLate * lateFee;
				vt.add(DayLate
						+ Messages.getString("CheckInController.24") + Fine); //$NON-NLS-1$
			} else {
				vt.add(0 + Messages.getString("CheckInController.25") + 0); //$NON-NLS-1$
			}
			vt.add(BorrowFee + Fine);
			inModel.addRow(vt);
		}

	}

	/**
	 * @param checkin
	 *            the check in to set
	 */
	public void setCheckin(CheckIn checkin) {
		this.checkin = checkin;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(CheckInDialog view) {
		this.view = view;
	}
}
