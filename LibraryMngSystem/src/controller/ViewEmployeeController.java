/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.table.DefaultTableModel;

import model.AccessEmp;
import model.LibUtil;
import view.ViewEmployeeDialog;
import entity.Employee;

/**
 * View employee controller, control view employee dialog
 * 
 * @author CuongNQ
 */
public class ViewEmployeeController {

	// Defined
	private Employee emp = null;
	private ViewEmployeeDialog view;
	private DefaultTableModel borModel;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param emp
	 */
	public ViewEmployeeController(ViewEmployeeDialog view, Employee emp) {
		this.view = view;
		this.emp = emp;
		initComponent();
		getEmpBorDetail();
	}

	/**
	 * initialize the controller.
	 */
	@SuppressWarnings("serial")
	private void initComponent() {
		// Set all information
		view.getLblID().setText(new Integer(emp.getEmpID()).toString());
		view.getLblName().setText(emp.getName());
		String DOB = new Date(emp.getDOB()).toString();

		view.getLblDOB().setText(LibUtil.getInstance().convertDate(DOB));
		if (emp.getGender() == 1) {
			view.getLblGender().setText(
					Messages.getString("ViewEmployeeController.0")); //$NON-NLS-1$
		} else {
			view.getLblGender().setText(
					Messages.getString("ViewEmployeeController.1")); //$NON-NLS-1$
		}
		view.getLblEmail().setText(emp.getEmail());
		view.getLblAdd().setText(emp.getAddress());
		view.getLblPhone().setText(emp.getPhone());
		view.getLblDepart().setText(emp.getDepartment());
		if (emp.getPermission() == 1) {
			view.getLblPermission().setText(
					Messages.getString("ViewEmployeeController.2")); //$NON-NLS-1$
		} else {
			view.getLblPermission().setText(
					Messages.getString("ViewEmployeeController.3")); //$NON-NLS-1$
		}
		// Add event close btn
		view.getBtnClose().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});

		// Create bor model
		borModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int column, int row) {
				return false;
			}
		};
		borModel.addColumn(Messages.getString("ViewEmployeeController.4")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("ViewEmployeeController.5")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("ViewEmployeeController.6")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("ViewEmployeeController.7")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("ViewEmployeeController.8")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("ViewEmployeeController.9")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("ViewEmployeeController.10")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("ViewEmployeeController.11")); //$NON-NLS-1$
		borModel.addColumn(Messages.getString("ViewEmployeeController.12")); //$NON-NLS-1$

		// Add model to table
		view.getTblBor().setModel(borModel);

		// Escape dialog by key
		LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * Get full borrow information of employee
	 */
	private void getEmpBorDetail() {
		AccessEmp.getInstance().getEmpBorInfo(borModel, emp.getEmpID());
	}

	/**
	 * @return the view
	 */
	public ViewEmployeeDialog getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(ViewEmployeeDialog view) {
		this.view = view;
	}
}
