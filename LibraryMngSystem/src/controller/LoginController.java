/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import model.AccessLogin;
import model.LibConfig;
import model.LibConnection;
import model.LibPassword;
import model.LibUtil;

import org.jdesktop.jxlayer.JXLayer;
import org.jdesktop.jxlayer.plaf.effect.BufferedImageOpEffect;
import org.jdesktop.jxlayer.plaf.ext.LockableUI;

import view.AboutWindow;
import view.LoginDialog;
import view.SettingConnection;

import com.jhlabs.image.BlurFilter;

/**
 * Login controller, control login dialog
 * 
 * @author CuongNQ
 */
public class LoginController {

	// Defined
	private ManageController manageControl;
	@SuppressWarnings("unused")
	private AboutWindow about;
	// Defined Setting Dialog
	private LoginDialog view;
	// Defined Jxlayer
	private JXLayer<JComponent> layer;
	// Defined blurUI
	private LockableUI blurUI;
	// Defined Jcomponent
	private JComponent jc;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param manageControl
	 */
	public LoginController(LoginDialog view, ManageController manageControl) {
		this.view = view;
		this.manageControl = manageControl;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {
		// Load connection config file
		LibConnection.getInstance().getProperty();
		// Load user & pass from config file
		LibConfig.getInstance().loadLoginConfig(view);
		// Create new instance of blurUI
		blurUI = new LockableUI(new BufferedImageOpEffect(new BlurFilter()));
		// Create new instance of Jcomponent
		jc = (JComponent) view.getContentPane();
		// Create new instance of layer
		layer = new JXLayer<JComponent>(jc);
		// Set layer blur effect
		layer.setUI(blurUI);
		blurUI.setLockedCursor(null);
		// set layer blur to pane
		view.setContentPane(layer);

		// Add event to menu setting
		view.getMnConnection().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Blur layer
				doBlur();
				// Display setting dialog
				new SettingController(new SettingConnection(view)).getView()
						.setVisible(true);
				// Blur layer
				doBlur();
			}
		});

		// Add event to menu quit
		view.getMnQuit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Dispose this frame
				view.dispose();
				System.exit(0);
			}
		});

		// Add event to about us
		view.getMnAbout().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.setVisible(false);// hidden current frame
				about = new AboutWindow(null, view);
			}
		});

		// Add event to login
		view.getBtnLogin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// invoked doRemember method to remember password
				doRemember();
				// invoked login method
				login();
			}
		});

		// Add event windows closing
		view.addWindowListener(new java.awt.event.WindowAdapter() {

			@Override
			public void windowClosing(java.awt.event.WindowEvent evt) {
				view.dispose();
				System.exit(0);
			}
		});

		// Add event open help mn
		view.getMnHelp().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LibUtil.getInstance().openHelp();
			}
		});

		// Add event enter key
		view.getTxtUser().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// invoked doRemember method to remember password
					doRemember();
					// invoked login method
					login();
				}
			}
		});

		view.getTxtPass().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// invoked doRemember method to remember password
					doRemember();
					// invoked login method
					login();
				}
			}
		});
	}

	/**
	 * Blur main frame when dialog open
	 */
	private void doBlur() {
		// set layer blur to pane
		view.setContentPane(layer);
		blurUI.setLocked(!blurUI.isLocked());
	}

	/**
	 * Remember account entered
	 */
	private void doRemember() {
		if (view.getCbxRemember().isSelected()) {
			LibConfig.getInstance().saveLoginConfig(
					view.getTxtUser().getText(),
					new String(view.getTxtPass().getPassword()));
		} else {
			LibConfig.getInstance().saveLoginConfig(
					Messages.getString("EmptyText"),
					Messages.getString("EmptyText")); //$NON-NLS-1$ 
		}
	}

	/**
	 * @return the view
	 */
	public LoginDialog getView() {
		return view;
	}

	/**
	 * Connect to SQL Server and check administrator info
	 */
	private void login() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					// Create cursor and disable two field, btn
					view.setCursor(new Cursor(Cursor.WAIT_CURSOR));
					view.getTxtUser().setEnabled(false);
					view.getTxtPass().setEnabled(false);
					view.getBtnLogin().setEnabled(false);

					if (AccessLogin.getInstance().login(
							view.getTxtUser().getText(),
							LibPassword.getInstance()
									.encryptMD5(
											new String(view.getTxtPass()
													.getPassword())))) {
						view.dispose();
						// Display manage frame
						manageControl.getView().setVisible(true);
					} else {
						doBlur();
						JOptionPane.showMessageDialog(
								view,
								Messages.getString("LoginController.2"), //$NON-NLS-1$
								Messages.getString("LoginController.3"),
								JOptionPane.WARNING_MESSAGE);						
						// Sleep 1 minisecond otherwise can't doBlur again
						Thread.sleep(1);
						doBlur();
						view.getTxtUser().requestFocus();
					}
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				} finally {
					// Return current cursor and set enable field, btn
					view.setCursor(null);
					view.getTxtUser().setEnabled(true);
					view.getTxtPass().setEnabled(true);
					view.getBtnLogin().setEnabled(true);
				}

			}
		}).start();
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(LoginDialog view) {
		this.view = view;
	}
}
