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

import model.AccessEmp;
import model.LibUtil;
import model.LibValid;
import view.AddEmployeeDialog;
import view.EditEmployeeDialog;
import view.EmployeePanel;
import view.ViewEmployeeDialog;
import entity.Employee;

/**
 * Employee controller, control employee panel
 * 
 * @author CuongNQ
 */
public class EmployeeController {

	// Defined
	private EmployeePanel view;
	private DefaultTableModel empModel;
	private AddEmployeeController addEmp;
	private EditEmployeeController editEmp;
	private ViewEmployeeController viewEmp;
	private ManageController parent;
	private int page;
	private int totalRow;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param empModel
	 * @param manage
	 */
	public EmployeeController(EmployeePanel view, DefaultTableModel empModel,
			ManageController manage) {
		this.view = view;
		this.empModel = empModel;
		this.parent = manage;
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
		view.getTblEmp().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Add model to table
		view.getTblEmp().setModel(empModel);
		// Set model
		empModel.addColumn(Messages.getString("EmployeeController.19")); //$NON-NLS-1$
		empModel.addColumn(Messages.getString("EmployeeController.20")); //$NON-NLS-1$
		empModel.addColumn(Messages.getString("EmployeeController.21")); //$NON-NLS-1$
		empModel.addColumn(Messages.getString("EmployeeController.22")); //$NON-NLS-1$
		empModel.addColumn(Messages.getString("EmployeeController.23")); //$NON-NLS-1$
		empModel.addColumn(Messages.getString("EmployeeController.24")); //$NON-NLS-1$
		// Add event to employee table
		view.getTblEmp().addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(java.awt.event.FocusEvent evt) {
				tableFocus();
			}
		});
		view.getTblEmp().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					// Set enable action button
					view.getBtnEdit().setEnabled(true);
					view.getBtnView().setEnabled(true);
					view.getBtnDelete().setEnabled(true);
					// If double click display edit employee dialog
					if (evt.getClickCount() == 2) {
						viewEmp();
					}
				}
			}
		});

		// Add event to add employee btn
		view.getBtnAdd().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableFocus();
				addEmp();
			}
		});

		// Add event click search employee
		view.getBtnSearch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableFocus();
				page = 1;
				searchEmp();
			}
		});

		// Add event view button
		view.getBtnView().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewEmp();
			}
		});

		// Add event edit btn
		view.getBtnEdit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableFocus();
				editEmp();
			}
		});

		// Add event delete btn
		view.getBtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteEmp();
			}
		});

		// Add event enter key
		view.getTxtEmpID().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchEmp();
				}
			}
		});
		view.getTxtEmpName().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchEmp();
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
					searchEmp();
				}
			}
		});
		view.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (page != 1 && LibUtil.getInstance().getPage(totalRow) != 0) {
					page--;
				}
				searchEmp();
			}
		});
		view.getBtnFirst().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = 1;
				searchEmp();
			}
		});
		view.getBtnLast().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = LibUtil.getInstance().getPage(totalRow);
				searchEmp();
			}
		});
	}

	/**
	 * Method add employee on database
	 */
	private void addEmp() {
		parent.doBlur();
		// Display Add employee dialog
		addEmp = new AddEmployeeController(new AddEmployeeDialog(
				parent.getView()));
		addEmp.getView().setVisible(true);
		// invoked method add employee
		if (addEmp.getEmp() != null) {
			if (AccessEmp.getInstance().addEmp(addEmp.getEmp())) {
				JOptionPane.showMessageDialog(
						view,
						Messages.getString("EmployeeController.0"), //$NON-NLS-1$
						Messages.getString("EmployeeController.1"),
						JOptionPane.INFORMATION_MESSAGE);
				// Move last page and show newest employee
				view.getTxtEmpID().setText(
						Messages.getString("EmptyText")); //$NON-NLS-1$
				view.getTxtEmpName().setText(
						Messages.getString("EmptyText")); //$NON-NLS-1$
				view.getBtnLast().doClick();
			} else {
				JOptionPane.showMessageDialog(view,
						Messages.getString("EmployeeController.4") //$NON-NLS-1$
								+ Messages.getString("EmployeeController.5"),
						Messages.getString("EmployeeController.6"), //$NON-NLS-1$ 
						JOptionPane.ERROR_MESSAGE);
			}
		}
		parent.doBlur();
		// Set selection to new employee
		view.getTblEmp().changeSelection(view.getTblEmp().getRowCount() - 1,
				0, false, false);
	}

	/**
	 * Delete an employee
	 */
	private void deleteEmp() {
		parent.doBlur();
		int sure = JOptionPane.showConfirmDialog(parent.getView(),
				Messages.getString("EmployeeController.7"),
				Messages.getString("EmployeeController.8"), //$NON-NLS-1$ 
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (sure == JOptionPane.OK_OPTION) {
			// Get Id employee selected
			String empID = view.getTblEmp()
					.getValueAt(view.getTblEmp().getSelectedRow(), 0)
					.toString();
			if (!AccessEmp.getInstance().deleteEmp(Integer.parseInt(empID))) {
				JOptionPane.showMessageDialog(
						parent.getView(),
						Messages.getString("EmployeeController.9") //$NON-NLS-1$
								+ Messages.getString("EmployeeController.10"), //$NON-NLS-1$
						Messages.getString("EmployeeController.11"),
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(parent.getView(),
						Messages.getString("EmployeeController.12"),
						Messages.getString("EmployeeController.13"), //$NON-NLS-1$ 
						JOptionPane.INFORMATION_MESSAGE);
				empModel.removeRow(view.getTblEmp().getSelectedRow());
			}
		}
		tableFocus();
		parent.doBlur();
	}

	/**
	 * Method edit employee on database and edit on employee table
	 */
	private void editEmp() {
		parent.doBlur();
		// Get Id employee selected
		String empID = view.getTblEmp()
				.getValueAt(view.getTblEmp().getSelectedRow(), 0).toString();
		// Get employee from database
		Employee emp = AccessEmp.getInstance().getEmpInfo(new Integer(empID));
		// Create instance of Employee edit dialog and display it
		editEmp = new EditEmployeeController(new EditEmployeeDialog(
				parent.getView()), emp);
		editEmp.getView().setVisible(true);
		// Update data on database
		if (editEmp.getEmp() != null) {
			if (AccessEmp.getInstance().editEmp(editEmp.getEmp())) {
				JOptionPane.showMessageDialog(
						view,
						Messages.getString("EmployeeController.14"), //$NON-NLS-1$
						Messages.getString("EmployeeController.15"),
						JOptionPane.INFORMATION_MESSAGE);
				// Remove old data on table model
				empModel.removeRow(view.getTblEmp().getSelectedRow());
				// Add new row
				empModel.addRow(emp.toVector());
			} else {
				JOptionPane.showMessageDialog(view,
						Messages.getString("EmployeeController.16") //$NON-NLS-1$
								+ Messages.getString("EmployeeController.17"),
						Messages.getString("EmployeeController.18"), //$NON-NLS-1$ 
						JOptionPane.ERROR_MESSAGE);
			}
		}
		parent.doBlur();
		// Set selection to employee book
		view.getTblEmp().changeSelection(view.getTblEmp().getRowCount() - 1,
				0, false, false);
	}

	/**
	 * @return the view
	 */
	public EmployeePanel getView() {
		return view;
	}

	/**
	 * Search employee by Id or name
	 */
	public void searchEmp() {
		if (!LibValid.getInstance().EmpID(view.getTxtEmpID().getText())) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("EmployeeController.25"), //$NON-NLS-1$
					Messages.getString("EmployeeController.26"),
					JOptionPane.ERROR_MESSAGE);
		} else {
			parent.removeModel(empModel);
			new Thread(new Runnable() {

				@Override
				public void run() {
					totalRow = AccessEmp.getInstance().searchEmp(empModel,
							view.getTxtEmpID().getText(),
							view.getTxtEmpName().getText(), (page - 1));
					view.getLblPage().setText(
							Messages.getString("EmployeeController.27")
									+ page
									+ Messages
											.getString("Slash") //$NON-NLS-1$ 
									+ LibUtil.getInstance().getPage(totalRow));
				}
			}).start();
		}
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(EmployeePanel view) {
		this.view = view;
	}

	/**
	 * Do lost focus table
	 */
	private void tableFocus() {
		// Set disable action button
		view.getBtnEdit().setEnabled(false);
		view.getBtnView().setEnabled(false);
		view.getBtnDelete().setEnabled(false);
		view.getTblEmp().setFocusable(false);
	}

	/**
	 * Method view full information employee
	 */
	private void viewEmp() {
		// Get Id employee selected
		String empID = view.getTblEmp()
				.getValueAt(view.getTblEmp().getSelectedRow(), 0).toString();
		// Get employee from database
		Employee emp = AccessEmp.getInstance().getEmpInfo(new Integer(empID));
		parent.doBlur();
		// Create instance of Employee edit dialog and display it
		viewEmp = new ViewEmployeeController(new ViewEmployeeDialog(
				parent.getView()), emp);
		viewEmp.getView().setVisible(true);
		tableFocus();
		parent.doBlur();
	}
}
