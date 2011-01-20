/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import entity.BorrowDetail;
import entity.CheckIn;

/**
 * Access borrow table
 * 
 * @author CuongNQ
 */
public class AccessBorrow {

	// Defined
	private Connection cn = null;
	private ResultSet rsDetails = null;
	private CallableStatement csDetails = null;
	private CheckIn checkin;
	private Vector<Object> vt;
	// Defined instance of AccessBorrow
	private static AccessBorrow instance = new AccessBorrow();

	/**
	 * Static method get instance of AccessBorrow
	 * 
	 * @return instance of accessborrow
	 */
	public static AccessBorrow getInstance() {
		return instance;
	}

	/**
	 * Check in borrow had checked-out, return book
	 * 
	 * @param borID
	 * @param bookID
	 * @param returnDate
	 * @param totalfee
	 * @return true if successful, otherwise false
	 */
	public boolean checkIn(int borID, int bookID, long returnDate,
			float totalfee) {
		// Defined connection, rs and cs to connect and query database
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
			// close all connect
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return false;
	}

	/**
	 * Add a checkout information to table
	 * 
	 * @param empID
	 * @param map
	 * @return true if add successful, otherwise false
	 */
	public boolean checkOut(int empID, TreeMap<Object, Object> map) {
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		BorrowDetail borDetail;
		java.util.Set<Object> set;
		set = map.keySet();
		java.util.Iterator<Object> it = set.iterator();
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
			// close all connect
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return false;
	}

	/**
	 * Delete borrow (All borrow details and borrow)
	 * 
	 * @param borID
	 * @param bookID
	 * @return true if delete successful, otherwise false
	 */
	public boolean deleteBorrow(int borID, int bookID) {
		// Defined connection, rs and cs to connect and query database
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
			// close all connect
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return true;
	}

	/**
	 * Get full borrow details information
	 * 
	 * @param arr
	 * @param borID
	 * @param empID
	 * @param bookID
	 */
	public void getFullBorInfo(String[] arr, int borID, int empID, int bookID) {
		// Defined connection, rs and cs to connect and query database
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
				arr[2] = LibUtil.getInstance().convertDate(
						rsDetails.getDate(3).toString());
				if (rsDetails.getInt(4) == 1) {
					arr[3] = Messages.getString("AccessBorrow.0"); //$NON-NLS-1$
				} else {
					arr[3] = Messages.getString("AccessBorrow.1"); //$NON-NLS-1$
				}
				arr[4] = rsDetails.getString(5);
				arr[5] = rsDetails.getString(6);
				arr[6] = rsDetails.getString(7);
				arr[7] = rsDetails.getString(8);
				if (rsDetails.getInt(9) == 1) {
					arr[8] = Messages.getString("AccessBorrow.2"); //$NON-NLS-1$
				} else {
					arr[8] = Messages.getString("AccessBorrow.3"); //$NON-NLS-1$
				}
				arr[9] = String.valueOf(rsDetails.getInt(10));
				if (rsDetails.getInt(11) == 0) {
					arr[10] = Messages.getString("AccessBorrow.4"); //$NON-NLS-1$
					arr[13] = Messages.getString("AccessBorrow.5"); //$NON-NLS-1$
					arr[14] = Messages.getString("AccessBorrow.6"); //$NON-NLS-1$
				} else {
					arr[10] = Messages.getString("AccessBorrow.7"); //$NON-NLS-1$
					arr[13] = LibUtil.getInstance().convertDate(
							rsDetails.getDate(14).toString());
					arr[14] = Messages.getString("AccessBorrow.8")
							+ String.valueOf(rsDetails.getFloat(15));
				}
				arr[11] = LibUtil.getInstance().convertDate(
						rsDetails.getDate(12).toString());
				arr[12] = LibUtil.getInstance().convertDate(
						rsDetails.getDate(13).toString());
				arr[15] = rsDetails.getString(16);
				arr[16] = rsDetails.getString(17);
				arr[17] = rsDetails.getString(18);
				arr[18] = rsDetails.getString(19);
				arr[19] = rsDetails.getString(20);
				arr[20] = rsDetails.getString(21);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(rsDetails);
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
	}

	/**
	 * Search borrow information
	 * 
	 * @param borModel
	 * @param EmpID
	 * @param CallNo
	 * @param page
	 * @return total row in database
	 */
	public int searchBor(DefaultTableModel borModel, String EmpID,
			String CallNo, int page) {
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			if (EmpID.length() == 0) {
				// Search CallNo only
				csDetails = cn.prepareCall(LibProcedure.GET_BOR_BY_CALLNO);
				csDetails.setString(1, CallNo);
				csDetails.setInt(2, page);
				csDetails.setInt(3, LibUtil.noRow);
				csDetails.registerOutParameter(4, java.sql.Types.INTEGER);
			} else {
				// Search EmpID only
				csDetails = cn.prepareCall(LibProcedure.GET_BOR_BY_EMPID);
				csDetails.setInt(1, new Integer(EmpID));
				csDetails.setInt(2, page);
				csDetails.setInt(3, LibUtil.noRow);
				csDetails.registerOutParameter(4, java.sql.Types.INTEGER);
			}
			rsDetails = csDetails.executeQuery();
			while (rsDetails.next()) {
				vt = new Vector<Object>();
				vt.add(rsDetails.getInt(1));
				vt.add(rsDetails.getInt(2));
				vt.add(rsDetails.getInt(3));
				vt.add(rsDetails.getString(4));
				vt.add(rsDetails.getString(5));
				vt.add(rsDetails.getString(6));
				vt.add(LibUtil.getInstance().convertDate(
						rsDetails.getDate(7).toString()));
				vt.add(LibUtil.getInstance().convertDate(
						rsDetails.getDate(8).toString()));
				if (rsDetails.getInt(9) == 0) {
					vt.add(Messages.getString("AccessBorrow.9")); //$NON-NLS-1$
					vt.add(Messages.getString("AccessBorrow.10")); //$NON-NLS-1$
					vt.add(Messages.getString("AccessBorrow.11")); //$NON-NLS-1$
				} else {
					vt.add(Messages.getString("AccessBorrow.12")); //$NON-NLS-1$
					vt.add(rsDetails.getDate(10));
					vt.add(rsDetails.getFloat(11));
				}
				borModel.addRow(vt);
			}
			return csDetails.getInt(4);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(rsDetails);
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return 1;
	}

	/**
	 * Search checking out borrow to send alert
	 * 
	 * @param anaModel
	 * @param dueDate
	 * @param page
	 * @return total row in database
	 */
	@SuppressWarnings("deprecation")
	public int searchCheckingOut(DefaultTableModel anaModel,
			java.util.Date dueDate, int page) {
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();

		try {
			if (dueDate == null) {
				dueDate = new java.util.Date(2030, 1, 1);
			}
			// Search
			csDetails = cn.prepareCall(LibProcedure.GET_CHECKING_OUT);
			csDetails.setDate(1, new Date(dueDate.getTime()));
			csDetails.setInt(2, page);
			csDetails.setInt(3, LibUtil.noRow);
			csDetails.registerOutParameter(4, java.sql.Types.INTEGER);
			rsDetails = csDetails.executeQuery();
			while (rsDetails.next()) {
				vt = new Vector<Object>();
				vt.add(rsDetails.getInt(1));
				vt.add(rsDetails.getInt(2));
				vt.add(rsDetails.getInt(3));
				vt.add(rsDetails.getString(4));
				vt.add(rsDetails.getString(5));
				vt.add(rsDetails.getString(6));
				vt.add(LibUtil.getInstance().convertDate(
						rsDetails.getDate(7).toString()));
				vt.add(LibUtil.getInstance().convertDate(
						rsDetails.getDate(8).toString()));
				anaModel.addRow(vt);
			}
			return csDetails.getInt(4);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(rsDetails);
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return 1;
	}

	/**
	 * Search checkout information by book info
	 * 
	 * @param map
	 * @param CallNo
	 * @param ISBN
	 * @param Title
	 * @param Auth
	 * @param page
	 * @return total row in database
	 */
	public int searchCheckOutByBookInfo(TreeMap<Object, CheckIn> map,
			String CallNo, String ISBN, String Title, String Auth, int page) {
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			csDetails = cn
					.prepareCall(LibProcedure.SEARCH_CHECKOUT_BY_BOOK_INFO);
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
				map.put(checkin.getBorID()
						+ Messages.getString("AccessBorrow.13")
						+ checkin.getBookID(), checkin);
			}
			return csDetails.getInt(7);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(rsDetails);
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return 1;
	}

	/**
	 * Search checkout information by borrow id
	 * 
	 * @param map
	 * @param borID
	 */
	public void searchCheckOutByBorID(TreeMap<Object, CheckIn> map, int borID) {
		// Defined connection, rs and cs to connect and query database
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
				map.put(checkin.getBorID()
						+ Messages.getString("AccessBorrow.14") + checkin.getCallNumber(), //$NON-NLS-1$
				checkin);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(rsDetails);
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
	}

	/**
	 * Search checkout information by employee information
	 * 
	 * @param map
	 * @param EmpID
	 * @param Name
	 * @param page
	 * @return total row in database
	 */
	public int searchCheckOutByEmpInfo(TreeMap<Object, CheckIn> map,
			String EmpID, String Name, int page) {
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			if (EmpID.length() != 0) {
				csDetails = cn
						.prepareCall(LibProcedure.SERCH_CHECKOUT_BY_EMPID);
				csDetails.setInt(1, Integer.parseInt(EmpID));
				csDetails.setInt(2, page);
				csDetails.setInt(3, LibUtil.noRow);
				csDetails.registerOutParameter(4, java.sql.Types.INTEGER);
			} else {
				csDetails = cn
						.prepareCall(LibProcedure.SEARCH_CHECKOUT_BY_EMPNAME);
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
				map.put(checkin.getBorID()
						+ Messages.getString("AccessBorrow.15")
						+ checkin.getBookID(), checkin);
			}
			return csDetails.getInt(4);
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(rsDetails);
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return 1;
	}
}
