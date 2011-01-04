/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Subject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CuongNQ
 */
public class AccessSub {

    //Defined instance of AccessEmp
    private static AccessSub instance = new AccessSub();
    private Connection cn = null;
    private ResultSet rsDetails = null;
    private CallableStatement csDetails = null;

    /*
     * Static method get instance of AccessEmp
     */
    public static AccessSub getInstance() {
        return instance;
    }

    /**
     * 
     * @param sub is subject object
     * @return true if add successful, otherwise false
     */
    public boolean addSubject(Subject sub) {
        //Defined connection, rs and cs to connect and query database
        Connection cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall("{call sp_AddSub(?,?)}");
            csDetails.setString(1, sub.getSubName());
            csDetails.setString(2, sub.getDescription());
            csDetails.execute();
            return true;
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
     * @param SubID
     * @return
     */
    public Subject getAnSubject(int SubID) {
        //Defined Object
        Subject emp = null;
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall("{call sp_GetSubByID(?)}");
            csDetails.setInt(1, SubID);
            rsDetails = csDetails.executeQuery();
            if (rsDetails.next()) {
                emp = new Subject(rsDetails.getInt(1), rsDetails.getString(2),
                        rsDetails.getString(3));
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
     * @param subModel is subject model of subject manage table
     */
    public void getAllSubject(DefaultTableModel subModel) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall("{call sp_GetAllSub}");
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                Vector vt = new Vector();
                vt.addElement(rsDetails.getInt(1));
                vt.addElement(rsDetails.getString(2));
                vt.addElement(rsDetails.getString(3));
                subModel.addRow(vt);
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
     * @param subModel is subject model
     * @param SubID is subject id
     * @param SubName is subject name
     */
    public void searchSubject(DefaultTableModel subModel, String SubID, String SubName) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            if (SubID.length() == 0 && SubName.length() != 0) {
                //Save Name only
                csDetails = cn.prepareCall("{call sp_GetSubByName(?)}");
                csDetails.setString(1, SubName);
            } else if (SubID.length() != 0 && SubName.length() == 0) {
                //Search EmpID only
                csDetails = cn.prepareCall("{call sp_GetSubByID(?)}");
                csDetails.setInt(1, new Integer(SubID));
            } else if (SubID.length() != 0 && SubName.length() != 0) {
                //Search both ID & Name
                csDetails = cn.prepareCall("{call sp_GetSubByAll(?,?)}");
                csDetails.setInt(1, new Integer(SubID));
                csDetails.setString(2, SubName);
            } else {
                getAllSubject(subModel);
                return;
            }
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                Vector vt = new Vector();
                vt.addElement(rsDetails.getInt(1));
                vt.addElement(rsDetails.getString(2));
                vt.addElement(rsDetails.getString(3));
                subModel.addRow(vt);
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
     * @param sub is subject object
     * @return true if edit successful, otherwise false
     */
    public boolean editSub(Subject sub) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();

        try {
            csDetails = cn.prepareCall("{call sp_EditSub(?,?,?)}");
            csDetails.setInt(1, sub.getSubID());
            csDetails.setString(2, sub.getSubName());
            csDetails.setString(3, sub.getDescription());
            csDetails.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
        return false;
    }
}
