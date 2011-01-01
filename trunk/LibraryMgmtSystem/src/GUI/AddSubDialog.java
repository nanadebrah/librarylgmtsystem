/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddSubDialog.java
 *
 * Created on Dec 31, 2010, 6:54:30 PM
 */

package GUI;

import java.io.File;

/**
 *
 * @author CuongNQ
 */
public class AddSubDialog extends javax.swing.JDialog {

    /** Creates new form AddSubDialog */
    public AddSubDialog(java.awt.Frame parent, boolean modal) {
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
        palAddSub = new javax.swing.JPanel();
        lblSubName = new javax.swing.JLabel();
        lblDes = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        scrlPanl = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images"+File.separator+"addSubLbl.png")));

        palAddSub.setBorder(javax.swing.BorderFactory.createTitledBorder("Subject Information"));

        lblSubName.setText("Name:");

        lblDes.setText("Description:");

        txtName.setToolTipText("Book's name");

        btnAdd.setText("Add");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtDes.setColumns(20);
        txtDes.setRows(5);
        txtDes.setToolTipText("Details of this book");
        scrlPanl.setViewportView(txtDes);

        org.jdesktop.layout.GroupLayout palAddSubLayout = new org.jdesktop.layout.GroupLayout(palAddSub);
        palAddSub.setLayout(palAddSubLayout);
        palAddSubLayout.setHorizontalGroup(
            palAddSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palAddSubLayout.createSequentialGroup()
                .addContainerGap()
                .add(palAddSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblDes)
                    .add(lblSubName))
                .add(18, 18, 18)
                .add(palAddSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(palAddSubLayout.createSequentialGroup()
                        .add(btnAdd)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnCancel))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, scrlPanl, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .add(txtName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap())
        );
        palAddSubLayout.setVerticalGroup(
            palAddSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palAddSubLayout.createSequentialGroup()
                .add(palAddSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblSubName)
                    .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblDes)
                    .add(scrlPanl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCancel)
                    .add(btnAdd)))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(lblImage)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddSub, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(41, 41, 41)
                        .add(lblImage))
                    .add(palAddSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
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
                AddSubDialog dialog = new AddSubDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel lblDes;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblSubName;
    private javax.swing.JPanel palAddSub;
    private javax.swing.JScrollPane scrlPanl;
    private javax.swing.JTextArea txtDes;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

}
