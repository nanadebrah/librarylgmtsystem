package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 * @author CuongNQ
 */
@SuppressWarnings("serial")
public class BorrowPanel extends JPanel {
	public BorrowPanel() {
		initComponents();
	}

	private void initComponents() {
		// Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		panel1 = new JPanel();
		btnFirst = new JButton();
		btnBack = new JButton();
		lblPage = new JLabel();
		btnNext = new JButton();
		btnLast = new JButton();
		panel2 = new JPanel();
		scrollPane1 = new JScrollPane();
		tblBorrow = new JTable();
		panel3 = new JPanel();
		toolBar1 = new JToolBar();
		btnCheckOut = new JButton();
		btnCheckIn = new JButton();
		btnFee = new JButton();
		btnView = new JButton();
		btnDelete = new JButton();
		btnSearch = new JButton();
		panel4 = new JPanel();
		label2 = new JLabel();
		txtCallNo = new JTextField();
		label3 = new JLabel();
		txtEmpID = new JTextField();

		// ======== this ========
		setLayout(new BorderLayout());

		// ======== panel1 ========
		{
			panel1.setLayout(new FlowLayout());

			// ---- btnFirst ----
			btnFirst.setBorderPainted(false);
			btnFirst.setIcon(new ImageIcon(getClass().getResource(
					"/view/images/taskbarImages/First.png")));
			panel1.add(btnFirst);

			// ---- btnBack ----
			btnBack.setBorderPainted(false);
			btnBack.setIcon(new ImageIcon(getClass().getResource(
					"/view/images/taskbarImages/Back.png")));
			panel1.add(btnBack);

			// ---- lblPage ----
			lblPage.setText("Page");
			panel1.add(lblPage);

			// ---- btnNext ----
			btnNext.setBorderPainted(false);
			btnNext.setIcon(new ImageIcon(getClass().getResource(
					"/view/images/taskbarImages/Next.png")));
			panel1.add(btnNext);

			// ---- btnLast ----
			btnLast.setBorderPainted(false);
			btnLast.setIcon(new ImageIcon(getClass().getResource(
					"/view/images/taskbarImages/Last.png")));
			panel1.add(btnLast);
		}
		add(panel1, BorderLayout.SOUTH);

		// ======== panel2 ========
		{
			panel2.setLayout(new BorderLayout());

			// ======== scrollPane1 ========
			{

				// ---- tblBorrow ----
				tblBorrow.setModel(new DefaultTableModel(2, 0));
				scrollPane1.setViewportView(tblBorrow);
			}
			panel2.add(scrollPane1, BorderLayout.CENTER);

			// ======== panel3 ========
			{
				panel3.setLayout(new GridBagLayout());
				((GridBagLayout) panel3.getLayout()).columnWidths = new int[] {
						0, 0, 0 };
				((GridBagLayout) panel3.getLayout()).rowHeights = new int[] {
						0, 0 };
				((GridBagLayout) panel3.getLayout()).columnWeights = new double[] {
						0.0, 1.0, 1.0E-4 };
				((GridBagLayout) panel3.getLayout()).rowWeights = new double[] {
						0.0, 1.0E-4 };

				// ======== toolBar1 ========
				{
					toolBar1.setFloatable(false);

					// ---- btnCheckOut ----
					btnCheckOut.setText("Check-out");
					btnCheckOut.setIcon(new ImageIcon(getClass().getResource(
							"/view/images/taskbarImages/CheckOut.png")));
					btnCheckOut.setBorderPainted(false);
					btnCheckOut
							.setHorizontalTextPosition(SwingConstants.CENTER);
					btnCheckOut.setVerticalTextPosition(SwingConstants.BOTTOM);
					toolBar1.add(btnCheckOut);

					// ---- btnCheckIn ----
					btnCheckIn.setText("Check-in");
					btnCheckIn.setBorderPainted(false);
					btnCheckIn.setIcon(new ImageIcon(getClass().getResource(
							"/view/images/taskbarImages/CheckIn.png")));
					btnCheckIn.setHorizontalTextPosition(SwingConstants.CENTER);
					btnCheckIn.setVerticalTextPosition(SwingConstants.BOTTOM);
					toolBar1.add(btnCheckIn);

					// ---- btnFee ----
					btnFee.setText("Fee rate");
					btnFee.setBorderPainted(false);
					btnFee.setIcon(new ImageIcon(getClass().getResource(
							"/view/images/taskbarImages/Fee.png")));
					btnFee.setHorizontalTextPosition(SwingConstants.CENTER);
					btnFee.setVerticalTextPosition(SwingConstants.BOTTOM);
					toolBar1.add(btnFee);
					toolBar1.addSeparator();

					// ---- btnView ----
					btnView.setText("View");
					btnView.setBorderPainted(false);
					btnView.setIcon(new ImageIcon(getClass().getResource(
							"/view/images/taskbarImages/View.png")));
					btnView.setHorizontalTextPosition(SwingConstants.CENTER);
					btnView.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnView.setEnabled(false);
					btnView.setRequestFocusEnabled(false);
					toolBar1.add(btnView);

					// ---- btnDelete ----
					btnDelete.setText("Delete");
					btnDelete.setBorderPainted(false);
					btnDelete.setIcon(new ImageIcon(getClass().getResource(
							"/view/images/taskbarImages/Delete.png")));
					btnDelete.setHorizontalTextPosition(SwingConstants.CENTER);
					btnDelete.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnDelete.setEnabled(false);
					btnDelete.setRequestFocusEnabled(false);
					toolBar1.add(btnDelete);
					toolBar1.addSeparator();

					// ---- btnSearch ----
					btnSearch.setText("Search");
					btnSearch.setBorderPainted(false);
					btnSearch.setIcon(new ImageIcon(getClass().getResource(
							"/view/images/taskbarImages/Search.png")));
					btnSearch.setHorizontalTextPosition(SwingConstants.CENTER);
					btnSearch.setVerticalTextPosition(SwingConstants.BOTTOM);
					toolBar1.add(btnSearch);
				}
				panel3.add(toolBar1, new GridBagConstraints(0, 0, 1, 1, 0.0,
						0.0, GridBagConstraints.CENTER,
						GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 5),
						0, 0));

				// ======== panel4 ========
				{
					panel4.setLayout(new GridBagLayout());
					((GridBagLayout) panel4.getLayout()).columnWidths = new int[] {
							0, 0, 0 };
					((GridBagLayout) panel4.getLayout()).rowHeights = new int[] {
							0, 0, 0 };
					((GridBagLayout) panel4.getLayout()).columnWeights = new double[] {
							0.0, 1.0, 1.0E-4 };
					((GridBagLayout) panel4.getLayout()).rowWeights = new double[] {
							0.0, 0.0, 1.0E-4 };

					// ---- label2 ----
					label2.setText("Book Call No:");
					panel4.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0,
							0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5,
									5), 0, 0));

					// ---- txtCallNo ----
					txtCallNo
							.setToolTipText("Search borrow by call number of book");
					panel4.add(txtCallNo, new GridBagConstraints(1, 0, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 5,
									0), 0, 0));

					// ---- label3 ----
					label3.setText("Employee No:");
					panel4.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0,
							0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									5), 0, 0));

					// ---- txtEmpID ----
					txtEmpID.setToolTipText("Search borrow by employee no");
					panel4.add(txtEmpID, new GridBagConstraints(1, 1, 1, 1,
							0.0, 0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									0), 0, 0));
				}
				panel3.add(panel4, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER,
						GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0),
						0, 0));
			}
			panel2.add(panel3, BorderLayout.NORTH);
		}
		add(panel2, BorderLayout.CENTER);
		// End of component initialization
		// //GEN-END:initComponents
	}

	// Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JPanel panel1;
	private JButton btnFirst;
	private JButton btnBack;
	private JLabel lblPage;
	private JButton btnNext;
	private JButton btnLast;
	private JPanel panel2;
	private JScrollPane scrollPane1;
	private JTable tblBorrow;
	private JPanel panel3;
	private JToolBar toolBar1;
	private JButton btnCheckOut;
	private JButton btnCheckIn;
	private JButton btnFee;
	private JButton btnView;
	private JButton btnDelete;
	private JButton btnSearch;
	private JPanel panel4;
	private JLabel label2;
	private JTextField txtCallNo;
	private JLabel label3;
	private JTextField txtEmpID;

	// End of variables declaration //GEN-END:variables
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
	 * @return the tblBorrow
	 */
	public JTable getTblBorrow() {
		return tblBorrow;
	}

	/**
	 * @param tblBorrow
	 *            the tblBorrow to set
	 */
	public void setTblBorrow(JTable tblBorrow) {
		this.tblBorrow = tblBorrow;
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
	 * @return the btnCheckIn
	 */
	public JButton getBtnCheckIn() {
		return btnCheckIn;
	}

	/**
	 * @param btnCheckIn
	 *            the btnCheckIn to set
	 */
	public void setBtnCheckIn(JButton btnCheckIn) {
		this.btnCheckIn = btnCheckIn;
	}

	/**
	 * @return the btnFee
	 */
	public JButton getBtnFee() {
		return btnFee;
	}

	/**
	 * @param btnFee
	 *            the btnFee to set
	 */
	public void setBtnFee(JButton btnFee) {
		this.btnFee = btnFee;
	}

	/**
	 * @return the btnView
	 */
	public JButton getBtnView() {
		return btnView;
	}

	/**
	 * @param btnView
	 *            the btnView to set
	 */
	public void setBtnView(JButton btnView) {
		this.btnView = btnView;
	}

	/**
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}

	/**
	 * @param btnDelete
	 *            the btnDelete to set
	 */
	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	/**
	 * @return the btnSearch
	 */
	public JButton getBtnSearch() {
		return btnSearch;
	}

	/**
	 * @param btnSearch
	 *            the btnSearch to set
	 */
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	/**
	 * @return the txtCallNo
	 */
	public JTextField getTxtCallNo() {
		return txtCallNo;
	}

	/**
	 * @param txtCallNo
	 *            the txtCallNo to set
	 */
	public void setTxtCallNo(JTextField txtCallNo) {
		this.txtCallNo = txtCallNo;
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
}
