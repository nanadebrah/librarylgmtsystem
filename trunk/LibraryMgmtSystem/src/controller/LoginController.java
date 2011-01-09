/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jhlabs.image.BlurFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import model.LibConfig;
import model.AccessLogin;
import model.LibPassword;
import org.jdesktop.jxlayer.JXLayer;
import org.jdesktop.jxlayer.plaf.effect.BufferedImageOpEffect;
import org.jdesktop.jxlayer.plaf.ext.LockableUI;
import view.AboutWindow;
import view.LoginDialog;
import view.SettingConnection;

/**
 *
 * @author CuongNQ
 */
public class LoginController {

    //
    private ManageController manageControl;
    private AboutWindow about;
    //Defined Setting Dialog
    private LoginDialog view;
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

    /**
     * 
     * @param view
     * @param manageControl
     */
    public LoginController(LoginDialog view, ManageController manageControl) {
        this.view = view;
        this.manageControl = manageControl;
        initComponent();
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {

        //Load user & pass from config file
        LibConfig.getInstance().loadConfig(view.getTxtUsername(),
                view.getTxtPassword(), view.getChBxRemember());
        //Create new instance of blurUI
        blurUI = new LockableUI(new BufferedImageOpEffect(new BlurFilter()));
        //Create new instance of Jcomponent
        jc = (JComponent) view.getContentPane();
        //Create new instance of layer
        layer = new JXLayer<JComponent>(jc);
        //Set layer blur effect
        layer.setUI(blurUI);
        blurUI.setLockedCursor(null);
        //set layer blur to pane
        view.setContentPane(layer);

        //Add event to menu setting
        view.getMnSetConnection().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Blur layer
                doBlur();
                //Display setting dialog
                new SettingController(new SettingConnection(
                        view, true)).getView().setVisible(true);
                //Blur layer
                doBlur();
            }
        });

        //Add event to menu quit
        view.getMnQuit().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Dispose this frame
                view.dispose();
                System.exit(0);
            }
        });

        //Add event to about us
        view.getMnAbout().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);//hidden current frame
                about = new AboutWindow(null, view);
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

        //Add event windows closing
        view.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent evt) {
                view.dispose();
                System.exit(0);
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

    /**
     * Blur main frame when dialog open
     */
    private void doBlur() {
        //set layer blur to pane
        view.setContentPane(layer);
        blurUI.setLocked(!blurUI.isLocked());
    }

    /**
     * Remember account entered
     */
    private void doRemember() {
        if (view.getChBxRemember().isSelected()) {
            LibConfig.getInstance().saveConfig(view.getTxtUsername().getText(),
                    new String(view.getTxtPassword().getPassword()));
        } else {
            LibConfig.getInstance().saveConfig("", "");
        }
    }

    /**
     * Connect to SQL Server and check admin info
     */
    private void login() {
        new Thread(new Runnable() {

            public void run() {
                if (AccessLogin.getInstance().login(view.getTxtUsername().getText(),
                        LibPassword.getInstance().encryptMD5(
                        new String(view.getTxtPassword().getPassword())))) {
                    view.dispose();
                    //Display manage frame
                    manageControl.getView().setVisible(true);
                } else {
                    doBlur();
                    JOptionPane.showMessageDialog(view,
                            "Wrong username or password.",
                            "Login Failed", JOptionPane.WARNING_MESSAGE);
                    try {
                        //Sleep 1 minisecond/ otherwise can't doBlur again
                        Thread.sleep(1);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    doBlur();
                }
            }
        }).start();
    }

    /**
     * @return the view
     */
    public LoginDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(LoginDialog view) {
        this.view = view;
    }
}
