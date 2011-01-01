/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditEmpDialog.java
 *
 * Created on Dec 31, 2010, 5:17:20 PM
 */

package GUI;

import java.awt.event.ItemEvent;
import java.io.File;

/**
 *
 * @author CuongNQ
 */
public class EditEmpDialog extends javax.swing.JDialog {

    /** Creates new form EditEmpDialog */
    public EditEmpDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        palEditEmp = new javax.swing.JPanel();
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
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        palEditEmp.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Information"));

        lblName.setText("Name:");

        lblGender.setText("Gender:");

        lblDOB.setText("Date of birth:");

        lblAdd.setText("Address:");

        lblPass.setText("Password:");

        lblEmail.setText("Email:");

        lblPhone.setText("Phone:");

        lblDepar.setText("Department:");

        lblPermis.setText("Permission:");

        txtName.setToolTipText("Edit name of Emp");

        rdbMale.setSelected(true);
        rdbMale.setText("Male");

        rdbFemale.setText("Female");

        txtAdd.setToolTipText("Edit address of Emp");

        txtPass.setToolTipText("Edit password of Emp");

        txtEmail.setToolTipText("Edit email of Emp");

        txtPhone.setToolTipText("Edit phone number of Emp");

        txtDepart.setToolTipText("Edit department of Emp");

        cbxPermis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Librarian", "Employee" }));
        cbxPermis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPermisItemStateChanged(evt);
            }
        });

        btnSave.setText("Save");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout palEditEmpLayout = new org.jdesktop.layout.GroupLayout(palEditEmp);
        palEditEmp.setLayout(palEditEmpLayout);
        palEditEmpLayout.setHorizontalGroup(
            palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palEditEmpLayout.createSequentialGroup()
                .addContainerGap()
                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(palEditEmpLayout.createSequentialGroup()
                        .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(palEditEmpLayout.createSequentialGroup()
                                .add(lblGender)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 112, Short.MAX_VALUE)
                                .add(rdbMale)
                                .add(18, 18, 18)
                                .add(rdbFemale))
                            .add(palEditEmpLayout.createSequentialGroup()
                                .add(lblPermis)
                                .add(18, 18, 18)
                                .add(cbxPermis, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(palEditEmpLayout.createSequentialGroup()
                                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(lblDOB)
                                    .add(lblAdd)
                                    .add(lblPass)
                                    .add(lblEmail)
                                    .add(lblPhone)
                                    .add(lblDepar)
                                    .add(lblName))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(txtName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .add(txtDepart, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .add(txtPhone, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .add(txtEmail, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .add(txtPass, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .add(txtAdd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .add(txtDOB, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))))
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, palEditEmpLayout.createSequentialGroup()
                        .add(btnSave)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnCancel)
                        .add(68, 68, 68))))
        );
        palEditEmpLayout.setVerticalGroup(
            palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palEditEmpLayout.createSequentialGroup()
                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblName)
                    .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblGender)
                    .add(rdbFemale)
                    .add(rdbMale))
                .add(8, 8, 8)
                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblDOB)
                    .add(txtDOB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblAdd)
                    .add(txtAdd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblPass)
                    .add(txtPass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblEmail)
                    .add(txtEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblPhone)
                    .add(txtPhone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblDepar)
                    .add(txtDepart, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblPermis)
                    .add(cbxPermis, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 7, Short.MAX_VALUE)
                .add(palEditEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnSave)
                    .add(btnCancel)))
        );

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images"+File.separator+"editEmpLbl.png")));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lblImage)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEditEmp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .add(palEditEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxPermisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPermisItemStateChanged
        //If  permission is employee, it doesn't need password
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (evt.getItem().equals("Employee")) {
                txtPass.setVisible(false);
                lblPass.setVisible(false);
            } else {
                txtPass.setVisible(true);
                lblPass.setVisible(true);
            }
        }
}//GEN-LAST:event_cbxPermisItemStateChanged

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_btnCancelActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditEmpDialog dialog = new EditEmpDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
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
    private javax.swing.JPanel palEditEmp;
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

}
