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

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.AccessEmp;
import model.LibUtil;
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
		empModel.addColumn("No");
		empModel.addColumn("Name");
		empModel.addColumn("Gender");
		empModel.addColumn("Email");
		empModel.addColumn("Department");
		empModel.addColumn("Permission");
		// Add event to employee table
		view.getTblEmp().addFocusListener(new FocusAdapter() {

			public void focusLost(java.awt.event.FocusEvent evt) {
				tableFocus();
			}
		});
		view.getTblEmp().addMouseListener(new MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				// Set enable acction button
				view.getBtnEdit().setEnabled(true);
				view.getBtnView().setEnabled(true);
				view.getBtnDelete().setEnabled(true);
				// If double click display edit employee dialog
				if (evt.getClickCount() == 2) {
					viewEmp();
				}
			}
		});

		// Add event to add employee btn
		view.getBtnAdd().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tableFocus();
				addEmp();
			}
		});

		// Add event click search employee
		view.getBtnSearch().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tableFocus();
				page = 1;
				searchEmp();
			}
		});

		// Add event view button
		view.getBtnView().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				viewEmp();
			}
		});

		// Add event edit btn
		view.getBtnEdit().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tableFocus();
				editEmp();
			}
		});

		// Add event delte btn
		view.getBtnDelete().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				deleteEmp();
			}
		});

		// Add event enter key
		view.getTxtEmpID().addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchEmp();
				}
			}
		});
		view.getTxtEmpName().addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchEmp();
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
					searchEmp();
				}
			}
		});
		view.getBtnBack().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (page != 1 && LibUtil.getInstance().getPage(totalRow) != 0) {
					page--;
				}
				searchEmp();
			}
		});
		view.getBtnFirst().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				page = 1;
				searchEmp();
			}
		});
		view.getBtnLast().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				page = LibUtil.getInstance().getPage(totalRow);
				searchEmp();
			}
		});
	}

	/**
	 * Delete an employee
	 */
	private void deleteEmp() {
		parent.doBlur();
		int sure = JOptionPane.showConfirmDialog(parent.getView(),
				"You sure want delete this employee!", "Delete employee",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (sure == JOptionPane.OK_OPTION) {
			// Get Id employee selected
			String empID = view.getTblEmp()
					.getValueAt(view.getTblEmp().getSelectedRow(), 0)
					.toString();
			if (!AccessEmp.getInstance().deleteEmp(Integer.parseInt(empID))) {
				JOptionPane
						.showMessageDialog(
								parent.getView(),
								"Delete failed!\n"
										+ "May be this employee is borrowing many books.",
								"Error!", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(parent.getView(),
						"Delete successful!", "Successful!",
						JOptionPane.INFORMATION_MESSAGE);
				empModel.removeRow(view.getTblEmp().getSelectedRow());
			}
		}
		tableFocus();
		parent.doBlur();
	}

	/**
	 * Do lost focus table
	 */
	private void tableFocus() {
		// Set disable acction button
		view.getBtnEdit().setEnabled(false);
		view.getBtnView().setEnabled(false);
		view.getBtnDelete().setEnabled(false);
		view.getTblEmp().setFocusable(false);
	}

	/**
	 * Method edit employee on databse and edit on employee table
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
				JOptionPane.showMessageDialog(view, "Update successful",
						"Successful!", JOptionPane.INFORMATION_MESSAGE);
				// Remove old data on table model
				empModel.removeRow(view.getTblEmp().getSelectedRow());
				// Add new row
				empModel.addRow(emp.toVector());
			} else {
				JOptionPane.showMessageDialog(view, "Edit failed!\n"
						+ "May be username isn't unique.", "Edit Employee",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		tableFocus();
		view.getTblEmp().clearSelection();
		parent.doBlur();
	}

	/**
	 * Method add employee on databse
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
				JOptionPane.showMessageDialog(view, "Add successful",
						"Successful!", JOptionPane.INFORMATION_MESSAGE);
				// Move last page and show newest employee
				view.getTxtEmpID().setText("");
				view.getTxtEmpName().setText("");
				view.getBtnLast().doClick();
			} else {
				JOptionPane.showMessageDialog(view, "Add failed!\n"
						+ "May be this librarian have added.", "Add Employee",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		parent.doBlur();
	}

	/**
	 * Seacrch employee by Id or name
	 */
	public void searchEmp() {
		parent.removeModel(empModel);
		new Thread(new Runnable() {

			public void run() {
				totalRow = AccessEmp.getInstance().searchEmp(empModel,
						view.getTxtEmpID().getText(),
						view.getTxtEmpName().getText(), (page - 1));
				view.getLblPage().setText(
						"Page " + page + "/"
								+ LibUtil.getInstance().getPage(totalRow));
			}
		}).start();
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

	/**
	 * @return the view
	 */
	public EmployeePanel getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(EmployeePanel view) {
		this.view = view;
	}
}
