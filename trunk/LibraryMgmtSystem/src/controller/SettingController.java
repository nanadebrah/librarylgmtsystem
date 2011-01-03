/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.LibConnection;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import model.LibPassword;
import view.SettingDialog;

/**
 *
 * @author CuongNQ
 */
public class SettingController {

    //Defined Setting Dialog
    private SettingDialog view;

    public SettingController(SettingDialog view) {
        this.view = view;
        initComponent();
        //invoked set default all field
        if (!loadConfig()) {
            setField();
        }
    }


    /*
     *  initialize the controller.
     */
    private void initComponent() {
        //Add event for btnTest
        view.getBtnTest().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                checkConnection();
            }
        });

        //Add event for btnDefault
        view.getBtnDefault().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setField();
            }
        });

        //Add event for btnClose
        view.getBtnSave().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                saveConfig();
            }
        });

        //Add event for btnClose
        view.getBtnClose().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
    }

    /*
     * Default all field text
     */
    private void setField() {
        view.getTxtHost().setText("10.211.55.3");
        view.getTxtPort().setText("1433");
        view.getTxtDatabase().setText("Library");
        view.getTxtUser().setText("sa");
        view.getTxtPass().setText("9988776655");
    }

    /*
     * Save config to property file
     */
    private void saveConfig() {
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
            pro.setProperty("host", view.getTxtHost().getText());
            pro.setProperty("port", view.getTxtPort().getText());
            pro.setProperty("database", view.getTxtDatabase().getText());
            pro.setProperty("username", view.getTxtUser().getText());
            pro.setProperty("password", LibPassword.getInstance().encryptPass(
                    new String(view.getTxtPass().getPassword())));
            pro.store(new FileOutputStream(f), null);
            view.getLblCheck().setText("Saved!");
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

    /*
     * Load config file
     */
    private boolean loadConfig() {
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

    /*
     *Check connection using JDBC 4
     */
    private void checkConnection() {
        //Change cursor
        view.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        //Test connection
        String pass = new String(view.getTxtPass().getPassword());
        boolean check = LibConnection.testConnection(
                view.getTxtHost().getText(), view.getTxtPort().getText(),
                view.getTxtDatabase().getText(), view.getTxtUser().getText(), pass);
        view.setConnectImage(check);
        if (check) {
            view.getLblCheck().setText("OK!");
        } else {
            view.getLblCheck().setText("Error!!!!");
        }
        //Change cursor
        view.setCursor(null);
    }

    /**
     * @return the view
     */
    public SettingDialog getView() {
        return view;
    }
}
