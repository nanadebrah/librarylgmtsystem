/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Subject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author CuongNQ
 */
public class AccessSub {

    //Defined instance of AccessEmp
    private static AccessSub instance = new AccessSub();
    private Connection cn = null;
    private ResultSet rsDetails = null;
    private CallableStatement csDetails = null;

    /*
     * Static method get instance of AccessEmp
     */
    public static AccessSub getInstance() {
        return instance;
    }

    /**
     * 
     * @param sub is subject object
     * @return true if add successful, otherwise false
     */
    public boolean addSubject(Subject sub) {
        //Defined connection, rs and cs to connect and query database
        Connection cn = LibConnection.getConnection();
        try {
            csDetails = cn.prepareCall("{call sp_AddSub(?,?)}");
            csDetails.setString(1, sub.getSubName());
            csDetails.setString(2, sub.getDescription());
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
}
