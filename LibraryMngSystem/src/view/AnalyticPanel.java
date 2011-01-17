/*
 * Created by JFormDesigner on Mon Jan 17 15:39:03 GMT+07:00 2011
 */

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
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXDatePicker;

/**
 * @author Nanette G Hutchison
 */
public class AnalyticPanel extends JPanel {
	public AnalyticPanel() {
		initComponents();
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
	 * @return the tblAna
	 */
	public JTable getTblAna() {
		return tblAna;
	}

	/**
	 * @param tblAna
	 *            the tblAna to set
	 */
	public void setTblAna(JTable tblAna) {
		this.tblAna = tblAna;
	}

	/**
	 * @return the btnTopBook
	 */
	public JButton getBtnTopBook() {
		return btnTopBook;
	}

	/**
	 * @param btnTopBook
	 *            the btnTopBook to set
	 */
	public void setBtnTopBook(JButton btnTopBook) {
		this.btnTopBook = btnTopBook;
	}

	/**
	 * @return the btnTopBorrow
	 */
	public JButton getBtnTopBorrow() {
		return btnTopBorrow;
	}

	/**
	 * @param btnTopBorrow
	 *            the btnTopBorrow to set
	 */
	public void setBtnTopBorrow(JButton btnTopBorrow) {
		this.btnTopBorrow = btnTopBorrow;
	}

	/**
	 * @return the btnAlert
	 */
	public JButton getBtnAlert() {
		return btnAlert;
	}

	/**
	 * @param btnAlert
	 *            the btnAlert to set
	 */
	public void setBtnAlert(JButton btnAlert) {
		this.btnAlert = btnAlert;
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

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		panel1 = new JPanel();
		btnFirst = new JButton();
		btnBack = new JButton();
		lblPage = new JLabel();
		btnNext = new JButton();
		btnLast = new JButton();
		panel2 = new JPanel();
		scrollPane1 = new JScrollPane();
		tblAna = new JTable();
		panel3 = new JPanel();
		toolBar1 = new JToolBar();
		btnTopBook = new JButton();
		btnTopBorrow = new JButton();
		btnAlert = new JButton();
		btnSearch = new JButton();
		panel4 = new JPanel();
		label2 = new JLabel();
		txtDueDate = new JXDatePicker();

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

				// ---- tblAna ----
				tblAna.setModel(new DefaultTableModel(2, 0));
				scrollPane1.setViewportView(tblAna);
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

					// ---- btnTopBook ----
					btnTopBook.setText("Top Book");
					btnTopBook.setIcon(new ImageIcon(getClass().getResource(
							"/view/images/taskbarImages/TopBook.png")));
					btnTopBook.setBorderPainted(false);
					btnTopBook.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnTopBook.setHorizontalTextPosition(SwingConstants.CENTER);
					toolBar1.add(btnTopBook);

					// ---- btnTopBorrow ----
					btnTopBorrow.setText("Top Borrower");
					btnTopBorrow.setBorderPainted(false);
					btnTopBorrow.setIcon(new ImageIcon(getClass().getResource(
							"/view/images/taskbarImages/TopBorrower.png")));
					btnTopBorrow.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnTopBorrow
							.setHorizontalTextPosition(SwingConstants.CENTER);
					toolBar1.add(btnTopBorrow);

					// ---- btnAlert ----
					btnAlert.setText("Overdue Alert");
					btnAlert.setBorderPainted(false);
					btnAlert.setIcon(new ImageIcon(getClass().getResource(
							"/view/images/taskbarImages/SendAlert.png")));
					btnAlert.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnAlert.setHorizontalTextPosition(SwingConstants.CENTER);
					btnAlert.setEnabled(false);
					btnAlert.setRequestFocusEnabled(false);
					toolBar1.add(btnAlert);

					// ---- btnSearch ----
					btnSearch.setText("Search");
					btnSearch.setBorderPainted(false);
					btnSearch.setIcon(new ImageIcon(getClass().getResource(
							"/view/images/taskbarImages/Search.png")));
					btnSearch.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnSearch.setHorizontalTextPosition(SwingConstants.CENTER);
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
							0, 0 };
					((GridBagLayout) panel4.getLayout()).columnWeights = new double[] {
							0.0, 1.0, 1.0E-4 };
					((GridBagLayout) panel4.getLayout()).rowWeights = new double[] {
							0.0, 1.0E-4 };

					// ---- label2 ----
					label2.setText("Due Date:");
					panel4.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0,
							0.0, GridBagConstraints.CENTER,
							GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
									5), 0, 0));
					panel4.add(txtDueDate, new GridBagConstraints(1, 0, 1, 1,
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
		// JFormDesigner - End of component initialization
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JPanel panel1;
	private JButton btnFirst;
	private JButton btnBack;
	private JLabel lblPage;
	private JButton btnNext;
	private JButton btnLast;
	private JPanel panel2;
	private JScrollPane scrollPane1;
	private JTable tblAna;
	private JPanel panel3;
	private JToolBar toolBar1;
	private JButton btnTopBook;
	private JButton btnTopBorrow;
	private JButton btnAlert;
	private JButton btnSearch;
	private JPanel panel4;
	private JLabel label2;
	private JXDatePicker txtDueDate;
	// JFormDesigner - End of variables declaration //GEN-END:variables
}
