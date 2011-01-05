/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Book;
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
public class AccessBook {

    //Defined
    private Connection cn = null;
    private ResultSet rsDetails = null;
    private CallableStatement csDetails = null;
    //Defined instance of AccessBook
    private static AccessBook instance = new AccessBook();

    /**
     * Static method get instance of AccessBook
     */
    public static AccessBook getInstance() {
        return instance;
    }

    /**
     * 
     * @param book
     * @return
     */
    public boolean addBook(Book book) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();

        try {
            csDetails = cn.prepareCall(LibProcedure.AddBook);
            csDetails.setString(1, book.getCallNumber());
            csDetails.setString(2, book.getISBN());
            csDetails.setInt(3, book.getSubID());
            csDetails.setString(4, book.getTitle());
            csDetails.setString(5, book.getAuthName());
            csDetails.setString(6, book.getPublisher());
            csDetails.setInt(7, book.getNoOfCopy());
            csDetails.setInt(8, book.getNoInLib());
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
     * @param book
     * @return
     */
    public boolean editBook(Book book){
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();

        try {
            csDetails = cn.prepareCall(LibProcedure.EditBook);
            csDetails.setString(1, book.getCallNumber());
            csDetails.setString(2, book.getFixCallNumber());
            csDetails.setString(3, book.getISBN());
            csDetails.setInt(4, book.getSubID());
            csDetails.setString(5, book.getTitle());
            csDetails.setString(6, book.getAuthName());
            csDetails.setString(7, book.getPublisher());
            csDetails.setInt(8, book.getNoOfCopy());
            csDetails.setInt(9, book.getNoInLib());
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
     * @param callNo
     * @return
     */
    public Book getABook(String callNo){
        //Defined Object
        Book book = null;
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall(LibProcedure.GetABook);
            csDetails.setString(1, callNo);
            rsDetails = csDetails.executeQuery();
            if (rsDetails.next()) {
                book = new Book();
                //Set all field on database to book object
                book.setCallNumber(rsDetails.getString(1));
                book.setISBN(rsDetails.getString(2));
                book.setSubID(rsDetails.getInt(3));
                book.setTitle(rsDetails.getString(4));
                book.setAuthName(rsDetails.getString(5));
                book.setPublisher(rsDetails.getString(6));
                book.setNoOfCopy(rsDetails.getInt(7));
                book.setNoInLib(rsDetails.getInt(8));
                //return employee object
                return book;
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
     * @param bookModel
     * @param CallNo
     * @param ISBN
     * @param Title
     * @param Auth
     */
    public void searchBook(DefaultTableModel bookModel, String CallNo, String ISBN,
            String Title, String Auth) {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        try {
            //Search both ID & Name
            csDetails = cn.prepareCall(LibProcedure.SearchBook);
            csDetails.setString(1, CallNo);
            csDetails.setString(2, ISBN);
            csDetails.setString(3, Title);
            csDetails.setString(4, Auth);
            rsDetails = csDetails.executeQuery();
            while (rsDetails.next()) {
                Vector vt = new Vector();
                vt.addElement(rsDetails.getString(1));
                vt.addElement(rsDetails.getString(2));
                vt.addElement(rsDetails.getString(3));
                vt.addElement(rsDetails.getString(4));
                vt.addElement(rsDetails.getString(5));
                vt.addElement(rsDetails.getInt(6)+"/"+rsDetails.getInt(7));
                
                bookModel.addRow(vt);
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
     * @return name of newest book added
     */
    public String getNewestBook() {
        //Defined connection, rs and cs to connect and query database
        cn = LibConnection.getConnection();
        //Defined book
        String CallNumber = null;

        try {
            csDetails = cn.prepareCall(LibProcedure.GetNewestBook);
            rsDetails = csDetails.executeQuery();
            if (rsDetails.next()) {
                CallNumber = rsDetails.getString(1);
            } else {
                //close all connect
                LibConnection.close(rsDetails);
                LibConnection.close(csDetails);
                LibConnection.close(cn);
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(rsDetails);
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
        return CallNumber;
    }
}
