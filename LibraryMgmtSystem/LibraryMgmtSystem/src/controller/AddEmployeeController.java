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
import javax.swing.JOptionPane;
import model.LibValid;
import view.AddEmpDialog;

/**
 * Add employee controller, control add employee dialog
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
                if (validEmp()) {
                    //set object
                    toObject();
                    //Dispose this dialog
                    view.dispose();
                }
            }
        });

        //Add item listenner
        view.getCbxPermis().addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                //If  permission is employee, it doesn't need password
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getItem().equals("Employee")) {
                        view.getTxtPass().setText("");
                        view.getTxtPass().setEditable(false);
                    } else {
                        view.getTxtPass().setEditable(true);
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

    /**
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
     * Valid all field of form
     * @return
     */
    private boolean validEmp() {
        if (!LibValid.getInstance().Name(view.getTxtName().getText())) {
            JOptionPane.showMessageDialog(view, "Name must valid.",
                    "Valid!", JOptionPane.INFORMATION_MESSAGE);
            view.getTxtName().requestFocus();
            return false;
        }
        if (view.getTxtDOB().getDate() == null) {
            JOptionPane.showMessageDialog(view, "Date of bith must valid.",
                    "Valid!", JOptionPane.INFORMATION_MESSAGE);
            view.getTxtDOB().requestFocus();
            return false;
        }
        if (!LibValid.getInstance().Address(view.getTxtAdd().getText())) {
            JOptionPane.showMessageDialog(view, "Address must valid.",
                    "Valid!", JOptionPane.INFORMATION_MESSAGE);
            view.getTxtAdd().requestFocus();
            return false;
        }
        if (view.getCbxPermis().getSelectedItem().equals("Librarian")) {
            if (!LibValid.getInstance().Password(
                    new String(view.getTxtPass().getPassword()))) {
                JOptionPane.showMessageDialog(view, "Password must valid.",
                        "Valid!", JOptionPane.INFORMATION_MESSAGE);
                view.getTxtPass().requestFocus();
                return false;
            }
        }
        if (!LibValid.getInstance().Email(view.getTxtEmail().getText())) {
            JOptionPane.showMessageDialog(view, "Email must valid.",
                    "Valid!", JOptionPane.INFORMATION_MESSAGE);
            view.getTxtEmail().requestFocus();
            return false;
        }
        if (!LibValid.getInstance().Phone(view.getTxtPhone().getText())) {
            JOptionPane.showMessageDialog(view, "Phone must valid.",
                    "Valid!", JOptionPane.INFORMATION_MESSAGE);
            view.getTxtPhone().requestFocus();
            return false;
        }
        if (!LibValid.getInstance().Depart(view.getTxtDepart().getText())) {
            JOptionPane.showMessageDialog(view, "Department must valid.",
                    "Valid!", JOptionPane.INFORMATION_MESSAGE);
            view.getTxtDepart().requestFocus();
            return false;
        }
        return true;
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
