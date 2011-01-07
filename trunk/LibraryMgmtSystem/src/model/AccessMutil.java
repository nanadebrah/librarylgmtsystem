/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.CheckIn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

/**
 *
 * @author CuongNQ
 */
public class AccessMutil {

    //Defined
    private Connection cn = null;
    private ResultSet rsDetails = null;
    private CallableStatement csDetails = null;
    private CheckIn checkin;
    //Defined instance of AccessBook
    private static AccessMutil instance = new AccessMutil();

    /**
     * Static method get instance of AccessBook
     */
    public static AccessMutil getInstance() {
        return instance;
    }

    /**
     * 
     * @param searchModel
     * @param borID
     */
    public void searchCheckOutByBorID(TreeMap map, int borID) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.SEARCH_CHECKOUT_BY_BORID);
            csDetails.setInt(1, borID);
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                checkin = new CheckIn();
                checkin.setBorID(rsDetails.getInt(1));
                checkin.setEmpID(rsDetails.getInt(2));
                checkin.setCallNumber(rsDetails.getString(3));
                checkin.setISBN(rsDetails.getString(4));
                checkin.setTitle(rsDetails.getString(5));
                checkin.setAuth(rsDetails.getString(6));
                checkin.setPublisher(rsDetails.getString(7));
                checkin.setDueDate(rsDetails.getDate(8).getTime());
                checkin.setIssueDate(rsDetails.getDate(9).getTime());
                map.put(checkin.getBorID() + "," + checkin.getCallNumber(), checkin);
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
     * @param searchModel
     * @param CallNo
     * @param ISBN
     * @param Title
     * @param Auth
     */
    public void searchCheckOutByBookInfo(TreeMap map, String CallNo, String ISBN,
            String Title, String Auth) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.SEARCH_CHECKOUT_BY_BOOK_INFO);
            csDetails.setString(1, CallNo);
            csDetails.setString(2, ISBN);
            csDetails.setString(3, Title);
            csDetails.setString(4, Auth);
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                checkin = new CheckIn();
                checkin.setBorID(rsDetails.getInt(1));
                checkin.setEmpID(rsDetails.getInt(2));
                checkin.setCallNumber(rsDetails.getString(3));
                checkin.setISBN(rsDetails.getString(4));
                checkin.setTitle(rsDetails.getString(5));
                checkin.setAuth(rsDetails.getString(6));
                checkin.setPublisher(rsDetails.getString(7));
                checkin.setDueDate(rsDetails.getDate(8).getTime());
                checkin.setIssueDate(rsDetails.getDate(9).getTime());
                map.put(checkin.getBorID() + "," + checkin.getCallNumber(), checkin);
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

    public void searchCheckOutByEmpInfo(TreeMap map, String EmpID, String Name) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            if (EmpID.length() != 0 && Name.length() == 0) {
                csDetails = cn.prepareCall(LibProcedure.SERCH_CHECKOUT_BY_EMPID);
                csDetails.setInt(1, Integer.parseInt(EmpID));
            } else if (EmpID.length() == 0 && Name.length() != 0) {
                csDetails = cn.prepareCall(LibProcedure.SEARCH_CHECKOUT_BY_EMPNAME);
                csDetails.setString(1, Name);
            } else if (EmpID.length() != 0 && Name.length() != 0) {
                csDetails = cn.prepareCall(LibProcedure.SEARCH_CHECKOUT_BY_EMPNAME);
                csDetails.setInt(1, Integer.parseInt(EmpID));
                csDetails.setString(2, Name);
            } else {
                csDetails = cn.prepareCall(LibProcedure.SEARCH_ALL_CHECKOUT);
            }
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                checkin = new CheckIn();
                checkin.setBorID(rsDetails.getInt(1));
                checkin.setEmpID(rsDetails.getInt(2));
                checkin.setCallNumber(rsDetails.getString(3));
                checkin.setISBN(rsDetails.getString(4));
                checkin.setTitle(rsDetails.getString(5));
                checkin.setAuth(rsDetails.getString(6));
                checkin.setPublisher(rsDetails.getString(7));
                checkin.setDueDate(rsDetails.getDate(8).getTime());
                checkin.setIssueDate(rsDetails.getDate(9).getTime());
                map.put(checkin.getBorID() + "," + checkin.getCallNumber(), checkin);
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
