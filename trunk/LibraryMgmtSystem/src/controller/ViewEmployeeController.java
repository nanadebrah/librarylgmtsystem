/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

        getView().getLblDOB1().setText(m+"/"+d+"/"+y);
        if (emp.getGender() == 1) {
            getView().getLblGender1().setText("Male");
        } else {
            getView().getLblGender1().setText("Female");
        }
        getView().getLblEmail1().setText(emp.getEmail());
        getView().getLblAddress1().setText(emp.getAddress());
        getView().getLblPhone1().setText(emp.getPhone());
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
