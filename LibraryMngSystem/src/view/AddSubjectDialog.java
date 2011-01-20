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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;

/**
 * @author CuongNQ
 */
@SuppressWarnings("serial")
public class AddSubjectDialog extends JDialog {
	public AddSubjectDialog(Frame owner) {
		super(owner, true);
		initComponents();
	}

	public AddSubjectDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	private void initComponents() {
		// Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		label1 = new JLabel();
		panel1 = new JPanel();
		label2 = new JLabel();
		txtName = new JTextField();
		label3 = new JLabel();
		scrollPane1 = new JScrollPane();
		txtDes = new JTextPane();
		btnAdd = new JButton();
		btnCancel = new JButton();

		// ======== this ========
		setTitle("Add Subject");
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout) contentPane.getLayout()).columnWidths = new int[] { 0,
				312, 0 };
		((GridBagLayout) contentPane.getLayout()).rowHeights = new int[] { 0, 0 };
		((GridBagLayout) contentPane.getLayout()).columnWeights = new double[] {
				0.0, 1.0, 1.0E-4 };
		((GridBagLayout) contentPane.getLayout()).rowWeights = new double[] {
				1.0, 1.0E-4 };

		// ---- label1 ----
		label1.setIcon(new ImageIcon(getClass().getResource(
				"/view/images/labelImages/AddSub.png")));
		contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 5), 0, 0));

		// ======== panel1 ========
		{
			panel1.setBorder(new CompoundBorder(new TitledBorder(
					new CompoundBorder(new EmptyBorder(5, 5, 5, 5),
							new BorderUIResource.EtchedBorderUIResource()),
					"Book Information"), new EmptyBorder(5, 5, 5, 5)));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout) panel1.getLayout()).columnWidths = new int[] { 0,
					140, 0, 0 };
			((GridBagLayout) panel1.getLayout()).rowHeights = new int[] { 0,
					124, 0, 0 };
			((GridBagLayout) panel1.getLayout()).columnWeights = new double[] {
					0.0, 1.0, 0.0, 1.0E-4 };
			((GridBagLayout) panel1.getLayout()).rowWeights = new double[] {
					0.0, 0.0, 0.0, 1.0E-4 };

			// ---- label2 ----
			label2.setText("Subject Name:");
			panel1.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

			// ---- txtName ----
			txtName.setToolTipText("Subject name");
			panel1.add(txtName, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label3 ----
			label3.setText("Description:");
			panel1.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

			// ======== scrollPane1 ========
			{

				// ---- txtDes ----
				txtDes.setToolTipText("About details of subject");
				scrollPane1.setViewportView(txtDes);
			}
			panel1.add(scrollPane1, new GridBagConstraints(1, 1, 2, 1, 0.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- btnAdd ----
			btnAdd.setText("Add");
			panel1.add(btnAdd, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 0, 5), 0, 0));

			// ---- btnCancel ----
			btnCancel.setText("Cancel");
			panel1.add(btnCancel, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		setSize(515, 265);
		setLocationRelativeTo(null);
		// End of component initialization
		// //GEN-END:initComponents
	}

	// Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JLabel label1;
	private JPanel panel1;
	private JLabel label2;
	private JTextField txtName;
	private JLabel label3;
	private JScrollPane scrollPane1;
	private JTextPane txtDes;
	private JButton btnAdd;
	private JButton btnCancel;

	// End of variables declaration //GEN-END:variables
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
	 * @return the txtDes
	 */
	public JTextPane getTxtDes() {
		return txtDes;
	}

	/**
	 * @param txtDes
	 *            the txtDes to set
	 */
	public void setTxtDes(JTextPane txtDes) {
		this.txtDes = txtDes;
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
