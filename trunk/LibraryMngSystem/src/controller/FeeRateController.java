/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.AccessFee;
import view.FeeRateDialog;
import entity.Fee;

/**
 * Fee rate change controller, control fee rate dialog
 * 
 * @author CuongNQ
 */
public class FeeRateController {

	// Defined
	private Fee fee = null;
	private FeeRateDialog view;

	/**
	 * Default constructor
	 * 
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

		// Get current setting
		getCurrentSetting();

		// Add event cancel btn
		view.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fee = null;
				view.dispose();
			}
		});

		// Add event close window
		view.addWindowListener(new java.awt.event.WindowAdapter() {

			@Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
				fee = null;
				view.dispose();
			}
		});

		// Add event change btn
		view.getBtnChange().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (view.getTxtFee().getText().length() > 0
						&& view.getTxtFine().getText().length() > 0) {
					fee = new Fee();
					fee.setFee(Messages.getString("FeeRateController.2")); //$NON-NLS-1$
					fee.setBorFee(new Float(view.getTxtFee().getText()
							.substring(1)));
					fee.setLateFee(new Float(view.getTxtFine().getText()
							.substring(1)));
					view.dispose();
				} else {
					JOptionPane.showMessageDialog(
							view,
							Messages.getString("FeeRateController.3")
									+ Messages.getString("FeeRateController.4"), //$NON-NLS-1$ 
							Messages.getString("ValidTitle"),
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * Get current setting on database
	 */
	private void getCurrentSetting() {
		fee = AccessFee.getInstance().getFee();
		view.getTxtFee().setText(
				Messages.getString("FeeRateController.0")
						+ Float.toString(getFee().getBorFee()));
		view.getTxtFine().setText(
				Messages.getString("FeeRateController.1")
						+ Float.toString(getFee().getLateFee()));
	}

	/**
	 * @return the fee
	 */
	public Fee getFee() {
		return fee;
	}

	/**
	 * @return the view
	 */
	public FeeRateDialog getView() {
		return view;
	}

	/**
	 * @param fee
	 *            the fee to set
	 */
	public void setFee(Fee fee) {
		this.fee = fee;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(FeeRateDialog view) {
		this.view = view;
	}
}
