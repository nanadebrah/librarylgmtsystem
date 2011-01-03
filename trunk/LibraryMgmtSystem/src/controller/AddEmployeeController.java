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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import view.AddEmpDialog;

/**
 *
 * @author CuongNQ
 */
public class AddEmployeeController {

    //Defined
    private Employee emp = null;
    private AddEmpDialog view;

    public AddEmployeeController(AddEmpDialog view) {
        this.view = view;
        initComponent();
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {
        //Create new employee
        setEmp(new Employee());
        
        //Add event close btn
        getView().getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                emp=null;
                getView().dispose();
            }
        });

        //Add event add btn
        getView().getBtnAdd().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //set object
                toObject();
                //Dispose this dialog
                getView().dispose();
            }
        });

        //Add item listenner
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

        //Add window event
        view.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                emp=null;
            }
        });
    }

    /*
     * Transfer all field to object
     */
    private void toObject() {
        setEmp(new Employee());
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
     * @return the view
     */
    public AddEmpDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(AddEmpDialog view) {
        this.view = view;
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
}
