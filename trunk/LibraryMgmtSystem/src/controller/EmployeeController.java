/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.AccessEmp;
import entity.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import view.AddEmpDialog;
import view.EditEmpDialog;
import view.ManageFrm;
import view.PalEmployee;
import view.ViewEmpDialog;

/**
 *
 * @author CuongNQ
 */
public class EmployeeController {

    //Defined
    private PalEmployee view;
    private DefaultTableModel empModel;
    private AddEmployeeController addEmp;
    private EditEmployeeController editEmp;
    private ViewEmployeeController viewEmp;
    private ManageController parent;

    public EmployeeController(PalEmployee view, DefaultTableModel empModel,
            ManageController manage) {
        this.view = view;
        this.empModel = empModel;
        this.parent = manage;
        initComponent();
    }

    /*
     *  initialize the controller.
     */
    private void initComponent() {
        //Set selection mode
        view.getTblEmp().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Add model to table
        view.getTblEmp().setModel(empModel);
        //Set model
        empModel.addColumn("ID");
        empModel.addColumn("Name");
        empModel.addColumn("Gender");
        empModel.addColumn("Email");
        empModel.addColumn("Department");
        empModel.addColumn("Permission");
        //Add event to employee table        
        view.getTblEmp().addFocusListener(new FocusAdapter() {

            public void focusLost(java.awt.event.FocusEvent evt) {
                tableFocus();
            }
        });

        view.getTblEmp().addMouseListener(new MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //Set enable acction button
                view.getBtnEditEmp().setEnabled(true);
                view.getBtnViewEmp().setEnabled(true);
                view.getBtnDelEmp().setEnabled(true);
                //If double click display edit employee dialog
                if (evt.getClickCount() == 2) {
                    viewEmp();
                }
            }
        });
        //Add event to add employee btn
        view.getBtnAddEmp().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tableFocus();
                addEmp();
            }
        });
        //Add event click search employee
        view.getBtnSearchEmp().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tableFocus();
                searchEmp();
            }
        });
        //Add event view button
        view.getBtnViewEmp().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                viewEmp();
            }
        });
        //Add event edit btn
        view.getBtnEditEmp().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tableFocus();
                editEmp();
            }
        });
    }

    /*
     * Do lost focus table
     */
    private void tableFocus() {
        //Set disable acction button
        view.getBtnEditEmp().setEnabled(false);
        view.getBtnViewEmp().setEnabled(false);
        view.getBtnDelEmp().setEnabled(false);
        view.getTblEmp().setFocusable(false);
    }

    /*
     *Method edit employee on databse and edit on employee table
     */
    private void editEmp() {
        parent.doBlur();
        //Get Id employee selected
        String empID = view.getTblEmp().getValueAt(
                view.getTblEmp().getSelectedRow(), 0).toString();
        //Get employee from database
        Employee emp = AccessEmp.getInstance().getAEmp(new Integer(empID));
        //Create instance of Employee edit dialog and display it
        editEmp = new EditEmployeeController(
                new EditEmpDialog(parent.getView(), true), emp);
        editEmp.getView().setVisible(true);
        //Update data on database
        if (editEmp.getEmp() != null) {
            if (AccessEmp.getInstance().editEmp(editEmp.getEmp())) {
                JOptionPane.showMessageDialog(getView(), "Update successful",
                        "Successful!", JOptionPane.INFORMATION_MESSAGE);
                //Remove old data on table model
                empModel.removeRow(view.getTblEmp().getSelectedRow());
                //Add new row
                empModel.addRow(emp.toVector());
            }
        }
        view.getTblEmp().clearSelection();
        parent.doBlur();
    }

    /*
     *Method add employee on databse
     */
    private void addEmp() {
        parent.doBlur();
        //Display Add employee dialog
        addEmp = new AddEmployeeController(new AddEmpDialog(parent.getView(), true));
        addEmp.getView().setVisible(true);
        //invoked method add employee
        if (addEmp.getEmp() != null) {
            if (AccessEmp.getInstance().addEmp(addEmp.getEmp())) {
                JOptionPane.showMessageDialog(getView(), "Add successful",
                        "Successful!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        view.getTblEmp().clearSelection();
        parent.doBlur();
    }

    /*
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

    /*
     * Method view full information employee
     */
    private void viewEmp() {
        //Get Id employee selected
        String empID = view.getTblEmp().getValueAt(
                view.getTblEmp().getSelectedRow(), 0).toString();
        //Get employee from database
        Employee emp = AccessEmp.getInstance().getAEmp(new Integer(empID));
        parent.doBlur();
        //Create instance of Employee edit dialog and display it
        viewEmp = new ViewEmployeeController(new ViewEmpDialog(parent.getView(), true), emp);
        viewEmp.getView().setVisible(true);
        tableFocus();
        parent.doBlur();
    }

    /**
     * @return the view
     */
    public PalEmployee getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(PalEmployee view) {
        this.view = view;
    }
}
