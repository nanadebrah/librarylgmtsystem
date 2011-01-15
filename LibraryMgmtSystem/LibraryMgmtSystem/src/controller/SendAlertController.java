/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.SendAlertDialog;

/**
 * Send alert dialog controller
 * @author CuongNQ
 */
public class SendAlertController {
    //Defined

    private SendAlertDialog view;
    private ManageController parent;

    public SendAlertController(SendAlertDialog view,
            ManageController parent) {
        this.parent=parent;
        this.view = view;
        initComponent();
    }
    /**
     * initialize the controller.
     */
    private void initComponent() {
        
    }
}
