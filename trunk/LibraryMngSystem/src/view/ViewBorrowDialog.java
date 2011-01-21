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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;

/**
 * @author CuongNQ
 */
@SuppressWarnings("serial")
public class ViewBorrowDialog extends JDialog {
	public ViewBorrowDialog(Frame owner) {
		super(owner, true);
		initComponents();
	}

	public ViewBorrowDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	private void initComponents() {
		// Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		label1 = new JLabel();
		panel1 = new JPanel();
		label10 = new JLabel();
		lblEmpID = new JLabel();
		label17 = new JLabel();
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
		panel2 = new JPanel();
		label11 = new JLabel();
		lblBorID = new JLabel();
		label9 = new JLabel();
		lblCallNo = new JLabel();
		label19 = new JLabel();
		lblIssueStatus = new JLabel();
		label12 = new JLabel();
		lblISBN = new JLabel();
		label20 = new JLabel();
		lblIssueDate = new JLabel();
		label13 = new JLabel();
		lblTitle = new JLabel();
		label21 = new JLabel();
		lblDueDate = new JLabel();
		label14 = new JLabel();
		lblAuthor = new JLabel();
		label22 = new JLabel();
		lblReturnDate = new JLabel();
		label15 = new JLabel();
		lblPublish = new JLabel();
		label23 = new JLabel();
		lblFee = new JLabel();
		label16 = new JLabel();
		lblSubject = new JLabel();
		btnClose = new JButton();

		//======== this ========
		setTitle("Details Of Borrow");
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {234, 169, 0, 0};
		((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

		//---- label1 ----
		label1.setIcon(new ImageIcon(getClass().getResource("/view/images/labelImages/InfoBorrow.png")));
		contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.NONE,
			new Insets(0, 0, 5, 5), 0, 0));

		//======== panel1 ========
		{
			panel1.setBorder(new CompoundBorder(
				new TitledBorder(new CompoundBorder(
					new EmptyBorder(5, 5, 5, 5),
					new BorderUIResource.EtchedBorderUIResource()), "Employee Information"),
				new EmptyBorder(5, 5, 5, 5)));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 397, 0};
			((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
			((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

			//---- label10 ----
			label10.setText("Employee No:");
			panel1.add(label10, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblEmpID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label17 ----
			label17.setText("Name:");
			panel1.add(label17, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblName, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label2 ----
			label2.setText("Date of birth:");
			panel1.add(label2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblDOB, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label3 ----
			label3.setText("Gender:");
			panel1.add(label3, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblGender, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label4 ----
			label4.setText("Email:");
			panel1.add(label4, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblEmail, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label5 ----
			label5.setText("Department:");
			panel1.add(label5, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblDepart, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label6 ----
			label6.setText("Address:");
			panel1.add(label6, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblAdd, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label7 ----
			label7.setText("Phone:");
			panel1.add(label7, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblPhone, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label8 ----
			label8.setText("Permission:");
			panel1.add(label8, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 5), 0, 0));
			panel1.add(lblPermission, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
			new Insets(0, 0, 5, 0), 0, 0));

		//======== panel2 ========
		{
			panel2.setBorder(new CompoundBorder(
				new TitledBorder(new CompoundBorder(
					new EmptyBorder(5, 5, 5, 5),
					new BorderUIResource.EtchedBorderUIResource()), "Book Information"),
				new EmptyBorder(5, 5, 5, 5)));
			panel2.setLayout(new GridBagLayout());
			((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 66, 0, 227, 0};
			((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
			((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0, 1.0E-4};
			((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};

			//---- label11 ----
			label11.setText("Borrow No:");
			panel2.add(label11, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
			panel2.add(lblBorID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- label9 ----
			label9.setText("Call Number:");
			panel2.add(label9, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel2.add(lblCallNo, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label19 ----
			label19.setText("Issue Status:");
			panel2.add(label19, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
			panel2.add(lblIssueStatus, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- label12 ----
			label12.setText("ISBN:");
			panel2.add(label12, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel2.add(lblISBN, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label20 ----
			label20.setText("Issue Date:");
			panel2.add(label20, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
			panel2.add(lblIssueDate, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- label13 ----
			label13.setText("Title:");
			panel2.add(label13, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel2.add(lblTitle, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label21 ----
			label21.setText("Due Date:");
			panel2.add(label21, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
			panel2.add(lblDueDate, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- label14 ----
			label14.setText("Author Name:");
			panel2.add(label14, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel2.add(lblAuthor, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label22 ----
			label22.setText("Return Date:");
			panel2.add(label22, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
			panel2.add(lblReturnDate, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- label15 ----
			label15.setText("Publisher:");
			panel2.add(label15, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 5, 5), 0, 0));
			panel2.add(lblPublish, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label23 ----
			label23.setText("Total Fee:");
			panel2.add(label23, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));
			panel2.add(lblFee, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));

			//---- label16 ----
			label16.setText("Subject:");
			panel2.add(label16, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 5), 0, 0));
			panel2.add(lblSubject, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel2, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 5, 0), 0, 0));

		//---- btnClose ----
		btnClose.setText("Close");
		contentPane.add(btnClose, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
			GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 0, 0), 0, 0));
		setSize(700, 470);
		setLocationRelativeTo(null);
		// //GEN-END:initComponents
	}

	// Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JLabel label1;
	private JPanel panel1;
	private JLabel label10;
	private JLabel lblEmpID;
	private JLabel label17;
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
	private JPanel panel2;
	private JLabel label11;
	private JLabel lblBorID;
	private JLabel label9;
	private JLabel lblCallNo;
	private JLabel label19;
	private JLabel lblIssueStatus;
	private JLabel label12;
	private JLabel lblISBN;
	private JLabel label20;
	private JLabel lblIssueDate;
	private JLabel label13;
	private JLabel lblTitle;
	private JLabel label21;
	private JLabel lblDueDate;
	private JLabel label14;
	private JLabel lblAuthor;
	private JLabel label22;
	private JLabel lblReturnDate;
	private JLabel label15;
	private JLabel lblPublish;
	private JLabel label23;
	private JLabel lblFee;
	private JLabel label16;
	private JLabel lblSubject;
	private JButton btnClose;
	// End of variables declaration //GEN-END:variables
	/**
	 * @return the lblEmpID
	 */
	public JLabel getLblEmpID() {
		return lblEmpID;
	}

	/**
	 * @param lblEmpID
	 *            the lblEmpID to set
	 */
	public void setLblEmpID(JLabel lblEmpID) {
		this.lblEmpID = lblEmpID;
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
	 * @return the lblBorID
	 */
	public JLabel getLblBorID() {
		return lblBorID;
	}

	/**
	 * @param lblBorID
	 *            the lblBorID to set
	 */
	public void setLblBorID(JLabel lblBorID) {
		this.lblBorID = lblBorID;
	}

	/**
	 * @return the lblCallNo
	 */
	public JLabel getLblCallNo() {
		return lblCallNo;
	}

	/**
	 * @param lblCallNo
	 *            the lblCallNo to set
	 */
	public void setLblCallNo(JLabel lblCallNo) {
		this.lblCallNo = lblCallNo;
	}

	/**
	 * @return the lblIssueStatus
	 */
	public JLabel getLblIssueStatus() {
		return lblIssueStatus;
	}

	/**
	 * @param lblIssueStatus
	 *            the lblIssueStatus to set
	 */
	public void setLblIssueStatus(JLabel lblIssueStatus) {
		this.lblIssueStatus = lblIssueStatus;
	}

	/**
	 * @return the lblISBN
	 */
	public JLabel getLblISBN() {
		return lblISBN;
	}

	/**
	 * @param lblISBN
	 *            the lblISBN to set
	 */
	public void setLblISBN(JLabel lblISBN) {
		this.lblISBN = lblISBN;
	}

	/**
	 * @return the lblIssueDate
	 */
	public JLabel getLblIssueDate() {
		return lblIssueDate;
	}

	/**
	 * @param lblIssueDate
	 *            the lblIssueDate to set
	 */
	public void setLblIssueDate(JLabel lblIssueDate) {
		this.lblIssueDate = lblIssueDate;
	}

	/**
	 * @return the lblTitle
	 */
	public JLabel getLblTitle() {
		return lblTitle;
	}

	/**
	 * @param lblTitle
	 *            the lblTitle to set
	 */
	public void setLblTitle(JLabel lblTitle) {
		this.lblTitle = lblTitle;
	}

	/**
	 * @return the lblDueDate
	 */
	public JLabel getLblDueDate() {
		return lblDueDate;
	}

	/**
	 * @param lblDueDate
	 *            the lblDueDate to set
	 */
	public void setLblDueDate(JLabel lblDueDate) {
		this.lblDueDate = lblDueDate;
	}

	/**
	 * @return the lblAuthor
	 */
	public JLabel getLblAuthor() {
		return lblAuthor;
	}

	/**
	 * @param lblAuthor
	 *            the lblAuthor to set
	 */
	public void setLblAuthor(JLabel lblAuthor) {
		this.lblAuthor = lblAuthor;
	}

	/**
	 * @return the lblReturnDate
	 */
	public JLabel getLblReturnDate() {
		return lblReturnDate;
	}

	/**
	 * @param lblReturnDate
	 *            the lblReturnDate to set
	 */
	public void setLblReturnDate(JLabel lblReturnDate) {
		this.lblReturnDate = lblReturnDate;
	}

	/**
	 * @return the lblPublish
	 */
	public JLabel getLblPublish() {
		return lblPublish;
	}

	/**
	 * @param lblPublish
	 *            the lblPublish to set
	 */
	public void setLblPublish(JLabel lblPublish) {
		this.lblPublish = lblPublish;
	}

	/**
	 * @return the lblFee
	 */
	public JLabel getLblFee() {
		return lblFee;
	}

	/**
	 * @param lblFee
	 *            the lblFee to set
	 */
	public void setLblFee(JLabel lblFee) {
		this.lblFee = lblFee;
	}

	/**
	 * @return the lblSubject
	 */
	public JLabel getLblSubject() {
		return lblSubject;
	}

	/**
	 * @param lblSubject
	 *            the lblSubject to set
	 */
	public void setLblSubject(JLabel lblSubject) {
		this.lblSubject = lblSubject;
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
}
