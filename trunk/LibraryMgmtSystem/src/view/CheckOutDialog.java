/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CheckOutDialog.java
 *
 * Created on Jan 5, 2011, 8:33:13 AM
 */

package view;

import javax.swing.ImageIcon;
import model.LibImages;

/**
 *
 * @author CuongNQ
 */
public class CheckOutDialog extends javax.swing.JDialog {

    /** Creates new form CheckOutDialog */
    public CheckOutDialog(java.awt.Frame parent, boolean modal) {
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

        palCheck = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        palBorrowInfo = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        tolbarEmp = new javax.swing.JToolBar();
        btnSearchEmp = new javax.swing.JButton();
        lblIDEmp = new javax.swing.JLabel();
        lblNameEmp = new javax.swing.JLabel();
        txtNameEmp = new javax.swing.JTextField();
        txtIdEmp = new javax.swing.JTextField();
        lblID1 = new javax.swing.JLabel();
        lblDOB = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblDOB1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        lblDepart = new javax.swing.JLabel();
        lblDepart1 = new javax.swing.JLabel();
        lblGender1 = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblPermission1 = new javax.swing.JLabel();
        lblPhone1 = new javax.swing.JLabel();
        lblAddress1 = new javax.swing.JLabel();
        lblPermission = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblPage = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        scrPanBoth = new javax.swing.JScrollPane();
        tblBoth = new javax.swing.JTable();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        btnCheckOut = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblIssueDate = new javax.swing.JLabel();
        lblDueDate = new javax.swing.JLabel();
        lblFee = new javax.swing.JLabel();
        lblFee1 = new javax.swing.JLabel();
        txtIssueDate = new org.jdesktop.swingx.JXDatePicker();
        txtDueDate = new org.jdesktop.swingx.JXDatePicker();
        jPanel8 = new javax.swing.JPanel();
        scrPanCheckOut = new javax.swing.JScrollPane();
        tblCheckOut = new javax.swing.JTable();
        palSearchBook = new javax.swing.JPanel();
        tolbarBook = new javax.swing.JToolBar();
        btnSearchBook = new javax.swing.JButton();
        txtAthBook = new javax.swing.JTextField();
        lblTitlBook = new javax.swing.JLabel();
        lblAthBook = new javax.swing.JLabel();
        txtISBNBook = new javax.swing.JTextField();
        lblCallNo = new javax.swing.JLabel();
        txtCallNoBook = new javax.swing.JTextField();
        lblISBNBook = new javax.swing.JLabel();
        txtTitlBook = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Check-Out Book For Employee");
        setResizable(false);

        jSplitPane1.setDividerLocation(500);
        jSplitPane1.setDividerSize(0);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Employee Search"));

        tolbarEmp.setBorder(null);
        tolbarEmp.setFloatable(false);
        tolbarEmp.setBorderPainted(false);
        tolbarEmp.setOpaque(false);

        btnSearchEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_SEARCH)));
        btnSearchEmp.setMnemonic('s');
        btnSearchEmp.setText("Search");
        btnSearchEmp.setBorderPainted(false);
        btnSearchEmp.setFocusable(false);
        btnSearchEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchEmp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarEmp.add(btnSearchEmp);

        lblIDEmp.setText("Emp ID:");

        lblNameEmp.setText("Emp Name:");

        txtNameEmp.setToolTipText("Employee's Username");

        txtIdEmp.setToolTipText("Employee's ID");

        lblID1.setText("Empty");

        lblDOB.setText("Date of birth:");

        lblName.setText("Name:");

        lblDOB1.setText("Empty");

        lblID.setText("ID:");

        lblName1.setText("Empty");

        lblDepart.setText("Department:");

        lblDepart1.setText("Empty");

        lblGender1.setText("Empty");

        lblAddress.setText("Address:");

        lblGender.setText("Gender:");

        lblPermission1.setText("Empty");

        lblPhone1.setText("Empty");

        lblAddress1.setText("Empty");

        lblPermission.setText("Permission:");

        lblPhone.setText("Phone:");

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(tolbarEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblIDEmp)
                    .add(lblNameEmp))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtNameEmp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .add(txtIdEmp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .add(30, 30, 30))
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblPermission)
                    .add(lblPhone)
                    .add(lblAddress)
                    .add(lblDepart)
                    .add(lblGender)
                    .add(lblDOB)
                    .add(lblName)
                    .add(lblID))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblPermission1)
                    .add(lblPhone1)
                    .add(lblAddress1)
                    .add(lblDepart1)
                    .add(lblGender1)
                    .add(lblDOB1)
                    .add(lblName1)
                    .add(lblID1))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, tolbarEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel9Layout.createSequentialGroup()
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblIDEmp)
                            .add(txtIdEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(2, 2, 2)
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtNameEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblNameEmp))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 32, Short.MAX_VALUE)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblID)
                    .add(lblID1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblName)
                    .add(lblName1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblDOB)
                    .add(lblDOB1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblGender)
                    .add(lblGender1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(lblAddress1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblPhone1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblPermission1))
                    .add(jPanel9Layout.createSequentialGroup()
                        .add(jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblDepart)
                            .add(lblDepart1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblAddress)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblPhone)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblPermission)))
                .add(28, 28, 28))
        );

        org.jdesktop.layout.GroupLayout palBorrowInfoLayout = new org.jdesktop.layout.GroupLayout(palBorrowInfo);
        palBorrowInfo.setLayout(palBorrowInfoLayout);
        palBorrowInfoLayout.setHorizontalGroup(
            palBorrowInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        palBorrowInfoLayout.setVerticalGroup(
            palBorrowInfoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(palBorrowInfo);

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_FIRST)));
        btnFirst.setBorderPainted(false);
        jPanel6.add(btnFirst);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_BACK)));
        btnBack.setBorderPainted(false);
        jPanel6.add(btnBack);

        lblPage.setText("Page 1/1");
        jPanel6.add(lblPage);

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_NEXT)));
        btnNext.setBorderPainted(false);
        jPanel6.add(btnNext);

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_LAST)));
        btnLast.setBorderPainted(false);
        jPanel6.add(btnLast);

        jPanel7.setLayout(new java.awt.BorderLayout());

        tblBoth.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrPanBoth.setViewportView(tblBoth);

        jPanel7.add(scrPanBoth, java.awt.BorderLayout.CENTER);

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 288, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel5);

        jSplitPane2.setDividerLocation(500);
        jSplitPane2.setDividerSize(0);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Check-Out Information"));

        btnCheckOut.setText("Check Out");

        btnCancel.setText("Cancel");

        lblIssueDate.setText("Issue Date:");

        lblDueDate.setText("Due Date:");

        lblFee.setText("Fee:");

        lblFee1.setText("Fee");

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblIssueDate)
                            .add(lblDueDate))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtIssueDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 168, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(txtDueDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(41, 41, 41)
                        .add(btnCheckOut)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(btnCancel))
                    .add(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(lblFee)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblFee1)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblIssueDate)
                    .add(txtIssueDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblDueDate)
                    .add(txtDueDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblFee1)
                    .add(lblFee))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCheckOut)
                    .add(btnCancel)))
        );

        jSplitPane2.setRightComponent(jPanel4);

        scrPanCheckOut.setBorder(javax.swing.BorderFactory.createTitledBorder("Check-Out"));

        tblCheckOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrPanCheckOut.setViewportView(tblCheckOut);

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 498, Short.MAX_VALUE)
            .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(scrPanCheckOut, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 141, Short.MAX_VALUE)
            .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(scrPanCheckOut, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
        );

        jSplitPane2.setLeftComponent(jPanel8);

        org.jdesktop.layout.GroupLayout palCheckLayout = new org.jdesktop.layout.GroupLayout(palCheck);
        palCheck.setLayout(palCheckLayout);
        palCheckLayout.setHorizontalGroup(
            palCheckLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jSplitPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
            .add(jSplitPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
        );
        palCheckLayout.setVerticalGroup(
            palCheckLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palCheckLayout.createSequentialGroup()
                .add(jSplitPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSplitPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        palSearchBook.setBorder(javax.swing.BorderFactory.createTitledBorder("Book Search"));

        tolbarBook.setBorder(null);
        tolbarBook.setFloatable(false);
        tolbarBook.setBorderPainted(false);
        tolbarBook.setOpaque(false);

        btnSearchBook.setIcon(new javax.swing.ImageIcon(getClass().getResource(LibImages.TASKBAR_SEARCH)));
        btnSearchBook.setMnemonic('s');
        btnSearchBook.setText("Search");
        btnSearchBook.setBorderPainted(false);
        btnSearchBook.setFocusable(false);
        btnSearchBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBook.add(btnSearchBook);

        txtAthBook.setToolTipText("search book by author");

        lblTitlBook.setText("Title:");

        lblAthBook.setText("Author:");

        txtISBNBook.setToolTipText("search book by ISBN");

        lblCallNo.setText("CallNo:");

        txtCallNoBook.setToolTipText("search book by order");

        lblISBNBook.setText("ISBN:");

        txtTitlBook.setToolTipText("search book by title");

        org.jdesktop.layout.GroupLayout palSearchBookLayout = new org.jdesktop.layout.GroupLayout(palSearchBook);
        palSearchBook.setLayout(palSearchBookLayout);
        palSearchBookLayout.setHorizontalGroup(
            palSearchBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, palSearchBookLayout.createSequentialGroup()
                .addContainerGap()
                .add(tolbarBook, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palSearchBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblISBNBook)
                    .add(lblCallNo))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palSearchBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(txtISBNBook, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .add(txtCallNoBook, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palSearchBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblTitlBook)
                    .add(lblAthBook))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palSearchBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(txtAthBook, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .add(txtTitlBook, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                .addContainerGap())
        );
        palSearchBookLayout.setVerticalGroup(
            palSearchBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palSearchBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, tolbarBook, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, palSearchBookLayout.createSequentialGroup()
                    .add(palSearchBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(txtTitlBook, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(lblCallNo)
                        .add(lblTitlBook)
                        .add(txtCallNoBook, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(2, 2, 2)
                    .add(palSearchBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(txtAthBook, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(lblISBNBook)
                        .add(lblAthBook)
                        .add(txtISBNBook, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palSearchBook, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(palCheck, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(palSearchBook, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palCheck, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSearchBook;
    private javax.swing.JButton btnSearchEmp;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddress1;
    private javax.swing.JLabel lblAthBook;
    private javax.swing.JLabel lblCallNo;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblDOB1;
    private javax.swing.JLabel lblDepart;
    private javax.swing.JLabel lblDepart1;
    private javax.swing.JLabel lblDueDate;
    private javax.swing.JLabel lblFee;
    private javax.swing.JLabel lblFee1;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGender1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblID1;
    private javax.swing.JLabel lblIDEmp;
    private javax.swing.JLabel lblISBNBook;
    private javax.swing.JLabel lblIssueDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblNameEmp;
    private javax.swing.JLabel lblPage;
    private javax.swing.JLabel lblPermission;
    private javax.swing.JLabel lblPermission1;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhone1;
    private javax.swing.JLabel lblTitlBook;
    private javax.swing.JPanel palBorrowInfo;
    private javax.swing.JPanel palCheck;
    private javax.swing.JPanel palSearchBook;
    private javax.swing.JScrollPane scrPanBoth;
    private javax.swing.JScrollPane scrPanCheckOut;
    private javax.swing.JTable tblBoth;
    private javax.swing.JTable tblCheckOut;
    private javax.swing.JToolBar tolbarBook;
    private javax.swing.JToolBar tolbarEmp;
    private javax.swing.JTextField txtAthBook;
    private javax.swing.JTextField txtCallNoBook;
    private org.jdesktop.swingx.JXDatePicker txtDueDate;
    private javax.swing.JTextField txtISBNBook;
    private javax.swing.JTextField txtIdEmp;
    private org.jdesktop.swingx.JXDatePicker txtIssueDate;
    private javax.swing.JTextField txtNameEmp;
    private javax.swing.JTextField txtTitlBook;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnBack
     */
    public javax.swing.JButton getBtnBack() {
        return btnBack;
    }

    /**
     * @param btnBack the btnBack to set
     */
    public void setBtnBack(javax.swing.JButton btnBack) {
        this.btnBack = btnBack;
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
     * @return the btnCheckOut
     */
    public javax.swing.JButton getBtnCheckOut() {
        return btnCheckOut;
    }

    /**
     * @param btnCheckOut the btnCheckOut to set
     */
    public void setBtnCheckOut(javax.swing.JButton btnCheckOut) {
        this.btnCheckOut = btnCheckOut;
    }

    /**
     * @return the btnFirst
     */
    public javax.swing.JButton getBtnFirst() {
        return btnFirst;
    }

    /**
     * @param btnFirst the btnFirst to set
     */
    public void setBtnFirst(javax.swing.JButton btnFirst) {
        this.btnFirst = btnFirst;
    }

    /**
     * @return the btnLast
     */
    public javax.swing.JButton getBtnLast() {
        return btnLast;
    }

    /**
     * @param btnLast the btnLast to set
     */
    public void setBtnLast(javax.swing.JButton btnLast) {
        this.btnLast = btnLast;
    }

    /**
     * @return the btnNext
     */
    public javax.swing.JButton getBtnNext() {
        return btnNext;
    }

    /**
     * @param btnNext the btnNext to set
     */
    public void setBtnNext(javax.swing.JButton btnNext) {
        this.btnNext = btnNext;
    }

    /**
     * @return the btnSearchBook
     */
    public javax.swing.JButton getBtnSearchBook() {
        return btnSearchBook;
    }

    /**
     * @param btnSearchBook the btnSearchBook to set
     */
    public void setBtnSearchBook(javax.swing.JButton btnSearchBook) {
        this.btnSearchBook = btnSearchBook;
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
     * @return the lblAddress1
     */
    public javax.swing.JLabel getLblAddress1() {
        return lblAddress1;
    }

    /**
     * @param lblAddress1 the lblAddress1 to set
     */
    public void setLblAddress1(javax.swing.JLabel lblAddress1) {
        this.lblAddress1 = lblAddress1;
    }

    /**
     * @return the lblDOB1
     */
    public javax.swing.JLabel getLblDOB1() {
        return lblDOB1;
    }

    /**
     * @param lblDOB1 the lblDOB1 to set
     */
    public void setLblDOB1(javax.swing.JLabel lblDOB1) {
        this.lblDOB1 = lblDOB1;
    }

    /**
     * @return the lblDepart1
     */
    public javax.swing.JLabel getLblDepart1() {
        return lblDepart1;
    }

    /**
     * @param lblDepart1 the lblDepart1 to set
     */
    public void setLblDepart1(javax.swing.JLabel lblDepart1) {
        this.lblDepart1 = lblDepart1;
    }

    /**
     * @return the lblFee1
     */
    public javax.swing.JLabel getLblFee1() {
        return lblFee1;
    }

    /**
     * @param lblFee1 the lblFee1 to set
     */
    public void setLblFee1(javax.swing.JLabel lblFee1) {
        this.lblFee1 = lblFee1;
    }

    /**
     * @return the lblGender1
     */
    public javax.swing.JLabel getLblGender1() {
        return lblGender1;
    }

    /**
     * @param lblGender1 the lblGender1 to set
     */
    public void setLblGender1(javax.swing.JLabel lblGender1) {
        this.lblGender1 = lblGender1;
    }

    /**
     * @return the lblID1
     */
    public javax.swing.JLabel getLblID1() {
        return lblID1;
    }

    /**
     * @param lblID1 the lblID1 to set
     */
    public void setLblID1(javax.swing.JLabel lblID1) {
        this.lblID1 = lblID1;
    }

    /**
     * @return the lblName1
     */
    public javax.swing.JLabel getLblName1() {
        return lblName1;
    }

    /**
     * @param lblName1 the lblName1 to set
     */
    public void setLblName1(javax.swing.JLabel lblName1) {
        this.lblName1 = lblName1;
    }

    /**
     * @return the lblPage
     */
    public javax.swing.JLabel getLblPage() {
        return lblPage;
    }

    /**
     * @param lblPage the lblPage to set
     */
    public void setLblPage(javax.swing.JLabel lblPage) {
        this.lblPage = lblPage;
    }

    /**
     * @return the lblPermission1
     */
    public javax.swing.JLabel getLblPermission1() {
        return lblPermission1;
    }

    /**
     * @param lblPermission1 the lblPermission1 to set
     */
    public void setLblPermission1(javax.swing.JLabel lblPermission1) {
        this.lblPermission1 = lblPermission1;
    }

    /**
     * @return the lblPhone1
     */
    public javax.swing.JLabel getLblPhone1() {
        return lblPhone1;
    }

    /**
     * @param lblPhone1 the lblPhone1 to set
     */
    public void setLblPhone1(javax.swing.JLabel lblPhone1) {
        this.lblPhone1 = lblPhone1;
    }

    /**
     * @return the tblBoth
     */
    public javax.swing.JTable getTblBoth() {
        return tblBoth;
    }

    /**
     * @param tblBoth the tblBoth to set
     */
    public void setTblBoth(javax.swing.JTable tblBoth) {
        this.tblBoth = tblBoth;
    }

    /**
     * @return the tblCheckOut
     */
    public javax.swing.JTable getTblCheckOut() {
        return tblCheckOut;
    }

    /**
     * @param tblCheckOut the tblCheckOut to set
     */
    public void setTblCheckOut(javax.swing.JTable tblCheckOut) {
        this.tblCheckOut = tblCheckOut;
    }

    /**
     * @return the txtAthBook
     */
    public javax.swing.JTextField getTxtAthBook() {
        return txtAthBook;
    }

    /**
     * @param txtAthBook the txtAthBook to set
     */
    public void setTxtAthBook(javax.swing.JTextField txtAthBook) {
        this.txtAthBook = txtAthBook;
    }

    /**
     * @return the txtCallNoBook
     */
    public javax.swing.JTextField getTxtCallNoBook() {
        return txtCallNoBook;
    }

    /**
     * @param txtCallNoBook the txtCallNoBook to set
     */
    public void setTxtCallNoBook(javax.swing.JTextField txtCallNoBook) {
        this.txtCallNoBook = txtCallNoBook;
    }

    /**
     * @return the txtDueDate
     */
    public org.jdesktop.swingx.JXDatePicker getTxtDueDate() {
        return txtDueDate;
    }

    /**
     * @param txtDueDate the txtDueDate to set
     */
    public void setTxtDueDate(org.jdesktop.swingx.JXDatePicker txtDueDate) {
        this.txtDueDate = txtDueDate;
    }

    /**
     * @return the txtISBNBook
     */
    public javax.swing.JTextField getTxtISBNBook() {
        return txtISBNBook;
    }

    /**
     * @param txtISBNBook the txtISBNBook to set
     */
    public void setTxtISBNBook(javax.swing.JTextField txtISBNBook) {
        this.txtISBNBook = txtISBNBook;
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
     * @return the txtIssueDate
     */
    public org.jdesktop.swingx.JXDatePicker getTxtIssueDate() {
        return txtIssueDate;
    }

    /**
     * @param txtIssueDate the txtIssueDate to set
     */
    public void setTxtIssueDate(org.jdesktop.swingx.JXDatePicker txtIssueDate) {
        this.txtIssueDate = txtIssueDate;
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

    /**
     * @return the txtTitlBook
     */
    public javax.swing.JTextField getTxtTitlBook() {
        return txtTitlBook;
    }

    /**
     * @param txtTitlBook the txtTitlBook to set
     */
    public void setTxtTitlBook(javax.swing.JTextField txtTitlBook) {
        this.txtTitlBook = txtTitlBook;
    }

    /**
     * @return the scrPanBoth
     */
    public javax.swing.JScrollPane getScrPanBoth() {
        return scrPanBoth;
    }

    /**
     * @param scrPanBoth the scrPanBoth to set
     */
    public void setScrPanBoth(javax.swing.JScrollPane scrPanBoth) {
        this.scrPanBoth = scrPanBoth;
    }
}
