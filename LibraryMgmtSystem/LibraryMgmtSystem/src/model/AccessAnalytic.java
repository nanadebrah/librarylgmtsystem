/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CuongNQ
 */
public class AccessAnalytic {

    //Defined
    private Connection cn = null;
    private ResultSet rsDetails = null;
    private CallableStatement csDetails = null;
    //Defined instance of AccessAnalytic
    private static AccessAnalytic instance = new AccessAnalytic();

    /**
     *  Create instance of AccessAnalytic
     * @return instance of AccessAnalytic
     */
    public static AccessAnalytic getInstance() {
        return instance;
    }

    /**
     *  Acess to database to get top book brrowed
     * @param anaModel is model to add book infomation get from database
     * @param page is nevagation bar proces
     * @return total row from database to calculate page
     */
    public int getTopBook(DefaultTableModel anaModel, int page) {
        java.util.Vector vt;
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.TOP_BOOK);
            csDetails.setInt(1, page);
            csDetails.setInt(2, LibUtil.noRow);
            csDetails.registerOutParameter(3, java.sql.Types.INTEGER);
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                vt = new java.util.Vector();
                vt.addElement(rsDetails.getInt(1));
                vt.addElement(rsDetails.getString(2));
                vt.addElement(rsDetails.getString(3));
                vt.addElement(rsDetails.getString(4));
                vt.addElement(rsDetails.getString(5));
                vt.addElement(rsDetails.getString(6));
                vt.addElement(rsDetails.getString(7));
                vt.addElement(rsDetails.getInt(8));
                anaModel.addRow(vt);
            }
            return csDetails.getInt(3);
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
     *  Acess to database to get top book brrowed
     * @param anaModel is model to add brrower infomation get from database
     * @param page is nevagation bar proces
     * @return total row from database to calculate page 
     */
    public int getTopBorrower(DefaultTableModel anaModel, int page) {
        java.util.Vector vt;
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.TOP_BORROWER);
            csDetails.setInt(1, page);
            csDetails.setInt(2, LibUtil.noRow);
            csDetails.registerOutParameter(3, java.sql.Types.INTEGER);
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                vt = new java.util.Vector();
                vt.addElement(rsDetails.getInt(1));
                vt.addElement(rsDetails.getString(2));
                vt.addElement(rsDetails.getString(3));
                vt.addElement(rsDetails.getString(4));
                vt.addElement(rsDetails.getString(5));
                vt.addElement(rsDetails.getString(6));
                vt.addElement(rsDetails.getString(7));
                vt.addElement(rsDetails.getInt(8));
                anaModel.addRow(vt);
            }
            return csDetails.getInt(3);
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
}
