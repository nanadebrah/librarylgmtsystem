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
import java.util.TreeMap;
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
    private TreeMap map;
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
        view.getLblFee1().setText("$" + Float.toString(borFee) + "/Day | $"
                + Float.toString(lateFee) + "/Late Day");

        //Set default issue date and due date
        view.getTxtIssueDate().setDate(new java.util.Date());
        view.getTxtDueDate().setDate(new java.util.Date(
                new java.util.Date().getTime() + 432000000));

        //Create new map
        map=new TreeMap();
        //Create new set
        set = new HashSet();
        //Set selection mode;
        view.getTblBoth().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Add check out model
        view.getTblCheckOut().setModel(outModel);

        //Add event cancel btn
        view.getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                borDetail = null;
                parent.removeModel(outModel);
                view.dispose();
            }
        });

        //Add window event
        view.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                borDetail = null;
                parent.removeModel(outModel);
            }
        });

        //Add event search book btn
        view.getBtnSearchBook().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchBook();
                //Add book model to table
                view.getTblBoth().setModel(bookModel);
                //Change title
                view.getScrPanBoth().setBorder(
                        javax.swing.BorderFactory.createTitledBorder("Book Information"));
            }
        });

        //Add event search employee btn
        view.getBtnSearchEmp().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchEmp();
                //Add employee model to table
                view.getTblBoth().setModel(empModel);
                //Change title
                view.getScrPanBoth().setBorder(
                        javax.swing.BorderFactory.createTitledBorder("Employee Information"));
            }
        });

        //Add event check out btn
        view.getBtnCheckOut().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (!set.isEmpty() && empID > 0) {
                    int sure = JOptionPane.showConfirmDialog(view,
                            "You sure all information is correct!",
                            "Checking-out", JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE);

                    if (sure == JOptionPane.OK_OPTION) {
                        checkOut();
                        parent.removeModel(outModel);
                        view.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(view,
                            "All information not correct!", "Check-out",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        //Add event double click to select book
        view.getTblBoth().addMouseListener(new MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //If double click display edit employee dialog
                if (evt.getClickCount() == 2) {
                    if (view.getTblBoth().getModel() == bookModel) {
                        selectBook();
                    } else {
                        selectEmployee();
                    }
                }
            }
        });

        //Add event doublie click to deselect book
        view.getTblCheckOut().addMouseListener(new MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //If double click display edit employee dialog
                if (evt.getClickCount() == 2) {
                    deselectBook();
                }
            }
        });
    }

    /**
     * 
     */
    private void checkOut() {
        //Add borrow details for earch book
        java.util.Iterator it = set.iterator();
        while (it.hasNext()) {
            borDetail=new BorrowDetail();
            borDetail.setCallNumber(it.next().toString());
            borDetail.setIssueDate(view.getTxtIssueDate().getDate().getTime());
            borDetail.setDueDate(view.getTxtDueDate().getDate().getTime());
            map.put(borDetail.getCallNumber(), borDetail);
        }
        AccessBorrow.getInstance().checkOut(empID, map);
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
        view.getLblID1().setText(new Integer(emp.getEmpID()).toString());
        view.getLblName1().setText(emp.getName());
        String DOB = new Date(emp.getDOB()).toString();

        view.getLblDOB1().setText(LibUtil.getInstance().convertDate(DOB));
        if (emp.getGender() == 1) {
            view.getLblGender1().setText("Male");
        } else {
            view.getLblGender1().setText("Female");
        }
        view.getLblAddress1().setText(emp.getAddress());
        view.getLblPhone1().setText(emp.getPhone());
        view.getLblDepart1().setText(emp.getDepartment());
        if (emp.getPermission() == 1) {
            view.getLblPermission1().setText("Librarian");
        } else {
            view.getLblPermission1().setText("Employee");
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
                    JOptionPane.showMessageDialog(view, "Out of stock!",
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
                        view.getTxtCallNoBook().getText(),
                        view.getTxtISBNBook().getText(),
                        view.getTxtTitlBook().getText(),
                        view.getTxtAthBook().getText());
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
