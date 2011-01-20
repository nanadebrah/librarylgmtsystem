/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import model.LibValid;
import view.EditEmployeeDialog;
import entity.Employee;

/**
 * Edit employee controller, control edit employee dialog
 * 
 * @author CuongNQ
 */
public class EditEmployeeController {

	// Defined employee and edit dialog
	private Employee emp = null;
	private EditEmployeeDialog view;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param emp
	 */
	public EditEmployeeController(EditEmployeeDialog view, Employee emp) {
		this.view = view;
		this.emp = emp;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {
		// Set all old field of employee
		setField();
		// add event change permission
		view.getCbxPermission().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// If permission is employee, it doesn't need password
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(
							Messages.getString("EditEmployeeController.0"))) { //$NON-NLS-1$
						view.getTxtPass().setText(
								Messages.getString("EditEmployeeController.1")); //$NON-NLS-1$
						view.getTxtPass().setEditable(false);
					} else {
						view.getTxtPass().setEditable(true);
					}
				}
			}
		});
		// Add event cancel btn
		view.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				emp = null;
				view.dispose();
			}
		});
		// Add event add btn
		view.getBtnSave().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (validEmp()) {
					toObject();
					view.dispose();
				}
			}
		});
		// Add event windows closing
		view.addWindowListener(new java.awt.event.WindowAdapter() {

			@Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
				emp = null;
				view.dispose();
			}

			@Override
			public void windowOpened(java.awt.event.WindowEvent evt) {
				// If employee, hidden pass text and pass label
				if (emp.getPermission() == 0) {
					view.getTxtPass().setEditable(false);
				}
			}
		});
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * @return the employee
	 */
	public Employee getEmp() {
		return emp;
	}

	/**
	 * @return the view
	 */
	public EditEmployeeDialog getView() {
		return view;
	}

	/**
	 * @param emp
	 *            the emp to set
	 */
	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	/**
	 * Set all info to field
	 */
	private void setField() {
		if (emp != null) {
			view.getTxtName().setText(emp.getName());
			if (emp.getGender() == 1) {
				view.getRdbMale().setSelected(true);
			} else {
				view.getRdbFemale().setSelected(true);
			}
			java.util.Date date = new java.util.Date(emp.getDOB());
			view.getTxtDOB().setDate(date);
			view.getTxtAdd().setText(emp.getAddress());
			view.getTxtEmail().setText(emp.getEmail());
			view.getTxtPhone().setText(emp.getPhone());
			view.getTxtDepart().setText(emp.getDepartment());
			if (emp.getPermission() == 1) {
				view.getCbxPermission().setSelectedIndex(0);
			} else {
				view.getCbxPermission().setSelectedIndex(1);
			}
		}
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(EditEmployeeDialog view) {
		this.view = view;
	}

	/**
	 * Transfer all field to object
	 */
	private void toObject() {
		emp.setFixName(view.getTxtName().getText());
		if (view.getRdbMale().isSelected()) {
			emp.setGender(1);
		} else {
			emp.setGender(0);
		}
		emp.setDOB(view.getTxtDOB().getDate().getTime());
		emp.setAddress(view.getTxtAdd().getText());
		emp.setEmail(view.getTxtEmail().getText());
		emp.setPassword(new String(view.getTxtPass().getPassword()));
		emp.setPhone(view.getTxtPhone().getText());
		emp.setDepartment(view.getTxtDepart().getText());
		if (view.getCbxPermission().getSelectedItem().toString()
				.equals(Messages.getString("EditEmployeeController.2"))) { //$NON-NLS-1$
			emp.setPermission(1);
		} else {
			emp.setName(view.getTxtName().getText());
			emp.setPermission(0);
		}
	}

	/**
	 * Valid all field of form
	 * 
	 * @return
	 */
	private boolean validEmp() {
		if (!LibValid.getInstance().Name(view.getTxtName().getText())) {
			JOptionPane.showMessageDialog(view,
					Messages.getString("EditEmployeeController.3"),
					Messages.getString("EditEmployeeController.4"), //$NON-NLS-1$ 
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtName().requestFocus();
			return false;
		}
		if (view.getTxtDOB().getDate() == null) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("EditEmployeeController.5"), //$NON-NLS-1$
					Messages.getString("EditEmployeeController.6"),
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtDOB().requestFocus();
			return false;
		}
		if (!LibValid.getInstance().Address(view.getTxtAdd().getText())) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("EditEmployeeController.7"), //$NON-NLS-1$
					Messages.getString("EditEmployeeController.8"),
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtAdd().requestFocus();
			return false;
		}
		if (view.getCbxPermission().getSelectedItem()
				.equals(Messages.getString("EditEmployeeController.9"))) { //$NON-NLS-1$
			if (!LibValid.getInstance().Password(
					new String(view.getTxtPass().getPassword()))) {
				JOptionPane.showMessageDialog(
						view,
						Messages.getString("EditEmployeeController.10"), //$NON-NLS-1$
						Messages.getString("EditEmployeeController.11"),
						JOptionPane.INFORMATION_MESSAGE);
				view.getTxtPass().requestFocus();
				return false;
			}
		}
		if (!LibValid.getInstance().Email(view.getTxtEmail().getText())) {
			JOptionPane.showMessageDialog(view,
					Messages.getString("EditEmployeeController.12"),
					Messages.getString("EditEmployeeController.13"), //$NON-NLS-1$ 
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtEmail().requestFocus();
			return false;
		}
		if (!LibValid.getInstance().Phone(view.getTxtPhone().getText())) {
			JOptionPane.showMessageDialog(view,
					Messages.getString("EditEmployeeController.14"),
					Messages.getString("EditEmployeeController.15"), //$NON-NLS-1$ 
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtPhone().requestFocus();
			return false;
		}
		if (!LibValid.getInstance().Depart(view.getTxtDepart().getText())) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("EditEmployeeController.16"), //$NON-NLS-1$
					Messages.getString("EditEmployeeController.17"),
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtDepart().requestFocus();
			return false;
		}
		return true;
	}
}
