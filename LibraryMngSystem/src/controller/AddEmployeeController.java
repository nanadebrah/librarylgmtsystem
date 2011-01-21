/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import model.LibValid;
import view.AddEmployeeDialog;
import entity.Employee;

/**
 * Add employee controller, control add employee dialog
 * 
 * @author CuongNQ
 */
public class AddEmployeeController {

	// Defined
	private Employee emp = null;
	private AddEmployeeDialog view;

	/**
	 * Default constructor
	 * 
	 * @param view
	 */
	public AddEmployeeController(AddEmployeeDialog view) {
		this.view = view;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {
		// Create new employee
		emp = new Employee();

		// Add event close btn
		view.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				emp = null;
				view.dispose();
			}
		});

		// Add event add btn
		view.getBtnAdd().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (validEmp()) {
					// set object
					toObject();
					// Dispose this dialog
					view.dispose();
				}
			}
		});

		// Add item listener
		view.getCbxPermission().addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// If permission is employee, it doesn't need password
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getItem().equals(
							Messages.getString("AddEmployeeController.0"))) { //$NON-NLS-1$
						view.getTxtPass().setText(
								Messages.getString("EmptyText")); //$NON-NLS-1$
						view.getTxtPass().setEditable(false);
					} else {
						view.getTxtPass().setEditable(true);
					}
				}
			}
		});

		// Add window event
		view.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent evt) {
				emp = null;
			}
		});
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * @return the emp
	 */
	public Employee getEmp() {
		return emp;
	}

	/**
	 * @return the view
	 */
	public AddEmployeeDialog getView() {
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
	 * @param view
	 *            the view to set
	 */
	public void setView(AddEmployeeDialog view) {
		this.view = view;
	}

	/**
	 * Transfer all field to object
	 */
	private void toObject() {
		emp = new Employee();
		emp.setName(view.getTxtName().getText());
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
				.equals(Messages.getString("AddEmployeeController.2"))) { //$NON-NLS-1$
			emp.setPermission(1);
		} else {
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
					Messages.getString("AddEmployeeController.3"),
					Messages.getString("ValidTitle"), //$NON-NLS-1$ 
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtName().requestFocus();
			return false;
		}
		if (view.getTxtDOB().getDate() == null) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("AddEmployeeController.5"), //$NON-NLS-1$
					Messages.getString("ValidTitle"),
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtDOB().requestFocus();
			return false;
		}
		if (!LibValid.getInstance().Address(view.getTxtAdd().getText())) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("AddEmployeeController.7"), //$NON-NLS-1$
					Messages.getString("ValidTitle"),
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtAdd().requestFocus();
			return false;
		}
		if (view.getCbxPermission().getSelectedItem()
				.equals(Messages.getString("AddEmployeeController.9"))) { //$NON-NLS-1$
			if (!LibValid.getInstance().Password(
					new String(view.getTxtPass().getPassword()))) {
				JOptionPane.showMessageDialog(
						view,
						Messages.getString("AddEmployeeController.10"), //$NON-NLS-1$
						Messages.getString("ValidTitle"),
						JOptionPane.INFORMATION_MESSAGE);
				view.getTxtPass().requestFocus();
				return false;
			}
		}
		if (!LibValid.getInstance().Email(view.getTxtEmail().getText())) {
			JOptionPane.showMessageDialog(view,
					Messages.getString("AddEmployeeController.12"),
					Messages.getString("ValidTitle"), //$NON-NLS-1$ 
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtEmail().requestFocus();
			return false;
		}
		if (!LibValid.getInstance().Phone(view.getTxtPhone().getText())) {
			JOptionPane.showMessageDialog(view,
					Messages.getString("AddEmployeeController.14"),
					Messages.getString("ValidTitle"), //$NON-NLS-1$ 
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtPhone().requestFocus();
			return false;
		}
		if (!LibValid.getInstance().Depart(view.getTxtDepart().getText())) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("AddEmployeeController.16"), //$NON-NLS-1$
					Messages.getString("ValidTitle"),
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtDepart().requestFocus();
			return false;
		}
		return true;
	}
}
