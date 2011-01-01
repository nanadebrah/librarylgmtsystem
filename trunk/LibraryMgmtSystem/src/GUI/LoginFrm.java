/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginFrm.java
 *
 * Created on Jan 1, 2011, 2:29:26 PM
 */
package GUI;

import Util.DataAccess.LibConnection;
import com.jhlabs.image.BlurFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import org.jdesktop.jxlayer.JXLayer;
import org.jdesktop.jxlayer.plaf.effect.BufferedImageOpEffect;
import org.jdesktop.jxlayer.plaf.ext.LockableUI;

/**
 *
 * @author CuongNQ
 */
public class LoginFrm extends javax.swing.JFrame {

    //Defined Jxlayer
    private JXLayer<JComponent> layer;
    //Defined blurUI
    private LockableUI blurUI;
    //Defined Jcomponent
    JComponent jc;
    //Defined connection, rs and cs to connect and query database
    Connection cn = null;
    ResultSet rsDetails = null;
    CallableStatement csDetails = null;

    /** Creates new form LoginFrm */
    public LoginFrm() {
        initComponents();
        //Set this frame to center of monitor
        setLocationRelativeTo(null);
        //Blur layer for frame
        blurLayer();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAbout = new javax.swing.JLabel();
        lblLoginIcon = new javax.swing.JLabel();
        panelLogin = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        chBxRemember = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        mnSystem = new javax.swing.JMenu();
        menuSetting = new javax.swing.JMenuItem();
        separator = new javax.swing.JPopupMenu.Separator();
        mnQuit = new javax.swing.JMenuItem();
        mnHelp = new javax.swing.JMenu();
        mnSubHelp = new javax.swing.JMenuItem();
        mnAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblAbout.setFont(new java.awt.Font("Lucida Grande", 2, 12));
        lblAbout.setText("Powered by Group-01.GC0502 - Vr1.0");

        lblLoginIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images"+File.separator+"loginLbl.png")));

        panelLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Login Information"));

        lblUserName.setText("Username:");

        lblPassword.setText("Password:");

        txtUsername.setToolTipText("Your user name");

        txtPassword.setToolTipText("Your password");

        chBxRemember.setText("Remember me");
        chBxRemember.setToolTipText("Check it if you want remember login information for next time");
        chBxRemember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBxRememberActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelLoginLayout = new org.jdesktop.layout.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panelLoginLayout.createSequentialGroup()
                .add(21, 21, 21)
                .add(panelLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(panelLoginLayout.createSequentialGroup()
                        .add(panelLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblPassword)
                            .add(lblUserName))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(panelLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtUsername, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .add(txtPassword, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
                    .add(panelLoginLayout.createSequentialGroup()
                        .add(chBxRemember)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 76, Short.MAX_VALUE)
                        .add(btnLogin)))
                .addContainerGap())
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelLoginLayout.createSequentialGroup()
                .add(9, 9, 9)
                .add(panelLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblUserName)
                    .add(txtUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblPassword)
                    .add(txtPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panelLoginLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(chBxRemember)
                    .add(btnLogin))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mnSystem.setText("System");

        menuSetting.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        menuSetting.setIcon(new ImageIcon(getClass().getResource("Images"+File.separator+"settingMenu.png")));
        menuSetting.setText("Setting");
        menuSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSettingActionPerformed(evt);
            }
        });
        mnSystem.add(menuSetting);
        mnSystem.add(separator);

        mnQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        mnQuit.setIcon(new ImageIcon(getClass().getResource("Images"+File.separator+"quitIcon.png")));
        mnQuit.setText("Quit");
        mnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnQuitActionPerformed(evt);
            }
        });
        mnSystem.add(mnQuit);

        menuBar.add(mnSystem);

        mnHelp.setText("Help");

        mnSubHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        mnSubHelp.setText("Help");
        mnHelp.add(mnSubHelp);

        mnAbout.setIcon(new ImageIcon(getClass().getResource("Images"+File.separator+"aboutMenu.png")));
        mnAbout.setText("About us");
        mnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAboutActionPerformed(evt);
            }
        });
        mnHelp.add(mnAbout);

        menuBar.add(mnHelp);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(lblLoginIcon, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblAbout)
                    .add(panelLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, lblLoginIcon, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, panelLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(16, 16, 16)
                .add(lblAbout))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Config to set Blur layer
     */
    private void blurLayer() {
        //Create new instance of blurUI
        blurUI = new LockableUI(new BufferedImageOpEffect(new BlurFilter()));
        //Create new instance of Jcomponent
        jc = (JComponent) getContentPane();
        //Create new instance of layer
        layer = new JXLayer<JComponent>(jc);
        //Set layer blur effect
        layer.setUI(blurUI);
        blurUI.setLockedCursor(null);
        //set layer blur to pane
        setContentPane(layer);
    }

    /*
     * Blur main frame when dialog open
     */
    public void doBlur() {
        //set layer blur to pane
        setContentPane(layer);
        blurUI.setLocked(!blurUI.isLocked());
    }

    /*
     * About method
     */
    private void aboutUs() {
        setVisible(false);//hidden current frame
        new AboutWindow().addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosed(java.awt.event.WindowEvent evt) {
                setVisible(true);//show current frame
            }
        });
    }

    /*
     * Connect to SQL Server and check admin info
     */
    private void login() {
        try {
            //invoked static method to get connection
            cn = LibConnection.getConnection();
            try {
                //invoked store procedure login and get resultset
                csDetails = cn.prepareCall("{call sp_Login(?,?)}");
                csDetails.setString(1, txtUsername.getText());
                csDetails.setString(2, new String(txtPassword.getPassword()));
                rsDetails = csDetails.executeQuery();
                //login successful, display manage frame
                if (rsDetails.next()) {
                    dispose();
                    new ManageFrm().setVisible(true);
                } else {//display error
                    doBlur();
                    JOptionPane.showMessageDialog(this,
                            "Wrong username or password.",
                            "Error", JOptionPane.WARNING_MESSAGE);
                    doBlur();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            //close all connect
            LibConnection.close(rsDetails);
            LibConnection.close(csDetails);
            LibConnection.close(cn);
        }
    }

    /*
     * Remember account entered
     */
    private void remember(){
        
    }

    private void menuSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSettingActionPerformed
        //Blur layer
        doBlur();
        //Display setting dialog
        new SettingDialog(this, true).setVisible(true);
        //Blur layer
        doBlur();
}//GEN-LAST:event_menuSettingActionPerformed

    private void mnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnQuitActionPerformed
        //Dispose this frame
        dispose();
        System.exit(0);
}//GEN-LAST:event_mnQuitActionPerformed

    private void mnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAboutActionPerformed
        //invoked aboutUs method
        aboutUs();
}//GEN-LAST:event_mnAboutActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        //invoked login method
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void chBxRememberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBxRememberActionPerformed
        //
    }//GEN-LAST:event_chBxRememberActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox chBxRemember;
    private javax.swing.JLabel lblAbout;
    private javax.swing.JLabel lblLoginIcon;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuSetting;
    private javax.swing.JMenuItem mnAbout;
    private javax.swing.JMenu mnHelp;
    private javax.swing.JMenuItem mnQuit;
    private javax.swing.JMenuItem mnSubHelp;
    private javax.swing.JMenu mnSystem;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPopupMenu.Separator separator;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}