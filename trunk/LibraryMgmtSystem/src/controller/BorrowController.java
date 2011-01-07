/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.AccessBorrow;
import model.AccessFee;
import view.CheckInDialog;
import view.CheckOutDialog;
import view.FeeRateDialog;
import view.PalBorrow;
import view.ViewBorrowDialog;

/**
 *
 * @author CuongNQ
 */
public class BorrowController {

    //Defined
    private PalBorrow view;
    private DefaultTableModel borModel;
    private ManageController parent;
    private CheckOutController checkOut;
    private CheckInController checkIn;
    private FeeRateController feeControl;
    private ViewBorrowController viewControl;
    private DefaultTableModel bookModel;
    private DefaultTableModel empModel;
    private DefaultTableModel outModel;
    private DefaultTableModel inModel;
    private DefaultTableModel searchModel;

    /**
     * 
     * @param view
     * @param borModel
     * @param parent
     */
    public BorrowController(PalBorrow view,
            DefaultTableModel borModel, ManageController parent) {
        this.view = view;
        this.borModel = borModel;
        this.parent = parent;
        initComponent();
    }

    /**
     *  initialize the controller.
     */
    private void initComponent() {

        //Create book model
        searchModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        //Create book model
        bookModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        //Create employee model
        empModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        //Create check-out model
        outModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        //Create check-in model
        inModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };

        //Set selection mode
        view.getTblBor().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Add model to table
        view.getTblBor().setModel(borModel);

        //Set searchModel
        searchModel.addColumn("Borrow ID");
        searchModel.addColumn("Employee ID");
        searchModel.addColumn("Call Number");
        searchModel.addColumn("Title");
        searchModel.addColumn("Auth");
        searchModel.addColumn("Publisher");
        searchModel.addColumn("Due Date");
        //Set int model
        inModel.addColumn("Borrow ID");
        inModel.addColumn("Call Number");
        inModel.addColumn("ISBN");
        inModel.addColumn("Day Borrow/Fee");
        inModel.addColumn("Day Late/Fine");
        inModel.addColumn("Total Fee");
        //Set bor model
        borModel.addColumn("Borrow ID");
        borModel.addColumn("Employee ID");
        borModel.addColumn("Employee Name");
        borModel.addColumn("Call Number");
        borModel.addColumn("Title");
        borModel.addColumn("Issue Date");
        borModel.addColumn("Due Date");
        borModel.addColumn("Issue Status");
        borModel.addColumn("Return Date");
        borModel.addColumn("Total Fee");
        //Set book model
        bookModel.addColumn("Call Number");
        bookModel.addColumn("ISBN");
        bookModel.addColumn("Title");
        bookModel.addColumn("Author");
        bookModel.addColumn("Publisher");
        bookModel.addColumn("Copies/Store");
        //Set out model
        outModel.addColumn("Call Number");
        outModel.addColumn("ISBN");
        outModel.addColumn("Title");
        outModel.addColumn("Author");
        outModel.addColumn("Publisher");
        //Set employee model
        empModel.addColumn("ID");
        empModel.addColumn("Name");
        empModel.addColumn("Gender");
        empModel.addColumn("Email");
        empModel.addColumn("Department");
        empModel.addColumn("Permission");

        //Add event fee rate btn
        view.getBtnFee().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tableFocus();
                editFee();
            }
        });

        //Add event check out btn
        view.getBtnChkOut().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tableFocus();
                checkOut();
            }
        });

        //Add event check in btn
        view.getBtnChkIn().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tableFocus();
                checkIn();
            }
        });

        //Add event search btn
        view.getBtnSearchBor().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tableFocus();
                searchBorrow();
            }
        });

        //Add event view btn
        view.getBtnViewBor().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                viewBorrowInfo();
            }
        });

        //Add event to borrow table
        view.getTblBor().addFocusListener(new FocusAdapter() {

            public void focusLost(java.awt.event.FocusEvent evt) {
                tableFocus();
            }
        });

        view.getTblBor().addMouseListener(new MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //Set enable acction button
                view.getBtnViewBor().setEnabled(true);
                view.getBtnDelBor().setEnabled(true);
                //If double click display edit employee dialog
                if (evt.getClickCount() == 2) {
                    viewBorrowInfo();
                }
            }
        });
    }

    private void viewBorrowInfo() {
        parent.doBlur();
        //Get field borID selected
        int borID = Integer.parseInt(view.getTblBor().getValueAt(
                view.getTblBor().getSelectedRow(), 0).toString());
        //Get field empID selected
        int empID = Integer.parseInt(view.getTblBor().getValueAt(
                view.getTblBor().getSelectedRow(), 1).toString());
        //Get field CallNo selected
        String callNo = view.getTblBor().getValueAt(
                view.getTblBor().getSelectedRow(), 3).toString();
        viewControl = new ViewBorrowController(new ViewBorrowDialog(
                parent.getView(), true), borID, empID, callNo);
        viewControl.getView().setVisible(true);
        parent.doBlur();
    }

    /**
     * Do lost focus table
     */
    private void tableFocus() {
        //Set disable acction button
        view.getBtnViewBor().setEnabled(false);
        view.getBtnDelBor().setEnabled(false);
        view.getTblBor().setFocusable(false);
    }

    /**
     *
     */
    private void checkIn() {
        parent.doBlur();
        checkIn = new CheckInController(
                new CheckInDialog(parent.getView(), true),
                searchModel, inModel, parent);
        checkIn.getView().setVisible(true);
        if (checkIn.getCheckin() != null) {
            JOptionPane.showMessageDialog(view,
                    "Check-in successful!", "Check-in",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        parent.doBlur();
    }

    /**
     *
     */
    private void checkOut() {
        parent.doBlur();
        checkOut = new CheckOutController(
                new CheckOutDialog(parent.getView(), true),
                bookModel, empModel, outModel, parent);
        checkOut.getView().setVisible(true);

        if (checkOut.getBorDetail() != null) {
            JOptionPane.showMessageDialog(view,
                    "Check-out successful!", "Check-out",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        parent.doBlur();
    }

    /**
     *
     */
    private void editFee() {
        parent.doBlur();
        feeControl = new FeeRateController(
                new FeeRateDialog(parent.getView(), true));
        feeControl.getView().setVisible(true);
        if (feeControl.getFee() != null) {
            AccessFee.getInstance().editFee(feeControl.getFee());
            JOptionPane.showMessageDialog(view, "Update successful",
                    "Successful!", JOptionPane.INFORMATION_MESSAGE);
        }
        parent.doBlur();
    }

    /**
     * 
     */
    public void searchBorrow() {
        parent.removeModel(borModel);
        AccessBorrow.getInstance().searchBor(borModel,
                view.getTxtEmpID().getText(),
                view.getTxtCallNoBor().getText());
    }

    /**
     * @return the view
     */
    public PalBorrow getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(PalBorrow view) {
        this.view = view;
    }
}
