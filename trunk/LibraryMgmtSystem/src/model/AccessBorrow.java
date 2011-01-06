/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.BorrowDetail;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CuongNQ
 */
public class AccessBorrow {

    //Defined
    private Connection cn = null;
    private ResultSet rsDetails = null;
    private CallableStatement csDetails = null;
    //Defined instance of AccessBook
    private static AccessBorrow instance = new AccessBorrow();

    /**
     * Static method get instance of AccessBook
     */
    public static AccessBorrow getInstance() {
        return instance;
    }

    /**
     *
     * @param EmpID
     * @return
     */
    public boolean addBorrow(int EmpID) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();

        try {
            csDetails = cn.prepareCall(LibProcedure.ADDBORROW);
            csDetails.setInt(1, EmpID);
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
     * @param borDetail
     * @return
     */
    public boolean addBorDetail(BorrowDetail borDetail) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();

        try {
            csDetails = cn.prepareCall(LibProcedure.ADDBORDETAIL);
            csDetails.setInt(1, borDetail.getBorID());
            csDetails.setString(2, borDetail.getCallNumber());
            csDetails.setInt(3, borDetail.getIssueStatus());
            csDetails.setDate(4, new Date(borDetail.getIssueDate()));
            csDetails.setDate(5, new Date(borDetail.getDueDate()));
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
     * @param borID
     * @return
     */
    public int getNewestBorrowID() {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();

        try {
            csDetails = cn.prepareCall(LibProcedure.GETNEWESTBORROWID);
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

    public BorrowDetail getNewestBorrow(DefaultTableModel borModel) {
        BorrowDetail borDetail = new BorrowDetail();
        int newestID=getNewestBorrowID();
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.GETBORROWBYBORID);
            csDetails.setInt(1, newestID);
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                borDetail.setBorID(rsDetails.getInt(1));
                borDetail.setEmpID(rsDetails.getInt(2));
                borDetail.setCallNumber(rsDetails.getString(3));
                borDetail.setIssueDate(rsDetails.getDate(4).getTime());
                borDetail.setDueDate(rsDetails.getDate(5).getTime());
                borDetail.setIssueStatus(rsDetails.getInt(6));
                borModel.addRow(borDetail.toVector());
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
     * @param EmpID
     * @param CallNo
     */
    public void searchBor(DefaultTableModel borModel, String EmpID, String CallNo) {
        BorrowDetail borDetail = new BorrowDetail();
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            if (EmpID.length() == 0 && CallNo.length() != 0) {
                //Search CallNo only
                csDetails = cn.prepareCall(LibProcedure.GETBORBYCALLNO);
                csDetails.setString(1, CallNo);
            } else if (EmpID.length() != 0 && CallNo.length() == 0) {
                //Search EmpID only
                csDetails = cn.prepareCall(LibProcedure.GETBORBYEMPID);
                csDetails.setInt(1, new Integer(EmpID));
            } else if (EmpID.length() != 0 && CallNo.length() != 0) {
                //Search both ID & CallNo
                csDetails = cn.prepareCall(LibProcedure.GETBORBYBOTH);
                csDetails.setString(1, CallNo);
                csDetails.setInt(2, new Integer(EmpID));
            } else {
                csDetails = cn.prepareCall(LibProcedure.GETALLBORROW);
            }
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                borDetail.setBorID(rsDetails.getInt(1));
                borDetail.setEmpID(rsDetails.getInt(2));
                borDetail.setCallNumber(rsDetails.getString(3));
                borDetail.setIssueDate(rsDetails.getDate(4).getTime());
                borDetail.setDueDate(rsDetails.getDate(5).getTime());
                borDetail.setIssueStatus(rsDetails.getInt(6));
                borModel.addRow(borDetail.toVector());
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
