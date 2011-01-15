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
import view.ProgramSettingDialog;
import view.SettingConnection;

/**
 * Config system class
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
     * Create new config file
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
            pro.setProperty("password", "");
            pro.setProperty("nopage", "20");
            pro.setProperty("emailHost", "smtp.gmail.com");
            pro.setProperty("emailPort", "587");
            pro.setProperty("emailUser", "Lib.Mgmt.Sys@gmail.com");
            pro.setProperty("emailPass", "");

            pro.store(new FileOutputStream(f),
                    "Cuongnqgc00033@fpt.edu.vn | FPT-Greenwich");

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
     * Load program config
     * @param view
     */
    public void loadProConfig(ProgramSettingDialog view) {
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
                createConfig();
                return;
            } else {
                in = new FileInputStream(f);
            }
            //load property file
            pro.load(in);
            //set field
            view.getTxtRow().setValue(
                    Integer.parseInt(pro.getProperty("nopage")));
            view.getTxtEmail().setText(pro.getProperty("emailUser"));
            view.getTxtPass().setText(
                    LibPassword.getInstance().decryptPass(pro.getProperty("emailPass")));
            view.getTxtSMTP().setText(pro.getProperty("emailHost"));
            view.getTxtPort().setText(pro.getProperty("emailPort"));
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
     * Load email config to process send email
     * @return
     */
    public String[] loadEmailConfig() {
        String[] arr = new String[4];
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
                createConfig();
                return null;
            } else {
                in = new FileInputStream(f);
            }
            //load property file
            pro.load(in);
            //set field
            arr[0] = pro.getProperty("emailHost");
            arr[1] = pro.getProperty("emailPort");
            arr[2] = pro.getProperty("emailUser");
            arr[3] = LibPassword.getInstance()
                    .decryptPass(pro.getProperty("emailPass"));            
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
        return arr;
    }

    /**
     * Save program config to property file
     * @param noRow
     */
    public void saveProConfig(String noRow,
            String Host, String Port,
            String Email, String Pass) {
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
            pro.setProperty("nopage", noRow);
            pro.setProperty("emailHost", Host);
            pro.setProperty("emailPort", Port);
            pro.setProperty("emailUser", Email);
            pro.setProperty("emailPass", LibPassword.getInstance().encryptPass(Pass));
            pro.store(new FileOutputStream(f),
                    "Cuongnqgc00033@fpt.edu.vn | FPT-Greenwich");

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
     * Save login config to property files
     * @param user
     * @param pass
     */
    public void saveLoginConfig(String user, String pass) {
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
            pro.store(new FileOutputStream(f),
                    "Cuongnqgc00033@fpt.edu.vn | FPT-Greenwich");

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
     * Load login config to username & password field
     * @param jtxt
     * @param jpass
     * @param jcheck
     * @return true if ok, else false
     */
    public boolean loadLoginConfig(javax.swing.JTextField jtxt,
            javax.swing.JPasswordField jpass, javax.swing.JCheckBox jcheck) {
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
                createConfig();
                return false;
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
            //load page config
            LibUtil.noRow = Integer.parseInt(pro.getProperty("nopage"));
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

    /**
     * Save config to property file
     * @param host
     * @param port
     * @param data
     * @param use
     * @param pass
     * @return
     */
    public boolean saveConnectConfig(String host, String port, String data,
            String use, String pass) {
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
            pro.setProperty("host", host);
            pro.setProperty("port", port);
            pro.setProperty("database", data);
            pro.setProperty("username", use);
            pro.setProperty("password", pass);
            pro.store(new FileOutputStream(f), null);
            return true;
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
        return false;
    }

    /**
     * Load connection config to config object
     * @param view
     * @return true if load successful, otherwise false
     */
    public boolean loadConnectConfig(SettingConnection view) {
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
                System.out.println("File not found!");
                return false;
            } else {
                in = new FileInputStream(f);
            }
            //load property file
            pro.load(in);

            //set all field
            view.getTxtHost().setText(pro.getProperty("host"));
            view.getTxtPort().setText(pro.getProperty("port"));
            view.getTxtDatabase().setText(pro.getProperty("database"));
            view.getTxtUser().setText(pro.getProperty("username"));
            view.getTxtPass().setText(LibPassword.getInstance().decryptPass(
                    pro.getProperty("password")));
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
