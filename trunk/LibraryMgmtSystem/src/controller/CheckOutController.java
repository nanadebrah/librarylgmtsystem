/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.BorrowDetail;
import entity.Employee;
import entity.Fee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.AccessBook;
import model.AccessBorrow;
import model.AccessEmp;
import model.AccessFee;
import model.LibUtil;
import view.CheckOutDialog;

/**
 *
 * @author CuongNQ
 */
public class CheckOutController {

    //Defined
    private CheckOutDialog view;
    private DefaultTableModel bookModel;
    private DefaultTableModel empModel;
    private DefaultTableModel outModel;
    private ManageController parent;
    private Vector vt;
    private HashSet set;
    private int empID;
    private Fee fee;
    private float borFee, lateFee;
    private BorrowDetail borDetail;

    public CheckOutController(CheckOutDialog view, DefaultTableModel bookModel,
            DefaultTableModel empModel, DefaultTableModel outModel, ManageController parent) {
        this.view = view;
        this.bookModel = bookModel;
        this.empModel = empModel;
        this.outModel = outModel;
        this.parent = parent;
        initComponent();
    }

    private void initComponent() {

        //Get fee setting
        fee = AccessFee.getInstance().getFee();
        borFee = fee.getBorFee();
        lateFee = fee.getLateFee();
        getView().getLblFee1().setText("$" + Float.toString(borFee) + "/Day | $"
                + Float.toString(lateFee) + "/Late Day");

        //Set default issue day and return day
        getView().getTxtIssueDate().setDate(new java.util.Date());
        getView().getTxtDueDate().setDate(new java.util.Date(
                new java.util.Date().getTime() + 432000000));

        //Create new set
        set = new HashSet();
        //Set selection mode
        getView().getTblBoth().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Add check out model
        getView().getTblCheckOut().setModel(outModel);

        //Add event cancel btn
        getView().getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                borDetail = null;
                parent.removeModel(outModel);
                getView().dispose();
            }
        });

        //Add window event
        getView().addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                borDetail = null;
                parent.removeModel(outModel);
            }
        });

        //Add event search book btn
        getView().getBtnSearchBook().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchBook();
                //Add book model to table
                getView().getTblBoth().setModel(bookModel);
                //Change title
                getView().getScrPanBoth().setBorder(
                        javax.swing.BorderFactory.createTitledBorder("Book Information"));
            }
        });

        //Add event search employee btn
        getView().getBtnSearchEmp().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchEmp();
                //Add employee model to table
                getView().getTblBoth().setModel(empModel);
                //Change title
                getView().getScrPanBoth().setBorder(
                        javax.swing.BorderFactory.createTitledBorder("Employee Information"));
            }
        });

        //Add event check out btn
        getView().getBtnCheckOut().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (!set.isEmpty() && empID > 0) {
                    int sure = JOptionPane.showConfirmDialog(view,
                            "You sure all information is correct!",
                            "Checking-out", JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE);

                    if (sure == JOptionPane.OK_OPTION) {
                        checkOut();
                        getView().dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(view,
                            "All information not correct!", "Checking-out",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //Add event double click to select book
        getView().getTblBoth().addMouseListener(new MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //If double click display edit employee dialog
                if (evt.getClickCount() == 2) {
                    if (getView().getTblBoth().getModel() == bookModel) {
                        selectBook();
                    } else {
                        selectEmployee();
                    }
                }
            }
        });

        //Add event doublie click to deselect book
        getView().getTblCheckOut().addMouseListener(new MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //If double click display edit employee dialog
                if (evt.getClickCount() == 2) {
                    deselectBook();
                }
            }
        });
    }

    private void checkOut() {
        //Add new borrow to databse
        AccessBorrow.getInstance().addBorrow(empID);
        //Add borrow details for earch book
        Iterator it = set.iterator();
        while (it.hasNext()) {
            //Create new borrow detail object
            borDetail = new BorrowDetail();
            borDetail.setBorID(AccessBorrow.getInstance().getNewestBorrowID());
            borDetail.setEmpID(empID);
            borDetail.setCallNumber(it.next().toString());
            borDetail.setIssueDate(getView().getTxtIssueDate().getDate().getTime());
            borDetail.setDueDate(getView().getTxtDueDate().getDate().getTime());
            borDetail.setIssueStatus(0);
            //Add new borrow detail to databse
            AccessBorrow.getInstance().addBorDetail(borDetail);
        }
    }

    /**
     * 
     */
    private void selectEmployee() {
        //Get field employee selected
        String empID = view.getTblBoth().getValueAt(
                view.getTblBoth().getSelectedRow(), 0).toString();
        this.empID = new Integer(empID);
        Employee emp = AccessEmp.getInstance().getEmp(this.empID);
        //Set all information
        getView().getLblID1().setText(new Integer(emp.getEmpID()).toString());
        getView().getLblName1().setText(emp.getName());
        String DOB = new Date(emp.getDOB()).toString();

        getView().getLblDOB1().setText(LibUtil.getInstance().convertDate(DOB));
        if (emp.getGender() == 1) {
            getView().getLblGender1().setText("Male");
        } else {
            getView().getLblGender1().setText("Female");
        }
        getView().getLblAddress1().setText(emp.getAddress());
        getView().getLblPhone1().setText(emp.getPhone());
        getView().getLblDepart1().setText(emp.getDepartment());
        if (emp.getPermission() == 1) {
            getView().getLblPermission1().setText("Librarian");
        } else {
            getView().getLblPermission1().setText("Employee");
        }
    }

    /**
     *
     */
    private void deselectBook() {
        //Get field book selected
        String field = view.getTblCheckOut().getValueAt(
                view.getTblCheckOut().getSelectedRow(), 0).toString();
        outModel.removeRow(view.getTblCheckOut().getSelectedRow());
        set.remove(field);
        view.getTblCheckOut().setFocusable(false);
    }

    /**
     * 
     */
    private void selectBook() {
        vt = new Vector();
        Integer noInLib;
        //Add info book to checkout table
        for (int i = 0; i < 6; i++) {
            //Get field book selected
            String field = view.getTblBoth().getValueAt(
                    view.getTblBoth().getSelectedRow(), i).toString();
            //if it field is no in copy, get it
            if (i == 5) {
                String[] temp = field.split("/");
                noInLib = Integer.parseInt(temp[1]);
                //If of store book
                if (noInLib == 0) {
                    JOptionPane.showMessageDialog(getView(), "Out of stock!",
                            "Warning!", JOptionPane.INFORMATION_MESSAGE);
                    //If out of stock remove it on set
                    set.remove(view.getTblBoth().getValueAt(
                            view.getTblBoth().getSelectedRow(), 0).toString());
                    return;
                }
            } else if (i == 0) {//get callnumber
                //if it have added return
                if (!set.add(field)) {
                    return;
                } else {
                    vt.addElement(field);
                }
            } else {
                vt.addElement(field);
            }
        }
        outModel.addRow(vt);
    }

    /**
     * Seacrch employee by Id or name
     */
    public void searchEmp() {
        parent.removeModel(empModel);
        new Thread(new Runnable() {

            public void run() {
                AccessEmp.getInstance().searchEmp(
                        empModel, view.getTxtIdEmp().getText(),
                        view.getTxtNameEmp().getText());
            }
        }).start();
    }

    /**
     * Method search Book
     */
    private void searchBook() {
        parent.removeModel(bookModel);
        new Thread(new Runnable() {

            public void run() {
                AccessBook.getInstance().searchBook(bookModel,
                        getView().getTxtCallNoBook().getText(),
                        getView().getTxtISBNBook().getText(),
                        getView().getTxtTitlBook().getText(),
                        getView().getTxtAthBook().getText());
            }
        }).start();
    }

    /**
     * @return the view
     */
    public CheckOutDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(CheckOutDialog view) {
        this.view = view;
    }

    /**
     * @return the borDetail
     */
    public BorrowDetail getBorDetail() {
        return borDetail;
    }

    /**
     * @param borDetail the borDetail to set
     */
    public void setBorDetail(BorrowDetail borDetail) {
        this.borDetail = borDetail;
    }
}
