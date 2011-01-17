/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.LibValid;
import view.EditSubjectDialog;
import entity.Subject;

/**
 * Edit subject controller, control edit subject dialog
 * 
 * @author CuongNQ
 */
public class EditSubjectController {

	// Defined employee and edit dialog
	private Subject sub = null;
	private EditSubjectDialog view;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param sub
	 */
	public EditSubjectController(EditSubjectDialog view, Subject sub) {
		this.view = view;
		this.sub = sub;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {
		// Set field
		view.getTxtName().setText(sub.getSubName());
		view.getTxtDes().setText(sub.getDescription());

		// Add event cancel btn
		view.getBtnCancel().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				sub = null;
				view.dispose();
			}
		});

		// Add event close window
		view.addWindowListener(new java.awt.event.WindowAdapter() {

			public void windowClosing(java.awt.event.WindowEvent evt) {
				sub = null;
				view.dispose();
			}
		});

		// Add event save btn
		view.getBtnSave().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (LibValid.getInstance().Sub(view.getTxtName().getText())) {
					sub.setSubName(view.getTxtName().getText());
					sub.setDescription(view.getTxtDes().getText());
					view.dispose();
				} else {
					JOptionPane.showMessageDialog(view,
							"Subject name not valid.", "Valid!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * @return the sub
	 */
	public Subject getSub() {
		return sub;
	}

	/**
	 * @param sub
	 *            the sub to set
	 */
	public void setSub(Subject sub) {
		this.sub = sub;
	}

	/**
	 * @return the view
	 */
	public EditSubjectDialog getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(EditSubjectDialog view) {
		this.view = view;
	}
}
