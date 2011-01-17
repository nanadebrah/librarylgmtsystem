/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.AccessSub;
import model.LibUtil;
import view.AddSubjectDialog;
import view.EditSubjectDialog;
import view.SubjectPanel;
import view.ViewSubjectDialog;
import entity.Subject;

/**
 * Subject controller, control subject panel
 * 
 * @author CuongNQ
 */
public class SubjectController {

	// Defined
	private SubjectPanel view;
	private DefaultTableModel subModel;
	private AddSubjectController addSubject;
	private EditSubjectController editSubject;
	private ViewSubjectController viewSubject;
	private ManageController parent;
	private int page;
	private int totalRow;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param subModel
	 * @param manage
	 */
	public SubjectController(SubjectPanel view, DefaultTableModel subModel,
			ManageController manage) {
		this.view = view;
		this.subModel = subModel;
		this.parent = manage;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {

		// Set default page
		page = 1;
		totalRow = 1;
		// Set selection mode
		getView().getTblSub().setSelectionMode(
				ListSelectionModel.SINGLE_SELECTION);
		// Add model to table
		getView().getTblSub().setModel(subModel);
		// Set model
		subModel.addColumn("Subject No");
		subModel.addColumn("Subject Name");
		subModel.addColumn("Description");

		// Add event add btn
		view.getBtnAdd().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				addSubject();
			}
		});

		// Add event search btn
		view.getBtnSearch().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				page = 1;
				searchSubject();
				tableFocus();
			}
		});

		// Add event edit btn
		view.getBtnEdit().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				editSubject();
			}
		});

		// Add event view btn
		view.getBtnView().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				viewSubject();
			}
		});

		// Add event del btn
		view.getBtnDelete().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				deleteSub();
			}
		});

		// Add event to subject table
		view.getTblSub().addFocusListener(new FocusAdapter() {

			public void focusLost(java.awt.event.FocusEvent evt) {
				tableFocus();
			}
		});
		view.getTblSub().addMouseListener(new MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				// Set enable acction button
				view.getBtnDelete().setEnabled(true);
				view.getBtnEdit().setEnabled(true);
				view.getBtnView().setEnabled(true);
				// If double click display edit subject dialog
				if (evt.getClickCount() == 2) {
					viewSubject();
				}
			}
		});

		// Add event enter key
		getView().getTxtSubID().addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchSubject();
				}
			}
		});
		getView().getTxtSubName().addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchSubject();
				}
			}
		});

		// Add event navigation btn
		view.getBtnNext().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (page == LibUtil.getInstance().getPage(totalRow)
						|| LibUtil.getInstance().getPage(totalRow) == 0) {
					return;
				} else {
					page++;
					searchSubject();
				}
			}
		});
		view.getBtnBack().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (page != 1 && LibUtil.getInstance().getPage(totalRow) != 0) {
					page--;
				}
				searchSubject();
			}
		});
		view.getBtnFirst().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				page = 1;
				searchSubject();
			}
		});
		view.getBtnLast().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				page = LibUtil.getInstance().getPage(totalRow);
				searchSubject();
			}
		});
	}

	/**
	 * Delete a subject
	 */
	private void deleteSub() {
		parent.doBlur();
		int sure = JOptionPane.showConfirmDialog(parent.getView(),
				"You sure want delete this subject!", "Delete subject",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (sure == JOptionPane.OK_OPTION) {
			// Get subID selected
			String subID = view.getTblSub()
					.getValueAt(view.getTblSub().getSelectedRow(), 0)
					.toString();
			if (!AccessSub.getInstance().deleteSub(Integer.parseInt(subID))) {
				JOptionPane.showMessageDialog(parent.getView(),
						"Delete failed!\n"
								+ "May be many books is using this subject.",
						"Error!", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(parent.getView(),
						"Delete successful!", "Successful!",
						JOptionPane.INFORMATION_MESSAGE);
				subModel.removeRow(view.getTblSub().getSelectedRow());
			}
		}
		tableFocus();
		parent.doBlur();
	}

	/**
	 * View subject
	 */
	private void viewSubject() {
		// Get Id subject selected
		String subID = view.getTblSub()
				.getValueAt(view.getTblSub().getSelectedRow(), 0).toString();
		// Get subject from database
		Subject sub = AccessSub.getInstance().getSubject(new Integer(subID));
		parent.doBlur();
		// Create instance of subject edit dialog and display it
		viewSubject = new ViewSubjectController(new ViewSubjectDialog(
				parent.getView()), sub);
		viewSubject.getView().setVisible(true);
		tableFocus();
		parent.doBlur();
	}

	/**
	 * Edit subject
	 */
	private void editSubject() {
		parent.doBlur();
		// Get Id subject selected
		String subID = view.getTblSub()
				.getValueAt(view.getTblSub().getSelectedRow(), 0).toString();
		// Get subject from database
		Subject sub = AccessSub.getInstance().getSubject(new Integer(subID));
		// Create instance of subject edit dialog and display it
		editSubject = new EditSubjectController(new EditSubjectDialog(
				parent.getView()), sub);
		editSubject.getView().setVisible(true);
		// Update data on database
		if (editSubject.getSub() != null) {
			if (AccessSub.getInstance().editSub(editSubject.getSub())) {
				JOptionPane.showMessageDialog(getView(), "Update successful",
						"Successful!", JOptionPane.INFORMATION_MESSAGE);
				// Remove old data on table model
				subModel.removeRow(view.getTblSub().getSelectedRow());
				// Add new row
				subModel.addRow(sub.toVector());
			}
		}
		tableFocus();
		parent.doBlur();
	}

	/**
	 * Do lost focus table
	 */
	private void tableFocus() {
		// Set disable acction button
		view.getBtnEdit().setEnabled(false);
		view.getBtnDelete().setEnabled(false);
		view.getBtnView().setEnabled(false);
		view.getTblSub().setFocusable(false);
	}

	/**
	 * Seacrh subject
	 */
	public void searchSubject() {
		parent.removeModel(subModel);
		totalRow = AccessSub.getInstance().searchSubject(subModel,
				getView().getTxtSubID().getText(),
				getView().getTxtSubName().getText(), (page - 1));

		view.getLblPage().setText(
				"Page " + page + "/" + LibUtil.getInstance().getPage(totalRow));
	}

	/**
	 * Add an subject
	 */
	private void addSubject() {
		parent.doBlur();
		// Display Add subject dialog
		addSubject = new AddSubjectController(new AddSubjectDialog(
				parent.getView()));
		addSubject.getView().setVisible(true);
		// invoked method add subject
		if (addSubject.getSub() != null) {
			if (AccessSub.getInstance().addSubject(addSubject.getSub())) {
				JOptionPane.showMessageDialog(getView(),
						"Add subject successful", "Successful!",
						JOptionPane.INFORMATION_MESSAGE);
				view.getTxtSubID().setText("");
				view.getTxtSubName().setText("");
				view.getBtnLast().doClick();
			}
		}
		tableFocus();
		parent.doBlur();
	}

	/**
	 * @return the view
	 */
	public SubjectPanel getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(SubjectPanel view) {
		this.view = view;
	}
}
