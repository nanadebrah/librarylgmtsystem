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
        emp = new Employee();

        //Add event close btn
        view.getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                emp = null;
                view.dispose();
            }
        });

        //Add event add btn
        view.getBtnAdd().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //set object
                toObject();
                //Dispose this dialog
                view.dispose();
            }
        });

        //Add item listenner
        view.getCbxPermis().addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                //If  permission is employee, it doesn't need password
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem().equals("Employee")) {
                        view.getTxtPass().setVisible(false);
                        view.getLblPass().setVisible(false);
                    } else {
                        view.getTxtPass().setVisible(true);
                        view.getLblPass().setVisible(true);
                    }
                }
            }
        });

        //Add window event
        view.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                emp = null;
            }
        });
    }

    /*
     * Transfer all field to object
     */
    private void toObject() {
        emp = new Employee();
        emp.setName(view.getTxtName().getText());
        if (view.getRdbMale().isSelected()) {
            emp.setGender(1);
        } else {
            emp.setGender(0);
        }
        emp.setDOB(view.getTxtDOB().getDate().getTime());
        emp.setAddress(view.getTxtAdd().getText());
        emp.setEmail(view.getTxtEmail().getText());
        emp.setPassword(new String(view.getTxtPass().getPassword()));
        emp.setPhone(view.getTxtPhone().getText());
        emp.setDepartment(view.getTxtDepart().getText());
        if (view.getCbxPermis().getSelectedItem().toString().equals("Librarian")) {
            emp.setPermission(1);
        } else {
            emp.setPermission(0);
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
