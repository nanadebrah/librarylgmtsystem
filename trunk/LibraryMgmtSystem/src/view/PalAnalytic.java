/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PalAnalytic.java
 *
 * Created on Jan 3, 2011, 6:05:03 PM
 */

package view;

import model.LibImages;

/**
 *
 * @author CuongNQ
 */
public class PalAnalytic extends javax.swing.JPanel {

    /** Creates new form PalAnalytic */
    public PalAnalytic() {
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

        tolbarAna = new javax.swing.JToolBar();
        btnTBookAna = new javax.swing.JButton();
        btnTBorAna = new javax.swing.JButton();
        btnViewAna = new javax.swing.JButton();
        btnAlertAna = new javax.swing.JButton();
        btnRevAna = new javax.swing.JButton();
        scrPanAna = new javax.swing.JScrollPane();
        tblAna = new javax.swing.JTable();

        setToolTipText("show details");

        tolbarAna.setBorder(null);
        tolbarAna.setFloatable(false);
        tolbarAna.setBorderPainted(false);
        tolbarAna.setOpaque(false);

        btnTBookAna.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_TOPBOOK)));
        btnTBookAna.setMnemonic('a');
        btnTBookAna.setText("Top Book");
        btnTBookAna.setBorderPainted(false);
        btnTBookAna.setFocusable(false);
        btnTBookAna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTBookAna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarAna.add(btnTBookAna);

        btnTBorAna.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_TOPBORROWER)));
        btnTBorAna.setMnemonic('e');
        btnTBorAna.setText("Top Borrower");
        btnTBorAna.setBorderPainted(false);
        btnTBorAna.setFocusable(false);
        btnTBorAna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTBorAna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarAna.add(btnTBorAna);

        btnViewAna.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_VIEW)));
        btnViewAna.setMnemonic('v');
        btnViewAna.setText("View");
        btnViewAna.setBorderPainted(false);
        btnViewAna.setEnabled(false);
        btnViewAna.setFocusable(false);
        btnViewAna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewAna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarAna.add(btnViewAna);

        btnAlertAna.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_SENDALERT)));
        btnAlertAna.setMnemonic('s');
        btnAlertAna.setText("Overdue Alert");
        btnAlertAna.setBorderPainted(false);
        btnAlertAna.setEnabled(false);
        btnAlertAna.setFocusable(false);
        btnAlertAna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlertAna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarAna.add(btnAlertAna);

        btnRevAna.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_REVENUE)));
        btnRevAna.setText("Revenue");
        btnRevAna.setBorderPainted(false);
        btnRevAna.setFocusable(false);
        btnRevAna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRevAna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarAna.add(btnRevAna);

        tblAna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrPanAna.setViewportView(tblAna);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(scrPanAna, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
            .add(tolbarAna, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(tolbarAna, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(scrPanAna, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlertAna;
    private javax.swing.JButton btnRevAna;
    private javax.swing.JButton btnTBookAna;
    private javax.swing.JButton btnTBorAna;
    private javax.swing.JButton btnViewAna;
    private javax.swing.JScrollPane scrPanAna;
    private javax.swing.JTable tblAna;
    private javax.swing.JToolBar tolbarAna;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnAlertAna
     */
    public javax.swing.JButton getBtnAlertAna() {
        return btnAlertAna;
    }

    /**
     * @param btnAlertAna the btnAlertAna to set
     */
    public void setBtnAlertAna(javax.swing.JButton btnAlertAna) {
        this.btnAlertAna = btnAlertAna;
    }

    /**
     * @return the btnRevAna
     */
    public javax.swing.JButton getBtnRevAna() {
        return btnRevAna;
    }

    /**
     * @param btnRevAna the btnRevAna to set
     */
    public void setBtnRevAna(javax.swing.JButton btnRevAna) {
        this.btnRevAna = btnRevAna;
    }

    /**
     * @return the btnTBookAna
     */
    public javax.swing.JButton getBtnTBookAna() {
        return btnTBookAna;
    }

    /**
     * @param btnTBookAna the btnTBookAna to set
     */
    public void setBtnTBookAna(javax.swing.JButton btnTBookAna) {
        this.btnTBookAna = btnTBookAna;
    }

    /**
     * @return the btnTBorAna
     */
    public javax.swing.JButton getBtnTBorAna() {
        return btnTBorAna;
    }

    /**
     * @param btnTBorAna the btnTBorAna to set
     */
    public void setBtnTBorAna(javax.swing.JButton btnTBorAna) {
        this.btnTBorAna = btnTBorAna;
    }

    /**
     * @return the btnViewAna
     */
    public javax.swing.JButton getBtnViewAna() {
        return btnViewAna;
    }

    /**
     * @param btnViewAna the btnViewAna to set
     */
    public void setBtnViewAna(javax.swing.JButton btnViewAna) {
        this.btnViewAna = btnViewAna;
    }

    /**
     * @return the tblAna
     */
    public javax.swing.JTable getTblAna() {
        return tblAna;
    }

    /**
     * @param tblAna the tblAna to set
     */
    public void setTblAna(javax.swing.JTable tblAna) {
        this.tblAna = tblAna;
    }

}
