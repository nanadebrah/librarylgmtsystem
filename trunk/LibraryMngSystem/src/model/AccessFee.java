/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Fee;

/**
 * Access to fee table
 * 
 * @author CuongNQ
 */
public class AccessFee {

	// Defined
	private Connection cn = null;
	private ResultSet rsDetails = null;
	private CallableStatement csDetails = null;
	// Defined instance of AccessFee
	private static AccessFee instance = new AccessFee();

	/**
	 * Static method get instance of AccessFee
	 */
	public static AccessFee getInstance() {
		return instance;
	}

	/**
	 * Get fee and fine rate
	 * 
	 * @return fee object
	 */
	public Fee getFee() {
		// Defined Object
		Fee fee = null;
		// Defined connection, rs and cs to connect and query database
		cn = LibConnection.getConnection();
		try {
			csDetails = cn.prepareCall(LibProcedure.GET_FEE);
			rsDetails = csDetails.executeQuery();
			if (rsDetails.next()) {
				fee = new Fee();
				// Set all field on database to fee object
				fee.setFee(rsDetails.getString(1));
				fee.setBorFee(rsDetails.getFloat(2));
				fee.setLateFee(rsDetails.getFloat(3));
				// return fee object
				return fee;
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
	 * Edit fee and fine setting
	 * 
	 * @param fee
	 * @return true if successful, otherwise false
	 */
	public boolean editFee(Fee fee) {
		// Defined connection, rs and cs to connect and query database
		Connection cn = LibConnection.getConnection();
		try {
			csDetails = cn.prepareCall(LibProcedure.EDIT_FEE);
			csDetails.setFloat(1, fee.getBorFee());
			csDetails.setFloat(2, fee.getLateFee());
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
}
