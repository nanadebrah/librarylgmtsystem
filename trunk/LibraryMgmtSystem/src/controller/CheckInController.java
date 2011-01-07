/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Book;
import entity.CheckIn;
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
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.AccessEmp;
import model.AccessFee;
import model.AccessMutil;
import model.LibUtil;
import view.CheckInDialog;

/**
 *
 * @author CuongNQ
 */
public class CheckInController {

    //Defined
    private CheckInDialog view;
    private DefaultTableModel searchModel;
    private DefaultTableModel inModel;
    private ManageController parent;
    private Book book;
    private CheckIn checkin;
    private Vector vt;
    private Set keyset;
    private Iterator it;
    private HashSet set;
    private TreeMap map;
    private float borFee, lateFee;

    public CheckInController(CheckInDialog view, DefaultTableModel searchModel,
            DefaultTableModel inModel, ManageController parent) {
        this.view = view;
        this.searchModel = searchModel;
        this.inModel = inModel;
        this.parent = parent;
        initComponent();
    }

    /**
     *
     */
    private void initComponent() {

        //Get fee setting
        Fee fee = AccessFee.getInstance().getFee();
        borFee = fee.getBorFee();
        lateFee = fee.getLateFee();
        getView().getLblFee1().setText("$" + Float.toString(borFee) + "/Day | $"
                + Float.toString(lateFee) + "/Late Day");

        //Create new map
        map = new TreeMap();
        //Create new set
        set = new HashSet();

        //Set default issue day and return day
        getView().getTxtReDate().setDate(new java.util.Date());
        //Set selection mode
        getView().getTblBoth().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Add search model
        getView().getTblBoth().setModel(searchModel);

        //Add check in model
        getView().getTblCheckIn().setModel(inModel);

        //Add event cancel btn
        getView().getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                removeModel();
                getView().dispose();
            }
        });

        //Add event search borID btn
        getView().getBtnSearchBor().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                parent.removeModel(searchModel);
                map.clear();
                if (getView().getTxtBorID().getText().length() > 0) {
                    AccessMutil.getInstance().searchCheckOutByBorID(map,
                            Integer.parseInt(getView().getTxtBorID().getText()));
                    getBorrow();
                }
            }
        });

        //Add event sarch book info btn
        getView().getBtnSearchBook().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                parent.removeModel(searchModel);
                map.clear();
                AccessMutil.getInstance().searchCheckOutByBookInfo(map,
                        getView().getTxtCallNoBook().getText(),
                        getView().getTxtISBNBook().getText(),
                        getView().getTxtTitlBook().getText(),
                        getView().getTxtAthBook().getText());
                getBorrow();
            }
        });

        //Add event search emp info btn
        getView().getBtnSearchEmp().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                parent.removeModel(searchModel);
                map.clear();
                AccessMutil.getInstance().searchCheckOutByEmpInfo(map,
                        getView().getTxtIdEmp().getText(),
                        getView().getTxtNameEmp().getText());
                getBorrow();
            }
        });

        //Add event double click to select borrow detail
        getView().getTblBoth().addMouseListener(new MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getInfoSelected();
                //If double click display edit employee dialog
                if (evt.getClickCount() == 2) {
                    selectBook();
                }
            }
        });

        //Add event double click to deselect borrow detail
        getView().getTblCheckIn().addMouseListener(new MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //If double click display edit employee dialog
                if (evt.getClickCount() == 2) {
                    deselectBook();
                }
            }
        });

        //Add window event
        getView().addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                removeModel();
            }
        });

        //Add event check in btn
        getView().getBtnCheckIn().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (inModel.getRowCount() > 0) {
                    int sure = JOptionPane.showConfirmDialog(view,
                            "You sure all information is correct!",
                            "Checking-out", JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE);

                    if (sure == JOptionPane.OK_OPTION) {
                        checkIn();
                        removeModel();
                        getView().dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(view,
                            "All information not correct!", "Checking-out",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void removeModel() {
        parent.removeModel(searchModel);
        parent.removeModel(inModel);
    }

    private void checkIn() {
    }

    /**
     * Get borrow from map to search table
     */
    private void getBorrow() {
        keyset = map.keySet();
        it = keyset.iterator();
        while (it.hasNext()) {
            checkin = (CheckIn) map.get(it.next());
            vt = new Vector();
            vt.add(checkin.getBorID());
            vt.add(checkin.getEmpID());
            vt.add(checkin.getCallNumber());
            vt.add(checkin.getTitle());
            vt.add(checkin.getAuth());
            vt.add(checkin.getPublisher());
            vt.add(LibUtil.getInstance().convertDate(
                    new Date(checkin.getDueDate()).toString()));
            searchModel.addRow(vt);
        }
    }

    /**
     * Remove book for check in
     */
    private void deselectBook() {
        String callNo = view.getTblCheckIn().getValueAt(
                view.getTblCheckIn().getSelectedRow(), 1).toString();
        String borId = view.getTblCheckIn().getValueAt(
                view.getTblCheckIn().getSelectedRow(), 0).toString();
        inModel.removeRow(view.getTblCheckIn().getSelectedRow());
        set.remove(borId + "," + callNo);
    }

    /**
     * Calculate borrow info and select book prepare to check in
     */
    private void selectBook() {
        //Get field borID selected
        String borID = view.getTblBoth().getValueAt(
                view.getTblBoth().getSelectedRow(), 0).toString();
        //Get field CallNo selected
        String callNo = view.getTblBoth().getValueAt(
                view.getTblBoth().getSelectedRow(), 2).toString();
        if (set.add(borID + "," + callNo)) {
            //Set all check-in information
            checkin = (CheckIn) map.get(borID + "," + callNo);
            getView().getTxtIssueDate().setDate(
                    new java.util.Date(checkin.getIssueDate()));
            vt = new Vector();
            vt.add(checkin.getBorID());
            vt.add(checkin.getCallNumber());
            vt.add(checkin.getISBN());
            //Calculate Borrow infomation
            int DayBor = (int) (checkin.getDueDate() - checkin.getIssueDate())
                    / (24 * 60 * 60 * 1000);
            int DayLate = (int) (getView().getTxtReDate().getDate().getTime()
                    - checkin.getDueDate()) / (24 * 60 * 60 * 1000);
            float BorrowFee = DayBor * borFee;
            float Fine = 0;
            vt.add(DayBor + "/" + BorrowFee);
            if (DayLate > 0) {
                Fine = DayLate * lateFee;
                vt.add(DayLate + "/" + Fine);
            } else {
                vt.add(0 + "/" + 0);
            }
            vt.add(BorrowFee + Fine);
            inModel.addRow(vt);
        }

    }

    /**
     * Get employee infomation & issue date
     */
    private void getInfoSelected() {
        //Get field employee selected
        String empID = view.getTblBoth().getValueAt(
                view.getTblBoth().getSelectedRow(), 1).toString();
        Employee emp = AccessEmp.getInstance().getEmp(Integer.parseInt(empID));
        //Set all employee information
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
        //Get field borID selected
        String borID = view.getTblBoth().getValueAt(
                view.getTblBoth().getSelectedRow(), 0).toString();
        //Get field CallNo selected
        String callNo = view.getTblBoth().getValueAt(
                view.getTblBoth().getSelectedRow(), 2).toString();
        //Set all check-in information
        checkin = (CheckIn) map.get(borID + "," + callNo);
        getView().getTxtIssueDate().setDate(
                new java.util.Date(checkin.getIssueDate()));
    }

    /**
     * @return the view
     */
    public CheckInDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(CheckInDialog view) {
        this.view = view;
    }
}
