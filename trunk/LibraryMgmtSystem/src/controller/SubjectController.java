/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.AccessEmp;
import view.AddSubDialog;
import view.ManageFrm;
import view.PalSubject;

/**
 *
 * @author CuongNQ
 */
public class SubjectController {

    //Defined
    private PalSubject view;
    private ManageFrm parent;
    private DefaultTableModel subModel;
    private AddSubjectController addSubject;
    private ManageController manage;

    public SubjectController(PalSubject view,
            DefaultTableModel subModel, ManageFrm parent,ManageController manage){
        this.view=view;
        this.subModel=subModel;
        this.parent=parent;
        this.manage=manage;
        initComponent();
    }

    /*
     *  initialize the controller.
     */
    private void initComponent() {
        
        //Set selection mode
        getView().getTblSub().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Add model to table
        getView().getTblSub().setModel(subModel);
        //Set model
        subModel.addColumn("Subject ID");
        subModel.addColumn("Subject Name");
        subModel.addColumn("Description");

        //Add event add btn
        getView().getBtnAddSub().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                addSubject();
            }
        });
    }

    /*
     * Add an subject
     */
    private void addSubject(){
        manage.doBlur();
        //Display Add employee dialog
        addSubject = new AddSubjectController(new AddSubDialog(parent, true));
        addSubject.getView().setVisible(true);
        //invoked method add employee
        if (addSubject.getSub() != null) {
            System.out.println(addSubject.getSub().getSubName());
        }
        view.getTblSub().clearSelection();
        manage.doBlur();
    }

    /**
     * @return the view
     */
    public PalSubject getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(PalSubject view) {
        this.view = view;
    }
}
