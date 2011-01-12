/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CuongNQ
 */
public class AccessLogin {

    //Defined
    private Connection cn = null;
    private ResultSet rsDetails = null;
    private CallableStatement csDetails = null;
    //Defined instance of AccessBook
    private static AccessLogin instance = new AccessLogin();

    /**
     * Static method get instance of AccessBook
     */
    public static AccessLogin getInstance() {
        return instance;
    }

    public boolean login(String user, String pass) {
        try {
            //invoked static method to get connection
            cn = LibConnection.getConnection();
            try {
                //invoked store procedure login and get resultset
                csDetails = cn.prepareCall(LibProcedure.LOGIN);
                csDetails.setString(1, user);
                //Encrypt to MD5 and set
                csDetails.setString(2, pass);
                rsDetails = csDetails.executeQuery();
                //login successful, display manage frame and dispose this frame
                if (rsDetails.next()) {
                    return true;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(rsDetails);
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
        return false;
    }
}
