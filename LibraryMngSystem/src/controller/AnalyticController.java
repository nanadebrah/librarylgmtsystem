/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.AccessAnalytic;
import model.AccessBorrow;
import model.LibUtil;
import view.AnalyticPanel;
import view.SendAlertDialog;

/**
 * Analytic controller, control analytic panel
 * 
 * @author CuongNQ
 */
public class AnalyticController {

	// Defined
	private AnalyticPanel view;
	private DefaultTableModel anaModel;
	private ManageController parent;
	private SendAlertController sendEmail;
	private int page;
	private int totalRow;
	private boolean isTopBook;
	private boolean isSearch;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param anaModel
	 * @param parent
	 */
	public AnalyticController(AnalyticPanel view, DefaultTableModel anaModel,
			ManageController parent) {
		this.view = view;
		this.parent = parent;
		this.anaModel = anaModel;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {

		// Set default page
		page = 1;
		totalRow = 1;
		// Set selection mode
		view.getTblAna().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Add model to table
		view.getTblAna().setModel(anaModel);

		// Add event search btn
		view.getBtnSearch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.requestFocus();
				searchCheckingOut();
			}
		});

		// Add event top book btn
		view.getBtnTopBook().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getTopBook();
			}
		});

		// Add event top borrower btn
		view.getBtnTopBorrow().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				getTopBorrower();
			}
		});

		// Add event send alert btn
		view.getBtnAlert().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendEmail();
			}
		});

		// Add event table
		view.getTblAna().addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(java.awt.event.FocusEvent evt) {
				// Set disable action button
				view.getBtnAlert().setEnabled(false);
			}
		});
		view.getTblAna().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					if (isSearch) {
						// Set enable action button
						view.getBtnAlert().setEnabled(true);
					} else {
						// Set disable action button
						view.getBtnAlert().setEnabled(false);
					}
					// If double click display edit subject dialog
					if (evt.getClickCount() == 2) {
						if (isSearch) {
							sendEmail();
						}
					}
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
					if (isSearch) {
						searchCheckingOut();
					} else {
						if (isTopBook) {
							getTopBook();
						} else {
							getTopBorrower();
						}
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
				if (isSearch) {
					searchCheckingOut();
				} else {
					if (isTopBook) {
						getTopBook();
					} else {
						getTopBorrower();
					}
				}
			}
		});
		view.getBtnFirst().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = 1;
				if (isSearch) {
					searchCheckingOut();
				} else {
					if (isTopBook) {
						getTopBook();
					} else {
						getTopBorrower();
					}
				}
			}
		});
		view.getBtnLast().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = LibUtil.getInstance().getPage(totalRow);
				if (isSearch) {
					searchCheckingOut();
				} else {
					if (isTopBook) {
						getTopBook();
					} else {
						getTopBorrower();
					}
				}
			}
		});
	}

	/**
	 * Get top book borrowed by employee
	 */
	private void getTopBook() {
		isSearch = false;
		isTopBook = true;
		// Clear column
		anaModel.setColumnCount(0);
		parent.removeModel(anaModel);
		// Set model
		anaModel.addColumn(Messages.getString("AnalyticController.0")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.1")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.2")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.3")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.4")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.5")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.6")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.7")); //$NON-NLS-1$
		totalRow = AccessAnalytic.getInstance()
				.getTopBook(anaModel, (page - 1));
		view.getLblPage().setText(
				Messages.getString("AnalyticController.8") + page
						+ Messages.getString("Slash")
						+ LibUtil.getInstance().getPage(totalRow));
	}

	/**
	 * Get top borrower
	 */
	private void getTopBorrower() {
		isSearch = false;
		isTopBook = false;
		// Clear column
		anaModel.setColumnCount(0);
		parent.removeModel(anaModel);
		// Set model
		anaModel.addColumn(Messages.getString("AnalyticController.10")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.11")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.12")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.13")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.14")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.15")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.16")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.17")); //$NON-NLS-1$
		totalRow = AccessAnalytic.getInstance().getTopBorrower(anaModel,
				(page - 1));
		view.getLblPage().setText(
				Messages.getString("AnalyticController.18") + page
						+ Messages.getString("Slash")
						+ LibUtil.getInstance().getPage(totalRow));
	}

	/**
	 * @return the view
	 */
	public AnalyticPanel getView() {
		return view;
	}

	/**
	 * Search checking out to send alert
	 */
	private void searchCheckingOut() {
		isSearch = true;
		// Clear column
		anaModel.setColumnCount(0);
		parent.removeModel(anaModel);
		// Set model
		anaModel.addColumn(Messages.getString("AnalyticController.20")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.21")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.22")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.23")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.24")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.25")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.26")); //$NON-NLS-1$
		anaModel.addColumn(Messages.getString("AnalyticController.27")); //$NON-NLS-1$

		totalRow = AccessBorrow.getInstance().searchCheckingOut(anaModel,
				view.getTxtDueDate().getDate(), (page - 1));
		view.getLblPage().setText(
				Messages.getString("AnalyticController.28") + page
						+ Messages.getString("Slash")
						+ LibUtil.getInstance().getPage(totalRow));
	}

	/**
	 * Display dialog to send email
	 */
	private void sendEmail() {
		parent.doBlur();
		// Get field borID selected
		int borID = Integer.parseInt(view.getTblAna()
				.getValueAt(view.getTblAna().getSelectedRow(), 0).toString());
		// Get field empID selected
		int empID = Integer.parseInt(view.getTblAna()
				.getValueAt(view.getTblAna().getSelectedRow(), 1).toString());
		// Get field bookID selected
		String bookID = view.getTblAna()
				.getValueAt(view.getTblAna().getSelectedRow(), 2).toString();
		sendEmail = new SendAlertController(new SendAlertDialog(
				parent.getView()), borID, empID, Integer.parseInt(bookID));
		sendEmail.getView().setVisible(true);
		parent.doBlur();
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(AnalyticPanel view) {
		this.view = view;
	}
}
