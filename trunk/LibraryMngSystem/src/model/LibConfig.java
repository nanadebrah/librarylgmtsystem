/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import view.LoginDialog;
import view.ProSettingDialog;
import view.SettingConnection;

/**
 * Config system class
 * 
 * @author CuongNQ
 */
public class LibConfig {

	// Defined instance of LibConfig
	private static LibConfig instance = new LibConfig();

	/*
	 * Static method get instance of LibConfig
	 */
	public static LibConfig getInstance() {
		return instance;
	}

	/**
	 * Create new config file
	 */
	public void createConfig() {
		// Defined object
		FileInputStream in = null;
		Properties pro;
		try {
			// Create instance of object
			pro = new Properties();
			File f = new File(System.getProperty(Messages
					.getString("LibConfig.0")) + File.separator //$NON-NLS-1$
					+ Messages.getString("LibConfig.1")); //$NON-NLS-1$
			f.createNewFile();
			// load property file
			in = new FileInputStream(f);
			pro.load(in);

			// Save all config to file
			pro.setProperty(Messages.getString("LibConfig.2"),
					Messages.getString("LibConfig.3")); //$NON-NLS-1$ 
			// Encrypt pass and save to file config
			pro.setProperty(
					Messages.getString("LibConfig.4"), //$NON-NLS-1$
					LibPassword.getInstance().encryptPass(
							Messages.getString("LibConfig.5"))); //$NON-NLS-1$

			// Save all database & connection config to file
			pro.setProperty(Messages.getString("LibConfig.6"),
					Messages.getString("LibConfig.7")); //$NON-NLS-1$ 
			pro.setProperty(Messages.getString("LibConfig.8"),
					Messages.getString("LibConfig.9")); //$NON-NLS-1$ 
			pro.setProperty(Messages.getString("LibConfig.10"),
					Messages.getString("LibConfig.11")); //$NON-NLS-1$ 
			pro.setProperty(Messages.getString("LibConfig.12"),
					Messages.getString("LibConfig.13")); //$NON-NLS-1$ 
			pro.setProperty(
					Messages.getString("LibConfig.14"), //$NON-NLS-1$
					LibPassword.getInstance().encryptPass(
							Messages.getString("LibConfig.15"))); //$NON-NLS-1$
			pro.setProperty(Messages.getString("LibConfig.16"),
					Messages.getString("LibConfig.17")); //$NON-NLS-1$ 
			pro.setProperty(Messages.getString("LibConfig.18"),
					Messages.getString("LibConfig.19")); //$NON-NLS-1$ 
			pro.setProperty(Messages.getString("LibConfig.20"),
					Messages.getString("LibConfig.21")); //$NON-NLS-1$ 
			pro.setProperty(Messages.getString("LibConfig.22"),
					Messages.getString("LibConfig.23")); //$NON-NLS-1$ 
			pro.setProperty(Messages.getString("LibConfig.24"),
					Messages.getString("LibConfig.25")); //$NON-NLS-1$ 
			pro.setProperty(
					Messages.getString("LibConfig.26"), //$NON-NLS-1$
					LibPassword.getInstance().encryptPass(
							Messages.getString("LibConfig.27"))); //$NON-NLS-1$

			pro.store(new FileOutputStream(f),
					Messages.getString("LibConfig.28")); //$NON-NLS-1$

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Load connection config to config object
	 * 
	 * @param view
	 * @return true if load successful, otherwise false
	 */
	public boolean loadConnectConfig(SettingConnection view) {
		// Defined object
		FileInputStream in = null;
		Properties pro;
		try {
			// Create instance of object
			pro = new Properties();
			File f = new File(System.getProperty(Messages
					.getString("LibConfig.29")) + File.separator //$NON-NLS-1$
					+ Messages.getString("LibConfig.30")); //$NON-NLS-1$
			// Check file exist
			if (!f.exists()) {
				System.out.println(Messages.getString("LibConfig.31")); //$NON-NLS-1$
				return false;
			} else {
				in = new FileInputStream(f);
			}
			// load property file
			pro.load(in);

			// set all field
			view.getTxtHost().setText(
					pro.getProperty(Messages.getString("LibConfig.32"))); //$NON-NLS-1$
			view.getTxtPort().setText(
					pro.getProperty(Messages.getString("LibConfig.33"))); //$NON-NLS-1$
			view.getTxtData().setText(
					pro.getProperty(Messages.getString("LibConfig.34"))); //$NON-NLS-1$
			view.getTxtUser().setText(
					pro.getProperty(Messages.getString("LibConfig.35"))); //$NON-NLS-1$
			view.getTxtPass().setText(
					LibPassword.getInstance()
							.decryptPass(
									pro.getProperty(Messages
											.getString("LibConfig.36")))); //$NON-NLS-1$
			if (Boolean.parseBoolean(pro.getProperty(Messages
					.getString("LibConfig.37")))) { //$NON-NLS-1$
				view.getChbWinAu().setSelected(true);
				view.getTxtUser().setEnabled(false);
				view.getTxtPass().setEnabled(false);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * Load email config to process send email
	 * 
	 * @return
	 */
	public String[] loadEmailConfig() {
		String[] arr = new String[4];
		// Defined object
		FileInputStream in = null;
		Properties pro;
		try {
			// Create instance of object
			pro = new Properties();
			File f = new File(System.getProperty(Messages
					.getString("LibConfig.38")) + File.separator //$NON-NLS-1$
					+ Messages.getString("LibConfig.39")); //$NON-NLS-1$
			// Check file exist
			if (!f.exists()) {
				// If it doesn't exist, create it
				createConfig();
				return null;
			} else {
				in = new FileInputStream(f);
			}
			// load property file
			pro.load(in);
			// set field
			arr[0] = pro.getProperty(Messages.getString("LibConfig.40")); //$NON-NLS-1$
			arr[1] = pro.getProperty(Messages.getString("LibConfig.41")); //$NON-NLS-1$
			arr[2] = pro.getProperty(Messages.getString("LibConfig.42")); //$NON-NLS-1$
			arr[3] = LibPassword.getInstance().decryptPass(
					pro.getProperty(Messages.getString("LibConfig.43"))); //$NON-NLS-1$
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return arr;
	}

	/**
	 * Load login config to username & password field
	 * 
	 * @param jtxt
	 * @param jpass
	 * @param jcheck
	 * @return true if ok, else false
	 */
	public boolean loadLoginConfig(LoginDialog view) {
		// Defined object
		FileInputStream in = null;
		Properties pro;
		try {
			// Create instance of object
			pro = new Properties();
			File f = new File(System.getProperty(Messages
					.getString("LibConfig.44")) + File.separator //$NON-NLS-1$
					+ Messages.getString("LibConfig.45")); //$NON-NLS-1$
			// Check file exist
			if (!f.exists()) {
				// If it doesn't exist, create it
				createConfig();
				return false;
			} else {
				in = new FileInputStream(f);
			}
			// load property file
			pro.load(in);

			// set all field
			view.getTxtUser().setText(
					pro.getProperty(Messages.getString("LibConfig.46"))); //$NON-NLS-1$
			// get pass from config and depass
			view.getTxtPass().setText(
					LibPassword.getInstance()
							.decryptPass(
									pro.getProperty(Messages
											.getString("LibConfig.47")))); //$NON-NLS-1$
			// load page config
			LibUtil.noRow = Integer.parseInt(pro.getProperty(Messages
					.getString("LibConfig.48"))); //$NON-NLS-1$
			// Check remember check
			if (view.getTxtUser().getText().length() > 0
					&& view.getTxtPass().getPassword().length > 0) {
				view.getCbxRemember().setSelected(true);
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * Load program config
	 * 
	 * @param view
	 */
	public void loadProConfig(ProSettingDialog view) {
		// Defined object
		FileInputStream in = null;
		Properties pro;
		try {
			// Create instance of object
			pro = new Properties();
			File f = new File(System.getProperty(Messages
					.getString("LibConfig.49")) + File.separator //$NON-NLS-1$
					+ Messages.getString("LibConfig.50")); //$NON-NLS-1$
			// Check file exist
			if (!f.exists()) {
				// If it doesn't exist, create it
				createConfig();
				return;
			} else {
				in = new FileInputStream(f);
			}
			// load property file
			pro.load(in);
			// set field
			view.getSpinNoRow().setValue(
					Integer.parseInt(pro.getProperty(Messages
							.getString("LibConfig.51")))); //$NON-NLS-1$
			view.getTxtEmail().setText(
					pro.getProperty(Messages.getString("LibConfig.52"))); //$NON-NLS-1$
			view.getTxtPass().setText(
					LibPassword.getInstance()
							.decryptPass(
									pro.getProperty(Messages
											.getString("LibConfig.53")))); //$NON-NLS-1$
			view.getTxtHost().setText(
					pro.getProperty(Messages.getString("LibConfig.54"))); //$NON-NLS-1$
			view.getTxtPort().setText(
					pro.getProperty(Messages.getString("LibConfig.55"))); //$NON-NLS-1$
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Save config to property file
	 * 
	 * @param host
	 * @param port
	 * @param data
	 * @param use
	 * @param pass
	 * @return
	 */
	public boolean saveConnectConfig(String host, String port, String data,
			String use, String pass, Boolean isWin) {
		// Defined object
		FileInputStream in = null;
		Properties pro;
		try {
			// Create instance of object
			pro = new Properties();
			File f = new File(System.getProperty(Messages
					.getString("LibConfig.56")) + File.separator //$NON-NLS-1$
					+ Messages.getString("LibConfig.57")); //$NON-NLS-1$
			// Check file exist, if not, create new property file to store
			if (!f.exists()) {
				f.createNewFile();
			}
			// load property file
			in = new FileInputStream(f);
			pro.load(in);

			// Save all config to file
			pro.setProperty(Messages.getString("LibConfig.58"), host); //$NON-NLS-1$
			pro.setProperty(Messages.getString("LibConfig.59"), port); //$NON-NLS-1$
			pro.setProperty(Messages.getString("LibConfig.60"), data); //$NON-NLS-1$
			pro.setProperty(Messages.getString("LibConfig.61"), use); //$NON-NLS-1$
			pro.setProperty(Messages.getString("LibConfig.62"), pass); //$NON-NLS-1$
			pro.setProperty(
					Messages.getString("LibConfig.63"), isWin.toString()); //$NON-NLS-1$
			pro.store(new FileOutputStream(f), null);
			LibConnection.getInstance().getProperty();
			return true;
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Save login config to property files
	 * 
	 * @param user
	 * @param pass
	 */
	public void saveLoginConfig(String user, String pass) {
		// Defined object
		FileInputStream in = null;
		Properties pro;
		try {
			// Create instance of object
			pro = new Properties();
			File f = new File(System.getProperty(Messages
					.getString("LibConfig.64")) + File.separator //$NON-NLS-1$
					+ Messages.getString("LibConfig.65")); //$NON-NLS-1$
			// Check file exist, if not, create new property file to store
			if (!f.exists()) {
				f.createNewFile();
			}
			// load property file
			in = new FileInputStream(f);
			pro.load(in);

			// Save all config to file
			pro.setProperty(Messages.getString("LibConfig.66"), user); //$NON-NLS-1$
			// Encrypt pass and save to file config
			pro.setProperty(Messages.getString("LibConfig.67"), //$NON-NLS-1$
					LibPassword.getInstance().encryptPass(pass));
			pro.store(new FileOutputStream(f),
					Messages.getString("LibConfig.68")); //$NON-NLS-1$

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Save program config to property file
	 * 
	 * @param noRow
	 */
	public void saveProConfig(String noRow, String Host, String Port,
			String Email, String Pass) {
		// Defined object
		FileInputStream in = null;
		Properties pro;
		try {
			// Create instance of object
			pro = new Properties();
			File f = new File(System.getProperty(Messages
					.getString("LibConfig.69")) + File.separator //$NON-NLS-1$
					+ Messages.getString("LibConfig.70")); //$NON-NLS-1$
			// Check file exist, if not, create new property file to store
			if (!f.exists()) {
				f.createNewFile();
			}
			// load property file
			in = new FileInputStream(f);
			pro.load(in);

			// Save all config to file
			pro.setProperty(Messages.getString("LibConfig.71"), noRow); //$NON-NLS-1$
			pro.setProperty(Messages.getString("LibConfig.72"), Host); //$NON-NLS-1$
			pro.setProperty(Messages.getString("LibConfig.73"), Port); //$NON-NLS-1$
			pro.setProperty(Messages.getString("LibConfig.74"), Email); //$NON-NLS-1$
			pro.setProperty(Messages.getString("LibConfig.75"), //$NON-NLS-1$
					LibPassword.getInstance().encryptPass(Pass));
			pro.store(new FileOutputStream(f),
					Messages.getString("LibConfig.76")); //$NON-NLS-1$

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
