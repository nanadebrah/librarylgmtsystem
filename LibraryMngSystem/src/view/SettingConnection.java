/*
 * Created by JFormDesigner on Mon Jan 17 17:03:03 GMT+07:00 2011
 */

package view;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.LibImages;

/**
 * @author Nanette G Hutchison
 */
public class SettingConnection extends JDialog {
	public SettingConnection(Frame owner) {
		super(owner, true);
		initComponents();
	}

	public SettingConnection(Dialog owner) {
		super(owner, true);
		initComponents();
	}

	/*
	 * Set image check connect
	 */
	public void setConnectImage(boolean check) {
		if (check) {
			lblImage.setIcon(new ImageIcon(getClass().getResource(
					LibImages.LABEL_CONNECT)));
		} else {
			lblImage.setIcon(new ImageIcon(getClass().getResource(
					LibImages.LABEL_CONNECTFAILED)));
		}
	}

	/**
	 * @return the lblStatus
	 */
	public JLabel getLblStatus() {
		return lblStatus;
	}

	/**
	 * @param lblStatus
	 *            the lblStatus to set
	 */
	public void setLblStatus(JLabel lblStatus) {
		this.lblStatus = lblStatus;
	}

	/**
	 * @return the txtHost
	 */
	public JTextField getTxtHost() {
		return txtHost;
	}

	/**
	 * @param txtHost
	 *            the txtHost to set
	 */
	public void setTxtHost(JTextField txtHost) {
		this.txtHost = txtHost;
	}

	/**
	 * @return the txtPort
	 */
	public JTextField getTxtPort() {
		return txtPort;
	}

	/**
	 * @param txtPort
	 *            the txtPort to set
	 */
	public void setTxtPort(JTextField txtPort) {
		this.txtPort = txtPort;
	}

	/**
	 * @return the txtData
	 */
	public JTextField getTxtData() {
		return txtData;
	}

	/**
	 * @param txtData
	 *            the txtData to set
	 */
	public void setTxtData(JTextField txtData) {
		this.txtData = txtData;
	}

	/**
	 * @return the txtUser
	 */
	public JTextField getTxtUser() {
		return txtUser;
	}

	/**
	 * @param txtUser
	 *            the txtUser to set
	 */
	public void setTxtUser(JTextField txtUser) {
		this.txtUser = txtUser;
	}

	/**
	 * @return the txtPass
	 */
	public JPasswordField getTxtPass() {
		return txtPass;
	}

	/**
	 * @param txtPass
	 *            the txtPass to set
	 */
	public void setTxtPass(JPasswordField txtPass) {
		this.txtPass = txtPass;
	}

	/**
	 * @return the btnDefault
	 */
	public JButton getBtnDefault() {
		return btnDefault;
	}

	/**
	 * @param btnDefault
	 *            the btnDefault to set
	 */
	public void setBtnDefault(JButton btnDefault) {
		this.btnDefault = btnDefault;
	}

	/**
	 * @return the btnSave
	 */
	public JButton getBtnSave() {
		return btnSave;
	}

	/**
	 * @param btnSave
	 *            the btnSave to set
	 */
	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	/**
	 * @return the btnClose
	 */
	public JButton getBtnClose() {
		return btnClose;
	}

	/**
	 * @param btnClose
	 *            the btnClose to set
	 */
	public void setBtnClose(JButton btnClose) {
		this.btnClose = btnClose;
	}

	/**
	 * @return the btnCheck
	 */
	public JButton getBtnCheck() {
		return btnCheck;
	}

	/**
	 * @param btnCheck
	 *            the btnCheck to set
	 */
	public void setBtnCheck(JButton btnCheck) {
		this.btnCheck = btnCheck;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		lblImage = new JLabel();
		panel1 = new JPanel();
		label2 = new JLabel();
		txtHost = new JTextField();
		label3 = new JLabel();
		txtPort = new JTextField();
		label4 = new JLabel();
		txtData = new JTextField();
		label5 = new JLabel();
		txtUser = new JTextField();
		label6 = new JLabel();
		txtPass = new JPasswordField();
		btnDefault = new JButton();
		btnSave = new JButton();
		btnClose = new JButton();
		btnCheck = new JButton();
		lblStatus = new JLabel();

		// ======== this ========
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout) contentPane.getLayout()).columnWidths = new int[] { 0,
				0, 0 };
		((GridBagLayout) contentPane.getLayout()).rowHeights = new int[] { 247,
				0, 0 };
		((GridBagLayout) contentPane.getLayout()).columnWeights = new double[] {
				0.0, 1.0, 1.0E-4 };
		((GridBagLayout) contentPane.getLayout()).rowWeights = new double[] {
				0.0, 0.0, 1.0E-4 };

		// ---- lblImage ----
		lblImage.setIcon(new ImageIcon(getClass().getResource(
				"/view/images/labelImages/Connect.png")));
		contentPane.add(lblImage, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 5, 5), 0, 0));

		// ======== panel1 ========
		{
			panel1.setBorder(new CompoundBorder(new TitledBorder(
					"Connection Setting"), new EmptyBorder(5, 5, 5, 5)));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout) panel1.getLayout()).columnWidths = new int[] { 0,
					0, 0, 0 };
			((GridBagLayout) panel1.getLayout()).rowHeights = new int[] { 0, 0,
					0, 0, 0, 0, 0 };
			((GridBagLayout) panel1.getLayout()).columnWeights = new double[] {
					0.0, 1.0, 0.0, 1.0E-4 };
			((GridBagLayout) panel1.getLayout()).rowWeights = new double[] {
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };

			// ---- label2 ----
			label2.setText("Host:");
			panel1.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtHost, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label3 ----
			label3.setText("Port:");
			panel1.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtPort, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label4 ----
			label4.setText("Database:");
			panel1.add(label4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtData, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label5 ----
			label5.setText("Username:");
			panel1.add(label5, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtUser, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label6 ----
			label6.setText("Password:");
			panel1.add(label6, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtPass, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- btnDefault ----
			btnDefault.setText("Default");
			panel1.add(btnDefault, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 0, 5), 0, 0));

			// ---- btnSave ----
			btnSave.setText("Save");
			panel1.add(btnSave, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

			// ---- btnClose ----
			btnClose.setText("Close");
			panel1.add(btnClose, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 5, 0), 0, 0));

		// ---- btnCheck ----
		btnCheck.setText("Check Connection");
		contentPane.add(btnCheck, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 5), 0, 0));
		contentPane.add(lblStatus, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 0), 0, 0));
		setSize(495, 305);
		setLocationRelativeTo(null);
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JLabel lblImage;
	private JPanel panel1;
	private JLabel label2;
	private JTextField txtHost;
	private JLabel label3;
	private JTextField txtPort;
	private JLabel label4;
	private JTextField txtData;
	private JLabel label5;
	private JTextField txtUser;
	private JLabel label6;
	private JPasswordField txtPass;
	private JButton btnDefault;
	private JButton btnSave;
	private JButton btnClose;
	private JButton btnCheck;
	private JLabel lblStatus;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
