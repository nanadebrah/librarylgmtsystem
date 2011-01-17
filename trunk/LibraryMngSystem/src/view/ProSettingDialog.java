/*
 * Created by JFormDesigner on Mon Jan 17 16:40:02 GMT+07:00 2011
 */

package view;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.skin.SkinInfo;

/**
 * @author Nanette G Hutchison
 */
public class ProSettingDialog extends JDialog {
	public ProSettingDialog(Frame owner) {
		super(owner, true);
		initComponents();
	}

	public ProSettingDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	/**
	 * @return the spinNoRow
	 */
	public JSpinner getSpinNoRow() {
		return spinNoRow;
	}

	/**
	 * @param spinNoRow
	 *            the spinNoRow to set
	 */
	public void setSpinNoRow(JSpinner spinNoRow) {
		this.spinNoRow = spinNoRow;
	}

	/**
	 * @return the cbxTheme
	 */
	public JComboBox getCbxTheme() {
		return cbxTheme;
	}

	/**
	 * @param cbxTheme
	 *            the cbxTheme to set
	 */
	public void setCbxTheme(JComboBox cbxTheme) {
		this.cbxTheme = cbxTheme;
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
	 * @return the txtEmail
	 */
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	/**
	 * @param txtEmail
	 *            the txtEmail to set
	 */
	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
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
	 * @return the btnCancel
	 */
	public JButton getBtnCancel() {
		return btnCancel;
	}

	/**
	 * @param btnCancel
	 *            the btnCancel to set
	 */
	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		label1 = new JLabel();
		panel1 = new JPanel();
		label2 = new JLabel();
		spinNoRow = new JSpinner();
		label3 = new JLabel();
		cbxTheme = new javax.swing.JComboBox(new Vector<SkinInfo>(
				SubstanceLookAndFeel.getAllSkins().values()));
		label4 = new JLabel();
		txtHost = new JTextField();
		label5 = new JLabel();
		txtPort = new JTextField();
		label6 = new JLabel();
		txtEmail = new JTextField();
		label7 = new JLabel();
		txtPass = new JPasswordField();
		panel3 = new JPanel();
		lblStatus = new JLabel();
		btnCheck = new JButton();
		btnDefault = new JButton();
		btnSave = new JButton();
		btnCancel = new JButton();

		// ======== this ========
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout) contentPane.getLayout()).columnWidths = new int[] {
				220, 0, 0 };
		((GridBagLayout) contentPane.getLayout()).rowHeights = new int[] { 257,
				29, 0 };
		((GridBagLayout) contentPane.getLayout()).columnWeights = new double[] {
				0.0, 1.0, 1.0E-4 };
		((GridBagLayout) contentPane.getLayout()).rowWeights = new double[] {
				0.0, 0.0, 1.0E-4 };

		// ---- label1 ----
		label1.setIcon(new ImageIcon(getClass().getResource(
				"/view/images/labelImages/Setting.png")));
		contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 5, 5), 0, 0));

		// ======== panel1 ========
		{
			panel1.setBorder(new CompoundBorder(new TitledBorder(
					"Program Setting"), new EmptyBorder(5, 5, 5, 5)));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout) panel1.getLayout()).columnWidths = new int[] { 0,
					155, 0 };
			((GridBagLayout) panel1.getLayout()).rowHeights = new int[] { 0, 0,
					0, 0, 0, 0, 0 };
			((GridBagLayout) panel1.getLayout()).columnWeights = new double[] {
					0.0, 1.0, 1.0E-4 };
			((GridBagLayout) panel1.getLayout()).rowWeights = new double[] {
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };

			// ---- label2 ----
			label2.setText("No row a page:");
			panel1.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(spinNoRow, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label3 ----
			label3.setText("Themes:");
			panel1.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(cbxTheme, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label4 ----
			label4.setText("SMTP Host:");
			panel1.add(label4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtHost, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label5 ----
			label5.setText("Port:");
			panel1.add(label5, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtPort, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label6 ----
			label6.setText("Email:");
			panel1.add(label6, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtEmail, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label7 ----
			label7.setText("Password:");
			panel1.add(label7, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));
			panel1.add(txtPass, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 5, 0), 0, 0));

		// ======== panel3 ========
		{
			panel3.setLayout(new FlowLayout());
			panel3.add(lblStatus);

			// ---- btnCheck ----
			btnCheck.setText("Check Email");
			panel3.add(btnCheck);

			// ---- btnDefault ----
			btnDefault.setText("Default");
			panel3.add(btnDefault);

			// ---- btnSave ----
			btnSave.setText("Save");
			panel3.add(btnSave);

			// ---- btnCancel ----
			btnCancel.setText("Cancel");
			panel3.add(btnCancel);
		}
		contentPane.add(panel3, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0));
		setSize(540, 330);
		setLocationRelativeTo(null);
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JLabel label1;
	private JPanel panel1;
	private JLabel label2;
	private JSpinner spinNoRow;
	private JLabel label3;
	private JComboBox cbxTheme;
	private JLabel label4;
	private JTextField txtHost;
	private JLabel label5;
	private JTextField txtPort;
	private JLabel label6;
	private JTextField txtEmail;
	private JLabel label7;
	private JPasswordField txtPass;
	private JPanel panel3;
	private JLabel lblStatus;
	private JButton btnCheck;
	private JButton btnDefault;
	private JButton btnSave;
	private JButton btnCancel;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
