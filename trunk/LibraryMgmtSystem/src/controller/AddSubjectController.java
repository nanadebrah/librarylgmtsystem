/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import view.AddSubDialog;

/**
 *
 * @author CuongNQ
 */
public class AddSubjectController {

    //Defined
    private Subject sub = null;
    private AddSubDialog view;

    public AddSubjectController(AddSubDialog view) {
        this.view = view;
        initComponent();
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {
        //Create new employee
        sub = new Subject();

        //Add event close btn
        view.getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sub = null;
                view.dispose();
            }
        });

        //Add event add btn
        view.getBtnAdd().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //set object
                toObject();
                //Dispose this dialog
                view.dispose();
            }
        });

        //Add window event
        view.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                sub = null;
            }
        });
    }

    /*
     * Transfer all field to object
     */
    private void toObject() {
        sub.setSubName(view.getTxtName().getText());
        sub.setDescription(view.getTxtDes().getText());
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
    public AddSubDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(AddSubDialog view) {
        this.view = view;
    }
}
