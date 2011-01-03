/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PalEmployee.java
 *
 * Created on Jan 3, 2011, 1:25:34 PM
 */

package view;

import javax.swing.ImageIcon;
import model.LibImages;

/**
 *
 * @author CuongNQ
 */
public class PalEmployee extends javax.swing.JPanel {

    /** Creates new form PalEmployee */
    public PalEmployee() {
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

        tolbarEmp = new javax.swing.JToolBar();
        btnAddEmp = new javax.swing.JButton();
        separator1 = new javax.swing.JToolBar.Separator();
        btnEditEmp = new javax.swing.JButton();
        btnViewEmp = new javax.swing.JButton();
        btnDelEmp = new javax.swing.JButton();
        separator2 = new javax.swing.JToolBar.Separator();
        btnSearchEmp = new javax.swing.JButton();
        scrPanEmp = new javax.swing.JScrollPane();
        tblEmp = new javax.swing.JTable();
        lblIDEmp = new javax.swing.JLabel();
        lblNameEmp = new javax.swing.JLabel();
        txtNameEmp = new javax.swing.JTextField();
        txtIdEmp = new javax.swing.JTextField();

        tolbarEmp.setBorder(null);
        tolbarEmp.setFloatable(false);
        tolbarEmp.setBorderPainted(false);
        tolbarEmp.setOpaque(false);

        btnAddEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.Taskbar_Add)));
        btnAddEmp.setMnemonic('a');
        btnAddEmp.setText("Add");
        btnAddEmp.setBorderPainted(false);
        btnAddEmp.setFocusable(false);
        btnAddEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddEmp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarEmp.add(btnAddEmp);
        tolbarEmp.add(separator1);

        btnEditEmp.setIcon(new ImageIcon(getClass().getResource(LibImages.Taskbar_Edit)));
        btnEditEmp.setMnemonic('e');
        btnEditEmp.setText("Edit");
        btnEditEmp.setBorderPainted(false);
        btnEditEmp.setEnabled(false);
        btnEditEmp.setFocusable(false);
        btnEditEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditEmp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarEmp.add(btnEditEmp);

        btnViewEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.Taskbar_View)));
        btnViewEmp.setMnemonic('v');
        btnViewEmp.setText("View");
        btnViewEmp.setBorderPainted(false);
        btnViewEmp.setEnabled(false);
        btnViewEmp.setFocusable(false);
        btnViewEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewEmp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarEmp.add(btnViewEmp);

        btnDelEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.Taskbar_Delete)));
        btnDelEmp.setMnemonic('d');
        btnDelEmp.setText("Delete");
        btnDelEmp.setBorderPainted(false);
        btnDelEmp.setEnabled(false);
        btnDelEmp.setFocusable(false);
        btnDelEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelEmp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarEmp.add(btnDelEmp);
        tolbarEmp.add(separator2);

        btnSearchEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.Taskbar_Search)));
        btnSearchEmp.setMnemonic('s');
        btnSearchEmp.setText("Search");
        btnSearchEmp.setBorderPainted(false);
        btnSearchEmp.setFocusable(false);
        btnSearchEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchEmp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarEmp.add(btnSearchEmp);

        tblEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrPanEmp.setViewportView(tblEmp);

        lblIDEmp.setText("Emp ID:");

        lblNameEmp.setText("Emp Name:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(tolbarEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(lblIDEmp)
                        .add(32, 32, 32)
                        .add(txtIdEmp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(lblNameEmp)
                        .add(10, 10, 10)
                        .add(txtNameEmp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))))
            .add(scrPanEmp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, tolbarEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblIDEmp)
                            .add(txtIdEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(2, 2, 2)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblNameEmp)
                            .add(txtNameEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(scrPanEmp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmp;
    private javax.swing.JButton btnDelEmp;
    private javax.swing.JButton btnEditEmp;
    private javax.swing.JButton btnSearchEmp;
    private javax.swing.JButton btnViewEmp;
    private javax.swing.JLabel lblIDEmp;
    private javax.swing.JLabel lblNameEmp;
    private javax.swing.JScrollPane scrPanEmp;
    private javax.swing.JToolBar.Separator separator1;
    private javax.swing.JToolBar.Separator separator2;
    private javax.swing.JTable tblEmp;
    private javax.swing.JToolBar tolbarEmp;
    private javax.swing.JTextField txtIdEmp;
    private javax.swing.JTextField txtNameEmp;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the tblEmp
     */
    public javax.swing.JTable getTblEmp() {
        return tblEmp;
    }

    /**
     * @param tblEmp the tblEmp to set
     */
    public void setTblEmp(javax.swing.JTable tblEmp) {
        this.tblEmp = tblEmp;
    }

    /**
     * @return the btnDelEmp
     */
    public javax.swing.JButton getBtnDelEmp() {
        return btnDelEmp;
    }

    /**
     * @param btnDelEmp the btnDelEmp to set
     */
    public void setBtnDelEmp(javax.swing.JButton btnDelEmp) {
        this.btnDelEmp = btnDelEmp;
    }

    /**
     * @return the btnEditEmp
     */
    public javax.swing.JButton getBtnEditEmp() {
        return btnEditEmp;
    }

    /**
     * @param btnEditEmp the btnEditEmp to set
     */
    public void setBtnEditEmp(javax.swing.JButton btnEditEmp) {
        this.btnEditEmp = btnEditEmp;
    }

    /**
     * @return the btnSearchEmp
     */
    public javax.swing.JButton getBtnSearchEmp() {
        return btnSearchEmp;
    }

    /**
     * @param btnSearchEmp the btnSearchEmp to set
     */
    public void setBtnSearchEmp(javax.swing.JButton btnSearchEmp) {
        this.btnSearchEmp = btnSearchEmp;
    }

    /**
     * @return the btnViewEmp
     */
    public javax.swing.JButton getBtnViewEmp() {
        return btnViewEmp;
    }

    /**
     * @param btnViewEmp the btnViewEmp to set
     */
    public void setBtnViewEmp(javax.swing.JButton btnViewEmp) {
        this.btnViewEmp = btnViewEmp;
    }

    /**
     * @return the btnAddEmp
     */
    public javax.swing.JButton getBtnAddEmp() {
        return btnAddEmp;
    }

    /**
     * @param btnAddEmp the btnAddEmp to set
     */
    public void setBtnAddEmp(javax.swing.JButton btnAddEmp) {
        this.btnAddEmp = btnAddEmp;
    }

    /**
     * @return the txtIdEmp
     */
    public javax.swing.JTextField getTxtIdEmp() {
        return txtIdEmp;
    }

    /**
     * @param txtIdEmp the txtIdEmp to set
     */
    public void setTxtIdEmp(javax.swing.JTextField txtIdEmp) {
        this.txtIdEmp = txtIdEmp;
    }

    /**
     * @return the txtNameEmp
     */
    public javax.swing.JTextField getTxtNameEmp() {
        return txtNameEmp;
    }

    /**
     * @param txtNameEmp the txtNameEmp to set
     */
    public void setTxtNameEmp(javax.swing.JTextField txtNameEmp) {
        this.txtNameEmp = txtNameEmp;
    }

}
