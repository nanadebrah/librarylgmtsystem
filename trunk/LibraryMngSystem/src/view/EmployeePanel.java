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
public class EmployeePanel extends JPanel {
	public EmployeePanel() {
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
		tblEmp = new JTable();
		panel3 = new JPanel();
		toolBar1 = new JToolBar();
		btnAdd = new JButton();
		btnEdit = new JButton();
		btnView = new JButton();
		btnDelete = new JButton();
		btnSearch = new JButton();
		panel4 = new JPanel();
		label2 = new JLabel();
		txtEmpID = new JTextField();
		label3 = new JLabel();
		txtEmpName = new JTextField();

		//======== this ========
		setLayout(new BorderLayout());

		//======== panel1 ========
		{
			panel1.setLayout(new FlowLayout());

			//---- btnFirst ----
			btnFirst.setBorderPainted(false);
			btnFirst.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/First.png")));
			panel1.add(btnFirst);

			//---- btnBack ----
			btnBack.setBorderPainted(false);
			btnBack.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Back.png")));
			panel1.add(btnBack);

			//---- lblPage ----
			lblPage.setText("Page");
			panel1.add(lblPage);

			//---- btnNext ----
			btnNext.setBorderPainted(false);
			btnNext.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Next.png")));
			panel1.add(btnNext);

			//---- btnLast ----
			btnLast.setBorderPainted(false);
			btnLast.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Last.png")));
			panel1.add(btnLast);
		}
		add(panel1, BorderLayout.SOUTH);

		//======== panel2 ========
		{
			panel2.setLayout(new BorderLayout());

			//======== scrollPane1 ========
			{

				//---- tblEmp ----
				tblEmp.setModel(new DefaultTableModel(2, 0));
				scrollPane1.setViewportView(tblEmp);
			}
			panel2.add(scrollPane1, BorderLayout.CENTER);

			//======== panel3 ========
			{
				panel3.setLayout(new GridBagLayout());
				((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 0, 0};
				((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0};
				((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
				((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

				//======== toolBar1 ========
				{
					toolBar1.setFloatable(false);

					//---- btnAdd ----
					btnAdd.setText("Add");
					btnAdd.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Add.png")));
					btnAdd.setBorderPainted(false);
					btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
					btnAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnAdd.setMnemonic('A');
					toolBar1.add(btnAdd);
					toolBar1.addSeparator();

					//---- btnEdit ----
					btnEdit.setText("Edit");
					btnEdit.setBorderPainted(false);
					btnEdit.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Edit.png")));
					btnEdit.setHorizontalTextPosition(SwingConstants.CENTER);
					btnEdit.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnEdit.setEnabled(false);
					btnEdit.setRequestFocusEnabled(false);
					btnEdit.setMnemonic('I');
					toolBar1.add(btnEdit);

					//---- btnView ----
					btnView.setText("View");
					btnView.setBorderPainted(false);
					btnView.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/View.png")));
					btnView.setHorizontalTextPosition(SwingConstants.CENTER);
					btnView.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnView.setEnabled(false);
					btnView.setRequestFocusEnabled(false);
					btnView.setMnemonic('V');
					toolBar1.add(btnView);

					//---- btnDelete ----
					btnDelete.setText("Delete");
					btnDelete.setBorderPainted(false);
					btnDelete.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Delete.png")));
					btnDelete.setHorizontalTextPosition(SwingConstants.CENTER);
					btnDelete.setVerticalTextPosition(SwingConstants.BOTTOM);
					btnDelete.setEnabled(false);
					btnDelete.setRequestFocusEnabled(false);
					btnDelete.setMnemonic('T');
					toolBar1.add(btnDelete);
					toolBar1.addSeparator();

					//---- btnSearch ----
					btnSearch.setText("Search");
					btnSearch.setBorderPainted(false);
					btnSearch.setIcon(new ImageIcon(getClass().getResource("/view/images/taskbarImages/Search.png")));
					btnSearch.setHorizontalTextPosition(SwingConstants.CENTER);
					btnSearch.setVerticalTextPosition(SwingConstants.BOTTOM);
					toolBar1.add(btnSearch);
				}
				panel3.add(toolBar1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(0, 0, 0, 5), 0, 0));

				//======== panel4 ========
				{
					panel4.setLayout(new GridBagLayout());
					((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 0, 0};
					((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0, 0};
					((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
					((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

					//---- label2 ----
					label2.setText("Employee No:");
					panel4.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 5, 5), 0, 0));
					panel4.add(txtEmpID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 5, 0), 0, 0));

					//---- label3 ----
					label3.setText("Employee Name:");
					panel4.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 5), 0, 0));
					panel4.add(txtEmpName, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(0, 0, 0, 0), 0, 0));
				}
				panel3.add(panel4, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			panel2.add(panel3, BorderLayout.NORTH);
		}
		add(panel2, BorderLayout.CENTER);
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
	private JTable tblEmp;
	private JPanel panel3;
	private JToolBar toolBar1;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnView;
	private JButton btnDelete;
	private JButton btnSearch;
	private JPanel panel4;
	private JLabel label2;
	private JTextField txtEmpID;
	private JLabel label3;
	private JTextField txtEmpName;
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
	 * @return the tblEmp
	 */
	public JTable getTblEmp() {
		return tblEmp;
	}

	/**
	 * @param tblEmp
	 *            the tblEmp to set
	 */
	public void setTblEmp(JTable tblEmp) {
		this.tblEmp = tblEmp;
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
	 * @return the btnEdit
	 */
	public JButton getBtnEdit() {
		return btnEdit;
	}

	/**
	 * @param btnEdit
	 *            the btnEdit to set
	 */
	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
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
}
