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
	private void initComponent() {
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
		view.getLblEmail().setText(emp.getEmail());
		view.getLblAdd().setText(emp.getAddress());
		view.getLblPhone().setText(emp.getPhone());
		view.getLblDepart().setText(emp.getDepartment());
		if (emp.getPermission() == 1) {
			view.getLblPermission().setText("Librarian");
		} else {
			view.getLblPermission().setText("Employee");
		}
		// Add event close btn
		view.getBtnClose().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});

		// Create bor model
		borModel = new DefaultTableModel() {

			public boolean isCellEditable(int column, int row) {
				return false;
			}
		};
		borModel.addColumn("Borrow No");
		borModel.addColumn("Book No");
		borModel.addColumn("Call Number");
		borModel.addColumn("Title");
		borModel.addColumn("Issue Date");
		borModel.addColumn("Due Date");
		borModel.addColumn("Issue Status");
		borModel.addColumn("Return Date");
		borModel.addColumn("Total Fee");

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
