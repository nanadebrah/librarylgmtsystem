/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import entity.Book;

/**
 * Access book class
 * 
 * @author CuongNQ
 */
public class AccessBook {

	// Defined
	private Connection cn = null;
	private ResultSet rsDetails = null;
	private CallableStatement csDetails = null;
	// Defined instance of AccessBook
	private static AccessBook instance = new AccessBook();

	/**
	 * Static method get instance of AccessBook
	 * 
	 * @return instance of access book
	 */
	public static AccessBook getInstance() {
		return instance;
	}

	/**
	 * Add book to database
	 * 
	 * @param book
	 *            is entity
	 * @return true if add successful, otherwise false
	 */
	public boolean addBook(Book book) {
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();

		try {
			csDetails = cn.prepareCall(LibProcedure.ADD_BOOK);
			csDetails.setString(1, book.getCallNumber());
			csDetails.setString(2, book.getISBN());
			csDetails.setInt(3, book.getSubID());
			csDetails.setString(4, book.getTitle());
			csDetails.setString(5, book.getAuthName());
			csDetails.setString(6, book.getPublisher());
			csDetails.setInt(7, book.getNoOfCopy());
			csDetails.setInt(8, book.getNoInLib());
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
	 * Delete book from database
	 * 
	 * @param bookID
	 *            to delete book
	 * @return true if successful, otherwise false
	 */
	public boolean deleteBook(int bookID) {
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			csDetails = cn.prepareCall(LibProcedure.DETELE_BOOK);
			csDetails.setInt(1, bookID);
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
	 * Edit book from database
	 * 
	 * @param book
	 *            is entity of book
	 * @return true if edit successful, otherwise false
	 */
	public boolean editBook(Book book) {
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();

		try {
			csDetails = cn.prepareCall(LibProcedure.EDIT_BOOK);
			csDetails.setInt(1, book.getBookID());
			csDetails.setString(2, book.getCallNumber());
			csDetails.setString(3, book.getISBN());
			csDetails.setInt(4, book.getSubID());
			csDetails.setString(5, book.getTitle());
			csDetails.setString(6, book.getAuthName());
			csDetails.setString(7, book.getPublisher());
			csDetails.setInt(8, book.getNoOfCopy());
			csDetails.setInt(9, book.getNoInLib());
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
	 * Get book borrow information, full borrow info
	 * 
	 * @param borModel
	 *            is default table model
	 * @param bookID
	 *            is id of book want get
	 */
	public void getBookBorInfo(DefaultTableModel borModel, int bookID) {
		java.util.Vector<Object> vt;
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			csDetails = cn.prepareCall(LibProcedure.GET_BOOK_BOR_INFO);
			csDetails.setInt(1, bookID);
			rsDetails = csDetails.executeQuery();
			while (rsDetails.next()) {
				vt = new java.util.Vector<Object>();
				vt.addElement(rsDetails.getInt(1));
				vt.addElement(rsDetails.getInt(2));
				vt.addElement(rsDetails.getString(3));
				vt.addElement(rsDetails.getString(4));
				vt.addElement(LibUtil.getInstance().convertDate(
						rsDetails.getDate(5).toString()));
				vt.addElement(LibUtil.getInstance().convertDate(
						rsDetails.getDate(6).toString()));
				if (rsDetails.getString(7).equals(
						Messages.getString("AccessBook.0"))) { //$NON-NLS-1$
					vt.addElement(rsDetails.getString(7));
					vt.addElement(Messages.getString("AccessBook.1")); //$NON-NLS-1$
					vt.addElement(Messages.getString("AccessBook.2")); //$NON-NLS-1$
				} else {
					vt.addElement(rsDetails.getString(7));
					vt.addElement(LibUtil.getInstance().convertDate(
							rsDetails.getDate(8).toString()));
					vt.addElement(rsDetails.getFloat(9));
				}
				borModel.addRow(vt);
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
	 * Get book information to show
	 * 
	 * @param bookID
	 *            id of book want to get
	 * @return book entity
	 */
	public Book getBookInfo(int bookID) {
		// Defined Object
		Book book = null;
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			csDetails = cn.prepareCall(LibProcedure.GET_BOOK_INFO);
			csDetails.setInt(1, bookID);
			rsDetails = csDetails.executeQuery();
			if (rsDetails.next()) {
				book = new Book();
				// Set all field on database to book object
				book.setBookID(rsDetails.getInt(1));
				book.setCallNumber(rsDetails.getString(2));
				book.setISBN(rsDetails.getString(3));
				book.setSubName(rsDetails.getString(4));
				book.setTitle(rsDetails.getString(5));
				book.setAuthName(rsDetails.getString(6));
				book.setPublisher(rsDetails.getString(7));
				book.setNoOfCopy(rsDetails.getInt(8));
				book.setNoInLib(rsDetails.getInt(9));
				// return employee object
				return book;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			// close all connect
			LibConnection.close(rsDetails);
			LibConnection.close(csDetails);
			LibConnection.close(cn);
		}
		return null;
	}

	/**
	 * Get bookID of newest book
	 * 
	 * @return bookID of newest book
	 */
	public int getNewestBook() {
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();

		try {
			csDetails = cn.prepareCall(LibProcedure.GET_NEWEST_BOOKID);
			rsDetails = csDetails.executeQuery();
			if (rsDetails.next()) {
				return rsDetails.getInt(1);
			}
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
	 * Search book information by callno, isbn, title or author
	 * 
	 * @param bookModel
	 *            is model to get and add to it
	 * @param CallNo
	 *            is callnumber of book
	 * @param ISBN
	 *            is isbn of book
	 * @param Title
	 *            is title of book
	 * @param Auth
	 *            is authname of book
	 * @param page
	 *            is page want get from navigation bar
	 * @return total row number form database to count page
	 */
	public int searchBook(DefaultTableModel bookModel, String CallNo,
			String ISBN, String Title, String Auth, int page) {
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			// Search both ID & Name
			csDetails = cn.prepareCall(LibProcedure.SEARCH_BOOK);
			csDetails.setString(1, CallNo);
			csDetails.setString(2, ISBN);
			csDetails.setString(3, Title);
			csDetails.setString(4, Auth);
			csDetails.setInt(5, page);
			csDetails.setInt(6, LibUtil.noRow);
			csDetails.registerOutParameter(7, java.sql.Types.INTEGER);
			rsDetails = csDetails.executeQuery();
			while (rsDetails.next()) {
				Vector<Object> vt = new Vector<Object>();
				vt.addElement(rsDetails.getInt(1));
				vt.addElement(rsDetails.getString(2));
				vt.addElement(rsDetails.getString(3));
				vt.addElement(rsDetails.getString(4));
				vt.addElement(rsDetails.getString(5));
				vt.addElement(rsDetails.getString(6));
				vt.addElement(rsDetails.getString(7));
				vt.addElement(rsDetails.getInt(8)
						+ Messages.getString("AccessBook.3") + rsDetails.getInt(9)); //$NON-NLS-1$
				bookModel.addRow(vt);
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
}
