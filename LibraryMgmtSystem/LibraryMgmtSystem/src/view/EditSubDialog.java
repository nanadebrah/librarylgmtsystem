/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditSubDialog.java
 *
 * Created on Dec 31, 2010, 7:21:36 PM
 */

package view;

import model.LibImages;

/**
 *
 * @author CuongNQ
 */
public class EditSubDialog extends javax.swing.JDialog {

    /** Creates new form EditSubDialog */
    public EditSubDialog(java.awt.Frame parent, boolean modal) {
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
        setTitle("Edit Information For Subject");
        setResizable(false);

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.LABEL_EDITSUB)));

        palEditSub.setBorder(javax.swing.BorderFactory.createTitledBorder("Subject Information"));

        lblSubName.setText("Name:");

        lblDes.setText("Description:");

        txtName.setToolTipText("Subject's name");

        btnSave.setText("Save");

        btnCancel.setText("Cancel");

        txtDes.setColumns(20);
        txtDes.setRows(5);
        txtDes.setToolTipText("Details of this subject");
        scrlPanl.setViewportView(txtDes);

        org.jdesktop.layout.GroupLayout palEditSubLayout = new org.jdesktop.layout.GroupLayout(palEditSub);
        palEditSub.setLayout(palEditSubLayout);
        palEditSubLayout.setHorizontalGroup(
            palEditSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palEditSubLayout.createSequentialGroup()
                .add(palEditSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(palEditSubLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(palEditSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblSubName)
                            .add(lblDes))
                        .add(18, 18, 18)
                        .add(palEditSubLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(scrlPanl, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .add(txtName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
                    .add(palEditSubLayout.createSequentialGroup()
                        .add(115, 115, 115)
                        .add(btnSave)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnCancel)))
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
            .add(layout.createSequentialGroup()
                .add(lblImage)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEditSub, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
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
     * @return the txtDes
     */
    public javax.swing.JTextArea getTxtDes() {
        return txtDes;
    }

    /**
     * @param txtDes the txtDes to set
     */
    public void setTxtDes(javax.swing.JTextArea txtDes) {
        this.txtDes = txtDes;
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

}