/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
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

        //Set selection mode
        getView().getTblBor().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Add model to table
        getView().getTblBor().setModel(borModel);
        //Set model
        borModel.addColumn("gi do1");
        borModel.addColumn("gi do2");
        borModel.addColumn("gi do3");
        borModel.addColumn("gi do4");
        borModel.addColumn("gi do5");
        borModel.addColumn("gi do6");
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
