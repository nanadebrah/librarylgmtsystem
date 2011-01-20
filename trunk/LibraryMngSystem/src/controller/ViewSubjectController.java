/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ViewSubjectDialog;
import entity.Subject;

/**
 * View subject controller, control view subject dialog
 * 
 * @author CuongNQ
 */
public class ViewSubjectController {

	// Defined
	private Subject sub = null;
	private ViewSubjectDialog view;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param sub
	 */
	public ViewSubjectController(ViewSubjectDialog view, Subject sub) {
		this.view = view;
		this.sub = sub;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {
		// Set field
		view.getLblID().setText(new Integer(sub.getSubID()).toString());
		view.getLblName().setText(sub.getSubName());
		view.getTxtDes().setText(sub.getDescription());
		// Add event close btn
		view.getBtnClose().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * @return the view
	 */
	public ViewSubjectDialog getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(ViewSubjectDialog view) {
		this.view = view;
	}
}
