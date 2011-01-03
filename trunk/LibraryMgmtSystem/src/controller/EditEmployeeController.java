/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import view.EditEmpDialog;

/**
 *
 * @author CuongNQ
 */
public class EditEmployeeController {

    //Defined employee and edit dialog
    private Employee emp = null;
    private EditEmpDialog view;

    public EditEmployeeController(EditEmpDialog view, Employee emp) {
        this.view = view;
        this.emp = emp;
        initComponent();
    }

    /*
     *  initialize the controller.
     */
    private void initComponent() {
        //Set all old field of employee
        setField();
        //add event chang permission
        getView().getCbxPermis().addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                //If  permission is employee, it doesn't need password
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem().equals("Employee")) {
                        getView().getTxtPass().setVisible(false);
                        getView().getLblPass().setVisible(false);
                    } else {
                        getView().getTxtPass().setVisible(true);
                        getView().getLblPass().setVisible(true);
                    }
                }
            }
        });
        //Add event cancel btn
        getView().getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                emp = null;
                getView().dispose();
            }
        });
        //Add event add btn
        getView().getBtnSave().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                toObject();
                getView().dispose();
            }
        });
        //Add event windows closing
        getView().addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent evt) {
                emp = null;
                getView().dispose();
            }
        });
    }

    /*
     * Set all info to field
     */
    private void setField() {
        if (getEmp() != null) {
            getView().getTxtName().setText(getEmp().getName());
            if (getEmp().getGender() == 1) {
                getView().getRdbMale().setSelected(true);
            } else {
                getView().getRdbFemale().setSelected(true);
            }
            java.util.Date date = new java.util.Date(getEmp().getDOB());
            getView().getTxtDOB().setDate(date);
            getView().getTxtAdd().setText(getEmp().getAddress());
            getView().getTxtEmail().setText(getEmp().getEmail());
            getView().getTxtPhone().setText(getEmp().getPhone());
            getView().getTxtDepart().setText(getEmp().getDepartment());
            if (getEmp().getPermission() == 1) {
                getView().getCbxPermis().setSelectedIndex(0);
            } else {
                getView().getCbxPermis().setSelectedIndex(1);
            }
        }
    }

    /*
     * Transfer all field to object
     */
    private void toObject() {
        getEmp().setName(getView().getTxtName().getText());
        if (getView().getRdbMale().isSelected()) {
            getEmp().setGender(1);
        } else {
            getEmp().setGender(0);
        }
        getEmp().setDOB(getView().getTxtDOB().getDate().getTime());
        getEmp().setAddress(getView().getTxtAdd().getText());
        getEmp().setEmail(getView().getTxtEmail().getText());
        getEmp().setPassword(new String(getView().getTxtPass().getPassword()));
        getEmp().setPhone(getView().getTxtPhone().getText());
        getEmp().setDepartment(getView().getTxtDepart().getText());
        if (getView().getCbxPermis().getSelectedItem().toString().equals("Librarian")) {
            getEmp().setPermission(1);
        } else {
            getEmp().setPermission(0);
        }
    }

    /**
     * @return the emp
     */
    public Employee getEmp() {
        return emp;
    }

    /**
     * @param emp the emp to set
     */
    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    /**
     * @return the view
     */
    public EditEmpDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(EditEmpDialog view) {
        this.view = view;
    }
}
