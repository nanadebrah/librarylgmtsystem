/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Fee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.AccessFee;
import view.FeeRateDialog;

/**
 *
 * @author CuongNQ
 */
public class FeeRateController {

    //Defined
    private Fee fee = null;
    private FeeRateDialog view;

    public FeeRateController(FeeRateDialog view) {
        this.view = view;
        initComponent();
    }

    /**
     *  initialize the controller.
     */
    private void initComponent() {
        
        //Get current setting
        getCurrentSetting();

        //Add event cancel btn
        getView().getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                fee=null;
                getView().dispose();
            }
        });

        //Add event close window
        getView().addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                fee=null;
                getView().dispose();
            }
        });

        //Add event change btn
        getView().getBtnChange().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                fee=new Fee();
                fee.setFee("Fee");
                fee.setBorFee(new Float(getView().getTxtDayFee().getText().substring(1)));
                fee.setLateFee(new Float(getView().getTxtLateFee().getText().substring(1)));
                getView().dispose();
            }
        });
    }

    private void getCurrentSetting(){
        setFee(AccessFee.getInstance().getFee());
        getView().getTxtDayFee().setText("$"+Float.toString(getFee().getBorFee()));
        getView().getTxtLateFee().setText("$"+Float.toString(getFee().getLateFee()));
    }

    /**
     * @return the view
     */
    public FeeRateDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(FeeRateDialog view) {
        this.view = view;
    }

    /**
     * @return the fee
     */
    public Fee getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(Fee fee) {
        this.fee = fee;
    }
}
