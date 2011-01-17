/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProgramSettingDialog.java
 *
 * Created on Jan 9, 2011, 10:47:23 PM
 */
package view;

import java.util.Vector;
import model.LibImages;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SkinInfo;

/**
 *
 * @author CuongNQ
 */
public class ProgramSettingDialog extends javax.swing.JDialog {

    /** Creates new form ProgramSettingDialog */
    public ProgramSettingDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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

        palSetting = new javax.swing.JPanel();
        lblNoRow = new javax.swing.JLabel();
        lblTheme = new javax.swing.JLabel();
        txtRow = new javax.swing.JSpinner();
        cbxTheme = new javax.swing.JComboBox(new Vector<SkinInfo>(
            SubstanceLookAndFeel.getAllSkins().values()));
    lblImage = new javax.swing.JLabel();
    conectSetPanel = new javax.swing.JPanel();
    lblHost = new javax.swing.JLabel();
    lblPort = new javax.swing.JLabel();
    lblEmail = new javax.swing.JLabel();
    lblPassword = new javax.swing.JLabel();
    txtSMTP = new javax.swing.JTextField();
    txtPort = new javax.swing.JTextField();
    txtEmail = new javax.swing.JTextField();
    txtPass = new javax.swing.JPasswordField();
    btnCheckEmail = new javax.swing.JButton();
    lblStatus = new javax.swing.JLabel();
    btnSave = new javax.swing.JButton();
    btnClose = new javax.swing.JButton();
    btnDefault = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Program Setting");
    setResizable(false);

    palSetting.setBorder(javax.swing.BorderFactory.createTitledBorder("Program Setting"));

    lblNoRow.setText("No row a page:");

    lblTheme.setText("Themes:");

    txtRow.setToolTipText("Number row will display on a page in table");
    txtRow.setValue(1);

    cbxTheme.setToolTipText("Theme for system");

    org.jdesktop.layout.GroupLayout palSettingLayout = new org.jdesktop.layout.GroupLayout(palSetting);
    palSetting.setLayout(palSettingLayout);
    palSettingLayout.setHorizontalGroup(
        palSettingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(palSettingLayout.createSequentialGroup()
            .addContainerGap()
            .add(palSettingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(lblTheme)
                .add(lblNoRow))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(palSettingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(txtRow, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .add(cbxTheme, 0, 155, Short.MAX_VALUE))
            .addContainerGap())
    );
    palSettingLayout.setVerticalGroup(
        palSettingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(org.jdesktop.layout.GroupLayout.TRAILING, palSettingLayout.createSequentialGroup()
            .addContainerGap()
            .add(palSettingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                .add(lblNoRow, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(txtRow, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(palSettingLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                .add(cbxTheme, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(lblTheme))
            .add(64, 64, 64))
    );

    lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.LABEL_SETTING)));

    conectSetPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Email Setting"));

    lblHost.setText("SMTP host:");

    lblPort.setText("Port:");

    lblEmail.setText("Email:");

    lblPassword.setText("Password:");

    txtSMTP.setToolTipText("SMTP email host");

    txtPort.setToolTipText("SMTP port");

    txtEmail.setToolTipText("Your email");

    txtPass.setToolTipText("Your email's password");

    btnCheckEmail.setText("Check Email");

    org.jdesktop.layout.GroupLayout conectSetPanelLayout = new org.jdesktop.layout.GroupLayout(conectSetPanel);
    conectSetPanel.setLayout(conectSetPanelLayout);
    conectSetPanelLayout.setHorizontalGroup(
        conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(conectSetPanelLayout.createSequentialGroup()
            .addContainerGap()
            .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(conectSetPanelLayout.createSequentialGroup()
                    .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(lblHost)
                        .add(lblPort)
                        .add(lblPassword)
                        .add(lblEmail))
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(txtPort, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .add(txtEmail, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .add(txtPass, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .add(txtSMTP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                .add(conectSetPanelLayout.createSequentialGroup()
                    .add(btnCheckEmail)
                    .add(18, 18, 18)
                    .add(lblStatus)))
            .addContainerGap())
    );
    conectSetPanelLayout.setVerticalGroup(
        conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(conectSetPanelLayout.createSequentialGroup()
            .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(lblHost)
                .add(txtSMTP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(lblPort)
                .add(txtPort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(lblEmail)
                .add(txtEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(lblPassword)
                .add(txtPass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(conectSetPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(btnCheckEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(lblStatus))
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    btnSave.setText("Save");

    btnClose.setText("Close");

    btnDefault.setText("Default");

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                    .add(lblImage, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .add(18, 18, 18)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(conectSetPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, palSetting, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                    .add(btnSave)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(btnDefault)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                    .add(btnClose)))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .addContainerGap()
                    .add(palSetting, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 125, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                    .add(conectSetPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(layout.createSequentialGroup()
                    .add(97, 97, 97)
                    .add(lblImage)))
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                .add(btnClose)
                .add(btnDefault)
                .add(btnSave))
            .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckEmail;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDefault;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbxTheme;
    private javax.swing.JPanel conectSetPanel;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHost;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblNoRow;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTheme;
    private javax.swing.JPanel palSetting;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPort;
    private javax.swing.JSpinner txtRow;
    private javax.swing.JTextField txtSMTP;
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
     * @return the cbxTheme
     */
    public javax.swing.JComboBox getCbxTheme() {
        return cbxTheme;
    }

    /**
     * @param cbxTheme the cbxTheme to set
     */
    public void setCbxTheme(javax.swing.JComboBox cbxTheme) {
        this.cbxTheme = cbxTheme;
    }

    /**
     * @return the txtRow
     */
    public javax.swing.JSpinner getTxtRow() {
        return txtRow;
    }

    /**
     * @param txtRow the txtRow to set
     */
    public void setTxtRow(javax.swing.JSpinner txtRow) {
        this.txtRow = txtRow;
    }

    /**
     * @return the txtEmail
     */
    public javax.swing.JTextField getTxtEmail() {
        return txtEmail;
    }

    /**
     * @param txtEmail the txtEmail to set
     */
    public void setTxtEmail(javax.swing.JTextField txtEmail) {
        this.txtEmail = txtEmail;
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
     * @return the txtSMTP
     */
    public javax.swing.JTextField getTxtSMTP() {
        return txtSMTP;
    }

    /**
     * @param txtSMTP the txtSMTP to set
     */
    public void setTxtSMTP(javax.swing.JTextField txtSMTP) {
        this.txtSMTP = txtSMTP;
    }

    /**
     * @return the btnCheckEmail
     */
    public javax.swing.JButton getBtnCheckEmail() {
        return btnCheckEmail;
    }

    /**
     * @param btnCheckEmail the btnCheckEmail to set
     */
    public void setBtnCheckEmail(javax.swing.JButton btnCheckEmail) {
        this.btnCheckEmail = btnCheckEmail;
    }

    /**
     * @return the lblStatus
     */
    public javax.swing.JLabel getLblStatus() {
        return lblStatus;
    }

    /**
     * @param lblStatus the lblStatus to set
     */
    public void setLblStatus(javax.swing.JLabel lblStatus) {
        this.lblStatus = lblStatus;
    }

}