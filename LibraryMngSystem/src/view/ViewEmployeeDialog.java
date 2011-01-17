/*
 * Created by JFormDesigner on Mon Jan 17 18:07:59 GMT+07:00 2011
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 * @author Nanette G Hutchison
 */
public class ViewEmployeeDialog extends JDialog {
	public ViewEmployeeDialog(Frame owner) {
		super(owner, true);
		initComponents();
	}

	public ViewEmployeeDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	/**
	 * @return the lblName
	 */
	public JLabel getLblName() {
		return lblName;
	}

	/**
	 * @param lblName
	 *            the lblName to set
	 */
	public void setLblName(JLabel lblName) {
		this.lblName = lblName;
	}

	/**
	 * @return the lblID
	 */
	public JLabel getLblID() {
		return lblID;
	}

	/**
	 * @param lblID
	 *            the lblID to set
	 */
	public void setLblID(JLabel lblID) {
		this.lblID = lblID;
	}

	/**
	 * @return the lblDOB
	 */
	public JLabel getLblDOB() {
		return lblDOB;
	}

	/**
	 * @param lblDOB
	 *            the lblDOB to set
	 */
	public void setLblDOB(JLabel lblDOB) {
		this.lblDOB = lblDOB;
	}

	/**
	 * @return the lblGender
	 */
	public JLabel getLblGender() {
		return lblGender;
	}

	/**
	 * @param lblGender
	 *            the lblGender to set
	 */
	public void setLblGender(JLabel lblGender) {
		this.lblGender = lblGender;
	}

	/**
	 * @return the lblEmail
	 */
	public JLabel getLblEmail() {
		return lblEmail;
	}

	/**
	 * @param lblEmail
	 *            the lblEmail to set
	 */
	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	/**
	 * @return the lblDepart
	 */
	public JLabel getLblDepart() {
		return lblDepart;
	}

	/**
	 * @param lblDepart
	 *            the lblDepart to set
	 */
	public void setLblDepart(JLabel lblDepart) {
		this.lblDepart = lblDepart;
	}

	/**
	 * @return the lblAdd
	 */
	public JLabel getLblAdd() {
		return lblAdd;
	}

	/**
	 * @param lblAdd
	 *            the lblAdd to set
	 */
	public void setLblAdd(JLabel lblAdd) {
		this.lblAdd = lblAdd;
	}

	/**
	 * @return the lblPhone
	 */
	public JLabel getLblPhone() {
		return lblPhone;
	}

	/**
	 * @param lblPhone
	 *            the lblPhone to set
	 */
	public void setLblPhone(JLabel lblPhone) {
		this.lblPhone = lblPhone;
	}

	/**
	 * @return the lblPermission
	 */
	public JLabel getLblPermission() {
		return lblPermission;
	}

	/**
	 * @param lblPermission
	 *            the lblPermission to set
	 */
	public void setLblPermission(JLabel lblPermission) {
		this.lblPermission = lblPermission;
	}

	/**
	 * @return the tblBor
	 */
	public JTable getTblBor() {
		return tblBor;
	}

	/**
	 * @param tblBor
	 *            the tblBor to set
	 */
	public void setTblBor(JTable tblBor) {
		this.tblBor = tblBor;
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

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		panel1 = new JPanel();
		label10 = new JLabel();
		lblID = new JLabel();
		label9 = new JLabel();
		lblName = new JLabel();
		label2 = new JLabel();
		lblDOB = new JLabel();
		label3 = new JLabel();
		lblGender = new JLabel();
		label4 = new JLabel();
		lblEmail = new JLabel();
		label5 = new JLabel();
		lblDepart = new JLabel();
		label6 = new JLabel();
		lblAdd = new JLabel();
		label7 = new JLabel();
		lblPhone = new JLabel();
		label8 = new JLabel();
		lblPermission = new JLabel();
		label1 = new JLabel();
		scrollPane1 = new JScrollPane();
		tblBor = new JTable();
		btnClose = new JButton();

		// ======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout) contentPane.getLayout()).columnWidths = new int[] { 0,
				0, 0 };
		((GridBagLayout) contentPane.getLayout()).rowHeights = new int[] { 243,
				0, 0, 0 };
		((GridBagLayout) contentPane.getLayout()).columnWeights = new double[] {
				0.0, 1.0, 1.0E-4 };
		((GridBagLayout) contentPane.getLayout()).rowWeights = new double[] {
				0.0, 1.0, 0.0, 1.0E-4 };

		// ======== panel1 ========
		{
			panel1.setBorder(new CompoundBorder(new TitledBorder(
					"Employee Information"), new EmptyBorder(5, 5, 5, 5)));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout) panel1.getLayout()).columnWidths = new int[] { 0,
					384, 0 };
			((GridBagLayout) panel1.getLayout()).rowHeights = new int[] { 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0 };
			((GridBagLayout) panel1.getLayout()).columnWeights = new double[] {
					0.0, 1.0, 1.0E-4 };
			((GridBagLayout) panel1.getLayout()).rowWeights = new double[] {
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };

			// ---- label10 ----
			label10.setText("Employee No:");
			panel1.add(label10, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label9 ----
			label9.setText("Name:");
			panel1.add(label9, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblName, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label2 ----
			label2.setText("Date of birth:");
			panel1.add(label2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblDOB, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label3 ----
			label3.setText("Gender:");
			panel1.add(label3, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblGender, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label4 ----
			label4.setText("Email:");
			panel1.add(label4, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblEmail, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label5 ----
			label5.setText("Department:");
			panel1.add(label5, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblDepart, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label6 ----
			label6.setText("Address:");
			panel1.add(label6, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblAdd, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label7 ----
			label7.setText("Phone:");
			panel1.add(label7, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblPhone, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label8 ----
			label8.setText("Permission:");
			panel1.add(label8, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 0, 5), 0, 0));
			panel1.add(lblPermission, new GridBagConstraints(1, 8, 1, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 5, 0), 0, 0));

		// ---- label1 ----
		label1.setIcon(new ImageIcon(getClass().getResource(
				"/view/images/labelImages/InfoEmp.png")));
		contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 5, 5), 0, 0));

		// ======== scrollPane1 ========
		{
			scrollPane1
					.setBorder(new TitledBorder("Employee's Borrow Details"));

			// ---- tblBor ----
			tblBor.setModel(new DefaultTableModel(2, 0));
			scrollPane1.setViewportView(tblBor);
		}
		contentPane.add(scrollPane1, new GridBagConstraints(0, 1, 2, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- btnClose ----
		btnClose.setText("Close");
		contentPane.add(btnClose, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 0), 0, 0));
		setSize(680, 485);
		setLocationRelativeTo(null);
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JPanel panel1;
	private JLabel label10;
	private JLabel lblID;
	private JLabel label9;
	private JLabel lblName;
	private JLabel label2;
	private JLabel lblDOB;
	private JLabel label3;
	private JLabel lblGender;
	private JLabel label4;
	private JLabel lblEmail;
	private JLabel label5;
	private JLabel lblDepart;
	private JLabel label6;
	private JLabel lblAdd;
	private JLabel label7;
	private JLabel lblPhone;
	private JLabel label8;
	private JLabel lblPermission;
	private JLabel label1;
	private JScrollPane scrollPane1;
	private JTable tblBor;
	private JButton btnClose;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
