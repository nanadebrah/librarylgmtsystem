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
import model.LibUtil;
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
    private DefaultTableModel bothModel;
    private DefaultTableModel outModel;
    private DefaultTableModel inModel;
    private DefaultTableModel searchModel;
    private int page;
    private Integer totalRow;

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

        //Set default page
        page = 1;
        totalRow = 1;
        //Create book model
        searchModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        //Create book model
        bothModel = new DefaultTableModel() {

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
        searchModel.addColumn("Book ID");
        searchModel.addColumn("Call Number");
        searchModel.addColumn("Title");
        searchModel.addColumn("Auth");
        searchModel.addColumn("Publisher");
        searchModel.addColumn("Due Date");

        //Set int model
        inModel.addColumn("Borrow ID");
        inModel.addColumn("Book ID");
        inModel.addColumn("Call Number");
        inModel.addColumn("Title");
        inModel.addColumn("Day Borrow/Fee");
        inModel.addColumn("Day Late/Fine");
        inModel.addColumn("Total Fee");

        //Set bor model
        borModel.addColumn("Borrow ID");
        borModel.addColumn("Employee ID");
        borModel.addColumn("Book ID");
        borModel.addColumn("Employee Name");
        borModel.addColumn("Call Number");
        borModel.addColumn("Title");
        borModel.addColumn("Issue Date");
        borModel.addColumn("Due Date");
        borModel.addColumn("Issue Status");
        borModel.addColumn("Return Date");
        borModel.addColumn("Total Fee");

        //Set out model
        outModel.addColumn("Book ID");
        outModel.addColumn("Call Number");
        outModel.addColumn("ISBN");
        outModel.addColumn("Title");
        outModel.addColumn("Author");
        outModel.addColumn("Publisher");

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
                page = 1;
                searchBorrow();
            }
        });

        //Add event view btn
        view.getBtnViewBor().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                viewBorrowInfo();
            }
        });

        view.getBtnDelBor().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                deleteBorrow();
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

        //Add event navigation btn
        view.getBtnNext().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (page == LibUtil.getInstance().getPage(totalRow)
                        || LibUtil.getInstance().getPage(totalRow) == 0) {
                    return;
                } else {
                    page++;
                    searchBorrow();
                }
            }
        });
        view.getBtnBack().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (page != 1 && LibUtil.getInstance().getPage(totalRow) != 0) {
                    page--;
                }
                searchBorrow();
            }
        });
        view.getBtnFirst().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                page = 1;
                searchBorrow();
            }
        });
        view.getBtnLast().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                page = LibUtil.getInstance().getPage(totalRow);
                searchBorrow();
            }
        });
    }

    /**
     * 
     */
    private void deleteBorrow() {
        parent.doBlur();
        int sure = JOptionPane.showConfirmDialog(parent.getView(),
                "You sure want delete this borrow!",
                "Delete borrow", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (sure == JOptionPane.OK_OPTION) {
            //Get borID and bookID selected
            String borID = view.getTblBor().getValueAt(
                    view.getTblBor().getSelectedRow(), 0).toString();
            String bookID = view.getTblBor().getValueAt(
                    view.getTblBor().getSelectedRow(), 2).toString();
            if (!AccessBorrow.getInstance().deleteBorrow(Integer.parseInt(borID),
                    Integer.parseInt(bookID))) {
                JOptionPane.showMessageDialog(parent.getView(), "Delete failed!\n"
                        + "May be this borrow isn't checked-in.", "Error!",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parent.getView(),
                        "Delete successful!", "Successful!",
                        JOptionPane.INFORMATION_MESSAGE);
                borModel.removeRow(view.getTblBor().getSelectedRow());
            }
        }
        parent.doBlur();
    }

    /**
     *
     */
    private void viewBorrowInfo() {
        parent.doBlur();
        //Get field borID selected
        int borID = Integer.parseInt(view.getTblBor().getValueAt(
                view.getTblBor().getSelectedRow(), 0).toString());
        //Get field empID selected
        int empID = Integer.parseInt(view.getTblBor().getValueAt(
                view.getTblBor().getSelectedRow(), 1).toString());
        //Get field bookID selected
        String bookID = view.getTblBor().getValueAt(
                view.getTblBor().getSelectedRow(), 2).toString();
        viewControl = new ViewBorrowController(new ViewBorrowDialog(
                parent.getView(), true), borID, empID, Integer.parseInt(bookID));
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
                bothModel, outModel, parent);
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
        totalRow = AccessBorrow.getInstance().searchBor(borModel,
                view.getTxtEmpID().getText(),
                view.getTxtCallNoBor().getText(), (page - 1));
        view.getTxtPage().setText("Page " + page + "/"
                + LibUtil.getInstance().getPage(totalRow));
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
