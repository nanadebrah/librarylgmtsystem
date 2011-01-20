/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import model.AccessBorrow;
import model.AccessFee;
import model.LibConfig;
import model.LibEmailSender;
import view.SendAlertDialog;

/**
 * Send alert dialog controller
 * 
 * @author CuongNQ
 */
public class SendAlertController {
	// Defined

	private SendAlertDialog view;
	private int borID, empID, bookID;
	private String[] arr;
	private String[] arrEmail;
	private String content = Messages.getString("SendAlertController.0");
	private boolean isSent;
	private entity.Fee fee;

	public SendAlertController(SendAlertDialog view, int borID, int empID,
			int bookID) {
		this.bookID = bookID;
		this.borID = borID;
		this.empID = empID;
		this.view = view;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {
		arrEmail = LibConfig.getInstance().loadEmailConfig();
		arr = new String[21];
		// Access get full borrow details
		AccessBorrow.getInstance().getFullBorInfo(arr, borID, empID, bookID);
		// Access get fee details
		fee = AccessFee.getInstance().getFee();
		view.getTxtTo().setText(arr[4]);
		view.getTxtFrom().setText(arrEmail[2]);
		createContent();

		// Add event send btn
		view.getBtnSend().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				doSendMail();
			}
		});
		// Add event close btn
		view.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * Create default content of mail
	 */
	private void createContent() {
		// Design mail content
		view.getTxtSubject().setText(
				Messages.getString("SendAlertController.1") + arr[9]);
		content += Messages.getString("SendAlertController.2") + arr[1]
				+ Messages.getString("SendAlertController.3");
		content += Messages.getString("SendAlertController.4") + arr[12]
				+ Messages.getString("SendAlertController.5")
				+ Messages.getString("SendAlertController.6");
		content += Messages.getString("SendAlertController.7")
				+ Messages.getString("SendAlertController.8")
				+ new Date().toString()
				+ Messages.getString("SendAlertController.9")
				+ Messages.getString("SendAlertController.10") + arr[9]
				+ Messages.getString("SendAlertController.11")
				+ Messages.getString("SendAlertController.12") + arr[11]
				+ Messages.getString("SendAlertController.13")
				+ Messages.getString("SendAlertController.14") + arr[12]
				+ Messages.getString("SendAlertController.15")
				+ Messages.getString("SendAlertController.16")
				+ fee.getBorFee()
				+ Messages.getString("SendAlertController.17")
				+ Messages.getString("SendAlertController.18")
				+ fee.getLateFee()
				+ Messages.getString("SendAlertController.19");
		content += Messages.getString("SendAlertController.20")
				+ Messages.getString("SendAlertController.21") + arr[1]
				+ Messages.getString("SendAlertController.22")
				+ Messages.getString("SendAlertController.23") + arr[4]
				+ Messages.getString("SendAlertController.24")
				+ Messages.getString("SendAlertController.25") + arr[6]
				+ Messages.getString("SendAlertController.26")
				+ Messages.getString("SendAlertController.27") + arr[7]
				+ Messages.getString("SendAlertController.28")
				+ Messages.getString("SendAlertController.29") + arr[5]
				+ Messages.getString("SendAlertController.30");
		content += Messages.getString("SendAlertController.31")
				+ Messages.getString("SendAlertController.32") + arr[15]
				+ Messages.getString("SendAlertController.33")
				+ Messages.getString("SendAlertController.34") + arr[16]
				+ Messages.getString("SendAlertController.35")
				+ Messages.getString("SendAlertController.36") + arr[17]
				+ Messages.getString("SendAlertController.37")
				+ Messages.getString("SendAlertController.38") + arr[18]
				+ Messages.getString("SendAlertController.39")
				+ Messages.getString("SendAlertController.40") + arr[19]
				+ Messages.getString("SendAlertController.41")
				+ Messages.getString("SendAlertController.42") + arr[20]
				+ Messages.getString("SendAlertController.43");
		content += Messages.getString("SendAlertController.44")
				+ Messages.getString("SendAlertController.45")
				+ Messages.getString("SendAlertController.46");
		content += Messages.getString("SendAlertController.47")
				+ Messages.getString("SendAlertController.48");
		view.getTxtContent().setText(content);
	}

	/**
	 * Send mail
	 */
	private void doSendMail() {
		try {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						view.setCursor(new Cursor(Cursor.WAIT_CURSOR));
						LibEmailSender.getInstance().send(
								view.getTxtTo().getText(),
								view.getTxtFrom().getText(), arrEmail[0],
								arrEmail[1], view.getTxtSubject().getText(),
								content, null, null, arrEmail[2], arrEmail[3]);
						isSent = true;
					} catch (Exception ex) {
						isSent = false;
						ex.printStackTrace();
					}
				}
			});
			t.start();
			t.join();
			view.setCursor(null);
			if (isSent) {
				JOptionPane.showMessageDialog(view,
						Messages.getString("SendAlertController.49"),
						Messages.getString("SendAlertController.50"),
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(
						view,
						Messages.getString("SendAlertController.51")
								+ Messages.getString("SendAlertController.52"),
						Messages.getString("SendAlertController.53"),
						JOptionPane.ERROR_MESSAGE);
			}
			view.dispose();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @return the view
	 */
	public SendAlertDialog getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(SendAlertDialog view) {
		this.view = view;
	}
}
