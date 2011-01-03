/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import view.ManageFrm;
import view.PalAnalytic;

/**
 *
 * @author CuongNQ
 */
public class AnalyticController {

    //Defined
    private PalAnalytic view;
    private ManageFrm parent;
    private DefaultTableModel anaModel;

    public AnalyticController(PalAnalytic view,
            DefaultTableModel anaModel, ManageFrm parent){
        this.view=view;
        this.anaModel=anaModel;
        this.parent=parent;
        initComponent();
    }

    /*
     *  initialize the controller.
     */
    private void initComponent() {

        //Set selection mode
        getView().getTblAna().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Add model to table
        getView().getTblAna().setModel(anaModel);
        //Set model
        anaModel.addColumn("gi do");
        anaModel.addColumn("gi do");
        anaModel.addColumn("gi do");
        anaModel.addColumn("gi do");
        anaModel.addColumn("gi do");
        anaModel.addColumn("gi do");
    }

    /**
     * @return the view
     */
    public PalAnalytic getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(PalAnalytic view) {
        this.view = view;
    }
}
