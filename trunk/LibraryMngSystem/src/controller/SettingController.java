/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
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

			@Override
			public void actionPerformed(ActionEvent e) {
				checkConnection();
			}
		});

		// Add event for btnDefault
		view.getBtnDefault().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setField();
			}
		});

		// Add event for btnClose
		view.getBtnSave().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveConfig();
			}
		});

		// Add event for btnClose
		view.getBtnClose().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});

		// Add event Windows authentication
		view.getChbWinAu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (view.getChbWinAu().isSelected()) {
					view.getTxtUser().setEnabled(false);
					view.getTxtPass().setEnabled(false);
				} else {
					view.getTxtUser().setEnabled(true);
					view.getTxtPass().setEnabled(true);
				}
			}
		});

		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * Check connection using JDBC 4
	 */
	private void checkConnection() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// Change cursor
				view.setCursor(new Cursor(Cursor.WAIT_CURSOR));
				// Test connection
				String pass = new String(view.getTxtPass().getPassword());
				boolean check = LibConnection.testConnection(view.getTxtHost()
						.getText(), view.getTxtPort().getText(), view
						.getTxtData().getText(), view.getTxtUser().getText(),
						pass, view.getChbWinAu().isSelected());
				view.setConnectImage(check);
				if (check) {
					view.getLblStatus().setForeground(Color.blue);
					view.getLblStatus().setText(
							Messages.getString("SettingController.0")); //$NON-NLS-1$
				} else {
					view.getLblStatus().setForeground(Color.red);
					view.getLblStatus().setText(
							Messages.getString("SettingController.1")); //$NON-NLS-1$
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
						new String(view.getTxtPass().getPassword())),
				view.getChbWinAu().isSelected())) {
			view.getLblStatus().setForeground(Color.black);
			view.getLblStatus().setText(
					Messages.getString("SettingController.2")); //$NON-NLS-1$
		} else {
			view.getLblStatus().setForeground(Color.red);
			view.getLblStatus().setText(
					Messages.getString("SettingController.3")); //$NON-NLS-1$
		}
	}

	/**
	 * Default all field text
	 */
	private void setField() {
		view.getTxtHost().setText(Messages.getString("SettingController.4")); //$NON-NLS-1$
		view.getTxtPort().setText(Messages.getString("SettingController.5")); //$NON-NLS-1$
		view.getTxtData().setText(Messages.getString("SettingController.6")); //$NON-NLS-1$
		view.getTxtUser().setText(Messages.getString("SettingController.7")); //$NON-NLS-1$
		view.getTxtPass().setText(Messages.getString("SettingController.8")); //$NON-NLS-1$
		view.getChbWinAu().setSelected(false);
	}
}
