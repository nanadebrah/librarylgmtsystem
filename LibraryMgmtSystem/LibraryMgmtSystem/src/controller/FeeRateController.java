/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Fee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.AccessFee;
import view.FeeRateDialog;

/**
 * Fee rate change controller, control fee rate dialog
 * @author CuongNQ
 */
public class FeeRateController {

    //Defined
    private Fee fee = null;
    private FeeRateDialog view;

    /**
     * Default constructor
     * @param view
     */
    public FeeRateController(FeeRateDialog view) {
        this.view = view;
        initComponent();
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {

        //Get current setting
        getCurrentSetting();

        //Add event cancel btn
        view.getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                fee = null;
                view.dispose();
            }
        });

        //Add event close window
        view.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent evt) {
                fee = null;
                view.dispose();
            }
        });

        //Add event change btn
        view.getBtnChange().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (view.getTxtDayFee().getText().length() > 0
                        && view.getTxtLateFee().getText().length() > 0) {
                    fee = new Fee();
                    fee.setFee("Fee");
                    fee.setBorFee(new Float(view.getTxtDayFee().getText().substring(1)));
                    fee.setLateFee(new Float(view.getTxtLateFee().getText().substring(1)));
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(view, "All field must valid.\n"
                            + "Example: $7.10",
                            "Valid!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * Get current setting on database
     */
    private void getCurrentSetting() {
        fee = AccessFee.getInstance().getFee();
        view.getTxtDayFee().setText("$" + Float.toString(getFee().getBorFee()));
        view.getTxtLateFee().setText("$" + Float.toString(getFee().getLateFee()));
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
