/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ViewSubDialog;

/**
 *
 * @author CuongNQ
 */
public class ViewSubjectController {

    //Defined
    private Subject sub = null;
    private ViewSubDialog view;

    public ViewSubjectController(ViewSubDialog view, Subject sub) {
        this.view = view;
        this.sub = sub;
        initComponent();
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {
        //Set field
        getView().getLblSubID1().setText(new Integer(sub.getSubID()).toString());
        getView().getLblName1().setText(sub.getSubName());
        getView().getTxtDes().setText(sub.getDescription());
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
    public ViewSubDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(ViewSubDialog view) {
        this.view = view;
    }
}
