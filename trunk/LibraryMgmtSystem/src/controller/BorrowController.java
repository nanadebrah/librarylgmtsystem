/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import view.CheckOutDialog;
import view.ManageFrm;
import view.PalBorrow;

/**
 *
 * @author CuongNQ
 */
public class BorrowController {

    //Defined
    private PalBorrow view;
    private DefaultTableModel borModel;
    private ManageController parent;
    private CheckOutController checkOut;
    private DefaultTableModel bookModel;
    private DefaultTableModel empModel;
    private DefaultTableModel outModel;

    public BorrowController(PalBorrow view,
            DefaultTableModel borModel, ManageController parent) {
        this.view = view;
        this.borModel = borModel;
        this.parent = parent;
        initComponent();
    }

    /*
     *  initialize the controller.
     */
    private void initComponent() {

        //Create book model
        bookModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        //Create employee model
        empModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        //Create check-out model
        outModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };

        //Set selection mode
        getView().getTblBor().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Add model to table
        getView().getTblBor().setModel(borModel);
        //Set bor model
        borModel.addColumn("gi do1");
        borModel.addColumn("gi do2");
        borModel.addColumn("gi do3");
        borModel.addColumn("gi do4");
        borModel.addColumn("gi do5");
        borModel.addColumn("gi do6");
        //Set book model
        bookModel.addColumn("Call Number");
        bookModel.addColumn("ISBN");
        bookModel.addColumn("Title");
        bookModel.addColumn("Author");
        bookModel.addColumn("Publisher");
        bookModel.addColumn("Copies/Store");
        //Set out model
        outModel.addColumn("Call Number");
        outModel.addColumn("ISBN");
        outModel.addColumn("Title");
        outModel.addColumn("Author");
        outModel.addColumn("Publisher");
        //Set employee model
        empModel.addColumn("ID");
        empModel.addColumn("Name");
        empModel.addColumn("Gender");
        empModel.addColumn("Email");
        empModel.addColumn("Department");
        empModel.addColumn("Permission");

        //Add event check out btn
        getView().getBtnChkOut().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                checkOut=new CheckOutController(
                        new CheckOutDialog(parent.getView(), true),
                        bookModel, empModel, outModel,parent);
                checkOut.getView().setVisible(true);
            }
        });
    }

    /**
     * @return the view
     */
    public PalBorrow getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(PalBorrow view) {
        this.view = view;
    }
}
