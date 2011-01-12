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
import view.SettingConnection;

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
            pro.setProperty("password", "");
            pro.setProperty("nopage", "20");

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
     * @param txtRow
     */
    public void loadProConfig(javax.swing.JSpinner txtRow){
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
            } else {
                in = new FileInputStream(f);
            }
            //load property file
            pro.load(in);
            //set field
            txtRow.setValue(Integer.parseInt(pro.getProperty("nopage")));
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
     * Save program config to property file
     * @param noRow
     */
    public void saveProConfig(String noRow){
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
     * 
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
     * 
     * @param jtxt
     * @param jpass
     * @param jcheck
     * @return
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
            LibUtil.noRow=Integer.parseInt(pro.getProperty("nopage"));
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
     *
     * @param view
     * @return
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
