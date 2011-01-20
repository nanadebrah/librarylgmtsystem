package view;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;

/**
 * @author CuongNQ
 */
@SuppressWarnings("serial")
public class AddBookDialog extends JDialog {
	public AddBookDialog(Frame owner) {
		super(owner, true);
		initComponents();
	}

	public AddBookDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	private void initComponents() {
		// Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		label1 = new JLabel();
		panel1 = new JPanel();
		label2 = new JLabel();
		txtISBN = new JFormattedTextField();
		label3 = new JLabel();
		txtTitle = new JTextField();
		label4 = new JLabel();
		txtAuthor = new JTextField();
		label5 = new JLabel();
		txtPublisher = new JTextField();
		label6 = new JLabel();
		spinCopy = new JSpinner();
		label8 = new JLabel();
		spinLib = new JSpinner();
		label7 = new JLabel();
		cbxSub = new JComboBox();
		btnAdd = new JButton();
		btnCancel = new JButton();

		// ======== this ========
		setMinimumSize(new Dimension(500, 300));
		setResizable(false);
		setTitle("Add Book");
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout) contentPane.getLayout()).columnWidths = new int[] {
				178, 384, 0 };
		((GridBagLayout) contentPane.getLayout()).rowHeights = new int[] { 0, 0 };
		((GridBagLayout) contentPane.getLayout()).columnWeights = new double[] {
				0.0, 1.0, 1.0E-4 };
		((GridBagLayout) contentPane.getLayout()).rowWeights = new double[] {
				1.0, 1.0E-4 };

		// ---- label1 ----
		label1.setIcon(new ImageIcon(getClass().getResource(
				"/view/images/labelImages/AddBook.png")));
		contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));

		// ======== panel1 ========
		{
			panel1.setBorder(new CompoundBorder(new TitledBorder(
					new CompoundBorder(new EmptyBorder(5, 5, 5, 5),
							new BorderUIResource.EtchedBorderUIResource()),
					"Book Information"), new EmptyBorder(5, 5, 5, 5)));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout) panel1.getLayout()).columnWidths = new int[] { 0,
					64, 95, 69, 0 };
			((GridBagLayout) panel1.getLayout()).rowHeights = new int[] { 0, 0,
					0, 0, 0, 0, 0, 0 };
			((GridBagLayout) panel1.getLayout()).columnWeights = new double[] {
					0.0, 0.0, 1.0, 0.0, 1.0E-4 };
			((GridBagLayout) panel1.getLayout()).rowWeights = new double[] {
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };

			// ---- label2 ----
			label2.setText("ISBN:");
			panel1.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- txtISBN ----
			try {
				txtISBN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(
						new javax.swing.text.MaskFormatter("###-####")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			txtISBN.setToolTipText("International Standard Book Number");
			panel1.add(txtISBN, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label3 ----
			label3.setText("Title:");
			panel1.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- txtTitle ----
			txtTitle.setToolTipText("Title of book");
			panel1.add(txtTitle, new GridBagConstraints(1, 1, 3, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label4 ----
			label4.setText("Author:");
			panel1.add(label4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- txtAuthor ----
			txtAuthor.setToolTipText("Auther of book");
			panel1.add(txtAuthor, new GridBagConstraints(1, 2, 3, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label5 ----
			label5.setText("Publisher:");
			panel1.add(label5, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- txtPublisher ----
			txtPublisher.setToolTipText("Publisher of book");
			panel1.add(txtPublisher, new GridBagConstraints(1, 3, 3, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label6 ----
			label6.setText("No of copies:");
			panel1.add(label6, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- spinCopy ----
			spinCopy.setToolTipText("Number of book copies");
			panel1.add(spinCopy, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- label8 ----
			label8.setText("No in library:");
			panel1.add(label8, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- spinLib ----
			spinLib.setEnabled(false);
			spinLib.setToolTipText("Number of book in library");
			panel1.add(spinLib, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label7 ----
			label7.setText("Subject:");
			panel1.add(label7, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(cbxSub, new GridBagConstraints(1, 5, 3, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- btnAdd ----
			btnAdd.setText("Add");
			panel1.add(btnAdd, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

			// ---- btnCancel ----
			btnCancel.setText("Cancel");
			panel1.add(btnCancel, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 0, 5), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		setSize(555, 310);
		setLocationRelativeTo(null);
		// End of component initialization
		// //GEN-END:initComponents
	}

	// Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JLabel label1;
	private JPanel panel1;
	private JLabel label2;
	private JFormattedTextField txtISBN;
	private JLabel label3;
	private JTextField txtTitle;
	private JLabel label4;
	private JTextField txtAuthor;
	private JLabel label5;
	private JTextField txtPublisher;
	private JLabel label6;
	private JSpinner spinCopy;
	private JLabel label8;
	private JSpinner spinLib;
	private JLabel label7;
	private JComboBox cbxSub;
	private JButton btnAdd;
	private JButton btnCancel;

	// End of variables declaration //GEN-END:variables
	/**
	 * @return the txtISBN
	 */
	public JFormattedTextField getTxtISBN() {
		return txtISBN;
	}

	/**
	 * @param txtISBN
	 *            the txtISBN to set
	 */
	public void setTxtISBN(JFormattedTextField txtISBN) {
		this.txtISBN = txtISBN;
	}

	/**
	 * @return the txtTitle
	 */
	public JTextField getTxtTitle() {
		return txtTitle;
	}

	/**
	 * @param txtTitle
	 *            the txtTitle to set
	 */
	public void setTxtTitle(JTextField txtTitle) {
		this.txtTitle = txtTitle;
	}

	/**
	 * @return the txtAuthor
	 */
	public JTextField getTxtAuthor() {
		return txtAuthor;
	}

	/**
	 * @param txtAuthor
	 *            the txtAuthor to set
	 */
	public void setTxtAuthor(JTextField txtAuthor) {
		this.txtAuthor = txtAuthor;
	}

	/**
	 * @return the txtPublisher
	 */
	public JTextField getTxtPublisher() {
		return txtPublisher;
	}

	/**
	 * @param txtPublisher
	 *            the txtPublisher to set
	 */
	public void setTxtPublisher(JTextField txtPublisher) {
		this.txtPublisher = txtPublisher;
	}

	/**
	 * @return the spinCopy
	 */
	public JSpinner getSpinCopy() {
		return spinCopy;
	}

	/**
	 * @param spinCopy
	 *            the spinCopy to set
	 */
	public void setSpinCopy(JSpinner spinCopy) {
		this.spinCopy = spinCopy;
	}

	/**
	 * @return the spinLib
	 */
	public JSpinner getSpinLib() {
		return spinLib;
	}

	/**
	 * @param spinLib
	 *            the spinLib to set
	 */
	public void setSpinLib(JSpinner spinLib) {
		this.spinLib = spinLib;
	}

	/**
	 * @return the cbxSub
	 */
	public JComboBox getCbxSub() {
		return cbxSub;
	}

	/**
	 * @param cbxSub
	 *            the cbxSub to set
	 */
	public void setCbxSub(JComboBox cbxSub) {
		this.cbxSub = cbxSub;
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
}
