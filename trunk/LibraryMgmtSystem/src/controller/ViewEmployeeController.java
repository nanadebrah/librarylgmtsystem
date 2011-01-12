/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Employee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;
import model.AccessEmp;
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
    private DefaultTableModel borModel;

    /**
     * 
     * @param view
     * @param emp
     */
    public ViewEmployeeController(ViewEmpDialog view, Employee emp) {
        this.view = view;
        this.emp = emp;
        initComponent();
        getEmpBorDetail();
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {
        //Set all information
        view.getLblID1().setText(new Integer(emp.getEmpID()).toString());
        view.getLblName1().setText(emp.getName());
        String DOB = new Date(emp.getDOB()).toString();

        view.getLblDOB1().setText(LibUtil.getInstance().convertDate(DOB));
        if (emp.getGender() == 1) {
            view.getLblGender1().setText("Male");
        } else {
            view.getLblGender1().setText("Female");
        }
        view.getLblEmail1().setText(emp.getEmail());
        view.getLblAddress1().setText(emp.getAddress());
        view.getLblPhone1().setText(emp.getPhone());
        view.getLblDepart1().setText(emp.getDepartment());
        if (emp.getPermission() == 1) {
            view.getLblPermission1().setText("Librarian");
        } else {
            view.getLblPermission1().setText("Employee");
        }
        //Add event close btn
        view.getBtnClose().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });

        //Create bor model
        borModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        borModel.addColumn("Borrow No");
        borModel.addColumn("Book No");
        borModel.addColumn("Call Number");
        borModel.addColumn("Title");
        borModel.addColumn("Issue Date");
        borModel.addColumn("Due Date");
        borModel.addColumn("Issue Status");
        borModel.addColumn("Return Date");
        borModel.addColumn("Total Fee");

        //Add model to table
        view.getTblBor().setModel(borModel);
    }

    /**
     * 
     */
    private void getEmpBorDetail() {
        AccessEmp.getInstance().getEmpBorInfo(borModel, emp.getEmpID());
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
