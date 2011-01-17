/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LibConfig;
import model.LibConnection;
import model.LibPassword;
import view.SettingConnection;

/**
 * Setting controller, control setting dialog
 * 
 * @author CuongNQ
 */
public class SettingController {

	// Defined Setting Dialog
	private SettingConnection view;

	/**
	 * Default constructor
	 * 
	 * @param view
	 */
	public SettingController(SettingConnection view) {
		this.view = view;
		initComponent();
		// invoked set default all field
		if (!LibConfig.getInstance().loadConnectConfig(view)) {
			setField();
		}
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {
		// Add event for btnTest
		view.getBtnCheck().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				checkConnection();
			}
		});

		// Add event for btnDefault
		view.getBtnDefault().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setField();
			}
		});

		// Add event for btnClose
		view.getBtnSave().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				saveConfig();
			}
		});

		// Add event for btnClose
		view.getBtnClose().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * Default all field text
	 */
	private void setField() {
		view.getTxtHost().setText("localhost");
		view.getTxtPort().setText("1433");
		view.getTxtData().setText("Library");
		view.getTxtUser().setText("sa");
		view.getTxtPass().setText("9988776655");
	}

	/**
	 * Save config to property file
	 */
	private void saveConfig() {
		if (LibConfig.getInstance().saveConnectConfig(
				view.getTxtHost().getText(),
				view.getTxtPort().getText(),
				view.getTxtData().getText(),
				view.getTxtUser().getText(),
				LibPassword.getInstance().encryptPass(
						new String(view.getTxtPass().getPassword())))) {
			view.getLblStatus().setText("Saved!");
		} else {
			view.getLblStatus().setText("Error!");
		}
	}

	/**
	 * Check connection using JDBC 4
	 */
	private void checkConnection() {
		new Thread(new Runnable() {

			public void run() {
				// Change cursor
				view.setCursor(new Cursor(Cursor.WAIT_CURSOR));
				// Test connection
				String pass = new String(view.getTxtPass().getPassword());
				boolean check = LibConnection.testConnection(view.getTxtHost()
						.getText(), view.getTxtPort().getText(), view
						.getTxtData().getText(), view.getTxtUser().getText(),
						pass);
				view.setConnectImage(check);
				if (check) {
					view.getLblStatus().setText("OK!");
				} else {
					view.getLblStatus().setText("Error!!!!");
				}
				// Change cursor
				view.setCursor(null);
			}
		}).start();

	}

	/**
	 * @return the view
	 */
	public SettingConnection getView() {
		return view;
	}
}
