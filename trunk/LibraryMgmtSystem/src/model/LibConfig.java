/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author CuongNQ
 */
public class LibConfig {

    //Defined instance of LibConfig
    private static LibConfig instance = new LibConfig();

    /*
     * Static method get instance of Libook
     */
    public static LibConfig getInstance() {
        return instance;
    }

    /**
     * 
     */
    public void createConfig() {
        //Defined object
        FileInputStream in = null;
        Properties pro;
        try {
            //Create instane of object
            pro = new Properties();
            File f = new File(System.getProperty("user.dir")
                    + File.separator + "Config.properties");
            f.createNewFile();
            //load property file
            in = new FileInputStream(f);
            pro.load(in);

            //Save all config to file
            pro.setProperty("loginUser", "");
            //Encrypt pass and save to file config
            pro.setProperty("loginPass", "");

            //Save all database & connection config to file
            pro.setProperty("host", "localhost");
            pro.setProperty("port", "1433");
            pro.setProperty("database", "Library");
            pro.setProperty("username", "sa");
            pro.setProperty("password", "9988776655");

            pro.store(new FileOutputStream(f), null);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 
     * @param user
     * @param pass
     */
    public void saveConfig(String user, String pass) {
        //Defined object
        FileInputStream in = null;
        Properties pro;
        try {
            //Create instane of object
            pro = new Properties();
            File f = new File(System.getProperty("user.dir")
                    + File.separator + "Config.properties");
            //Check file exist, if not, create new property file to store
            if (!f.exists()) {
                f.createNewFile();
            }
            //load property file
            in = new FileInputStream(f);
            pro.load(in);

            //Save all config to file
            pro.setProperty("loginUser", user);
            //Encrypt pass and save to file config
            pro.setProperty("loginPass", LibPassword.getInstance().encryptPass(pass));
            pro.store(new FileOutputStream(f), null);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 
     * @param jtxt
     * @param jpass
     * @param jcheck
     * @return
     */
    public boolean loadConfig(javax.swing.JTextField jtxt,
            javax.swing.JPasswordField jpass,javax.swing.JCheckBox jcheck) {
        //Defined object
        FileInputStream in = null;
        Properties pro;
        try {
            //Create instane of object
            pro = new Properties();
            File f = new File(System.getProperty("user.dir")
                    + File.separator + "Config.properties");
            //Check file exist
            if (!f.exists()) {
                //If it doesn't exist, create it
                LibConfig.getInstance().createConfig();
            } else {
                in = new FileInputStream(f);
            }
            //load property file
            pro.load(in);

            //set all field
            jtxt.setText(pro.getProperty("loginUser"));
            //get pass from config and depass
            jpass.setText(
                    LibPassword.getInstance().decryptPass(
                    pro.getProperty("loginPass")));
            //Check remmeber check
            if (jtxt.getText().length() > 0
                    && jpass.getPassword().length > 0) {
                jcheck.setSelected(true);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }
}
