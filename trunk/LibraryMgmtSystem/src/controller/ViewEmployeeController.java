/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import model.LibUtil;
import view.ViewEmpDialog;

/**
 *
 * @author CuongNQ
 */
public class ViewEmployeeController {

    //Defined
    private Employee emp = null;
    private ViewEmpDialog view;

    public ViewEmployeeController(ViewEmpDialog view, Employee emp) {
        this.view = view;
        this.emp = emp;
        initComponent();
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {
        //Set all information
        getView().getLblID1().setText(new Integer(emp.getEmpID()).toString());
        getView().getLblName1().setText(emp.getName());
        String DOB=new Date(emp.getDOB()).toString();

        getView().getLblDOB1().setText(LibUtil.getInstance().convertDate(DOB));
        if (emp.getGender() == 1) {
            getView().getLblGender1().setText("Male");
        } else {
            getView().getLblGender1().setText("Female");
        }
        getView().getLblEmail1().setText(emp.getEmail());
        getView().getLblAddress1().setText(emp.getAddress());
        getView().getLblPhone1().setText(emp.getPhone());
        getView().getLblDepart1().setText(emp.getDepartment());
        if (emp.getPermission() == 1) {
            getView().getLblPermission1().setText("Librarian");
        } else {
            getView().getLblPermission1().setText("Employee");
        }
        //Add event close btn
        getView().getBtnClose().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                getView().dispose();
            }
        });
    }

    /**
     * @return the view
     */
    public ViewEmpDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(ViewEmpDialog view) {
        this.view = view;
    }
}
