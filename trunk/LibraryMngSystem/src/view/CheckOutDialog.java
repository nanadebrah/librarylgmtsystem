package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXDatePicker;

/**
 * @author CuongNQ
 */
@SuppressWarnings("serial")
public class CheckOutDialog extends JDialog {
	public CheckOutDialog(Frame owner) {
		super(owner, true);
		initComponents();
	}

	public CheckOutDialog(Dialog owner) {
		super(owner);
		initComponents();
	}

	private void initComponents() {
		// Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		panel1 = new JPanel();
		label3 = new JLabel();
		txtCallNumber = new JTextField();
		label1 = new JLabel();
		txtTitle = new JTextField();
		btnSearchBook = new JButton();
		label4 = new JLabel();
		txtISBN = new JTextField();
		label2 = new JLabel();
		txtAuth = new JTextField();
		panel6 = new JPanel();
		panel7 = new JPanel();
		scrPanBoth = new JScrollPane();
		tblBoth = new JTable();
		panel8 = new JPanel();
		btnFirst = new JButton();
		btnBack = new JButton();
		lblPage = new JLabel();
		btnNext = new JButton();
		btnLast = new JButton();
		panel9 = new JPanel();
		label28 = new JLabel();
		txtEmpID = new JTextField();
		btnSearchEmp = new JButton();
		label29 = new JLabel();
		txtEmpName = new JTextField();
		label30 = new JLabel();
		lblID = new JLabel();
		label31 = new JLabel();
		lblName = new JLabel();
		label32 = new JLabel();
		lblDOB = new JLabel();
		label33 = new JLabel();
		lblGender = new JLabel();
		label34 = new JLabel();
		lblDepart = new JLabel();
		label35 = new JLabel();
		lblAddress = new JLabel();
		label36 = new JLabel();
		lblPhone = new JLabel();
		label37 = new JLabel();
		lblPermission = new JLabel();
		scrollPane2 = new JScrollPane();
		tblCheckOut = new JTable();
		panel3 = new JPanel();
		panel5 = new JPanel();
		label23 = new JLabel();
		txtIssueDate = new JXDatePicker();
		label26 = new JLabel();
		txtDueDate = new JXDatePicker();
		label24 = new JLabel();
		lblFee = new JLabel();
		panel10 = new JPanel();
		btnCheckOut = new JButton();
		btnCancel = new JButton();

		//======== this ========
		setMinimumSize(new Dimension(800, 550));
		setTitle("Check-Out Book");
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {752, 0};
		((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {76, 67, 0};
		((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
		((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

		//======== panel1 ========
		{
			panel1.setBorder(new CompoundBorder(
				new TitledBorder(new CompoundBorder(
					new EmptyBorder(5, 5, 5, 5),
					new BorderUIResource.EtchedBorderUIResource()), "Book Search"),
				new EmptyBorder(5, 5, 5, 5)));
			panel1.setLayout(new GridBagLayout());
			((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {74, 66, 126, 54, 161, 0};
			((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0};
			((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0, 1.0E-4};
			((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

			//---- label3 ----
			label3.setText("Call Number:");
			panel1.add(label3, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- txtCallNumber ----
			txtCallNumber.setToolTipText("Searach book by call number");
			panel1.add(txtCallNumber, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- label1 ----
			label1.setText("Title:");
			panel1.add(label1, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//---- txtTitle ----
			txtTitle.setToolTipText("Search book by title");
			panel1.add(txtTitle, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//---- btnSearchBook ----
			btnSearchBook.setText("Search");
			btnSearchBook.setBorderPainted(false);
			btnSearchBook.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Search.png")));
			btnSearchBook.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnSearchBook.setHorizontalTextPosition(SwingConstants.CENTER);
			panel1.add(btnSearchBook, new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));

			//---- label4 ----
			label4.setText("ISBN:");
			panel1.add(label4, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 5), 0, 0));

			//---- txtISBN ----
			txtISBN.setToolTipText("Search book by ISBN");
			panel1.add(txtISBN, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 5), 0, 0));

			//---- label2 ----
			label2.setText("Author:");
			panel1.add(label2, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 5), 0, 0));

			//---- txtAuth ----
			txtAuth.setToolTipText("Search book by author name");
			panel1.add(txtAuth, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
			GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
			new Insets(0, 0, 5, 0), 0, 0));

		//======== panel6 ========
		{
			panel6.setLayout(new GridBagLayout());
			((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {0, 125, 0};
			((GridBagLayout)panel6.getLayout()).rowHeights = new int[] {251, 147, 0};
			((GridBagLayout)panel6.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
			((GridBagLayout)panel6.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

			//======== panel7 ========
			{
				panel7.setLayout(new GridBagLayout());
				((GridBagLayout)panel7.getLayout()).columnWidths = new int[] {503, 0};
				((GridBagLayout)panel7.getLayout()).rowHeights = new int[] {83, 0, 0};
				((GridBagLayout)panel7.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
				((GridBagLayout)panel7.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

				//======== scrPanBoth ========
				{

					//---- tblBoth ----
					tblBoth.setModel(new DefaultTableModel(2, 0));
					scrPanBoth.setViewportView(tblBoth);
				}
				panel7.add(scrPanBoth, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//======== panel8 ========
				{
					panel8.setLayout(new FlowLayout());

					//---- btnFirst ----
					btnFirst.setBorderPainted(false);
					btnFirst.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/First.png")));
					panel8.add(btnFirst);

					//---- btnBack ----
					btnBack.setBorderPainted(false);
					btnBack.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Back.png")));
					panel8.add(btnBack);

					//---- lblPage ----
					lblPage.setText("Page");
					panel8.add(lblPage);

					//---- btnNext ----
					btnNext.setBorderPainted(false);
					btnNext.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Next.png")));
					panel8.add(btnNext);

					//---- btnLast ----
					btnLast.setBorderPainted(false);
					btnLast.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Last.png")));
					panel8.add(btnLast);
				}
				panel7.add(panel8, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			panel6.add(panel7, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 5), 0, 0));

			//======== panel9 ========
			{
				panel9.setBorder(new CompoundBorder(
					new TitledBorder(new CompoundBorder(
						new EmptyBorder(5, 5, 5, 5),
						new BorderUIResource.EtchedBorderUIResource()), "Employee Information"),
					new EmptyBorder(5, 5, 5, 5)));
				panel9.setLayout(new GridBagLayout());
				((GridBagLayout)panel9.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
				((GridBagLayout)panel9.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				((GridBagLayout)panel9.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 1.0E-4};
				((GridBagLayout)panel9.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

				//---- label28 ----
				label28.setText("Employee No:");
				panel9.add(label28, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- txtEmpID ----
				txtEmpID.setToolTipText("Search employee by employee number");
				panel9.add(txtEmpID, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- btnSearchEmp ----
				btnSearchEmp.setText("Search");
				btnSearchEmp.setBorderPainted(false);
				btnSearchEmp.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Search.png")));
				btnSearchEmp.setVerticalTextPosition(SwingConstants.BOTTOM);
				btnSearchEmp.setHorizontalTextPosition(SwingConstants.CENTER);
				panel9.add(btnSearchEmp, new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- label29 ----
				label29.setText("Employee Name:");
				panel9.add(label29, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(0, 0, 5, 5), 0, 0));
				panel9.add(txtEmpName, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- label30 ----
				label30.setText("No:");
				panel9.add(label30, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- lblID ----
				lblID.setText("Empty");
				panel9.add(lblID, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- label31 ----
				label31.setText("Name:");
				panel9.add(label31, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- lblName ----
				lblName.setText("Empty");
				panel9.add(lblName, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- label32 ----
				label32.setText("Date of birth:");
				panel9.add(label32, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- lblDOB ----
				lblDOB.setText("Empty");
				panel9.add(lblDOB, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- label33 ----
				label33.setText("Gender:");
				panel9.add(label33, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- lblGender ----
				lblGender.setText("Empty");
				panel9.add(lblGender, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- label34 ----
				label34.setText("Department:");
				panel9.add(label34, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- lblDepart ----
				lblDepart.setText("Empty");
				panel9.add(lblDepart, new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- label35 ----
				label35.setText("Address:");
				panel9.add(label35, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- lblAddress ----
				lblAddress.setText("Empty");
				panel9.add(lblAddress, new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- label36 ----
				label36.setText("Phone:");
				panel9.add(label36, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 5), 0, 0));

				//---- lblPhone ----
				lblPhone.setText("Empty");
				panel9.add(lblPhone, new GridBagConstraints(1, 8, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 5, 0), 0, 0));

				//---- label37 ----
				label37.setText("Permission");
				panel9.add(label37, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- lblPermission ----
				lblPermission.setText("Empty");
				panel9.add(lblPermission, new GridBagConstraints(1, 9, 2, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			panel6.add(panel9, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));

			//======== scrollPane2 ========
			{

				//---- tblCheckOut ----
				tblCheckOut.setModel(new DefaultTableModel(2, 0));
				scrollPane2.setViewportView(tblCheckOut);
			}
			panel6.add(scrollPane2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 5), 0, 0));

			//======== panel3 ========
			{
				panel3.setLayout(new BorderLayout());

				//======== panel5 ========
				{
					panel5.setBorder(new CompoundBorder(
						new TitledBorder(new CompoundBorder(
							new EmptyBorder(5, 5, 5, 5),
							new BorderUIResource.EtchedBorderUIResource()), "Check-Out Infromation"),
						new EmptyBorder(5, 5, 5, 5)));
					panel5.setLayout(new GridBagLayout());
					((GridBagLayout)panel5.getLayout()).columnWidths = new int[] {0, 182, 0};
					((GridBagLayout)panel5.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
					((GridBagLayout)panel5.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
					((GridBagLayout)panel5.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

					//---- label23 ----
					label23.setText("Issue Date:");
					panel5.add(label23, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 5, 5), 0, 0));
					panel5.add(txtIssueDate, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 5, 0), 0, 0));

					//---- label26 ----
					label26.setText("Due Date:");
					panel5.add(label26, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 5, 5), 0, 0));
					panel5.add(txtDueDate, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 5, 0), 0, 0));

					//---- label24 ----
					label24.setText("Fee:");
					panel5.add(label24, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 5), 0, 0));

					//---- lblFee ----
					lblFee.setText("Fee");
					panel5.add(lblFee, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));
				}
				panel3.add(panel5, BorderLayout.CENTER);

				//======== panel10 ========
				{
					panel10.setLayout(new FlowLayout());

					//---- btnCheckOut ----
					btnCheckOut.setText("CheckOut");
					panel10.add(btnCheckOut);

					//---- btnCancel ----
					btnCancel.setText("Cancel");
					panel10.add(btnCancel);
				}
				panel3.add(panel10, BorderLayout.SOUTH);
			}
			panel6.add(panel3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		}
		contentPane.add(panel6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
			GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 0, 0));
		setSize(850, 600);
		setLocationRelativeTo(null);
		// //GEN-END:initComponents
	}

	// Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JPanel panel1;
	private JLabel label3;
	private JTextField txtCallNumber;
	private JLabel label1;
	private JTextField txtTitle;
	private JButton btnSearchBook;
	private JLabel label4;
	private JTextField txtISBN;
	private JLabel label2;
	private JTextField txtAuth;
	private JPanel panel6;
	private JPanel panel7;
	private JScrollPane scrPanBoth;
	private JTable tblBoth;
	private JPanel panel8;
	private JButton btnFirst;
	private JButton btnBack;
	private JLabel lblPage;
	private JButton btnNext;
	private JButton btnLast;
	private JPanel panel9;
	private JLabel label28;
	private JTextField txtEmpID;
	private JButton btnSearchEmp;
	private JLabel label29;
	private JTextField txtEmpName;
	private JLabel label30;
	private JLabel lblID;
	private JLabel label31;
	private JLabel lblName;
	private JLabel label32;
	private JLabel lblDOB;
	private JLabel label33;
	private JLabel lblGender;
	private JLabel label34;
	private JLabel lblDepart;
	private JLabel label35;
	private JLabel lblAddress;
	private JLabel label36;
	private JLabel lblPhone;
	private JLabel label37;
	private JLabel lblPermission;
	private JScrollPane scrollPane2;
	private JTable tblCheckOut;
	private JPanel panel3;
	private JPanel panel5;
	private JLabel label23;
	private JXDatePicker txtIssueDate;
	private JLabel label26;
	private JXDatePicker txtDueDate;
	private JLabel label24;
	private JLabel lblFee;
	private JPanel panel10;
	private JButton btnCheckOut;
	private JButton btnCancel;
	// End of variables declaration //GEN-END:variables
	/**
	 * @return the txtCallNumber
	 */
	public JTextField getTxtCallNumber() {
		return txtCallNumber;
	}

	/**
	 * @param txtCallNumber
	 *            the txtCallNumber to set
	 */
	public void setTxtCallNumber(JTextField txtCallNumber) {
		this.txtCallNumber = txtCallNumber;
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
	 * @return the btnSearchBook
	 */
	public JButton getBtnSearchBook() {
		return btnSearchBook;
	}

	/**
	 * @param btnSearchBook
	 *            the btnSearchBook to set
	 */
	public void setBtnSearchBook(JButton btnSearchBook) {
		this.btnSearchBook = btnSearchBook;
	}

	/**
	 * @return the txtISBN
	 */
	public JTextField getTxtISBN() {
		return txtISBN;
	}

	/**
	 * @param txtISBN
	 *            the txtISBN to set
	 */
	public void setTxtISBN(JTextField txtISBN) {
		this.txtISBN = txtISBN;
	}

	/**
	 * @return the txtAuth
	 */
	public JTextField getTxtAuth() {
		return txtAuth;
	}

	/**
	 * @param txtAuth
	 *            the txtAuth to set
	 */
	public void setTxtAuth(JTextField txtAuth) {
		this.txtAuth = txtAuth;
	}

	/**
	 * @return the scrPanBoth
	 */
	public JScrollPane getScrPanBoth() {
		return scrPanBoth;
	}

	/**
	 * @param scrPanBoth
	 *            the scrPanBoth to set
	 */
	public void setScrPanBoth(JScrollPane scrPanBoth) {
		this.scrPanBoth = scrPanBoth;
	}

	/**
	 * @return the tblBoth
	 */
	public JTable getTblBoth() {
		return tblBoth;
	}

	/**
	 * @param tblBoth
	 *            the tblBoth to set
	 */
	public void setTblBoth(JTable tblBoth) {
		this.tblBoth = tblBoth;
	}

	/**
	 * @return the btnFirst
	 */
	public JButton getBtnFirst() {
		return btnFirst;
	}

	/**
	 * @param btnFirst
	 *            the btnFirst to set
	 */
	public void setBtnFirst(JButton btnFirst) {
		this.btnFirst = btnFirst;
	}

	/**
	 * @return the btnBack
	 */
	public JButton getBtnBack() {
		return btnBack;
	}

	/**
	 * @param btnBack
	 *            the btnBack to set
	 */
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	/**
	 * @return the lblPage
	 */
	public JLabel getLblPage() {
		return lblPage;
	}

	/**
	 * @param lblPage
	 *            the lblPage to set
	 */
	public void setLblPage(JLabel lblPage) {
		this.lblPage = lblPage;
	}

	/**
	 * @return the btnNext
	 */
	public JButton getBtnNext() {
		return btnNext;
	}

	/**
	 * @param btnNext
	 *            the btnNext to set
	 */
	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}

	/**
	 * @return the btnLast
	 */
	public JButton getBtnLast() {
		return btnLast;
	}

	/**
	 * @param btnLast
	 *            the btnLast to set
	 */
	public void setBtnLast(JButton btnLast) {
		this.btnLast = btnLast;
	}

	/**
	 * @return the txtEmpID
	 */
	public JTextField getTxtEmpID() {
		return txtEmpID;
	}

	/**
	 * @param txtEmpID
	 *            the txtEmpID to set
	 */
	public void setTxtEmpID(JTextField txtEmpID) {
		this.txtEmpID = txtEmpID;
	}

	/**
	 * @return the btnSearchEmp
	 */
	public JButton getBtnSearchEmp() {
		return btnSearchEmp;
	}

	/**
	 * @param btnSearchEmp
	 *            the btnSearchEmp to set
	 */
	public void setBtnSearchEmp(JButton btnSearchEmp) {
		this.btnSearchEmp = btnSearchEmp;
	}

	/**
	 * @return the txtEmpName
	 */
	public JTextField getTxtEmpName() {
		return txtEmpName;
	}

	/**
	 * @param txtEmpName
	 *            the txtEmpName to set
	 */
	public void setTxtEmpName(JTextField txtEmpName) {
		this.txtEmpName = txtEmpName;
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
	 * @return the lblAddress
	 */
	public JLabel getLblAddress() {
		return lblAddress;
	}

	/**
	 * @param lblAddress
	 *            the lblAddress to set
	 */
	public void setLblAddress(JLabel lblAddress) {
		this.lblAddress = lblAddress;
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
	 * @return the tblCheckOut
	 */
	public JTable getTblCheckOut() {
		return tblCheckOut;
	}

	/**
	 * @param tblCheckOut
	 *            the tblCheckOut to set
	 */
	public void setTblCheckOut(JTable tblCheckOut) {
		this.tblCheckOut = tblCheckOut;
	}

	/**
	 * @return the txtIssueDate
	 */
	public JXDatePicker getTxtIssueDate() {
		return txtIssueDate;
	}

	/**
	 * @param txtIssueDate
	 *            the txtIssueDate to set
	 */
	public void setTxtIssueDate(JXDatePicker txtIssueDate) {
		this.txtIssueDate = txtIssueDate;
	}

	/**
	 * @return the txtDueDate
	 */
	public JXDatePicker getTxtDueDate() {
		return txtDueDate;
	}

	/**
	 * @param txtDueDate
	 *            the txtDueDate to set
	 */
	public void setTxtDueDate(JXDatePicker txtDueDate) {
		this.txtDueDate = txtDueDate;
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
	 * @return the btnCheckOut
	 */
	public JButton getBtnCheckOut() {
		return btnCheckOut;
	}

	/**
	 * @param btnCheckOut
	 *            the btnCheckOut to set
	 */
	public void setBtnCheckOut(JButton btnCheckOut) {
		this.btnCheckOut = btnCheckOut;
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
