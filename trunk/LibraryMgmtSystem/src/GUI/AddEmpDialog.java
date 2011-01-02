/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * addEmpDialog.java
 *
 * Created on Dec 30, 2010, 10:05:59 PM
 */
package GUI;

import Util.Objects.Employee;
import java.awt.event.ItemEvent;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author CuongNQ
 */
public class AddEmpDialog extends javax.swing.JDialog {

    public Employee emp = null;

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
        setTitle("Add a employee or librarian");
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

        txtDOB.setToolTipText("His ( her ) date of birth");

        txtAdd.setToolTipText("His( her ) address");

        txtPass.setToolTipText("His( her ) password");

        txtEmail.setToolTipText("His( her ) email");

        txtPhone.setToolTipText("His( her ) phone number");

        txtDepart.setToolTipText("His( her ) department");

        cbxPermis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Librarian", "Employee" }));
        cbxPermis.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPermisItemStateChanged(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout palAddEmpLayout = new org.jdesktop.layout.GroupLayout(palAddEmp);
        palAddEmp.setLayout(palAddEmpLayout);
        palAddEmpLayout.setHorizontalGroup(
            palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palAddEmpLayout.createSequentialGroup()
                .addContainerGap()
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(palAddEmpLayout.createSequentialGroup()
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
                            .add(txtName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .add(txtDOB, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .add(txtAdd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .add(txtPass, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .add(txtEmail, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .add(txtPhone, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .add(txtDepart, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                            .add(cbxPermis, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(palAddEmpLayout.createSequentialGroup()
                                .add(rdbMale)
                                .add(18, 18, 18)
                                .add(rdbFemale)))
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, palAddEmpLayout.createSequentialGroup()
                        .add(btnAdd)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnCancel)
                        .add(68, 68, 68))))
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
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 7, Short.MAX_VALUE)
                .add(palAddEmpLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnAdd)
                    .add(btnCancel)))
        );

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images"+File.separator+"addEmpLbl.png")));

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
                        .add(palAddEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Check valid all field
     */
    private boolean checkValid() {
        java.util.Date date = txtDOB.getDate();
        if (cbxPermis.getSelectedItem().toString().equals("Librarian")) {
            if (txtName.getText().length() == 0 || date == null || txtPass.getPassword().length == 0
                    || txtDepart.getText().length() == 0 || txtAdd.getText().length() == 0
                    || txtEmail.getText().length() == 0 || txtPhone.getText().length() == 0) {
                return false;
            }
        } else {
            if (txtName.getText().length() == 0 || date == null
                    || txtDepart.getText().length() == 0 || txtAdd.getText().length() == 0
                    || txtEmail.getText().length() == 0 || txtPhone.getText().length() == 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * Transfer all field to object
     */
    private void toObject() {
        emp = new Employee();
        emp.setName(txtName.getText());
        if (rdbMale.isSelected()) {
            emp.setGender(1);
        } else {
            emp.setGender(0);
        }
        emp.setDOB(txtDOB.getDate().getTime());
        emp.setAddress(txtAdd.getText());
        emp.setEmail(txtEmail.getText());
        emp.setPassword(new String(txtPass.getPassword()));
        emp.setPhone(txtPhone.getText());
        emp.setDepartment(txtDepart.getText());
        if (cbxPermis.getSelectedItem().toString().equals("Librarian")) {
            emp.setPermission(1);
        } else {
            emp.setPermission(0);
        }
    }

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
        //Dispose this dialog
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //invoked when add button clicked
        if (checkValid()) {
            //set object
            toObject();
            //Dispose this dialog
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "All field must valid",
                    "Warning!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                AddEmpDialog dialog = new AddEmpDialog(new javax.swing.JFrame(), true);
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
}
