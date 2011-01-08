/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Employee;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CuongNQ
 */
public class AccessEmp {

    //Defined instance of AccessEmp
    private static AccessEmp instance = new AccessEmp();
    private Connection cn = null;
    private ResultSet rsDetails = null;
    private CallableStatement csDetails = null;

    /**
     * 
     * @return
     */
    public static AccessEmp getInstance() {
        return instance;
    }

    /**
     *
     * @param EmpID is ID to query on database
     * @return Employee queried
     */
    public Employee getEmpInfo(int EmpID) {
        //Defined Object
        Employee emp = null;
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.GET_EMP_INFO);
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
     * @param borModel
     * @param empID
     */
    public void getEmpBorInfo(DefaultTableModel borModel, int empID) {
        java.util.Vector vt;
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.GET_EMP_BOR_INFO);
            csDetails.setInt(1, empID);
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                vt = new java.util.Vector();
                vt.addElement(rsDetails.getInt(1));
                vt.addElement(rsDetails.getString(2));
                vt.addElement(rsDetails.getString(3));
                vt.addElement(LibUtil.getInstance().convertDate(
                        rsDetails.getDate(4).toString()));
                vt.addElement(LibUtil.getInstance().convertDate(
                        rsDetails.getDate(5).toString()));
                if (rsDetails.getInt(6) == 0) {
                    vt.addElement("Checked-Out");
                    vt.addElement("--");
                    vt.addElement("--");
                } else {
                    vt.addElement("Checked-In");
                    vt.addElement(LibUtil.getInstance().convertDate(
                            rsDetails.getDate(7).toString()));
                    vt.addElement(rsDetails.getFloat(8));
                }
                borModel.addRow(vt);
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
     * @param emp
     * @return
     */
    public boolean addEmp(Employee emp) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            if (emp.getPermission() == 1) {
                csDetails = cn.prepareCall(LibProcedure.ADD_LIB);
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
                return true;
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
            //close all connect
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
        return false;
    }

    /**
     * 
     * @param emp
     * @return
     */
    public boolean editEmp(Employee emp) {
        //Defined connection, rs and cs to connect and query database
        Connection cn = LibConnection.getConnection();
        try {
            if (emp.getPermission() == 1) {
                csDetails = cn.prepareCall(LibProcedure.EDIT_LIB);
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
                return true;
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
            //close all connect
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
        return false;
    }

    /**
     * 
     * @param empModel
     * @param EmpID
     * @param Name
     * @param page
     * @param totalRow
     * @return
     */
    public int searchEmp(DefaultTableModel empModel, String EmpID,
            String Name, int page) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            if (EmpID.length() == 0) {
                //Search Name only
                csDetails = cn.prepareCall(LibProcedure.GET_EMP_BY_NAME);
                csDetails.setString(1, Name);
                csDetails.setInt(2, page);
                csDetails.setInt(3, LibUtil.noRow);
                csDetails.registerOutParameter(4, java.sql.Types.INTEGER);
            } else {
                //Search EmpID only
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
            return csDetails.getInt(4);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(rsDetails);
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
        return 1;
    }

    /**
     *
     * @return
     */
    public int getNewestEmp() {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        //Defined book

        try {
            csDetails = cn.prepareCall(LibProcedure.GET_NEWEST_EMP);
            rsDetails = csDetails.executeQuery();
            if (rsDetails.next()) {
                return rsDetails.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(rsDetails);
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
        return 0;
    }

    /**
     * 
     * @param empID
     * @return
     */
    public boolean deleteEmp(int empID) {
        //If root, return it
        if (empID == 1) {
            return false;
        }
        //Defined connection, rs and cs to connect and query database
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
            //close all connect
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
        return true;
    }
}
