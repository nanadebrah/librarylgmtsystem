/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Vector;

/**
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

    //Default constructor
    public Employee() {
    }

    /**
     * 
     * @param EmpID
     * @param Name
     * @param DOB
     * @param Gender
     * @param Email
     * @param Password
     * @param Address
     * @param Permission
     * @param Department
     * @param Phone
     */
    public Employee(int EmpID, String Name, long DOB, int Gender,
            String Email, String Password, String Address,
            int Permission, String Department, String Phone) {
        this.EmpID = EmpID;
        this.DOB = DOB;
        this.Gender = Gender;
        this.Email = Email;
        this.Password = Password;
        this.Address = Address;
        this.Permission = Permission;
        this.Department = Department;
        this.Phone = Phone;
    }

    /**
     * @return the EmpID
     */
    public int getEmpID() {
        return EmpID;
    }

    /**
     * @param EmpID the EmpID to set
     */
    public void setEmpID(int EmpID) {
        this.EmpID = EmpID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the DOB
     */
    public long getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(long DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the Gender
     */
    public int getGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(int Gender) {
        this.Gender = Gender;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Permission
     */
    public int getPermission() {
        return Permission;
    }

    /**
     * @param Permission the Permission to set
     */
    public void setPermission(int Permission) {
        this.Permission = Permission;
    }

    /**
     * @return the Department
     */
    public String getDepartment() {
        return Department;
    }

    /**
     * @param Department the Department to set
     */
    public void setDepartment(String Department) {
        this.Department = Department;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * @param Phone the phone to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * Convert employee to vector
     */
    public Vector toVector() {
        Vector vt = new Vector();
        vt.addElement(EmpID);
        vt.addElement(Name);
        if (Gender == 1) {
            vt.addElement("Male");
        } else {
            vt.addElement("Female");
        }
        vt.addElement(Email);
        vt.addElement(Department);
        if (Permission == 1) {
            vt.addElement("Librarian");
        } else {
            vt.addElement("Employee");
        }
        return vt;
    }

    /**
     * @return the fixName
     */
    public String getFixName() {
        return fixName;
    }

    /**
     * @param fixName the fixName to set
     */
    public void setFixName(String fixName) {
        this.fixName = fixName;
    }
}
