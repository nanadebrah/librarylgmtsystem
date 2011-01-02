/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.Objects;

/**
 *
 * @author CuongNQ
 */
public class Employee {

    private int EmpID;
    private String Name;
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
    //Param constructor

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
     * @param phone the phone to set
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
}
