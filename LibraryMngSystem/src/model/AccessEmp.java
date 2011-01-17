/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import entity.Employee;

/**
 * Access employee table
 * 
 * @author CuongNQ
 */
public class AccessEmp {

	// Defined instance of AccessEmp
	private static AccessEmp instance = new AccessEmp();
	private Connection cn = null;
	private ResultSet rsDetails = null;
	private CallableStatement csDetails = null;

	/**
	 * Static method get instance of AccessEmp
	 * 
	 * @return
	 */
	public static AccessEmp getInstance() {
		return instance;
	}

	/**
	 * Get a info employee to employee object
	 * 
	 * @param EmpID
	 *            is ID to query on database
	 * @return Employee queried
	 */
	public Employee getEmpInfo(int EmpID) {
		// Defined Object
		Employee emp = null;
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			csDetails = cn.prepareCall(LibProcedure.GET_EMP_INFO);
			csDetails.setInt(1, EmpID);
			rsDetails = csDetails.executeQuery();
			if (rsDetails.next()) {
				emp = new Employee();
				// Set all field on database to employee object
				emp.setEmpID(rsDetails.getInt(1));
				emp.setName(rsDetails.getString(2));
				emp.setDOB(rsDetails.getDate(3).getTime());
				emp.setGender(rsDetails.getInt(4));
				emp.setEmail(rsDetails.getString(5));
				emp.setAddress(rsDetails.getString(7));
				emp.setPhone(rsDetails.getString(8));
				emp.setPermission(rsDetails.getInt(9));
				emp.setDepartment(rsDetails.getString(10));
				// return employee object
				return emp;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(rsDetails);
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return null;
	}

	/**
	 * Get borrow details of employee
	 * 
	 * @param borModel
	 * @param empID
	 */
	public void getEmpBorInfo(DefaultTableModel borModel, int empID) {
		java.util.Vector vt;
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			csDetails = cn.prepareCall(LibProcedure.GET_EMP_BOR_INFO);
			csDetails.setInt(1, empID);
			rsDetails = csDetails.executeQuery();
			while (rsDetails.next()) {
				vt = new java.util.Vector();
				vt.addElement(rsDetails.getInt(1));
				vt.addElement(rsDetails.getInt(2));
				vt.addElement(rsDetails.getString(3));
				vt.addElement(rsDetails.getString(4));
				vt.addElement(LibUtil.getInstance().convertDate(
						rsDetails.getDate(5).toString()));
				vt.addElement(LibUtil.getInstance().convertDate(
						rsDetails.getDate(6).toString()));
				if (rsDetails.getString(7).equals("Checked-Out")) {
					vt.addElement(rsDetails.getString(7));
					vt.addElement("--");
					vt.addElement("--");
				} else {
					vt.addElement(rsDetails.getString(7));
					vt.addElement(LibUtil.getInstance().convertDate(
							rsDetails.getDate(8).toString()));
					vt.addElement(rsDetails.getFloat(9));
				}
				borModel.addRow(vt);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(rsDetails);
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
	}

	/**
	 * Add employee to database
	 * 
	 * @param emp
	 * @return
	 */
	public boolean addEmp(Employee emp) {
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			if (emp.getPermission() == 1) {
				csDetails = cn.prepareCall(LibProcedure.ADD_LIB);
				csDetails.setString(1, emp.getName());
				csDetails.setDate(2, new Date(emp.getDOB()));
				csDetails.setInt(3, emp.getGender());
				csDetails.setString(4, emp.getEmail());
				csDetails
						.setString(
								5,
								LibPassword.getInstance().encryptMD5(
										emp.getPassword()));
				csDetails.setString(6, emp.getAddress());
				csDetails.setString(7, emp.getPhone());
				csDetails.setString(8, emp.getDepartment());
				if (!csDetails.execute()) {
					return true;
				}
			} else {
				csDetails = cn.prepareCall(LibProcedure.ADD_EMP);
				csDetails.setString(1, emp.getName());
				csDetails.setDate(2, new Date(emp.getDOB()));
				csDetails.setInt(3, emp.getGender());
				csDetails.setString(4, emp.getEmail());
				csDetails.setString(5, emp.getAddress());
				csDetails.setString(6, emp.getPhone());
				csDetails.setString(7, emp.getDepartment());
				csDetails.execute();
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return false;
	}

	/**
	 * Edit employee
	 * 
	 * @param emp
	 * @return true if successful, otherwise false
	 */
	public boolean editEmp(Employee emp) {
		// Defined connection, rs and cs to connect and query database
		Connection cn = LibConnection.getConnection();
		try {
			if (emp.getPermission() == 1) {
				csDetails = cn.prepareCall(LibProcedure.EDIT_LIB);
				csDetails.setInt(1, emp.getEmpID());
				csDetails.setString(2, emp.getName());
				csDetails.setString(3, emp.getFixName());
				csDetails.setDate(4, new Date(emp.getDOB()));
				csDetails.setInt(5, emp.getGender());
				csDetails.setString(6, emp.getEmail());
				csDetails
						.setString(
								7,
								LibPassword.getInstance().encryptMD5(
										emp.getPassword()));
				csDetails.setString(8, emp.getAddress());
				csDetails.setString(9, emp.getPhone());
				csDetails.setString(10, emp.getDepartment());
				if (!csDetails.execute()) {
					return true;
				}
			} else {
				csDetails = cn.prepareCall(LibProcedure.EDIT_EMP);
				csDetails.setInt(1, emp.getEmpID());
				csDetails.setString(2, emp.getName());
				csDetails.setDate(3, new Date(emp.getDOB()));
				csDetails.setInt(4, emp.getGender());
				csDetails.setString(5, emp.getEmail());
				csDetails.setString(6, emp.getAddress());
				csDetails.setString(7, emp.getPhone());
				csDetails.setString(8, emp.getDepartment());
				csDetails.execute();
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return false;
	}

	/**
	 * Search employee from employee database
	 * 
	 * @param empModel
	 * @param EmpID
	 * @param Name
	 * @param page
	 * @return total row in database
	 */
	public int searchEmp(DefaultTableModel empModel, String EmpID, String Name,
			int page) {
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			if (EmpID.length() == 0) {
				// Search Name only
				csDetails = cn.prepareCall(LibProcedure.GET_EMP_BY_NAME);
				csDetails.setString(1, Name);
				csDetails.setInt(2, page);
				csDetails.setInt(3, LibUtil.noRow);
				csDetails.registerOutParameter(4, java.sql.Types.INTEGER);
			} else {
				// Search EmpID only
				csDetails = cn.prepareCall(LibProcedure.GET_EMP_BY_ID);
				csDetails.setInt(1, new Integer(EmpID));
				csDetails.setInt(2, page);
				csDetails.setInt(3, LibUtil.noRow);
				csDetails.registerOutParameter(4, java.sql.Types.INTEGER);
			}
			rsDetails = csDetails.executeQuery();
			while (rsDetails.next()) {
				Vector vt = new Vector();
				vt.addElement(rsDetails.getInt(1));
				vt.addElement(rsDetails.getString(2));
				vt.addElement(rsDetails.getString(3));
				vt.addElement(rsDetails.getString(4));
				vt.addElement(rsDetails.getString(5));
				vt.addElement(rsDetails.getString(6));
				empModel.addRow(vt);
			}
			return csDetails.getInt(4);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(rsDetails);
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return 1;
	}

	/**
	 * Delete employee
	 * 
	 * @param empID
	 * @return true if delete successful, otherwise false
	 */
	public boolean deleteEmp(int empID) {
		// If root, return it
		if (empID == 1) {
			return false;
		}
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			csDetails = cn.prepareCall(LibProcedure.DETELE_EMP);
			csDetails.setInt(1, empID);
			if (csDetails.execute()) {
				return false;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return true;
	}
}
