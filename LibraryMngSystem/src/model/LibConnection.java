/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * Connection management class
 * 
 * @author CuongNQ
 */
public class LibConnection {

	// Defined instance of LibConnection
	private static LibConnection instance = new LibConnection();

	// Defined pie of connection
	private static String host;
	private static String port;
	private static String database;
	private static String username;
	private static String password;
	private static boolean isWin;

	/**
	 * Method is used to close open objects when connecting to database.
	 * 
	 * @param obj
	 *            is object which will be opened when connecting.
	 */
	public static void close(Object obj) {
		try {
			if (obj instanceof Connection) {
				((Connection) obj).close();
			}
			if (obj instanceof Statement) {
				((Statement) obj).close();
			}
			if (obj instanceof PreparedStatement) {
				((PreparedStatement) obj).close();
			}
			if (obj instanceof CallableStatement) {
				((CallableStatement) obj).close();
			}
			if (obj instanceof ResultSet) {
				((ResultSet) obj).close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,
					Messages.getString("LibConnection.0"),
					Messages.getString("LibConnection.1"), //$NON-NLS-1$ 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Method is used to return one connection if connecting successfully.
	 * 
	 * @return returns one connection.
	 */
	public static Connection getConnection() {
		// Defined Connection and field to connect
		Connection cn = null;
		String url;
		try {
			// Load driver
			Class.forName(Messages.getString("LibConnection.2")); //$NON-NLS-1$

			// If is windows authentication use integrated security mode
			if (!isWin) {
				url = Messages.getString("LibConnection.3") + host
						+ Messages.getString("LibConnection.4") + port //$NON-NLS-1$ 
						+ Messages.getString("LibConnection.5") + database; //$NON-NLS-1$
				cn = DriverManager.getConnection(url, username, password);
			} else {
				url = Messages.getString("LibConnection.6") + host
						+ Messages.getString("LibConnection.7") + port //$NON-NLS-1$ 
						+ Messages.getString("LibConnection.8") + database //$NON-NLS-1$
						+ Messages.getString("LibConnection.9"); //$NON-NLS-1$
				cn = DriverManager.getConnection(url);
			}

			// return connection
			return cn;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,
					Messages.getString("LibConnection.10"),
					Messages.getString("LibConnection.11"), //$NON-NLS-1$ 
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Static method get instance of LibEmailSender
	 */
	public static LibConnection getInstance() {
		return instance;
	}

	/**
	 * Test connection to server with all field config
	 * 
	 * @param host
	 *            of server
	 * @param port
	 *            of server
	 * @param database
	 *            of server
	 * @param username
	 *            of server
	 * @param password
	 *            of server
	 * @return Connect successful or not
	 */
	public static boolean testConnection(String host, String port,
			String database, String username, String password, boolean isWin) {
		// Defined Connection and field to connect
		Connection cn = null;
		String url;
		try {
			// Load driver
			Class.forName(Messages.getString("LibConnection.12")); //$NON-NLS-1$

			// Set config
			if (!isWin) {
				url = Messages.getString("LibConnection.13") + host
						+ Messages.getString("LibConnection.14") + port //$NON-NLS-1$ 
						+ Messages.getString("LibConnection.15") + database; //$NON-NLS-1$
				cn = DriverManager.getConnection(url, username, password);
			} else {
				url = Messages.getString("LibConnection.16") + host
						+ Messages.getString("LibConnection.17") + port //$NON-NLS-1$ 
						+ Messages.getString("LibConnection.18") + database //$NON-NLS-1$
						+ Messages.getString("LibConnection.19"); //$NON-NLS-1$
				cn = DriverManager.getConnection(url);
			}

			// return connect successful
			close(cn);
			return true;
		} catch (SQLException ex) {
		} catch (ClassNotFoundException ex) {
		} finally {
			close(cn);
		}
		return false;
	}

	/**
	 * Get config from property file
	 */
	public void getProperty() {
		// Create instance of object
		FileInputStream in = null;
		Properties pro;
		try {
			// Get config from properties file
			pro = new Properties();
			File f = new File(System.getProperty(Messages
					.getString("LibConnection.20")) + File.separator //$NON-NLS-1$
					+ Messages.getString("LibConnection.21")); //$NON-NLS-1$
			// Check file exist
			if (!f.exists()) {
				// Create file and return
				LibConfig.getInstance().createConfig();
				return;
			} else {
				in = new FileInputStream(f);
			}

			// load property file
			pro.load(in);

			// Fill all variable
			host = pro.getProperty(Messages.getString("LibConnection.22")); //$NON-NLS-1$
			port = pro.getProperty(Messages.getString("LibConnection.23")); //$NON-NLS-1$
			database = pro.getProperty(Messages.getString("LibConnection.24")); //$NON-NLS-1$
			isWin = Boolean.parseBoolean(pro.getProperty(Messages
					.getString("LibConnection.25"))); //$NON-NLS-1$
			username = pro.getProperty(Messages.getString("LibConnection.26")); //$NON-NLS-1$
			password = LibPassword.getInstance().decryptPass(
					pro.getProperty(Messages.getString("LibConnection.27"))); //$NON-NLS-1$

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
