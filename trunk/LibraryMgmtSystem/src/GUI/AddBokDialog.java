/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddBokDialog.java
 *
 * Created on Dec 31, 2010, 6:10:53 PM
 */

package GUI;

import java.io.File;

/**
 *
 * @author CuongNQ
 */
public class AddBokDialog extends javax.swing.JDialog {

    /** Creates new form AddBokDialog */
    public AddBokDialog(java.awt.Frame parent, boolean modal) {
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

        palAddBok = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblAuth = new javax.swing.JLabel();
        lblPublish = new javax.swing.JLabel();
        lblNoCop = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        txtPublish = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cbxSub = new javax.swing.JComboBox();
        txtNoCop = new javax.swing.JSpinner();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        palAddBok.setBorder(javax.swing.BorderFactory.createTitledBorder("Book Information"));

        lblTitle.setText("Title:");

        lblAuth.setText("Author:");

        lblPublish.setText("Publisher:");

        lblNoCop.setText("No of Copy:");

        lblSub.setText("Subject:");

        txtTitle.setToolTipText("Title of this book");

        txtAuthor.setToolTipText("Author of this book");

        txtPublish.setToolTipText("Publisher of this book");

        btnAdd.setText("Add");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cbxSub.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSub.setToolTipText("Subject of this book");

        txtNoCop.setToolTipText("Copies of this book");

        org.jdesktop.layout.GroupLayout palAddBokLayout = new org.jdesktop.layout.GroupLayout(palAddBok);
        palAddBok.setLayout(palAddBokLayout);
        palAddBokLayout.setHorizontalGroup(
            palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palAddBokLayout.createSequentialGroup()
                .add(130, 130, 130)
                .add(btnAdd)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnCancel)
                .add(99, 99, 99))
            .add(palAddBokLayout.createSequentialGroup()
                .addContainerGap()
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblTitle)
                    .add(lblAuth)
                    .add(lblPublish)
                    .add(lblNoCop)
                    .add(lblSub))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .add(txtAuthor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .add(txtPublish, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .add(txtNoCop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbxSub, 0, 267, Short.MAX_VALUE))
                .addContainerGap())
        );
        palAddBokLayout.setVerticalGroup(
            palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palAddBokLayout.createSequentialGroup()
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblTitle)
                    .add(txtTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblAuth)
                    .add(txtAuthor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblPublish)
                    .add(txtPublish, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(palAddBokLayout.createSequentialGroup()
                        .add(lblNoCop)
                        .add(6, 6, 6))
                    .add(txtNoCop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblSub)
                    .add(cbxSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnAdd)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnCancel)))
        );

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images"+File.separator+"addBokLbl.png")));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(lblImage)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddBok, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(41, 41, 41)
                        .add(lblImage))
                    .add(palAddBok, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        dispose();
}//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox cbxSub;
    private javax.swing.JLabel lblAuth;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblNoCop;
    private javax.swing.JLabel lblPublish;
    private javax.swing.JLabel lblSub;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel palAddBok;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JSpinner txtNoCop;
    private javax.swing.JTextField txtPublish;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables

}
