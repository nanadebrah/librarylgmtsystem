/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.EditSubDialog;

/**
 *
 * @author CuongNQ
 */
public class EditSubjectController {

    //Defined employee and edit dialog
    private Subject sub = null;
    private EditSubDialog view;

    public EditSubjectController(EditSubDialog view, Subject sub) {
        this.view = view;
        this.sub = sub;
        initComponent();
    }

    /*
     *  initialize the controller.
     */
    private void initComponent() {
        //Set field
        getView().getTxtName().setText(sub.getSubName());
        getView().getTxtDes().setText(sub.getDescription());

        //Add event cancel btn
        getView().getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sub=null;
                getView().dispose();
            }
        });

        //Add event close window
        getView().addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                sub=null;
                getView().dispose();
            }
        });

        //Add event save btn
        getView().getBtnSave().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sub.setSubName(getView().getTxtName().getText());
                sub.setDescription(getView().getTxtDes().getText());
                getView().dispose();
            }
        });
    }

    /**
     * @return the sub
     */
    public Subject getSub() {
        return sub;
    }

    /**
     * @param sub the sub to set
     */
    public void setSub(Subject sub) {
        this.sub = sub;
    }

    /**
     * @return the view
     */
    public EditSubDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(EditSubDialog view) {
        this.view = view;
    }
}
