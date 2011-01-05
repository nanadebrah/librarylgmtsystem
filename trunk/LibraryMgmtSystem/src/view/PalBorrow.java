/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PalBorrow.java
 *
 * Created on Jan 3, 2011, 6:03:25 PM
 */

package view;

import model.LibImages;

/**
 *
 * @author CuongNQ
 */
public class PalBorrow extends javax.swing.JPanel {

    /** Creates new form PalBorrow */
    public PalBorrow() {
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

        tolbarBor = new javax.swing.JToolBar();
        btnChkOut = new javax.swing.JButton();
        btnChkIn = new javax.swing.JButton();
        btnFee = new javax.swing.JButton();
        separator7 = new javax.swing.JToolBar.Separator();
        btnEditBor = new javax.swing.JButton();
        btnViewBor = new javax.swing.JButton();
        btnDelBor = new javax.swing.JButton();
        separator8 = new javax.swing.JToolBar.Separator();
        btnSearchBor = new javax.swing.JButton();
        scrPanBor = new javax.swing.JScrollPane();
        tblBor = new javax.swing.JTable();
        lblCallNoBor = new javax.swing.JLabel();
        lblEmNmBor = new javax.swing.JLabel();
        txtEmNamBor = new javax.swing.JTextField();
        txtCallNoBor = new javax.swing.JTextField();

        tolbarBor.setBorder(null);
        tolbarBor.setFloatable(false);
        tolbarBor.setBorderPainted(false);
        tolbarBor.setOpaque(false);

        btnChkOut.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_CHECKOUT)));
        btnChkOut.setMnemonic('o');
        btnChkOut.setText("Check-Out");
        btnChkOut.setBorderPainted(false);
        btnChkOut.setFocusable(false);
        btnChkOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChkOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnChkOut);

        btnChkIn.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_CHECKIN)));
        btnChkIn.setMnemonic('i');
        btnChkIn.setText("Check-In");
        btnChkIn.setBorderPainted(false);
        btnChkIn.setFocusable(false);
        btnChkIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChkIn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnChkIn);

        btnFee.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_FEE)));
        btnFee.setMnemonic('f');
        btnFee.setText("Fee rate");
        btnFee.setBorderPainted(false);
        btnFee.setFocusable(false);
        btnFee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFee.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnFee);
        tolbarBor.add(separator7);

        btnEditBor.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_EDIT)));
        btnEditBor.setMnemonic('e');
        btnEditBor.setText("Edit");
        btnEditBor.setBorderPainted(false);
        btnEditBor.setEnabled(false);
        btnEditBor.setFocusable(false);
        btnEditBor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditBor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnEditBor);

        btnViewBor.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_VIEW)));
        btnViewBor.setMnemonic('v');
        btnViewBor.setText("View");
        btnViewBor.setBorderPainted(false);
        btnViewBor.setEnabled(false);
        btnViewBor.setFocusable(false);
        btnViewBor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewBor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnViewBor);

        btnDelBor.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_DETELE)));
        btnDelBor.setMnemonic('d');
        btnDelBor.setText("Delete");
        btnDelBor.setBorderPainted(false);
        btnDelBor.setEnabled(false);
        btnDelBor.setFocusable(false);
        btnDelBor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelBor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnDelBor);
        tolbarBor.add(separator8);

        btnSearchBor.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_SEARCH)));
        btnSearchBor.setMnemonic('s');
        btnSearchBor.setText("Search");
        btnSearchBor.setBorderPainted(false);
        btnSearchBor.setFocusable(false);
        btnSearchBor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchBor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnSearchBor);

        tblBor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrPanBor.setViewportView(tblBor);

        lblCallNoBor.setText("CallNo:");

        lblEmNmBor.setText("Emp Name:");

        txtEmNamBor.setToolTipText("Username of employee");

        txtCallNoBor.setToolTipText("order of book");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(scrPanBor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(tolbarBor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblEmNmBor)
                    .add(lblCallNoBor))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(txtEmNamBor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .add(txtCallNoBor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, tolbarBor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblCallNoBor)
                            .add(txtCallNoBor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(2, 2, 2)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblEmNmBor)
                            .add(txtEmNamBor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(scrPanBor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChkIn;
    private javax.swing.JButton btnChkOut;
    private javax.swing.JButton btnDelBor;
    private javax.swing.JButton btnEditBor;
    private javax.swing.JButton btnFee;
    private javax.swing.JButton btnSearchBor;
    private javax.swing.JButton btnViewBor;
    private javax.swing.JLabel lblCallNoBor;
    private javax.swing.JLabel lblEmNmBor;
    private javax.swing.JScrollPane scrPanBor;
    private javax.swing.JToolBar.Separator separator7;
    private javax.swing.JToolBar.Separator separator8;
    private javax.swing.JTable tblBor;
    private javax.swing.JToolBar tolbarBor;
    private javax.swing.JTextField txtCallNoBor;
    private javax.swing.JTextField txtEmNamBor;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnChkIn
     */
    public javax.swing.JButton getBtnChkIn() {
        return btnChkIn;
    }

    /**
     * @param btnChkIn the btnChkIn to set
     */
    public void setBtnChkIn(javax.swing.JButton btnChkIn) {
        this.btnChkIn = btnChkIn;
    }

    /**
     * @return the btnChkOut
     */
    public javax.swing.JButton getBtnChkOut() {
        return btnChkOut;
    }

    /**
     * @param btnChkOut the btnChkOut to set
     */
    public void setBtnChkOut(javax.swing.JButton btnChkOut) {
        this.btnChkOut = btnChkOut;
    }

    /**
     * @return the btnDelBor
     */
    public javax.swing.JButton getBtnDelBor() {
        return btnDelBor;
    }

    /**
     * @param btnDelBor the btnDelBor to set
     */
    public void setBtnDelBor(javax.swing.JButton btnDelBor) {
        this.btnDelBor = btnDelBor;
    }

    /**
     * @return the btnEditBor
     */
    public javax.swing.JButton getBtnEditBor() {
        return btnEditBor;
    }

    /**
     * @param btnEditBor the btnEditBor to set
     */
    public void setBtnEditBor(javax.swing.JButton btnEditBor) {
        this.btnEditBor = btnEditBor;
    }

    /**
     * @return the btnFee
     */
    public javax.swing.JButton getBtnFee() {
        return btnFee;
    }

    /**
     * @param btnFee the btnFee to set
     */
    public void setBtnFee(javax.swing.JButton btnFee) {
        this.btnFee = btnFee;
    }

    /**
     * @return the btnSearchBor
     */
    public javax.swing.JButton getBtnSearchBor() {
        return btnSearchBor;
    }

    /**
     * @param btnSearchBor the btnSearchBor to set
     */
    public void setBtnSearchBor(javax.swing.JButton btnSearchBor) {
        this.btnSearchBor = btnSearchBor;
    }

    /**
     * @return the btnViewBor
     */
    public javax.swing.JButton getBtnViewBor() {
        return btnViewBor;
    }

    /**
     * @param btnViewBor the btnViewBor to set
     */
    public void setBtnViewBor(javax.swing.JButton btnViewBor) {
        this.btnViewBor = btnViewBor;
    }

    /**
     * @return the tblBor
     */
    public javax.swing.JTable getTblBor() {
        return tblBor;
    }

    /**
     * @param tblBor the tblBor to set
     */
    public void setTblBor(javax.swing.JTable tblBor) {
        this.tblBor = tblBor;
    }

    /**
     * @return the txtCallNoBor
     */
    public javax.swing.JTextField getTxtCallNoBor() {
        return txtCallNoBor;
    }

    /**
     * @param txtCallNoBor the txtCallNoBor to set
     */
    public void setTxtCallNoBor(javax.swing.JTextField txtCallNoBor) {
        this.txtCallNoBor = txtCallNoBor;
    }

    /**
     * @return the txtEmNamBor
     */
    public javax.swing.JTextField getTxtEmNamBor() {
        return txtEmNamBor;
    }

    /**
     * @param txtEmNamBor the txtEmNamBor to set
     */
    public void setTxtEmNamBor(javax.swing.JTextField txtEmNamBor) {
        this.txtEmNamBor = txtEmNamBor;
    }

}
