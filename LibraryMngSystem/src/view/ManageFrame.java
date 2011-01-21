package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.jdesktop.swingx.JXTaskPane;

/**
 * @author CuongNQ
 */
@SuppressWarnings("serial")
public class ManageFrame extends JFrame {
	public ManageFrame() {
		initComponents();
	}

	private void initComponents() {
		// Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		menuBar1 = new JMenuBar();
		menu1 = new JMenu();
		mnSetting = new JMenuItem();
		mnLogout = new JMenuItem();
		mnQuit = new JMenuItem();
		mnEmployee = new JMenu();
		mnBook = new JMenu();
		mnSubject = new JMenu();
		mnBorrow = new JMenu();
		mnAnalytic = new JMenu();
		menuHelp = new JMenu();
		mnHelp = new JMenuItem();
		mnAboutUs = new JMenuItem();
		scrollPane1 = new JScrollPane();
		panel2 = new JPanel();
		xTaskPane1 = new JXTaskPane();
		btnEmployee = new JButton();
		btnSubject = new JButton();
		btnBook = new JButton();
		xTaskPane2 = new JXTaskPane();
		btnBorrow = new JButton();
		btnAnalytic = new JButton();
		panelMain = new JPanel();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(900, 470));
		setTitle("Library Management System");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== menuBar1 ========
		{

			//======== menu1 ========
			{
				menu1.setText("System");

				//---- mnSetting ----
				mnSetting.setText("Setting");
				mnSetting.setIcon(new ImageIcon(getClass().getResource("/view/images/menuImages/ProgramSetting.png")));
				mnSetting.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.ALT_MASK));
				menu1.add(mnSetting);

				//---- mnLogout ----
				mnLogout.setText("Logout");
				mnLogout.setIcon(new ImageIcon(getClass().getResource("/view/images/menuImages/Logout.png")));
				mnLogout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.ALT_MASK));
				menu1.add(mnLogout);
				menu1.addSeparator();

				//---- mnQuit ----
				mnQuit.setText("Quit");
				mnQuit.setIcon(new ImageIcon(getClass().getResource("/view/images/menuImages/Quit.png")));
				mnQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.ALT_MASK));
				menu1.add(mnQuit);
			}
			menuBar1.add(menu1);

			//======== mnEmployee ========
			{
				mnEmployee.setText("Employee");
				mnEmployee.setMnemonic('E');
			}
			menuBar1.add(mnEmployee);

			//======== mnBook ========
			{
				mnBook.setText("Book");
				mnBook.setMnemonic('B');
			}
			menuBar1.add(mnBook);

			//======== mnSubject ========
			{
				mnSubject.setText("Subject");
				mnSubject.setMnemonic('S');
			}
			menuBar1.add(mnSubject);

			//======== mnBorrow ========
			{
				mnBorrow.setText("Borrow");
				mnBorrow.setMnemonic('B');
			}
			menuBar1.add(mnBorrow);

			//======== mnAnalytic ========
			{
				mnAnalytic.setText("Analytic");
				mnAnalytic.setMnemonic('A');
			}
			menuBar1.add(mnAnalytic);

			//======== menuHelp ========
			{
				menuHelp.setText("Help");

				//---- mnHelp ----
				mnHelp.setText("Help");
				mnHelp.setIcon(new ImageIcon(getClass().getResource("/view/images/menuImages/Help.png")));
				mnHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
				menuHelp.add(mnHelp);

				//---- mnAboutUs ----
				mnAboutUs.setText("About us");
				mnAboutUs.setIcon(new ImageIcon(getClass().getResource("/view/images/menuImages/About.png")));
				menuHelp.add(mnAboutUs);
			}
			menuBar1.add(menuHelp);
		}
		setJMenuBar(menuBar1);

		//======== scrollPane1 ========
		{

			//======== panel2 ========
			{
				panel2.setLayout(new GridBagLayout());
				((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0};
				((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0, 0};
				((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
				((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

				//======== xTaskPane1 ========
				{
					xTaskPane1.setTitle("Management");
					xTaskPane1.setFocusable(false);
					Container xTaskPane1ContentPane = xTaskPane1.getContentPane();
					xTaskPane1ContentPane.setLayout(new BorderLayout());

					//---- btnEmployee ----
					btnEmployee.setText("Employee");
					btnEmployee.setBorderPainted(false);
					btnEmployee.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Employee.png")));
					btnEmployee.setHorizontalAlignment(SwingConstants.LEFT);
					btnEmployee.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
					btnEmployee.setMnemonic('E');
					xTaskPane1ContentPane.add(btnEmployee, BorderLayout.NORTH);

					//---- btnSubject ----
					btnSubject.setText("Subject");
					btnSubject.setBorderPainted(false);
					btnSubject.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Sub.png")));
					btnSubject.setHorizontalAlignment(SwingConstants.LEFT);
					btnSubject.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
					btnSubject.setMnemonic('S');
					xTaskPane1ContentPane.add(btnSubject, BorderLayout.SOUTH);

					//---- btnBook ----
					btnBook.setText("Book");
					btnBook.setBorderPainted(false);
					btnBook.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Book.png")));
					btnBook.setHorizontalAlignment(SwingConstants.LEFT);
					btnBook.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
					btnBook.setMnemonic('B');
					xTaskPane1ContentPane.add(btnBook, BorderLayout.CENTER);
				}
				panel2.add(xTaskPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));

				//======== xTaskPane2 ========
				{
					xTaskPane2.setTitle("Borrow & Analytic");
					xTaskPane2.setFocusable(false);
					Container xTaskPane2ContentPane = xTaskPane2.getContentPane();
					xTaskPane2ContentPane.setLayout(new BorderLayout());

					//---- btnBorrow ----
					btnBorrow.setText("Borrow");
					btnBorrow.setBorderPainted(false);
					btnBorrow.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Borrow.png")));
					btnBorrow.setHorizontalAlignment(SwingConstants.LEFT);
					btnBorrow.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
					btnBorrow.setMnemonic('O');
					xTaskPane2ContentPane.add(btnBorrow, BorderLayout.NORTH);

					//---- btnAnalytic ----
					btnAnalytic.setText("Analytic");
					btnAnalytic.setBorderPainted(false);
					btnAnalytic.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Analytic.png")));
					btnAnalytic.setHorizontalAlignment(SwingConstants.LEFT);
					btnAnalytic.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
					btnAnalytic.setMnemonic('A');
					xTaskPane2ContentPane.add(btnAnalytic, BorderLayout.CENTER);
				}
				panel2.add(xTaskPane2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			scrollPane1.setViewportView(panel2);
		}
		contentPane.add(scrollPane1, BorderLayout.LINE_START);

		//======== panelMain ========
		{
			panelMain.setLayout(new CardLayout());
		}
		contentPane.add(panelMain, BorderLayout.CENTER);
		setSize(900, 470);
		setLocationRelativeTo(null);
		// //GEN-END:initComponents
	}

	// Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JMenuBar menuBar1;
	private JMenu menu1;
	private JMenuItem mnSetting;
	private JMenuItem mnLogout;
	private JMenuItem mnQuit;
	private JMenu mnEmployee;
	private JMenu mnBook;
	private JMenu mnSubject;
	private JMenu mnBorrow;
	private JMenu mnAnalytic;
	private JMenu menuHelp;
	private JMenuItem mnHelp;
	private JMenuItem mnAboutUs;
	private JScrollPane scrollPane1;
	private JPanel panel2;
	private JXTaskPane xTaskPane1;
	private JButton btnEmployee;
	private JButton btnSubject;
	private JButton btnBook;
	private JXTaskPane xTaskPane2;
	private JButton btnBorrow;
	private JButton btnAnalytic;
	private JPanel panelMain;
	// End of variables declaration //GEN-END:variables
	/**
	 * @return the mnSetting
	 */
	public JMenuItem getMnSetting() {
		return mnSetting;
	}

	/**
	 * @param mnSetting
	 *            the mnSetting to set
	 */
	public void setMnSetting(JMenuItem mnSetting) {
		this.mnSetting = mnSetting;
	}

	/**
	 * @return the mnLogout
	 */
	public JMenuItem getMnLogout() {
		return mnLogout;
	}

	/**
	 * @param mnLogout
	 *            the mnLogout to set
	 */
	public void setMnLogout(JMenuItem mnLogout) {
		this.mnLogout = mnLogout;
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
	 * @return the mnEmployee
	 */
	public JMenu getMnEmployee() {
		return mnEmployee;
	}

	/**
	 * @param mnEmployee
	 *            the mnEmployee to set
	 */
	public void setMnEmployee(JMenu mnEmployee) {
		this.mnEmployee = mnEmployee;
	}

	/**
	 * @return the mnBook
	 */
	public JMenu getMnBook() {
		return mnBook;
	}

	/**
	 * @param mnBook
	 *            the mnBook to set
	 */
	public void setMnBook(JMenu mnBook) {
		this.mnBook = mnBook;
	}

	/**
	 * @return the mnSubject
	 */
	public JMenu getMnSubject() {
		return mnSubject;
	}

	/**
	 * @param mnSubject
	 *            the mnSubject to set
	 */
	public void setMnSubject(JMenu mnSubject) {
		this.mnSubject = mnSubject;
	}

	/**
	 * @return the mnBorrow
	 */
	public JMenu getMnBorrow() {
		return mnBorrow;
	}

	/**
	 * @param mnBorrow
	 *            the mnBorrow to set
	 */
	public void setMnBorrow(JMenu mnBorrow) {
		this.mnBorrow = mnBorrow;
	}

	/**
	 * @return the mnAnalytic
	 */
	public JMenu getMnAnalytic() {
		return mnAnalytic;
	}

	/**
	 * @param mnAnalytic
	 *            the mnAnalytic to set
	 */
	public void setMnAnalytic(JMenu mnAnalytic) {
		this.mnAnalytic = mnAnalytic;
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
	 * @return the mnAboutUs
	 */
	public JMenuItem getMnAboutUs() {
		return mnAboutUs;
	}

	/**
	 * @param mnAboutUs
	 *            the mnAboutUs to set
	 */
	public void setMnAboutUs(JMenuItem mnAboutUs) {
		this.mnAboutUs = mnAboutUs;
	}

	/**
	 * @return the btnEmployee
	 */
	public JButton getBtnEmployee() {
		return btnEmployee;
	}

	/**
	 * @param btnEmployee
	 *            the btnEmployee to set
	 */
	public void setBtnEmployee(JButton btnEmployee) {
		this.btnEmployee = btnEmployee;
	}

	/**
	 * @return the btnSubject
	 */
	public JButton getBtnSubject() {
		return btnSubject;
	}

	/**
	 * @param btnSubject
	 *            the btnSubject to set
	 */
	public void setBtnSubject(JButton btnSubject) {
		this.btnSubject = btnSubject;
	}

	/**
	 * @return the btnBook
	 */
	public JButton getBtnBook() {
		return btnBook;
	}

	/**
	 * @param btnBook
	 *            the btnBook to set
	 */
	public void setBtnBook(JButton btnBook) {
		this.btnBook = btnBook;
	}

	/**
	 * @return the btnBorrow
	 */
	public JButton getBtnBorrow() {
		return btnBorrow;
	}

	/**
	 * @param btnBorrow
	 *            the btnBorrow to set
	 */
	public void setBtnBorrow(JButton btnBorrow) {
		this.btnBorrow = btnBorrow;
	}

	/**
	 * @return the btnAnalytic
	 */
	public JButton getBtnAnalytic() {
		return btnAnalytic;
	}

	/**
	 * @param btnAnalytic
	 *            the btnAnalytic to set
	 */
	public void setBtnAnalytic(JButton btnAnalytic) {
		this.btnAnalytic = btnAnalytic;
	}

	/**
	 * @return the panelMain
	 */
	public JPanel getPanelMain() {
		return panelMain;
	}

	/**
	 * @param panelMain
	 *            the panelMain to set
	 */
	public void setPanelMain(JPanel panelMain) {
		this.panelMain = panelMain;
	}
}
