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
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;

/**
 * @author CuongNQ
 */
@SuppressWarnings("serial")
public class ViewBookDialog extends JDialog {
	public ViewBookDialog(Frame owner) {
		super(owner, true);
		initComponents();
	}

	public ViewBookDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	private void initComponents() {
		// Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		panel1 = new JPanel();
		label10 = new JLabel();
		lblID = new JLabel();
		label2 = new JLabel();
		lblCallNo = new JLabel();
		label3 = new JLabel();
		lblISBN = new JLabel();
		label4 = new JLabel();
		lblTitle = new JLabel();
		label5 = new JLabel();
		lblAuthor = new JLabel();
		label6 = new JLabel();
		lblPublish = new JLabel();
		label7 = new JLabel();
		lblSubject = new JLabel();
		label8 = new JLabel();
		lblCopy = new JLabel();
		label9 = new JLabel();
		lblLib = new JLabel();
		label1 = new JLabel();
		scrollPane1 = new JScrollPane();
		tblBor = new JTable();
		btnClose = new JButton();

		// ======== this ========
		setTitle("Details Of Book");
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout) contentPane.getLayout()).columnWidths = new int[] {
				207, 500, 0 };
		((GridBagLayout) contentPane.getLayout()).rowHeights = new int[] { 234,
				0, 0, 0 };
		((GridBagLayout) contentPane.getLayout()).columnWeights = new double[] {
				0.0, 1.0, 1.0E-4 };
		((GridBagLayout) contentPane.getLayout()).rowWeights = new double[] {
				0.0, 1.0, 0.0, 1.0E-4 };

		// ======== panel1 ========
		{
			panel1.setBorder(new CompoundBorder(new TitledBorder(
					new CompoundBorder(new EmptyBorder(5, 5, 5, 5),
							new BorderUIResource.EtchedBorderUIResource()),
					"Book Information"), new EmptyBorder(5, 5, 5, 5)));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout) panel1.getLayout()).columnWidths = new int[] { 0,
					417, 0 };
			((GridBagLayout) panel1.getLayout()).rowHeights = new int[] { 0, 0,
					0, 0, 0, 0, 0, 0, 0, 0 };
			((GridBagLayout) panel1.getLayout()).columnWeights = new double[] {
					0.0, 1.0, 1.0E-4 };
			((GridBagLayout) panel1.getLayout()).rowWeights = new double[] {
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };

			// ---- label10 ----
			label10.setText("Book No:");
			panel1.add(label10, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label2 ----
			label2.setText("Call Number:");
			panel1.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblCallNo, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label3 ----
			label3.setText("ISBN:");
			panel1.add(label3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblISBN, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label4 ----
			label4.setText("Title:");
			panel1.add(label4, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblTitle, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label5 ----
			label5.setText("Author Name:");
			panel1.add(label5, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblAuthor, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label6 ----
			label6.setText("Publisher:");
			panel1.add(label6, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblPublish, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label7 ----
			label7.setText("Subject:");
			panel1.add(label7, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblSubject, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label8 ----
			label8.setText("No of copies:");
			panel1.add(label8, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(lblCopy, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label9 ----
			label9.setText("No in Library:");
			panel1.add(label9, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 0, 5), 0, 0));
			panel1.add(lblLib, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 5, 0), 0, 0));

		// ---- label1 ----
		label1.setIcon(new ImageIcon(getClass().getResource(
				"/view/images/labelImages/InfoBook.png")));
		contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 5, 5), 0, 0));

		// ======== scrollPane1 ========
		{
			scrollPane1.setBorder(new TitledBorder(new CompoundBorder(
					new EmptyBorder(5, 5, 5, 5),
					new BorderUIResource.EtchedBorderUIResource()),
					"Book's Borrow Details"));

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
		setSize(745, 495);
		setLocationRelativeTo(null);
		// End of component initialization
		// //GEN-END:initComponents
	}

	// Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JPanel panel1;
	private JLabel label10;
	private JLabel lblID;
	private JLabel label2;
	private JLabel lblCallNo;
	private JLabel label3;
	private JLabel lblISBN;
	private JLabel label4;
	private JLabel lblTitle;
	private JLabel label5;
	private JLabel lblAuthor;
	private JLabel label6;
	private JLabel lblPublish;
	private JLabel label7;
	private JLabel lblSubject;
	private JLabel label8;
	private JLabel lblCopy;
	private JLabel label9;
	private JLabel lblLib;
	private JLabel label1;
	private JScrollPane scrollPane1;
	private JTable tblBor;
	private JButton btnClose;

	// End of variables declaration //GEN-END:variables
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
	 * @return the lblCopy
	 */
	public JLabel getLblCopy() {
		return lblCopy;
	}

	/**
	 * @param lblCopy
	 *            the lblCopy to set
	 */
	public void setLblCopy(JLabel lblCopy) {
		this.lblCopy = lblCopy;
	}

	/**
	 * @return the lblLib
	 */
	public JLabel getLblLib() {
		return lblLib;
	}

	/**
	 * @param lblLib
	 *            the lblLib to set
	 */
	public void setLblLib(JLabel lblLib) {
		this.lblLib = lblLib;
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
}
