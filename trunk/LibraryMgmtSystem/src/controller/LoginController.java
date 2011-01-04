/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jhlabs.image.BlurFilter;
import model.LibConnection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import model.LibConfig;
import model.LibPassword;
import org.jdesktop.jxlayer.JXLayer;
import org.jdesktop.jxlayer.plaf.effect.BufferedImageOpEffect;
import org.jdesktop.jxlayer.plaf.ext.LockableUI;
import view.AboutWindow;
import view.LoginFrm;
import view.SettingDialog;

/**
 *
 * @author CuongNQ
 */
public class LoginController {

    //
    private ManageController loginControl;
    private AboutWindow about;
    //Defined Setting Dialog
    private LoginFrm view;
    //Defined Jxlayer
    private JXLayer<JComponent> layer;
    //Defined blurUI
    private LockableUI blurUI;
    //Defined Jcomponent
    private JComponent jc;
    //Defined connection, rs and cs to connect and query database
    private Connection cn = null;
    private ResultSet rsDetails = null;
    private CallableStatement csDetails = null;

    public LoginController(LoginFrm view, ManageController loginControl) {
        this.view = view;
        this.loginControl = loginControl;
        initComponent();
        //Load user & pass from config file
        loadConfig();
    }

    /*
     * initialize the controller.
     */
    private void initComponent() {

        //Create new instance of blurUI
        blurUI = new LockableUI(new BufferedImageOpEffect(new BlurFilter()));
        //Create new instance of Jcomponent
        jc = (JComponent) getView().getContentPane();
        //Create new instance of layer
        layer = new JXLayer<JComponent>(jc);
        //Set layer blur effect
        layer.setUI(blurUI);
        blurUI.setLockedCursor(null);
        //set layer blur to pane
        view.setContentPane(layer);

        //Add event to menu setting
        view.getMenuSetting().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Blur layer
                doBlur();
                //Display setting dialog
                new SettingController(new SettingDialog(
                        getView(), true)).getView().setVisible(true);
                //Blur layer
                doBlur();
            }
        });

        //Add event to menu quit
        view.getMnQuit().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Dispose this frame
                getView().dispose();
                System.exit(0);
            }
        });

        //Add event to about us
        view.getMnAbout().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                getView().setVisible(false);//hidden current frame
                about = new AboutWindow(view);
            }
        });

        //Add event to login
        view.getBtnLogin().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //invoked doRemember method to remember password
                doRemember();
                //invoked login method
                login();
            }
        });

        //Add event enter key
        view.getTxtUsername().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    //invoked doRemember method to remember password
                    doRemember();
                    //invoked login method
                    login();
                }
            }
        });
        view.getTxtPassword().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    //invoked doRemember method to remember password
                    doRemember();
                    //invoked login method
                    login();
                }
            }
        });
    }

    /*
     * Blur main frame when dialog open
     */
    private void doBlur() {
        //set layer blur to pane
        getView().setContentPane(layer);
        blurUI.setLocked(!blurUI.isLocked());
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
                //If it doesn't exist, create it
                LibConfig.getInstance().createConfig();
            } else {
                in = new FileInputStream(f);
            }
            //load property file
            pro.load(in);

            //set all field
            view.getTxtUsername().setText(pro.getProperty("loginUser"));
            //get pass from config and depass
            view.getTxtPassword().setText(
                    LibPassword.getInstance().decryptPass(
                    pro.getProperty("loginPass")));
            //Check remmeber check
            if (view.getTxtUsername().getText().length() > 0
                    && view.getTxtPassword().getPassword().length > 0) {
                view.getChBxRemember().setSelected(true);
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

    /*
     * Save user and pass to property file
     */
    private void saveConfig(String user, String pass) {
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

    /*
     * Remember account entered
     */
    private void doRemember() {
        if (view.getChBxRemember().isSelected()) {
            saveConfig(view.getTxtUsername().getText(),
                    new String(view.getTxtPassword().getPassword()));
        } else {
            saveConfig("", "");
        }
    }

    /*
     * Connect to SQL Server and check admin info
     */
    private void login() {
        new Thread(new Runnable() {

            public void run() {
                try {
                    //invoked static method to get connection
                    cn = LibConnection.getConnection();
                    try {
                        //invoked store procedure login and get resultset
                        csDetails = cn.prepareCall("{call sp_Login(?,?)}");
                        csDetails.setString(1, view.getTxtUsername().getText());
                        //Encrypt to MD5 and set
                        csDetails.setString(2, LibPassword.getInstance().encryptMD5(
                                new String(view.getTxtPassword().getPassword())));
                        rsDetails = csDetails.executeQuery();
                        //login successful, display manage frame and dispose this frame
                        if (rsDetails.next()) {
                            view.dispose();
                            //Display manage frame
                            loginControl.getView().setVisible(true);
                        } else {//display error
                            doBlur();
                            JOptionPane.showMessageDialog(view,
                                    "Wrong username or password.",
                                    "Login Failed", JOptionPane.WARNING_MESSAGE);
                            //Sleep 1 minisecond/ otherwise can't doBlur again
                            Thread.sleep(1);
                            doBlur();
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
            }
        }).start();
    }

    /**
     * @return the view
     */
    public LoginFrm getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(LoginFrm view) {
        this.view = view;
    }
}
