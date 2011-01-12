/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * editBokDialog.java
 *
 * Created on Dec 31, 2010, 6:49:10 PM
 */

package view;

import model.LibImages;

/**
 *
 * @author CuongNQ
 */
public class EditBokDialog extends javax.swing.JDialog {

    /** Creates new form editBokDialog */
    public EditBokDialog(java.awt.Frame parent, boolean modal) {
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
        txtAuthor = new javax.swing.JTextField();
        txtPublish = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cbxSub = new javax.swing.JComboBox();
        txtNoCop = new javax.swing.JSpinner();
        lblNoInLib = new javax.swing.JLabel();
        txtNoInLib = new javax.swing.JSpinner();
        lblTitle1 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JFormattedTextField();
        txtTitle = new javax.swing.JTextField();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Details For Book");
        setResizable(false);

        palAddBok.setBorder(javax.swing.BorderFactory.createTitledBorder("Book Information"));

        lblTitle.setText("Title:");

        lblAuth.setText("Author:");

        lblPublish.setText("Publisher:");

        lblNoCop.setText("No of copies:");

        lblSub.setText("Subject:");

        txtAuthor.setToolTipText("Author of this book");

        txtPublish.setToolTipText("Publisher of this book");

        btnAdd.setText("Save");

        btnCancel.setText("Cancel");

        cbxSub.setToolTipText("Subject of this book");

        txtNoCop.setToolTipText("Copies of this book");

        lblNoInLib.setText("No in library:");

        txtNoInLib.setEnabled(false);
        txtNoInLib.setToolTipText("Copies of this book");

        lblTitle1.setText("ISBN:");

        try {
            txtISBN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        org.jdesktop.layout.GroupLayout palAddBokLayout = new org.jdesktop.layout.GroupLayout(palAddBok);
        palAddBok.setLayout(palAddBokLayout);
        palAddBokLayout.setHorizontalGroup(
            palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palAddBokLayout.createSequentialGroup()
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(palAddBokLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(lblTitle)
                            .add(lblAuth)
                            .add(lblPublish)
                            .add(lblNoCop)
                            .add(lblSub)
                            .add(lblTitle1))
                        .add(18, 18, 18)
                        .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(cbxSub, 0, 273, Short.MAX_VALUE)
                            .add(txtAuthor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .add(txtTitle, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .add(txtISBN, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .add(palAddBokLayout.createSequentialGroup()
                                .add(txtNoCop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(lblNoInLib, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(txtNoInLib, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(txtPublish, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 273, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(98, 98, 98))
                    .add(palAddBokLayout.createSequentialGroup()
                        .add(130, 130, 130)
                        .add(btnAdd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 86, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        palAddBokLayout.setVerticalGroup(
            palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palAddBokLayout.createSequentialGroup()
                .add(12, 12, 12)
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblTitle1)
                    .add(txtISBN, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblTitle)
                    .add(txtTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
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
                    .add(txtNoCop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(palAddBokLayout.createSequentialGroup()
                        .add(lblNoInLib)
                        .add(6, 6, 6))
                    .add(txtNoInLib, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblSub)
                    .add(cbxSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddBokLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnAdd)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, btnCancel))
                .add(29, 29, 29))
        );

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.LABEL_EDITBOOK)));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lblImage)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palAddBok, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 418, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(79, 79, 79)
                        .add(lblImage))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(palAddBok, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 282, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JComboBox cbxSub;
    private javax.swing.JLabel lblAuth;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblNoCop;
    private javax.swing.JLabel lblNoInLib;
    private javax.swing.JLabel lblPublish;
    private javax.swing.JLabel lblSub;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel palAddBok;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JFormattedTextField txtISBN;
    private javax.swing.JSpinner txtNoCop;
    private javax.swing.JSpinner txtNoInLib;
    private javax.swing.JTextField txtPublish;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables

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
     * @return the cbxSub
     */
    public javax.swing.JComboBox getCbxSub() {
        return cbxSub;
    }

    /**
     * @param cbxSub the cbxSub to set
     */
    public void setCbxSub(javax.swing.JComboBox cbxSub) {
        this.cbxSub = cbxSub;
    }

    /**
     * @return the txtAuthor
     */
    public javax.swing.JTextField getTxtAuthor() {
        return txtAuthor;
    }

    /**
     * @param txtAuthor the txtAuthor to set
     */
    public void setTxtAuthor(javax.swing.JTextField txtAuthor) {
        this.txtAuthor = txtAuthor;
    }

    /**
     * @return the txtISBN
     */
    public javax.swing.JFormattedTextField getTxtISBN() {
        return txtISBN;
    }

    /**
     * @param txtISBN the txtISBN to set
     */
    public void setTxtISBN(javax.swing.JFormattedTextField txtISBN) {
        this.txtISBN = txtISBN;
    }

    /**
     * @return the txtNoCop
     */
    public javax.swing.JSpinner getTxtNoCop() {
        return txtNoCop;
    }

    /**
     * @param txtNoCop the txtNoCop to set
     */
    public void setTxtNoCop(javax.swing.JSpinner txtNoCop) {
        this.txtNoCop = txtNoCop;
    }

    /**
     * @return the txtNoInLib
     */
    public javax.swing.JSpinner getTxtNoInLib() {
        return txtNoInLib;
    }

    /**
     * @param txtNoInLib the txtNoInLib to set
     */
    public void setTxtNoInLib(javax.swing.JSpinner txtNoInLib) {
        this.txtNoInLib = txtNoInLib;
    }

    /**
     * @return the txtPublish
     */
    public javax.swing.JTextField getTxtPublish() {
        return txtPublish;
    }

    /**
     * @param txtPublish the txtPublish to set
     */
    public void setTxtPublish(javax.swing.JTextField txtPublish) {
        this.txtPublish = txtPublish;
    }

    /**
     * @return the txtTitle
     */
    public javax.swing.JTextField getTxtTitle() {
        return txtTitle;
    }

    /**
     * @param txtTitle the txtTitle to set
     */
    public void setTxtTitle(javax.swing.JTextField txtTitle) {
        this.txtTitle = txtTitle;
    }

}
