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
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.AccessSub;
import model.LibUtil;
import model.LibValid;
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
		subModel.addColumn(Messages.getString("SubjectController.13")); //$NON-NLS-1$
		subModel.addColumn(Messages.getString("SubjectController.14")); //$NON-NLS-1$
		subModel.addColumn(Messages.getString("SubjectController.15")); //$NON-NLS-1$

		// Add event add btn
		view.getBtnAdd().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addSubject();
			}
		});

		// Add event search btn
		view.getBtnSearch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = 1;
				searchSubject();
				tableFocus();
			}
		});

		// Add event edit btn
		view.getBtnEdit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editSubject();
			}
		});

		// Add event view btn
		view.getBtnView().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewSubject();
			}
		});

		// Add event del btn
		view.getBtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteSub();
			}
		});

		// Add event to subject table
		view.getTblSub().addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(java.awt.event.FocusEvent evt) {
				tableFocus();
			}
		});
		view.getTblSub().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					// Set enable action button
					view.getBtnDelete().setEnabled(true);
					view.getBtnEdit().setEnabled(true);
					view.getBtnView().setEnabled(true);
					// If double click display edit subject dialog
					if (evt.getClickCount() == 2) {
						viewSubject();
					}
				}
			}
		});

		// Add event enter key
		getView().getTxtSubID().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchSubject();
				}
			}
		});
		getView().getTxtSubName().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchSubject();
				}
			}
		});

		// Add event navigation btn
		view.getBtnNext().addActionListener(new ActionListener() {

			@Override
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

			@Override
			public void actionPerformed(ActionEvent e) {
				if (page != 1 && LibUtil.getInstance().getPage(totalRow) != 0) {
					page--;
				}
				searchSubject();
			}
		});
		view.getBtnFirst().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = 1;
				searchSubject();
			}
		});
		view.getBtnLast().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = LibUtil.getInstance().getPage(totalRow);
				searchSubject();
			}
		});
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
						Messages.getString("SubjectController.0"),
						Messages.getString("SubjectController.1"), //$NON-NLS-1$ 
						JOptionPane.INFORMATION_MESSAGE);
				view.getTxtSubID().setText(Messages.getString("EmptyText")); //$NON-NLS-1$
				view.getTxtSubName().setText(Messages.getString("EmptyText")); //$NON-NLS-1$
				view.getBtnLast().doClick();
			}
		}
		parent.doBlur();
		view.getTblSub().changeSelection(view.getTblSub().getRowCount() - 1, 0,
				false, false);
	}

	/**
	 * Delete a subject
	 */
	private void deleteSub() {
		parent.doBlur();
		int sure = JOptionPane.showConfirmDialog(parent.getView(),
				Messages.getString("SubjectController.4"),
				Messages.getString("SubjectController.5"), //$NON-NLS-1$ 
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (sure == JOptionPane.OK_OPTION) {
			// Get subID selected
			String subID = view.getTblSub()
					.getValueAt(view.getTblSub().getSelectedRow(), 0)
					.toString();
			if (!AccessSub.getInstance().deleteSub(Integer.parseInt(subID))) {
				JOptionPane.showMessageDialog(
						parent.getView(),
						Messages.getString("SubjectController.6") //$NON-NLS-1$
								+ Messages.getString("SubjectController.7"), //$NON-NLS-1$
						Messages.getString("SubjectController.8"),
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(parent.getView(),
						Messages.getString("SubjectController.9"),
						Messages.getString("SubjectController.10"), //$NON-NLS-1$ 
						JOptionPane.INFORMATION_MESSAGE);
				subModel.removeRow(view.getTblSub().getSelectedRow());
			}
		}
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
				JOptionPane.showMessageDialog(
						getView(),
						Messages.getString("SubjectController.11"), //$NON-NLS-1$
						Messages.getString("SubjectController.12"),
						JOptionPane.INFORMATION_MESSAGE);
				// Remove old data on table model
				subModel.removeRow(view.getTblSub().getSelectedRow());
				// Add new row
				subModel.addRow(sub.toVector());
			}
		}
		parent.doBlur();
		// Set selection to edited subject
		view.getTblSub().changeSelection(view.getTblSub().getRowCount() - 1, 0,
				false, false);
	}

	/**
	 * @return the view
	 */
	public SubjectPanel getView() {
		return view;
	}

	/**
	 * Search subject
	 */
	public void searchSubject() {
		if (!LibValid.getInstance().SubID(view.getTxtSubID().getText())) {
			JOptionPane.showMessageDialog(
					view,
					Messages.getString("SubjectController.16"), //$NON-NLS-1$
					Messages.getString("SubjectController.17"),
					JOptionPane.ERROR_MESSAGE);
		} else {
			parent.removeModel(subModel);
			totalRow = AccessSub.getInstance().searchSubject(subModel,
					getView().getTxtSubID().getText(),
					getView().getTxtSubName().getText(), (page - 1));

			view.getLblPage().setText(
					Messages.getString("SubjectController.18") + page
							+ Messages.getString("SubjectController.19") //$NON-NLS-1$ 
							+ LibUtil.getInstance().getPage(totalRow));
		}
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(SubjectPanel view) {
		this.view = view;
	}

	/**
	 * Do lost focus table
	 */
	private void tableFocus() {
		// Set disable action button
		view.getBtnEdit().setEnabled(false);
		view.getBtnDelete().setEnabled(false);
		view.getBtnView().setEnabled(false);
		view.getTblSub().setFocusable(false);
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
}
