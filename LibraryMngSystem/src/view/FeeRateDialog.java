/*
 * Created by JFormDesigner on Mon Jan 17 16:35:44 GMT+07:00 2011
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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * @author Nanette G Hutchison
 */
public class FeeRateDialog extends JDialog {
	public FeeRateDialog(Frame owner) {
		super(owner, true);
		initComponents();
	}

	public FeeRateDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	/**
	 * @return the txtFee
	 */
	public JFormattedTextField getTxtFee() {
		return txtFee;
	}

	/**
	 * @param txtFee
	 *            the txtFee to set
	 */
	public void setTxtFee(JFormattedTextField txtFee) {
		this.txtFee = txtFee;
	}

	/**
	 * @return the txtFine
	 */
	public JFormattedTextField getTxtFine() {
		return txtFine;
	}

	/**
	 * @param txtFine
	 *            the txtFine to set
	 */
	public void setTxtFine(JFormattedTextField txtFine) {
		this.txtFine = txtFine;
	}

	/**
	 * @return the btnChange
	 */
	public JButton getBtnChange() {
		return btnChange;
	}

	/**
	 * @param btnChange
	 *            the btnChange to set
	 */
	public void setBtnChange(JButton btnChange) {
		this.btnChange = btnChange;
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
		txtFee = new JFormattedTextField();
		label3 = new JLabel();
		txtFine = new JFormattedTextField();
		btnChange = new JButton();
		btnCancel = new JButton();

		// ======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout) contentPane.getLayout()).columnWidths = new int[] { 0,
				0, 0 };
		((GridBagLayout) contentPane.getLayout()).rowHeights = new int[] { 0, 0 };
		((GridBagLayout) contentPane.getLayout()).columnWeights = new double[] {
				0.0, 1.0, 1.0E-4 };
		((GridBagLayout) contentPane.getLayout()).rowWeights = new double[] {
				1.0, 1.0E-4 };

		// ---- label1 ----
		label1.setIcon(new ImageIcon(getClass().getResource(
				"/view/images/labelImages/FeeRate.png")));
		contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 5), 0, 0));

		// ======== panel1 ========
		{
			panel1.setBorder(new CompoundBorder(new TitledBorder(
					"Fee Rate Information"), new EmptyBorder(5, 5, 5, 5)));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout) panel1.getLayout()).columnWidths = new int[] { 0,
					65, 81, 0 };
			((GridBagLayout) panel1.getLayout()).rowHeights = new int[] { 0, 0,
					0, 0 };
			((GridBagLayout) panel1.getLayout()).columnWeights = new double[] {
					0.0, 0.0, 1.0, 1.0E-4 };
			((GridBagLayout) panel1.getLayout()).rowWeights = new double[] {
					0.0, 0.0, 0.0, 1.0E-4 };

			// ---- label2 ----
			label2.setText("Borrow Fee:");
			panel1.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtFee, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- label3 ----
			label3.setText("Late Fee:");
			panel1.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtFine, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

			// ---- btnChange ----
			btnChange.setText("Change");
			panel1.add(btnChange, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

			// ---- btnCancel ----
			btnCancel.setText("Cancel");
			panel1.add(btnCancel, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
					new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						0, 0, 0, 0), 0, 0));
		setSize(440, 190);
		setLocationRelativeTo(null);
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JLabel label1;
	private JPanel panel1;
	private JLabel label2;
	private JFormattedTextField txtFee;
	private JLabel label3;
	private JFormattedTextField txtFine;
	private JButton btnChange;
	private JButton btnCancel;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
