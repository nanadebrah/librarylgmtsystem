/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Employee;
import entity.Fee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.HashSet;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.AccessBook;
import model.AccessEmp;
import model.AccessFee;
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
    private int borrowerID;
    private Fee fee;
    private float borFee, lateFee;

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

        getView().getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                getView().dispose();
                parent.removeModel(outModel);
            }
        });

        //Add window event
        getView().addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                parent.removeModel(outModel);
            }
        });

        //Add event search book btn
        getView().getBtnSearchBook().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchBook();
                //Add book model to table
                getView().getTblBoth().setModel(bookModel);
            }
        });

        //Add event search employee btn
        getView().getBtnSearchEmp().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchEmp();
                //Add employee model to table
                getView().getTblBoth().setModel(empModel);
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

    /**
     * 
     */
    private void selectEmployee() {
        //Get field employee selected
        String empID = view.getTblBoth().getValueAt(
                view.getTblBoth().getSelectedRow(), 0).toString();
        borrowerID = new Integer(empID);
        Employee emp = AccessEmp.getInstance().getEmp(borrowerID);
        //Set all information
        getView().getLblID1().setText(new Integer(emp.getEmpID()).toString());
        getView().getLblName1().setText(emp.getName());
        String DOB = new Date(emp.getDOB()).toString();
        Pattern pt;
        Matcher ma;
        //Get year
        pt = Pattern.compile("^\\d{4}");
        ma = pt.matcher(DOB);
        ma.find();
        String y = ma.group();
        //Get day
        pt = Pattern.compile("\\d{2}$");
        ma = pt.matcher(DOB);
        ma.find();
        String d = ma.group();
        //get moth
        pt = Pattern.compile("-\\d{2}-");
        ma = pt.matcher(DOB);
        ma.find();
        String m = ma.group().substring(1).substring(0, 2);

        getView().getLblDOB1().setText(m + "/" + d + "/" + y);
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
                    JOptionPane.showMessageDialog(getView(), "Out stock!",
                            "Warning!", JOptionPane.INFORMATION_MESSAGE);
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
}
