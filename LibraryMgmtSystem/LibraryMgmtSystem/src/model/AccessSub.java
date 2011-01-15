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
 * Access to subject table
 * @author CuongNQ
 */
public class AccessSub {

    //Defined instance of AccessSub
    private static AccessSub instance = new AccessSub();
    private Connection cn = null;
    private ResultSet rsDetails = null;
    private CallableStatement csDetails = null;

    /**
     * Static method get instance of AccessSub
     */
    public static AccessSub getInstance() {
        return instance;
    }

    /**
     * Add a subject method
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
     * Get subject id method
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
     * Get a;; subject name and fill to add book form
     * @return subject name, will be split by "," char
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
     * Get subject object by subID
     * @param SubID
     * @return subject object
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
                //return subject object
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
     * Search subject from subject table
     * @param subModel
     * @param SubID
     * @param SubName
     * @param page
     * @return subject object found and total row in database
     */
    public int searchSubject(DefaultTableModel subModel,
            String SubID, String SubName, int page) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            if (SubID.length() == 0) {
                //Save Name only
                csDetails = cn.prepareCall(LibProcedure.GET_SUB_BY_NAME);
                csDetails.setString(1, SubName);
                csDetails.setInt(2, page);
                csDetails.setInt(3, LibUtil.noRow);
                csDetails.registerOutParameter(4, java.sql.Types.INTEGER);
            } else {
                //Search subID only
                csDetails = cn.prepareCall(LibProcedure.GET_SUB_BY_ID);
                csDetails.setInt(1, new Integer(SubID));
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
                subModel.addRow(vt);
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
     * Edit subject
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
     * Delete subject
     * @param subID
     * @return true if delete successful, otherwise false
     */
    public boolean deleteSub(int subID) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.DETELE_SUB);
            csDetails.setInt(1, subID);
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
