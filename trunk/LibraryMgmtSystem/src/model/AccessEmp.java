/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.LibPassword;
import entity.Employee;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CuongNQ
 */
public class AccessEmp {

    //Defined instance of AccessEmp
    private static AccessEmp instance = new AccessEmp();

    /*
     * Static method get instance of AccessEmp
     */
    public static AccessEmp getInstance() {
        return instance;
    }

    /**
     *
     * @param EmpID is ID to query on database
     * @return Employee queried
     */
    public Employee getAEmp(int EmpID) {
        //Defined Object
        Employee emp = null;
        //Defined connection, rs and cs to connect and query database
        Connection cn = LibConnection.getConnection();
        ResultSet rsDetails = null;
        CallableStatement csDetails = null;
        try {
            csDetails = cn.prepareCall("{call sp_GetEmp(?)}");
            csDetails.setInt(1, EmpID);
            rsDetails = csDetails.executeQuery();
            if (rsDetails.next()) {
                emp = new Employee();
                //Set all field on database to employee object
                emp.setEmpID(rsDetails.getInt(1));
                emp.setName(rsDetails.getString(2));
                emp.setDOB(rsDetails.getDate(3).getTime());
                emp.setGender(rsDetails.getInt(4));
                emp.setEmail(rsDetails.getString(5));
                emp.setAddress(rsDetails.getString(7));
                emp.setPhone(rsDetails.getString(8));
                emp.setPermission(rsDetails.getInt(9));
                emp.setDepartment(rsDetails.getString(10));
                //close all connect
                LibConnection.close(rsDetails);
                LibConnection.close(csDetails);
                LibConnection.close(cn);
                //return employee object
                return emp;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(rsDetails);
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
        return null;
    }

    /**
     *
     * @param emp is employee object to add to database
     */
    public void addEmp(Employee emp) {
        //Defined connection, rs and cs to connect and query database
        Connection cn = LibConnection.getConnection();
        CallableStatement csDetails = null;

        try {
            if (emp.getPermission() == 1) {
                csDetails = cn.prepareCall("{call sp_InsLib(?,?,?,?,?,?,?,?)}");
                csDetails.setString(1, emp.getName());
                csDetails.setDate(2, new Date(emp.getDOB()));
                csDetails.setInt(3, emp.getGender());
                csDetails.setString(4, emp.getEmail());
                csDetails.setString(5, LibPassword.getInstance().encryptMD5(
                        emp.getPassword()));
                csDetails.setString(6, emp.getAddress());
                csDetails.setString(7, emp.getPhone());
                csDetails.setString(8, emp.getDepartment());
                csDetails.execute();
                JOptionPane.showMessageDialog(null, "Add librarian successful",
                        "Successful!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                csDetails = cn.prepareCall("{call sp_InsEmp(?,?,?,?,?,?,?)}");
                csDetails.setString(1, emp.getName());
                csDetails.setDate(2, new Date(emp.getDOB()));
                csDetails.setInt(3, emp.getGender());
                csDetails.setString(4, emp.getEmail());
                csDetails.setString(5, emp.getAddress());
                csDetails.setString(6, emp.getPhone());
                csDetails.setString(7, emp.getDepartment());
                csDetails.execute();
                JOptionPane.showMessageDialog(null, "Add employee successful",
                        "Successful!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
    }

    /**
     *
     * @param empModel is Table model to get all data employee
     */
    public void getAllEmp(DefaultTableModel empModel) {
        //Defined connection, rs and cs to connect and query database
        Connection cn = LibConnection.getConnection();
        ResultSet rsDetails = null;
        CallableStatement csDetails = null;
        try {
            csDetails = cn.prepareCall("{call sp_GetAllEmp}");
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                Vector vt = new Vector();
                vt.addElement(rsDetails.getInt(1));
                vt.addElement(rsDetails.getString(2));
                if (rsDetails.getInt(3) == 1) {
                    vt.addElement("Male");
                } else {
                    vt.addElement("Female");
                }
                vt.addElement(rsDetails.getString(4));
                vt.addElement(rsDetails.getString(5));
                if (rsDetails.getInt(6) == 1) {
                    vt.addElement("Librarian");
                } else {
                    vt.addElement("Employee");
                }
                empModel.addRow(vt);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(rsDetails);
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
    }

    /**
     *
     * @param emp is employee to update in database
     */
    public void editEmp(Employee emp) {
        //Defined connection, rs and cs to connect and query database
        Connection cn = LibConnection.getConnection();
        CallableStatement csDetails = null;

        try {
            if (emp.getPermission() == 1) {
                csDetails = cn.prepareCall("{call sp_EditLib(?,?,?,?,?,?,?,?,?)}");
                csDetails.setInt(1, emp.getEmpID());
                csDetails.setString(2, emp.getName());
                csDetails.setDate(3, new Date(emp.getDOB()));
                csDetails.setInt(4, emp.getGender());
                csDetails.setString(5, emp.getEmail());
                csDetails.setString(6, LibPassword.getInstance().encryptMD5(
                        emp.getPassword()));
                csDetails.setString(7, emp.getAddress());
                csDetails.setString(8, emp.getPhone());
                csDetails.setString(9, emp.getDepartment());
                csDetails.execute();
                JOptionPane.showMessageDialog(null, "Update librarian successful",
                        "Successful!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                csDetails = cn.prepareCall("{call sp_EditEmp(?,?,?,?,?,?,?,?)}");
                csDetails.setInt(1, emp.getEmpID());
                csDetails.setString(2, emp.getName());
                csDetails.setDate(3, new Date(emp.getDOB()));
                csDetails.setInt(4, emp.getGender());
                csDetails.setString(5, emp.getEmail());
                csDetails.setString(6, emp.getAddress());
                csDetails.setString(7, emp.getPhone());
                csDetails.setString(8, emp.getDepartment());
                csDetails.execute();
                JOptionPane.showMessageDialog(null, "Update employee successful",
                        "Successful!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
    }

    /**
     *
     * @param empModel is Table model to get all data employee
     * @param EmpID is employee's ID to find
     * @param Name is employee's name fo find
     */
    public void searchEmp(DefaultTableModel empModel, String EmpID, String Name) {
        //Defined connection, rs and cs to connect and query database
        Connection cn = LibConnection.getConnection();
        ResultSet rsDetails = null;
        CallableStatement csDetails = null;
        try {
            if (EmpID.length() == 0 && Name.length() != 0) {
                //Save Name only
                csDetails = cn.prepareCall("{call sp_GetAnEmpWithName(?)}");
                csDetails.setString(1, Name);
            } else if (EmpID.length() != 0 && Name.length() == 0) {
                //Search EmpID only
                csDetails = cn.prepareCall("{call sp_GetAnEmpWithEmpID(?)}");
                csDetails.setInt(1, new Integer(EmpID));
            } else if (EmpID.length() != 0 && Name.length() != 0) {
                //Search both ID & Name
                csDetails = cn.prepareCall("{call sp_GetAnEmpAll(?,?)}");
                csDetails.setInt(1, new Integer(EmpID));
                csDetails.setString(2, Name);
            } else {
                getAllEmp(empModel);
                return;
            }
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                Vector vt = new Vector();
                vt.addElement(rsDetails.getInt(1));
                vt.addElement(rsDetails.getString(2));
                if (rsDetails.getInt(3) == 1) {
                    vt.addElement("Male");
                } else {
                    vt.addElement("Female");
                }
                vt.addElement(rsDetails.getString(4));
                vt.addElement(rsDetails.getString(5));
                if (rsDetails.getInt(6) == 1) {
                    vt.addElement("Librarian");
                } else {
                    vt.addElement("Employee");
                }
                empModel.addRow(vt);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(rsDetails);
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
    }
}
