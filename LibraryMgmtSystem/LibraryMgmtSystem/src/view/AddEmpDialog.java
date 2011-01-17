/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * addEmpDialog.java
 *
 * Created on Dec 30, 2010, 10:05:59 PM
 */
package view;

import model.LibImages;

/**
 *
 * @author CuongNQ
 */
public class AddEmpDialog extends javax.swing.JDialog {

    /** Creates new form addEmpDialog */
    public AddEmpDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Set to center of screen
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

        btgrGender = new javax.swing.ButtonGroup();
        palAddEmp = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblDOB = new javax.swing.JLabel();
        lblAdd = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblDepar = new javax.swing.JLabel();
        lblPermis = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        rdbMale = new javax.swing.JRadioButton();
        rdbFemale = new javax.swing.JRadioButton();
        txtDOB = new org.jdesktop.swingx.JXDatePicker();
        txtAdd = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtDepart = new javax.swing.JTextField();
        cbxPermis = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add An Employee Or Librarian");
        setResizable(false);

        palAddEmp.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Information"));

        lblName.setText("Name:");

        lblGender.setText("Gender:");

        lblDOB.setText("Date of birth:");

        lblAdd.setText("Address:");

        lblPass.setText("Password:");

        lblEmail.setText("Email:");

        lblPhone.setText("Phone:");

        lblDepar.setText("Department:");

        lblPermis.setText("Permission:");

        txtName.setToolTipText("FullName or Username");

        btgrGender.add(rdbMale);
        rdbMale.setSelected(true);
        rdbMale.setText("Male");

        btgrGender.add(rdbFemale);
        rdbFemale.setText("Female");

        txtDOB.setToolTipText("Employee's date of birth");

        txtAdd.setToolTipText("Employee's address");

        txtPass.setToolTipText("Employee's password");

        txtEmail.setToolTipText("Employee's email");

        txtPhone.setToolTipText("Employee's phone number");

        txtDepart.setToolTipText("Employee's department");

        cbxPermis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Librarian", "Employee" }));
        cbxPermis.setToolTipText("Employee's permission");

        btnAdd.setText("Add");

        btnCancel.setText("Cancel");

        org.jdesktop.layout.GroupLayout palAddEmpLayout = new org.jdesktop.layout.GroupLayout(palAddEmp);
        palAddEmp.setLayout(palAddEmpLayout);
        palAddEmpLayout.setHorizontalGroup(
            palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palAddEmpLayout.createSequentialGroup()
                .addContainerGap()
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblName)
                    .add(lblGender)
                    .add(lblDOB)
                    .add(lblAdd)
                    .add(lblPass)
                    .add(lblEmail)
                    .add(lblPhone)
                    .add(lblDepar)
                    .add(lblPermis))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtDepart, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .add(txtPhone, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .add(txtEmail, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .add(txtPass, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .add(txtAdd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .add(txtDOB, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .add(txtName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .add(cbxPermis, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .add(palAddEmpLayout.createSequentialGroup()
                .add(114, 114, 114)
                .add(rdbMale)
                .add(18, 18, 18)
                .add(rdbFemale)
                .addContainerGap(43, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, palAddEmpLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .add(btnAdd)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnCancel)
                .add(70, 70, 70))
        );
        palAddEmpLayout.setVerticalGroup(
            palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palAddEmpLayout.createSequentialGroup()
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblName)
                    .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblGender)
                    .add(rdbFemale)
                    .add(rdbMale))
                .add(8, 8, 8)
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblDOB)
                    .add(txtDOB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblAdd)
                    .add(txtAdd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblPass)
                    .add(txtPass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblEmail)
                    .add(txtEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblPhone)
                    .add(txtPhone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblDepar)
                    .add(txtDepart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblPermis)
                    .add(cbxPermis, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAdd)
                    .add(btnCancel))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.LABEL_ADDEMP)));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lblImage)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddEmp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(114, 114, 114)
                        .add(lblImage))
                    .add(layout.createSequentialGroup()
                        .add(9, 9, 9)
                        .add(palAddEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 376, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgrGender;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox cbxPermis;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblDepar;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPermis;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JPanel palAddEmp;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMale;
    private javax.swing.JTextField txtAdd;
    private org.jdesktop.swingx.JXDatePicker txtDOB;
    private javax.swing.JTextField txtDepart;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

    /**
     * @param btgrGender the btgrGender to set
     */
    public void setBtgrGender(javax.swing.ButtonGroup btgrGender) {
        this.btgrGender = btgrGender;
    }

    /**
     * @return the btnAdd
     */
    public javax.swing.JButton getBtnAdd() {
        return btnAdd;
    }

    /**
     * @param btnAdd the btnAdd to set
     */
    public void setBtnAdd(javax.swing.JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    /**
     * @return the btnCancel
     */
    public javax.swing.JButton getBtnCancel() {
        return btnCancel;
    }

    /**
     * @param btnCancel the btnCancel to set
     */
    public void setBtnCancel(javax.swing.JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    /**
     * @return the cbxPermis
     */
    public javax.swing.JComboBox getCbxPermis() {
        return cbxPermis;
    }

    /**
     * @param cbxPermis the cbxPermis to set
     */
    public void setCbxPermis(javax.swing.JComboBox cbxPermis) {
        this.cbxPermis = cbxPermis;
    }

    /**
     * @return the rdbFemale
     */
    public javax.swing.JRadioButton getRdbFemale() {
        return rdbFemale;
    }

    /**
     * @param rdbFemale the rdbFemale to set
     */
    public void setRdbFemale(javax.swing.JRadioButton rdbFemale) {
        this.rdbFemale = rdbFemale;
    }

    /**
     * @return the rdbMale
     */
    public javax.swing.JRadioButton getRdbMale() {
        return rdbMale;
    }

    /**
     * @param rdbMale the rdbMale to set
     */
    public void setRdbMale(javax.swing.JRadioButton rdbMale) {
        this.rdbMale = rdbMale;
    }

    /**
     * @return the txtAdd
     */
    public javax.swing.JTextField getTxtAdd() {
        return txtAdd;
    }

    /**
     * @param txtAdd the txtAdd to set
     */
    public void setTxtAdd(javax.swing.JTextField txtAdd) {
        this.txtAdd = txtAdd;
    }

    /**
     * @return the txtDOB
     */
    public org.jdesktop.swingx.JXDatePicker getTxtDOB() {
        return txtDOB;
    }

    /**
     * @param txtDOB the txtDOB to set
     */
    public void setTxtDOB(org.jdesktop.swingx.JXDatePicker txtDOB) {
        this.txtDOB = txtDOB;
    }

    /**
     * @return the txtDepart
     */
    public javax.swing.JTextField getTxtDepart() {
        return txtDepart;
    }

    /**
     * @param txtDepart the txtDepart to set
     */
    public void setTxtDepart(javax.swing.JTextField txtDepart) {
        this.txtDepart = txtDepart;
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
     * @return the txtName
     */
    public javax.swing.JTextField getTxtName() {
        return txtName;
    }

    /**
     * @param txtName the txtName to set
     */
    public void setTxtName(javax.swing.JTextField txtName) {
        this.txtName = txtName;
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
     * @return the txtPhone
     */
    public javax.swing.JTextField getTxtPhone() {
        return txtPhone;
    }

    /**
     * @param txtPhone the txtPhone to set
     */
    public void setTxtPhone(javax.swing.JTextField txtPhone) {
        this.txtPhone = txtPhone;
    }

    /**
     * @return the lblPass
     */
    public javax.swing.JLabel getLblPass() {
        return lblPass;
    }

    /**
     * @param lblPass the lblPass to set
     */
    public void setLblPass(javax.swing.JLabel lblPass) {
        this.lblPass = lblPass;
    }
}