/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util.DataAccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author CuongNQ
 */
public class LibConnection {

    /**
     * Method is used to return one connection if connecting successfully.
     *
     * @return returns one connection.
     *
     * @exception SQLException is made when there is one error when connecting to database.
     * @exception IOException is made if acessing to stream fails.
     * @exception ClassNotFoundException
     */
    public static Connection getConnection() throws FileNotFoundException {
        //Defined Connection and field to connect
        Connection cn = null;
        FileInputStream in = null;
        Properties pro;
        String host;
        String port;
        String database;
        String username;
        String password;
        String url;
        try {
            //Get config from properties file
            //Create instane of object
            pro = new Properties();
            File f = new File(System.getProperty("user.dir")
                    + File.separator + "Config.properties");
            //Check file exist
            if (!f.exists()) {
                JOptionPane.showMessageDialog(null,
                        "You must config connection setting!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            } else {
                in = new FileInputStream(f);
            }
            //load property file
            pro.load(in);
            host = pro.getProperty("host");
            port = pro.getProperty("port");
            database = pro.getProperty("database");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
            url = "jdbc:sqlserver://" + host + ":"
                    + port + ";DatabaseName=" + database;

            //Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(url, username, password);

            //return connection
            return cn;
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Connect error","Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Connect error","Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Connect error","Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     *
     * @param host
     * @param port
     * @param database
     * @param username
     * @param password
     * @return Connect successful or not
     */
    public static boolean testConnection(String host, String port,
            String database, String username, String password) {
        //Defined Connection and field to connect
        Connection cn = null;
        String url;
        try {
            //Set config
            url = "jdbc:sqlserver://" + host + ":" + port + ";DatabaseName=" + database;

            //Load driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(url, username, password);

            //return connect successful
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
     * Method is used to close open objects when connecting to database.
     * @param obj is object which will be opened when connecting.
     * @exception SQLException is made when there is one error when closing to database.
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
            if(obj instanceof CallableStatement){
                ((CallableStatement) obj).close();
            }
            if (obj instanceof ResultSet) {
                ((ResultSet) obj).close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"close error","Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
