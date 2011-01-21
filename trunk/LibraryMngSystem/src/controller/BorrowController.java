/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.AccessBorrow;
import model.AccessFee;
import model.LibUtil;
import model.LibValid;
import view.BorrowPanel;
import view.CheckInDialog;
import view.CheckOutDialog;
import view.FeeRateDialog;
import view.ViewBorrowDialog;

/**
 * Borrow controller, control borrow panel
 * 
 * @author CuongNQ
 */
public class BorrowController {

	// Defined
	private BorrowPanel view;
	private DefaultTableModel borModel;
	private ManageController parent;
	private CheckOutController checkOut;
	private CheckInController checkIn;
	private FeeRateController feeControl;
	private ViewBorrowController viewControl;
	private DefaultTableModel bothModel;
	private DefaultTableModel outModel;
	private DefaultTableModel inModel;
	private DefaultTableModel searchModel;
	private int page;
	private Integer totalRow;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param borModel
	 * @param parent
	 */
	public BorrowController(BorrowPanel view, DefaultTableModel borModel,
			ManageController parent) {
		this.view = view;
		this.borModel = borModel;
		this.parent = parent;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	@SuppressWarnings("serial")
	private void initComponent() {

		// Set default page
		page = 1;
		totalRow = 1;
		// Create book model
		searchModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int column, int row) {
				return false;
			}
		};
		// Create book model
		bothModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int column, int row) {
				return false;
			}
		};
		// Create check-out model
		outModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int column, int row) {
				return false;
			}
		};
		// Create check-in model
		inModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int column, int row) {
				return false;
			}
		};

		// Set selection mode
		view.getTblBorrow().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);

		// Add model to table
		view.getTblBorrow().setModel(borModel);

		// Set searchModel
		searchModel.addColumn(Messages.getString("BorrowController.17")); //$NON-NLS-1$
		searchModel.addColumn(Messages.getString("BorrowController.18")); //$NON-NLS-1$
		searchModel.addColumn(Messages.getString("BorrowController.19")); //$NON-NLS-1$
		searchModel.addColumn(Messages.getString("BorrowController.20")); //$NON-NLS-1$
		searchModel.addColumn(Messages.getString("BorrowController.21")); //$NON-NLS-1$
		searchModel.addColumn(Messages.getString("BorrowController.22")); //$NON-NLS-1$
		searchModel.addColumn(Messages.getString("BorrowController.23")); //$NON-NLS-1$
		searchModel.addColumn(Messages.getString("BorrowController.24")); //$NON-NLS-1$

		// Set int model
		inModel.addColumn(Messages.getString("BorrowController.25")); //$NON-NLS-1$
		inModel.addColumn(Messages.getString("BorrowController.26")); //$NON-NLS-1$
		inModel.addColumn(Messages.getString("BorrowController.27")); //$NON-NLS-1$
		inModel.addColumn(Messages.getString("BorrowController.28")); //$NON-NLS-1$
		inModel.addColumn(Messages.getString("BorrowController.29")); //$NON-NLS-1$
		inModel.addColumn(Messages.getString("BorrowController.30")); //$NON-NLS-1$
		inModel.addColumn(Messages.getString("BorrowController.31")); //$NON-NLS-1$

		// Set bor model
		borModel.addColumn(Messages.getString("BorrowController.32")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("BorrowController.33")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("BorrowController.34")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("BorrowController.35")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("BorrowController.36")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("BorrowController.37")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("BorrowController.38")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("BorrowController.39")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("BorrowController.40")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("BorrowController.41")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("BorrowController.42")); //$NON-NLS-1$

		// Set out model
		outModel.addColumn(Messages.getString("BorrowController.43")); //$NON-NLS-1$
		outModel.addColumn(Messages.getString("BorrowController.44")); //$NON-NLS-1$
		outModel.addColumn(Messages.getString("BorrowController.45")); //$NON-NLS-1$
		outModel.addColumn(Messages.getString("BorrowController.46")); //$NON-NLS-1$
		outModel.addColumn(Messages.getString("BorrowController.47")); //$NON-NLS-1$
		outModel.addColumn(Messages.getString("BorrowController.48")); //$NON-NLS-1$

		// Add event fee rate btn
		view.getBtnFee().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableFocus();
				editFee();
			}
		});

		// Add event check out btn
		view.getBtnCheckOut().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableFocus();
				checkOut();
			}
		});

		// Add event check in btn
		view.getBtnCheckIn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableFocus();
				checkIn();
			}
		});

		// Add event search btn
		view.getBtnSearch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableFocus();
				page = 1;
				searchBorrow();
			}
		});

		// Add event view btn
		view.getBtnView().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewBorrowInfo();
			}
		});

		view.getBtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteBorrow();
			}
		});

		// Add event to borrow table
		view.getTblBorrow().addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(java.awt.event.FocusEvent evt) {
				tableFocus();
			}
		});

		view.getTblBorrow().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					// Set enable action button
					view.getBtnView().setEnabled(true);
					view.getBtnDelete().setEnabled(true);
					// If double click display edit employee dialog
					if (evt.getClickCount() == 2) {
						viewBorrowInfo();
					}
				}
			}
		});

		// Add event enter key
		view.getTxtEmpID().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBorrow();
				}
			}
		});
		view.getTxtCallNo().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBorrow();
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
					searchBorrow();
				}
			}
		});
		view.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (page != 1 && LibUtil.getInstance().getPage(totalRow) != 0) {
					page--;
				}
				searchBorrow();
			}
		});
		view.getBtnFirst().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = 1;
				searchBorrow();
			}
		});
		view.getBtnLast().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = LibUtil.getInstance().getPage(totalRow);
				searchBorrow();
			}
		});
	}

	/**
	 * Check in dialog
	 */
	private void checkIn() {
		parent.doBlur();
		checkIn = new CheckInController(new CheckInDialog(parent.getView()),
				searchModel, inModel, parent);
		checkIn.getView().setVisible(true);
		if (checkIn.getCheckin() != null) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("BorrowController.0"), //$NON-NLS-1$
					Messages.getString("BorrowController.1"),
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtCallNo().setText(
					Messages.getString("EmptyText")); //$NON-NLS-1$
			view.getTxtEmpID()
					.setText(Messages.getString("EmptyText")); //$NON-NLS-1$
			view.getBtnLast().doClick();
		}
		parent.doBlur();
	}

	/**
	 * Check out dialog
	 */
	private void checkOut() {
		parent.doBlur();
		checkOut = new CheckOutController(new CheckOutDialog(parent.getView()),
				bothModel, outModel, parent);
		checkOut.getView().setVisible(true);

		if (checkOut.getBorDetail() != null) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("BorrowController.4"), //$NON-NLS-1$
					Messages.getString("BorrowController.5"),
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtCallNo().setText(
					Messages.getString("EmptyText")); //$NON-NLS-1$
			view.getTxtEmpID()
					.setText(Messages.getString("EmptyText")); //$NON-NLS-1$
			view.getBtnLast().doClick();
		}
		parent.doBlur();
	}

	/**
	 * Delete a borrow, it must checked in
	 */
	private void deleteBorrow() {
		parent.doBlur();
		int sure = JOptionPane.showConfirmDialog(parent.getView(),
				Messages.getString("BorrowController.8"),
				Messages.getString("BorrowController.9"), //$NON-NLS-1$ 
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (sure == JOptionPane.OK_OPTION) {
			// Get borID and bookID selected
			String borID = view.getTblBorrow()
					.getValueAt(view.getTblBorrow().getSelectedRow(), 0)
					.toString();
			String bookID = view.getTblBorrow()
					.getValueAt(view.getTblBorrow().getSelectedRow(), 2)
					.toString();
			if (!AccessBorrow.getInstance().deleteBorrow(
					Integer.parseInt(borID), Integer.parseInt(bookID))) {
				JOptionPane.showMessageDialog(
						parent.getView(),
						Messages.getString("BorrowController.10") //$NON-NLS-1$
								+ Messages.getString("BorrowController.11"), //$NON-NLS-1$
						Messages.getString("BorrowController.12"),
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(parent.getView(),
						Messages.getString("BorrowController.13"),
						Messages.getString("BorrowController.14"), //$NON-NLS-1$ 
						JOptionPane.INFORMATION_MESSAGE);
				borModel.removeRow(view.getTblBorrow().getSelectedRow());
			}
		}
		parent.doBlur();
	}

	/**
	 * Edit fee dialog
	 */
	private void editFee() {
		parent.doBlur();
		feeControl = new FeeRateController(new FeeRateDialog(parent.getView()));
		feeControl.getView().setVisible(true);
		if (feeControl.getFee() != null) {
			AccessFee.getInstance().editFee(feeControl.getFee());
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("BorrowController.15"), //$NON-NLS-1$
					Messages.getString("BorrowController.16"),
					JOptionPane.INFORMATION_MESSAGE);
		}
		parent.doBlur();
	}

	/**
	 * @return the view
	 */
	public BorrowPanel getView() {
		return view;
	}

	/**
     * 
     */
	public void searchBorrow() {
		if (!LibValid.getInstance().EmpID(view.getTxtEmpID().getText())) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("BorrowController.49"), //$NON-NLS-1$
					Messages.getString("BorrowController.50"),
					JOptionPane.ERROR_MESSAGE);
		} else {
			parent.removeModel(borModel);
			totalRow = AccessBorrow.getInstance().searchBor(borModel,
					view.getTxtEmpID().getText(),
					view.getTxtCallNo().getText(), (page - 1));
			view.getLblPage().setText(
					Messages.getString("BorrowController.51") + page
							+ Messages.getString("Slash") //$NON-NLS-1$ 
							+ LibUtil.getInstance().getPage(totalRow));
		}
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(BorrowPanel view) {
		this.view = view;
	}

	/**
	 * Do lost focus table
	 */
	private void tableFocus() {
		// Set disable action button
		view.getBtnView().setEnabled(false);
		view.getBtnDelete().setEnabled(false);
		view.getTblBorrow().setFocusable(false);
	}

	/**
	 * View full information of borrow
	 */
	private void viewBorrowInfo() {
		parent.doBlur();
		// Get field borID selected
		int borID = Integer
				.parseInt(view.getTblBorrow()
						.getValueAt(view.getTblBorrow().getSelectedRow(), 0)
						.toString());
		// Get field empID selected
		int empID = Integer
				.parseInt(view.getTblBorrow()
						.getValueAt(view.getTblBorrow().getSelectedRow(), 1)
						.toString());
		// Get field bookID selected
		String bookID = view.getTblBorrow()
				.getValueAt(view.getTblBorrow().getSelectedRow(), 2).toString();
		viewControl = new ViewBorrowController(new ViewBorrowDialog(
				parent.getView()), borID, empID, Integer.parseInt(bookID));
		viewControl.getView().setVisible(true);
		parent.doBlur();
	}
}
