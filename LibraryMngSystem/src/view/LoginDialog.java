/*
 * Created by JFormDesigner on Mon Jan 17 14:20:29 GMT+07:00 2011
 */

package view;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.LibImages;

/**
 * @author Nanette G Hutchison
 */
public class LoginDialog extends JDialog {
	public LoginDialog(Frame owner) {
		super(owner, true);
		initComponents();
	}

	public LoginDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	/**
	 * @return the mnConnection
	 */
	public JMenuItem getMnConnection() {
		return mnConnection;
	}

	/**
	 * @param mnConnection
	 *            the mnConnection to set
	 */
	public void setMnConnection(JMenuItem mnConnection) {
		this.mnConnection = mnConnection;
	}

	/**
	 * @return the mnQuit
	 */
	public JMenuItem getMnQuit() {
		return mnQuit;
	}

	/**
	 * @param mnQuit
	 *            the mnQuit to set
	 */
	public void setMnQuit(JMenuItem mnQuit) {
		this.mnQuit = mnQuit;
	}

	/**
	 * @return the mnHelp
	 */
	public JMenuItem getMnHelp() {
		return mnHelp;
	}

	/**
	 * @param mnHelp
	 *            the mnHelp to set
	 */
	public void setMnHelp(JMenuItem mnHelp) {
		this.mnHelp = mnHelp;
	}

	/**
	 * @return the mnAbout
	 */
	public JMenuItem getMnAbout() {
		return mnAbout;
	}

	/**
	 * @param mnAbout
	 *            the mnAbout to set
	 */
	public void setMnAbout(JMenuItem mnAbout) {
		this.mnAbout = mnAbout;
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
	 * @return the cbxRemember
	 */
	public JCheckBox getCbxRemember() {
		return cbxRemember;
	}

	/**
	 * @param cbxRemember
	 *            the cbxRemember to set
	 */
	public void setCbxRemember(JCheckBox cbxRemember) {
		this.cbxRemember = cbxRemember;
	}

	/**
	 * @return the btnLogin
	 */
	public JButton getBtnLogin() {
		return btnLogin;
	}

	/**
	 * @param btnLogin
	 *            the btnLogin to set
	 */
	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		mnConnection = new JMenuItem();
		mnQuit = new JMenuItem();
		menu2 = new JMenu();
		mnHelp = new JMenuItem();
		mnAbout = new JMenuItem();
		label1 = new JLabel();
		panel1 = new JPanel();
		label2 = new JLabel();
		txtUser = new JTextField();
		label3 = new JLabel();
		txtPass = new JPasswordField();
		cbxRemember = new JCheckBox();
		btnLogin = new JButton();
		label4 = new JLabel();

		//======== this ========
		setResizable(false);
		setTitle("Login - Library Management System");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 275, 0};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {164, 0, 0};
		((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

		//======== menuBar1 ========
		{

			//======== menu1 ========
			{
				menu1.setText("System");

				//---- mnConnection ----
				mnConnection.setText("Connection");
				mnConnection.setIcon(new ImageIcon(getClass().getResource("/view/images/menuImages/Setting.png")));
				menu1.add(mnConnection);
				menu1.addSeparator();

				//---- mnQuit ----
				mnQuit.setText("Quit");
				mnQuit.setIcon(new ImageIcon(getClass().getResource("/view/images/menuImages/Quit.png")));
				menu1.add(mnQuit);
			}
			menuBar1.add(menu1);

			//======== menu2 ========
			{
				menu2.setText("Help");

				//---- mnHelp ----
				mnHelp.setText("Help");
				mnHelp.setIcon(new ImageIcon(getClass().getResource("/view/images/menuImages/Help.png")));
				menu2.add(mnHelp);

				//---- mnAbout ----
				mnAbout.setText("About us");
				mnAbout.setIcon(new ImageIcon(getClass().getResource("/view/images/menuImages/About.png")));
				menu2.add(mnAbout);
			}
			menuBar1.add(menu2);
		}
		setJMenuBar(menuBar1);

		//---- label1 ----
		label1.setIcon(new ImageIcon(getClass().getResource("/view/images/labelImages/Login.png")));
		contentPane.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.NONE,
			new Insets(0, 0, 5, 5), 0, 0));

		//======== panel1 ========
		{
			panel1.setBorder(new CompoundBorder(
				new TitledBorder("Login Information"),
				new EmptyBorder(5, 5, 5, 5)));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {71, 0, 151, 0};
			((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
			((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0, 1.0E-4};
			((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

			//---- label2 ----
			label2.setText("Username:");
			panel1.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtUser, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- label3 ----
			label3.setText("Password:");
			panel1.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));
			panel1.add(txtPass, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- cbxRemember ----
			cbxRemember.setText("Remember me");
			panel1.add(cbxRemember, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));

			//---- btnLogin ----
			btnLogin.setText("Login");
			panel1.add(btnLogin, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
				new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.WEST, GridBagConstraints.NONE,
			new Insets(0, 0, 5, 0), 0, 0));

		//---- label4 ----
		label4.setText("Powered by Group-01.GC0502 - Vr1.0");
		label4.setFont(new Font("Lucida Grande", Font.ITALIC, 11));
		contentPane.add(label4, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
			new Insets(0, 0, 0, 0), 0, 0));
		setSize(465, 220);
		setLocationRelativeTo(null);
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem mnConnection;
	private JMenuItem mnQuit;
	private JMenu menu2;
	private JMenuItem mnHelp;
	private JMenuItem mnAbout;
	private JLabel label1;
	private JPanel panel1;
	private JLabel label2;
	private JTextField txtUser;
	private JLabel label3;
	private JPasswordField txtPass;
	private JCheckBox cbxRemember;
	private JButton btnLogin;
	private JLabel label4;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
