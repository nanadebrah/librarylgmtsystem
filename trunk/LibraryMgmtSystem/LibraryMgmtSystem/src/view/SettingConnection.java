/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SettingConnection.java
 *
 * Created on Dec 27, 2010, 4:55:14 PM
 */
package view;

import javax.swing.ImageIcon;
import model.LibImages;

/**
 *
 * @author CuongNQ
 */
public class SettingConnection extends javax.swing.JDialog {

    /** Creates new form SettingConnection */
    public SettingConnection(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Set dialog to center of screen
        setLocationRelativeTo(null);       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conectSetPanel = new javax.swing.JPanel();
        lblHost = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        lblDatabase = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        txtDatabase = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        btnDefault = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        lblConnect = new javax.swing.JLabel();
        btnTest = new javax.swing.JButton();
        lblTest = new javax.swing.JLabel();
        lblCheck = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connection Setting");
        setResizable(false);

        conectSetPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Connect Setting"));

        lblHost.setText("Host:");

        lblPort.setText("Port:");

        lblDatabase.setText("Database:");

        lblUsername.setText("Username:");

        lblPassword.setText("Password:");

        txtHost.setToolTipText("Example: localhost");

        txtPort.setToolTipText("Example: 1443");

        txtDatabase.setToolTipText("database's name");

        txtUser.setToolTipText("Your account");

        btnDefault.setText("Default");

        btnSave.setText("Save");

        btnClose.setText("Close");

        txtPass.setToolTipText("Your password");

        org.jdesktop.layout.GroupLayout conectSetPanelLayout = new org.jdesktop.layout.GroupLayout(conectSetPanel);
        conectSetPanel.setLayout(conectSetPanelLayout);
        conectSetPanelLayout.setHorizontalGroup(
            conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(conectSetPanelLayout.createSequentialGroup()
                .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(conectSetPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblHost)
                            .add(lblPort)
                            .add(lblDatabase)
                            .add(lblUsername)
                            .add(lblPassword))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtHost, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .add(txtPort, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .add(txtDatabase, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .add(txtUser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .add(txtPass, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                    .add(conectSetPanelLayout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(btnDefault)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnSave)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnClose)))
                .addContainerGap())
        );
        conectSetPanelLayout.setVerticalGroup(
            conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(conectSetPanelLayout.createSequentialGroup()
                .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblHost)
                    .add(txtHost, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblPort)
                    .add(txtPort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblDatabase)
                    .add(txtDatabase, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblUsername)
                    .add(txtUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblPassword)
                    .add(txtPass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnSave)
                    .add(btnClose)
                    .add(btnDefault))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblConnect.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.LABEL_CONNECT)));

        btnTest.setText("Check Connection");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblConnect)
                    .add(layout.createSequentialGroup()
                        .add(btnTest, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(lblTest)
                            .add(lblCheck))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(conectSetPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(conectSetPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(lblConnect)
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(btnTest, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblTest)
                            .add(lblCheck))
                        .add(17, 17, 17)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Set image check connect
     */
    public void setConnectImage(boolean check) {
        if (check) {
            lblConnect.setIcon(new ImageIcon(
                    getClass().getResource(LibImages.LABEL_CONNECT)));
        } else {
            lblConnect.setIcon(new ImageIcon(
                    getClass().getResource(LibImages.LABEL_CONNECTFAILED)));
        }
    }      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDefault;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTest;
    private javax.swing.JPanel conectSetPanel;
    private javax.swing.JLabel lblCheck;
    private javax.swing.JLabel lblConnect;
    private javax.swing.JLabel lblDatabase;
    private javax.swing.JLabel lblHost;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblTest;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtDatabase;
    private javax.swing.JTextField txtHost;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnClose
     */
    public javax.swing.JButton getBtnClose() {
        return btnClose;
    }

    /**
     * @param btnClose the btnClose to set
     */
    public void setBtnClose(javax.swing.JButton btnClose) {
        this.btnClose = btnClose;
    }

    /**
     * @return the btnDefault
     */
    public javax.swing.JButton getBtnDefault() {
        return btnDefault;
    }

    /**
     * @param btnDefault the btnDefault to set
     */
    public void setBtnDefault(javax.swing.JButton btnDefault) {
        this.btnDefault = btnDefault;
    }

    /**
     * @return the btnSave
     */
    public javax.swing.JButton getBtnSave() {
        return btnSave;
    }

    /**
     * @param btnSave the btnSave to set
     */
    public void setBtnSave(javax.swing.JButton btnSave) {
        this.btnSave = btnSave;
    }

    /**
     * @return the btnTest
     */
    public javax.swing.JButton getBtnTest() {
        return btnTest;
    }

    /**
     * @param btnTest the btnTest to set
     */
    public void setBtnTest(javax.swing.JButton btnTest) {
        this.btnTest = btnTest;
    }

    /**
     * @return the lblCheck
     */
    public javax.swing.JLabel getLblCheck() {
        return lblCheck;
    }

    /**
     * @param lblCheck the lblCheck to set
     */
    public void setLblCheck(javax.swing.JLabel lblCheck) {
        this.lblCheck = lblCheck;
    }

    /**
     * @return the txtDatabase
     */
    public javax.swing.JTextField getTxtDatabase() {
        return txtDatabase;
    }

    /**
     * @param txtDatabase the txtDatabase to set
     */
    public void setTxtDatabase(javax.swing.JTextField txtDatabase) {
        this.txtDatabase = txtDatabase;
    }

    /**
     * @return the txtHost
     */
    public javax.swing.JTextField getTxtHost() {
        return txtHost;
    }

    /**
     * @param txtHost the txtHost to set
     */
    public void setTxtHost(javax.swing.JTextField txtHost) {
        this.txtHost = txtHost;
    }

    /**
     * @return the txtPass
     */
    public javax.swing.JPasswordField getTxtPass() {
        return txtPass;
    }

    /**
     * @param txtPass the txtPass to set
     */
    public void setTxtPass(javax.swing.JPasswordField txtPass) {
        this.txtPass = txtPass;
    }

    /**
     * @return the txtPort
     */
    public javax.swing.JTextField getTxtPort() {
        return txtPort;
    }

    /**
     * @param txtPort the txtPort to set
     */
    public void setTxtPort(javax.swing.JTextField txtPort) {
        this.txtPort = txtPort;
    }

    /**
     * @return the txtUser
     */
    public javax.swing.JTextField getTxtUser() {
        return txtUser;
    }

    /**
     * @param txtUser the txtUser to set
     */
    public void setTxtUser(javax.swing.JTextField txtUser) {
        this.txtUser = txtUser;
    }

    /**
     * @return the lblConnect
     */
    public javax.swing.JLabel getLblConnect() {
        return lblConnect;
    }

    /**
     * @param lblConnect the lblConnect to set
     */
    public void setLblConnect(javax.swing.JLabel lblConnect) {
        this.lblConnect = lblConnect;
    }
}
