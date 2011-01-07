/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.BorrowDetail;
import entity.CheckIn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.Vector;
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
    private CheckIn checkin;
    private Vector vt;
    //Defined instance of AccessBook
    private static AccessBorrow instance = new AccessBorrow();

    /**
     * Static method get instance of AccessBook
     */
    public static AccessBorrow getInstance() {
        return instance;
    }

    public boolean checkOut(int empID, TreeMap map) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        BorrowDetail borDetail;
        java.util.Set set;
        set = map.keySet();
        java.util.Iterator it = set.iterator();
        try {
            csDetails = cn.prepareCall(LibProcedure.PREPARE_CHECKOUT);
            csDetails.setInt(1, empID);
            csDetails.execute();

            while (it.hasNext()) {
                borDetail = (BorrowDetail) map.get(it.next());
                csDetails = cn.prepareCall(LibProcedure.CHECK_OUT);
                csDetails.setString(1, borDetail.getCallNumber());
                csDetails.setDate(2, new Date(borDetail.getIssueDate()));
                csDetails.setDate(3, new Date(borDetail.getDueDate()));
                csDetails.execute();
            }
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
     * @param borModel
     * @param EmpID
     * @param CallNo
     */
    public void searchBor(DefaultTableModel borModel, String EmpID, String CallNo) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            if (EmpID.length() == 0 && CallNo.length() != 0) {
                //Search CallNo only
                csDetails = cn.prepareCall(LibProcedure.GET_BOR_BY_CALLNO);
                csDetails.setString(1, CallNo);
            } else if (EmpID.length() != 0 && CallNo.length() == 0) {
                //Search EmpID only
                csDetails = cn.prepareCall(LibProcedure.GET_BOR_BY_EMPID);
                csDetails.setInt(1, new Integer(EmpID));
            } else if (EmpID.length() != 0 && CallNo.length() != 0) {
                //Search both ID & CallNo
                csDetails = cn.prepareCall(LibProcedure.GET_BOR_BY_BOTH);
                csDetails.setString(1, CallNo);
                csDetails.setInt(2, new Integer(EmpID));
            } else {
                csDetails = cn.prepareCall(LibProcedure.GET_ALL_BORROW);
            }
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                vt = new Vector();
                vt.add(rsDetails.getInt(1));
                vt.add(rsDetails.getInt(2));
                vt.add(rsDetails.getString(3));
                vt.add(rsDetails.getString(4));
                vt.add(rsDetails.getString(5));
                vt.add(LibUtil.getInstance().convertDate(rsDetails.getDate(6).toString()));
                vt.add(LibUtil.getInstance().convertDate(rsDetails.getDate(7).toString()));
                if (rsDetails.getInt(8) == 0) {
                    vt.add("Checked-Out");
                    vt.add("--");
                    vt.add("--");
                } else {
                    vt.add("Checked-In");
                    vt.add(rsDetails.getDate(9));
                    vt.add(rsDetails.getFloat(10));
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
     * @param borID
     * @param CallNo
     * @param returnDate
     * @param totalfee
     * @return
     */
    public boolean checkIn(int borID, String CallNo,
            long returnDate, float totalfee) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();

        try {
            csDetails = cn.prepareCall(LibProcedure.CHECK_IN);
            csDetails.setInt(1, borID);
            csDetails.setString(2, CallNo);
            csDetails.setDate(3, new Date(returnDate));
            csDetails.setFloat(4, totalfee);
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

    /**
     *
     * @param map
     * @param EmpID
     * @param Name
     */
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
