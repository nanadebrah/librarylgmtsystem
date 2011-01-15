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
import javax.swing.JOptionPane;
import model.LibValid;
import view.EditEmpDialog;

/**
 * Edit employee controller, control edit employee dialog
 * @author CuongNQ
 */
public class EditEmployeeController {

    //Defined employee and edit dialog
    private Employee emp = null;
    private EditEmpDialog view;

    /**
     * Default constructor
     * @param view
     * @param emp
     */
    public EditEmployeeController(EditEmpDialog view, Employee emp) {
        this.view = view;
        this.emp = emp;
        initComponent();
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {
        //Set all old field of employee
        setField();
        //add event chang permission
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
        //Add event cancel btn
        view.getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                emp = null;
                view.dispose();
            }
        });
        //Add event add btn
        view.getBtnSave().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (validEmp()) {
                    toObject();
                    view.dispose();
                }
            }
        });
        //Add event windows closing
        view.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent evt) {
                emp = null;
                view.dispose();
            }

            public void windowOpened(java.awt.event.WindowEvent evt) {
                //If employee, hiden passtext and pass label
                if (emp.getPermission() == 0) {
                    view.getTxtPass().setEditable(false);
                }
            }
        });
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
     * Set all info to field
     */
    private void setField() {
        if (emp != null) {
            view.getTxtName().setText(emp.getName());
            if (emp.getGender() == 1) {
                view.getRdbMale().setSelected(true);
            } else {
                view.getRdbFemale().setSelected(true);
            }
            java.util.Date date = new java.util.Date(emp.getDOB());
            view.getTxtDOB().setDate(date);
            view.getTxtAdd().setText(emp.getAddress());
            view.getTxtEmail().setText(emp.getEmail());
            view.getTxtPhone().setText(emp.getPhone());
            view.getTxtDepart().setText(emp.getDepartment());
            if (emp.getPermission() == 1) {
                view.getCbxPermis().setSelectedIndex(0);
            } else {
                view.getCbxPermis().setSelectedIndex(1);
            }
        }
    }

    /**
     * Transfer all field to object
     */
    private void toObject() {
        emp.setFixName(view.getTxtName().getText());
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
            emp.setName(view.getTxtName().getText());
            emp.setPermission(0);
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
