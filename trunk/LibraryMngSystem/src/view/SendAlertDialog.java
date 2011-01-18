/*
 * Created by JFormDesigner on Mon Jan 17 16:52:53 GMT+07:00 2011
 */

package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * @author Nanette G Hutchison
 */
public class SendAlertDialog extends JDialog {
	public SendAlertDialog(Frame owner) {
		super(owner, true);
		initComponents();
	}

	public SendAlertDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	/**
	 * @return the txtTo
	 */
	public JTextField getTxtTo() {
		return txtTo;
	}

	/**
	 * @param txtTo
	 *            the txtTo to set
	 */
	public void setTxtTo(JTextField txtTo) {
		this.txtTo = txtTo;
	}

	/**
	 * @return the txtFrom
	 */
	public JTextField getTxtFrom() {
		return txtFrom;
	}

	/**
	 * @param txtFrom
	 *            the txtFrom to set
	 */
	public void setTxtFrom(JTextField txtFrom) {
		this.txtFrom = txtFrom;
	}

	/**
	 * @return the txtSubject
	 */
	public JTextField getTxtSubject() {
		return txtSubject;
	}

	/**
	 * @param txtSubject
	 *            the txtSubject to set
	 */
	public void setTxtSubject(JTextField txtSubject) {
		this.txtSubject = txtSubject;
	}

	/**
	 * @return the txtContent
	 */
	public JEditorPane getTxtContent() {
		return txtContent;
	}

	/**
	 * @param txtContent
	 *            the txtContent to set
	 */
	public void setTxtContent(JEditorPane txtContent) {
		this.txtContent = txtContent;
	}

	/**
	 * @return the btnSend
	 */
	public JButton getBtnSend() {
		return btnSend;
	}

	/**
	 * @param btnSend
	 *            the btnSend to set
	 */
	public void setBtnSend(JButton btnSend) {
		this.btnSend = btnSend;
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
		panel1 = new JPanel();
		label1 = new JLabel();
		txtTo = new JTextField();
		label2 = new JLabel();
		txtFrom = new JTextField();
		label3 = new JLabel();
		txtSubject = new JTextField();
		label4 = new JLabel();
		scrollPane1 = new JScrollPane();
		txtContent = new JEditorPane();
		label5 = new JLabel();
		btnSend = new JButton();
		btnCancel = new JButton();

		//======== this ========
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== panel1 ========
		{
			panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 0.0, 1.0E-4};
			((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};

			//---- label1 ----
			label1.setText("To:");
			panel1.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtTo, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label2 ----
			label2.setText("From:");
			panel1.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- txtFrom ----
			txtFrom.setEnabled(false);
			panel1.add(txtFrom, new GridBagConstraints(1, 1, 3, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label3 ----
			label3.setText("Subject:");
			panel1.add(label3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtSubject, new GridBagConstraints(1, 2, 3, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label4 ----
			label4.setText("Content:");
			panel1.add(label4, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//======== scrollPane1 ========
			{
				scrollPane1.setViewportView(txtContent);
			}
			panel1.add(scrollPane1, new GridBagConstraints(1, 3, 1, 2, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));

			//---- label5 ----
			label5.setIcon(new ImageIcon(getClass().getResource("/view/images/labelImages/Email.png")));
			panel1.add(label5, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- btnSend ----
			btnSend.setText("Send");
			panel1.add(btnSend, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));

			//---- btnCancel ----
			btnCancel.setText("Cancel");
			panel1.add(btnCancel, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, BorderLayout.CENTER);
		setSize(650, 450);
		setLocationRelativeTo(null);
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JPanel panel1;
	private JLabel label1;
	private JTextField txtTo;
	private JLabel label2;
	private JTextField txtFrom;
	private JLabel label3;
	private JTextField txtSubject;
	private JLabel label4;
	private JScrollPane scrollPane1;
	private JEditorPane txtContent;
	private JLabel label5;
	private JButton btnSend;
	private JButton btnCancel;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
