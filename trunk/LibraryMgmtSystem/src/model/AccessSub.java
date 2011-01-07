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

    /**
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
            csDetails = cn.prepareCall(LibProcedure.ADD_SUB);
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
     * @param subName
     * @return
     */
    public int getSubjectID(String subName) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.GET_SUBID);
            csDetails.setString(1, subName);
            rsDetails = csDetails.executeQuery();
            if (rsDetails.next()) {
                return rsDetails.getInt(1);
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
     * @param subID
     * @return
     */
    public String getSubjectName(int subID) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.GET_SUBNAME);
            csDetails.setInt(1, subID);
            rsDetails = csDetails.executeQuery();
            if (rsDetails.next()) {
                return rsDetails.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(rsDetails);
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
        return "";
    }

    /**
     * 
     * @return
     */
    public String getAllSubjectName() {
        String sub = "";
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.GET_ALL_SUBNAME);
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                sub += rsDetails.getString(1) + ",";
            }
            return sub;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(rsDetails);
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
        return "";
    }

    /**
     * 
     * @param SubID
     * @return
     */
    public Subject getSubject(int SubID) {
        //Defined Object
        Subject sub = null;
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.GET_SUB);
            csDetails.setInt(1, SubID);
            rsDetails = csDetails.executeQuery();
            if (rsDetails.next()) {
                sub = new Subject(rsDetails.getInt(1), rsDetails.getString(2),
                        rsDetails.getString(3));
                //return employee object
                return sub;
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
            csDetails = cn.prepareCall(LibProcedure.GET_ALL_SUB);
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
                csDetails = cn.prepareCall(LibProcedure.GET_SUB_BY_NAME);
                csDetails.setString(1, SubName);
            } else if (SubID.length() != 0 && SubName.length() == 0) {
                //Search EmpID only
                csDetails = cn.prepareCall(LibProcedure.GET_SUB);
                csDetails.setInt(1, new Integer(SubID));
            } else if (SubID.length() != 0 && SubName.length() != 0) {
                //Search both ID & Name
                csDetails = cn.prepareCall(LibProcedure.GET_SUB_BY_BOTH);
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
            csDetails = cn.prepareCall(LibProcedure.EDIT_SUB);
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

    /**
     *
     * @return
     */
    public int getNewestSub() {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        //Defined book

        try {
            csDetails = cn.prepareCall(LibProcedure.GET_NEWEST_SUB);
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
}
