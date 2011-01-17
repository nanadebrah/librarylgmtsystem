/*
 * Created by JFormDesigner on Mon Jan 17 16:08:02 GMT+07:00 2011
 */

package view;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.JXDatePicker;

/**
 * @author Nanette G Hutchison
 */
public class AddEmployeeDialog extends JDialog {
	public AddEmployeeDialog(Frame owner) {
		super(owner, true);
		initComponents();
	}

	public AddEmployeeDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	/**
	 * @return the txtName
	 */
	public JTextField getTxtName() {
		return txtName;
	}

	/**
	 * @param txtName
	 *            the txtName to set
	 */
	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	/**
	 * @return the rdbMale
	 */
	public JRadioButton getRdbMale() {
		return rdbMale;
	}

	/**
	 * @param rdbMale
	 *            the rdbMale to set
	 */
	public void setRdbMale(JRadioButton rdbMale) {
		this.rdbMale = rdbMale;
	}

	/**
	 * @return the rdbFemale
	 */
	public JRadioButton getRdbFemale() {
		return rdbFemale;
	}

	/**
	 * @param rdbFemale
	 *            the rdbFemale to set
	 */
	public void setRdbFemale(JRadioButton rdbFemale) {
		this.rdbFemale = rdbFemale;
	}

	/**
	 * @return the txtDOB
	 */
	public JXDatePicker getTxtDOB() {
		return txtDOB;
	}

	/**
	 * @param txtDOB
	 *            the txtDOB to set
	 */
	public void setTxtDOB(JXDatePicker txtDOB) {
		this.txtDOB = txtDOB;
	}

	/**
	 * @return the txtAdd
	 */
	public JTextField getTxtAdd() {
		return txtAdd;
	}

	/**
	 * @param txtAdd
	 *            the txtAdd to set
	 */
	public void setTxtAdd(JTextField txtAdd) {
		this.txtAdd = txtAdd;
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
	 * @return the txtPhone
	 */
	public JTextField getTxtPhone() {
		return txtPhone;
	}

	/**
	 * @param txtPhone
	 *            the txtPhone to set
	 */
	public void setTxtPhone(JTextField txtPhone) {
		this.txtPhone = txtPhone;
	}

	/**
	 * @return the txtDepart
	 */
	public JTextField getTxtDepart() {
		return txtDepart;
	}

	/**
	 * @param txtDepart
	 *            the txtDepart to set
	 */
	public void setTxtDepart(JTextField txtDepart) {
		this.txtDepart = txtDepart;
	}

	/**
	 * @return the cbxPermission
	 */
	public JComboBox getCbxPermission() {
		return cbxPermission;
	}

	/**
	 * @param cbxPermission
	 *            the cbxPermission to set
	 */
	public void setCbxPermission(JComboBox cbxPermission) {
		this.cbxPermission = cbxPermission;
	}

	/**
	 * @return the btnAdd
	 */
	public JButton getBtnAdd() {
		return btnAdd;
	}

	/**
	 * @param btnAdd
	 *            the btnAdd to set
	 */
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
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
		txtName = new JTextField();
		label3 = new JLabel();
		rdbMale = new JRadioButton();
		rdbFemale = new JRadioButton();
		label4 = new JLabel();
		txtDOB = new JXDatePicker();
		label5 = new JLabel();
		txtAdd = new JTextField();
		label6 = new JLabel();
		txtPass = new JPasswordField();
		label7 = new JLabel();
		txtEmail = new JTextField();
		label8 = new JLabel();
		txtPhone = new JTextField();
		label9 = new JLabel();
		txtDepart = new JTextField();
		label10 = new JLabel();
		cbxPermission = new JComboBox();
		btnAdd = new JButton();
		btnCancel = new JButton();

		// ======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout) contentPane.getLayout()).columnWidths = new int[] {
				173, 0, 0 };
		((GridBagLayout) contentPane.getLayout()).rowHeights = new int[] { 372,
				0 };
		((GridBagLayout) contentPane.getLayout()).columnWeights = new double[] {
				0.0, 1.0, 1.0E-4 };
		((GridBagLayout) contentPane.getLayout()).rowWeights = new double[] {
				0.0, 1.0E-4 };

		// ---- label1 ----
		label1.setIcon(new ImageIcon(getClass().getResource(
				"/view/images/labelImages/AddEmp.png")));
		contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 5), 0, 0));

		// ======== panel1 ========
		{
			panel1.setBorder(new CompoundBorder(new TitledBorder(
					"Employee Information"), new EmptyBorder(5, 5, 5, 5)));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout) panel1.getLayout()).columnWidths = new int[] { 0,
					98, 125, 0 };
			((GridBagLayout) panel1.getLayout()).rowHeights = new int[] { 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0, 0 };
			((GridBagLayout) panel1.getLayout()).columnWeights = new double[] {
					0.0, 0.0, 1.0, 1.0E-4 };
			((GridBagLayout) panel1.getLayout()).rowWeights = new double[] {
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };

			// ---- label2 ----
			label2.setText("Name:");
			panel1.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtName, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label3 ----
			label3.setText("Gender:");
			panel1.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- rdbMale ----
			rdbMale.setText("Male");
			rdbMale.setSelected(true);
			panel1.add(rdbMale, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- rdbFemale ----
			rdbFemale.setText("Female");
			panel1.add(rdbFemale, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label4 ----
			label4.setText("Date of birth:");
			panel1.add(label4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtDOB, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label5 ----
			label5.setText("Address:");
			panel1.add(label5, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtAdd, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
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

			// ---- label7 ----
			label7.setText("Email:");
			panel1.add(label7, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtEmail, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label8 ----
			label8.setText("Phone:");
			panel1.add(label8, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtPhone, new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label9 ----
			label9.setText("Department:");
			panel1.add(label9, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtDepart, new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label10 ----
			label10.setText("Permission:");
			panel1.add(label10, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- cbxPermission ----
			cbxPermission.setModel(new DefaultComboBoxModel(new String[] {
					"Librarian", "Employee" }));
			panel1.add(cbxPermission, new GridBagConstraints(1, 8, 2, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- btnAdd ----
			btnAdd.setText("Add");
			panel1.add(btnAdd, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0,
					GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 0, 5), 0, 0));

			// ---- btnCancel ----
			btnCancel.setText("Cancel");
			panel1.add(btnCancel, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		setSize(515, 395);
		setLocationRelativeTo(null);

		// ---- buttonGroup1 ----
		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(rdbMale);
		buttonGroup1.add(rdbFemale);
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JLabel label1;
	private JPanel panel1;
	private JLabel label2;
	private JTextField txtName;
	private JLabel label3;
	private JRadioButton rdbMale;
	private JRadioButton rdbFemale;
	private JLabel label4;
	private JXDatePicker txtDOB;
	private JLabel label5;
	private JTextField txtAdd;
	private JLabel label6;
	private JPasswordField txtPass;
	private JLabel label7;
	private JTextField txtEmail;
	private JLabel label8;
	private JTextField txtPhone;
	private JLabel label9;
	private JTextField txtDepart;
	private JLabel label10;
	private JComboBox cbxPermission;
	private JButton btnAdd;
	private JButton btnCancel;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
