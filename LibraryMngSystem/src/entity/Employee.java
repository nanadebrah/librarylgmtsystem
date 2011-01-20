/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Vector;

/**
 * Employee entity
 * 
 * @author CuongNQ
 */
public class Employee {

	private int EmpID;
	private String Name;
	private String fixName;
	private long DOB;
	private int Gender;
	private String Email;
	private String Password;
	private String Phone;
	private String Address;
	private int Permission;
	private String Department;

	/**
	 * @return the Address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @return the Department
	 */
	public String getDepartment() {
		return Department;
	}

	/**
	 * @return the DOB
	 */
	public long getDOB() {
		return DOB;
	}

	/**
	 * @return the Email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @return the EmpID
	 */
	public int getEmpID() {
		return EmpID;
	}

	/**
	 * @return the fixName
	 */
	public String getFixName() {
		return fixName;
	}

	/**
	 * @return the Gender
	 */
	public int getGender() {
		return Gender;
	}

	/**
	 * @return the Name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @return the Password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @return the Permission
	 */
	public int getPermission() {
		return Permission;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return Phone;
	}

	/**
	 * @param Address
	 *            the Address to set
	 */
	public void setAddress(String Address) {
		this.Address = Address;
	}

	/**
	 * @param Department
	 *            the Department to set
	 */
	public void setDepartment(String Department) {
		this.Department = Department;
	}

	/**
	 * @param DOB
	 *            the DOB to set
	 */
	public void setDOB(long DOB) {
		this.DOB = DOB;
	}

	/**
	 * @param Email
	 *            the Email to set
	 */
	public void setEmail(String Email) {
		this.Email = Email;
	}

	/**
	 * @param EmpID
	 *            the EmpID to set
	 */
	public void setEmpID(int EmpID) {
		this.EmpID = EmpID;
	}

	/**
	 * @param fixName
	 *            the fixName to set
	 */
	public void setFixName(String fixName) {
		this.fixName = fixName;
	}

	/**
	 * @param Gender
	 *            the Gender to set
	 */
	public void setGender(int Gender) {
		this.Gender = Gender;
	}

	/**
	 * @param Name
	 *            the Name to set
	 */
	public void setName(String Name) {
		this.Name = Name;
	}

	/**
	 * @param Password
	 *            the Password to set
	 */
	public void setPassword(String Password) {
		this.Password = Password;
	}

	/**
	 * @param Permission
	 *            the Permission to set
	 */
	public void setPermission(int Permission) {
		this.Permission = Permission;
	}

	/**
	 * @param Phone
	 *            the phone to set
	 */
	public void setPhone(String Phone) {
		this.Phone = Phone;
	}

	/**
	 * Convert employee to vector
	 */
	public Vector<Object> toVector() {
		Vector<Object> vt = new Vector<Object>();
		vt.addElement(EmpID);
		vt.addElement(Name);
		if (Gender == 1) {
			vt.addElement(Messages.getString("Employee.0")); //$NON-NLS-1$
		} else {
			vt.addElement(Messages.getString("Employee.1")); //$NON-NLS-1$
		}
		vt.addElement(Email);
		vt.addElement(Department);
		if (Permission == 1) {
			vt.addElement(Messages.getString("Employee.2")); //$NON-NLS-1$
		} else {
			vt.addElement(Messages.getString("Employee.3")); //$NON-NLS-1$
		}
		return vt;
	}
}
