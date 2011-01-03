/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.connection.AccessEmp;
import entity.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
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

    //Defined Employee Panel
    private PalEmployee view;
    private ManageFrm manView;
    private DefaultTableModel empModel;
    private AddEmployeeController addemp;
    private EditEmployeeController editemp;

    public EmployeeController(PalEmployee view,
            DefaultTableModel empModel, ManageFrm manView) {
        this.view = view;
        this.manView = manView;
        this.empModel = empModel;
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
        //Get Id employee selected
        String empID = view.getTblEmp().getValueAt(
                view.getTblEmp().getSelectedRow(), 0).toString();
        //Get employee from database
        Employee emp = AccessEmp.getInstance().getAEmp(new Integer(empID));
        //doBlur();
        //Create instance of Employee edit dialog and display it
        editemp = new EditEmployeeController(
                new EditEmpDialog(manView, true), emp);
        editemp.getView().setVisible(true);
        //Update data on database
        if (editemp.getEmp() != null) {
            AccessEmp.getInstance().editEmp(editemp.getEmp());
            //Remove old data on table model
            empModel.removeRow(view.getTblEmp().getSelectedRow());
            //Add new row
            empModel.addRow(emp.toVector());
        }
        view.getTblEmp().clearSelection();
        //doBlur();
    }

    /*
     *Method add employee on databse
     */
    private void addEmp() {
        //doBlur();
        //Display Add employee dialog
        addemp = new AddEmployeeController(new AddEmpDialog(manView, true));
        addemp.getView().setVisible(true);
        //invoked method add employee
        if (addemp.getEmp() != null) {
            AccessEmp.getInstance().addEmp(addemp.getEmp());
        }
        view.getTblEmp().clearSelection();
        //doBlur();
    }

    /*
     * Remove all field on model
     */
    private void removeModel(DefaultTableModel model) {
        int row = model.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }
    }

    /*
     * Seacrch employee by Id or name
     */
    public void searchEmp() {
        removeModel(empModel);
        AccessEmp.getInstance().searchEmp(
                empModel, view.getTxtIdEmp().getText(),
                view.getTxtNameEmp().getText());
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
        //doBlur();
        //Create instance of Employee edit dialog and display it
        ViewEmpDialog empView = new ViewEmpDialog(manView, true, emp);
        empView.setVisible(true);
        tableFocus();
        //doBlur();
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
