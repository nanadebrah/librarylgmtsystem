/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.connection;

import entity.Book;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author CuongNQ
 */
public class AccessBook {

    //Defined instance of AccessBook
    private static AccessBook instance = new AccessBook();

    /*
     * Static method get instance of AccessBook
     */
    public static AccessBook getInstance() {
        return instance;
    }

    public void addEmp(Book bok) {
        //Defined connection, rs and cs to connect and query database
        Connection cn = LibConnection.getConnection();
        CallableStatement csDetails = null;

        try {
            csDetails = cn.prepareCall("{call sp_AddBook(?,?,?,?,?,?,?)}");

            csDetails.execute();
            JOptionPane.showMessageDialog(null, "Add librarian successful",
                    "Successful!", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
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
        Connection cn = LibConnection.getConnection();
        CallableStatement csDetails = null;
        ResultSet rsDetails = null;
        //Defined book
        String CallNumber = null;

        try {
            csDetails = cn.prepareCall("{call sp_GetNewestBook}");
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
