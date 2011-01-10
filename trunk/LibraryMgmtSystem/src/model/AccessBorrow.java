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
    //Defined instance of AccessBorrow
    private static AccessBorrow instance = new AccessBorrow();

    /**
     * Static method get instance of AccessBook
     * @return instance of acessborrow
     */
    public static AccessBorrow getInstance() {
        return instance;
    }

    /**
     * 
     * @param empID
     * @param map
     * @return
     */
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
                csDetails.setInt(1, borDetail.getBookID());
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
     * @param page
     * @return
     */
    public int searchBor(DefaultTableModel borModel,
            String EmpID, String CallNo, int page) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            if (EmpID.length() == 0) {
                //Search CallNo only
                csDetails = cn.prepareCall(LibProcedure.GET_BOR_BY_CALLNO);
                csDetails.setString(1, CallNo);
                csDetails.setInt(2, page);
                csDetails.setInt(3, LibUtil.noRow);
                csDetails.registerOutParameter(4, java.sql.Types.INTEGER);
            } else {
                //Search EmpID only
                csDetails = cn.prepareCall(LibProcedure.GET_BOR_BY_EMPID);
                csDetails.setInt(1, new Integer(EmpID));
                csDetails.setInt(2, page);
                csDetails.setInt(3, LibUtil.noRow);
                csDetails.registerOutParameter(4, java.sql.Types.INTEGER);
            }
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                vt = new Vector();
                vt.add(rsDetails.getInt(1));
                vt.add(rsDetails.getInt(2));
                vt.add(rsDetails.getInt(3));
                vt.add(rsDetails.getString(4));
                vt.add(rsDetails.getString(5));
                vt.add(rsDetails.getString(6));
                vt.add(LibUtil.getInstance().convertDate(rsDetails.getDate(7).toString()));
                vt.add(LibUtil.getInstance().convertDate(rsDetails.getDate(8).toString()));
                if (rsDetails.getInt(9) == 0) {
                    vt.add("Checked-Out");
                    vt.add("--");
                    vt.add("--");
                } else {
                    vt.add("Checked-In");
                    vt.add(rsDetails.getDate(10));
                    vt.add(rsDetails.getFloat(11));
                }
                borModel.addRow(vt);
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
     * @param borID
     * @param bookID
     * @param returnDate
     * @param totalfee
     * @return
     */
    public boolean checkIn(int borID, int bookID,
            long returnDate, float totalfee) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();

        try {
            csDetails = cn.prepareCall(LibProcedure.CHECK_IN);
            csDetails.setInt(1, borID);
            csDetails.setInt(2, bookID);
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
     * @param map
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
     * @param map
     * @param CallNo
     * @param ISBN
     * @param Title
     * @param Auth
     * @param page
     * @return
     */
    public int searchCheckOutByBookInfo(TreeMap map, String CallNo, String ISBN,
            String Title, String Auth, int page) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.SEARCH_CHECKOUT_BY_BOOK_INFO);
            csDetails.setString(1, CallNo);
            csDetails.setString(2, ISBN);
            csDetails.setString(3, Title);
            csDetails.setString(4, Auth);
            csDetails.setInt(5, page);
            csDetails.setInt(6, LibUtil.noRow);
            csDetails.registerOutParameter(7, java.sql.Types.INTEGER);
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                checkin = new CheckIn();
                checkin.setBorID(rsDetails.getInt(1));
                checkin.setEmpID(rsDetails.getInt(2));
                checkin.setBookID(rsDetails.getInt(3));
                checkin.setCallNumber(rsDetails.getString(4));
                checkin.setISBN(rsDetails.getString(5));
                checkin.setTitle(rsDetails.getString(6));
                checkin.setAuth(rsDetails.getString(7));
                checkin.setPublisher(rsDetails.getString(8));
                checkin.setDueDate(rsDetails.getDate(9).getTime());
                checkin.setIssueDate(rsDetails.getDate(10).getTime());
                map.put(checkin.getBorID() + "," + checkin.getBookID(), checkin);
            }
            return csDetails.getInt(7);
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
     * @param map
     * @param EmpID
     * @param Name
     * @param page
     * @return
     */
    public int searchCheckOutByEmpInfo(TreeMap map, String EmpID,
            String Name, int page) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            if (EmpID.length() != 0) {
                csDetails = cn.prepareCall(LibProcedure.SERCH_CHECKOUT_BY_EMPID);
                csDetails.setInt(1, Integer.parseInt(EmpID));
                csDetails.setInt(2, page);
                csDetails.setInt(3, LibUtil.noRow);
                csDetails.registerOutParameter(4, java.sql.Types.INTEGER);
            } else {
                csDetails = cn.prepareCall(LibProcedure.SEARCH_CHECKOUT_BY_EMPNAME);
                csDetails.setString(1, Name);
                csDetails.setInt(2, page);
                csDetails.setInt(3, LibUtil.noRow);
                csDetails.registerOutParameter(4, java.sql.Types.INTEGER);
            }
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                checkin = new CheckIn();
                checkin.setBorID(rsDetails.getInt(1));
                checkin.setEmpID(rsDetails.getInt(2));
                checkin.setBookID(rsDetails.getInt(3));
                checkin.setCallNumber(rsDetails.getString(4));
                checkin.setISBN(rsDetails.getString(5));
                checkin.setTitle(rsDetails.getString(6));
                checkin.setAuth(rsDetails.getString(7));
                checkin.setPublisher(rsDetails.getString(8));
                checkin.setDueDate(rsDetails.getDate(9).getTime());
                checkin.setIssueDate(rsDetails.getDate(10).getTime());
                map.put(checkin.getBorID() + "," + checkin.getBookID(), checkin);
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
     * @param arr
     * @param borID
     * @param empID
     * @param bookID
     */
    public void getFullBorInfo(String[] arr, int borID, int empID, int bookID) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.GET_FULL_BOR_INFO);
            csDetails.setInt(1, borID);
            csDetails.setInt(2, empID);
            csDetails.setInt(3, bookID);
            rsDetails = csDetails.executeQuery();
            if (rsDetails.next()) {
                arr[0] = String.valueOf(rsDetails.getInt(1));
                arr[1] = rsDetails.getString(2);
                arr[2] = LibUtil.getInstance().convertDate(rsDetails.getDate(3).toString());
                if (rsDetails.getInt(4) == 1) {
                    arr[3] = "Male";
                } else {
                    arr[3] = "Female";
                }
                arr[4] = rsDetails.getString(5);
                arr[5] = rsDetails.getString(6);
                arr[6] = rsDetails.getString(7);
                arr[7] = rsDetails.getString(8);
                if (rsDetails.getInt(9) == 1) {
                    arr[8] = "Librarian";
                } else {
                    arr[8] = "Employee";
                }
                arr[9] = String.valueOf(rsDetails.getInt(10));
                if (rsDetails.getInt(11) == 0) {
                    arr[10] = "Checked-Out";
                    arr[13] = "--";
                    arr[14] = "--";
                } else {
                    arr[10] = "Checked-In";
                    arr[13] = LibUtil.getInstance().convertDate(rsDetails.getDate(14).toString());
                    arr[14] = String.valueOf(rsDetails.getFloat(15));
                }
                arr[11] = LibUtil.getInstance().convertDate(rsDetails.getDate(12).toString());
                arr[12] = LibUtil.getInstance().convertDate(rsDetails.getDate(13).toString());
                arr[15] = rsDetails.getString(16);
                arr[16] = rsDetails.getString(17);
                arr[17] = rsDetails.getString(18);
                arr[18] = rsDetails.getString(19);
                arr[19] = rsDetails.getString(20);
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
     * @param CallNumber
     * @return
     */
    public boolean deleteBorrow(int borID, int bookID) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.DETELE_BORROW);
            csDetails.setInt(1, borID);
            csDetails.setInt(2, bookID);
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
