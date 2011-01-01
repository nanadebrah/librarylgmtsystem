/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditSubDialog.java
 *
 * Created on Dec 31, 2010, 7:21:36 PM
 */

package GUI;

import java.io.File;

/**
 *
 * @author CuongNQ
 */
public class EditSubDialog extends javax.swing.JDialog {

    /** Creates new form EditSubDialog */
    public EditSubDialog(java.awt.Frame parent, boolean modal) {
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

        lblImage = new javax.swing.JLabel();
        palEditSub = new javax.swing.JPanel();
        lblSubName = new javax.swing.JLabel();
        lblDes = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        scrlPanl = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images"+File.separator+"editSubLbl.png")));

        palEditSub.setBorder(javax.swing.BorderFactory.createTitledBorder("Subject Information"));

        lblSubName.setText("Name:");

        lblDes.setText("Description:");

        btnSave.setText("Save");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtDes.setColumns(20);
        txtDes.setRows(5);
        scrlPanl.setViewportView(txtDes);

        org.jdesktop.layout.GroupLayout palEditSubLayout = new org.jdesktop.layout.GroupLayout(palEditSub);
        palEditSub.setLayout(palEditSubLayout);
        palEditSubLayout.setHorizontalGroup(
            palEditSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palEditSubLayout.createSequentialGroup()
                .addContainerGap()
                .add(palEditSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblDes)
                    .add(lblSubName))
                .add(18, 18, 18)
                .add(palEditSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(palEditSubLayout.createSequentialGroup()
                        .add(btnSave)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnCancel))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, scrlPanl)
                    .add(txtName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap())
        );
        palEditSubLayout.setVerticalGroup(
            palEditSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palEditSubLayout.createSequentialGroup()
                .add(palEditSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblSubName)
                    .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEditSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblDes)
                    .add(scrlPanl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEditSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCancel)
                    .add(btnSave)))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 419, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(lblImage)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEditSub, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 234, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(41, 41, 41)
                        .add(lblImage))
                    .add(palEditSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                EditSubDialog dialog = new EditSubDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblDes;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblSubName;
    private javax.swing.JPanel palEditSub;
    private javax.swing.JScrollPane scrlPanl;
    private javax.swing.JTextArea txtDes;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

}
