/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import model.LibValid;
import view.AddSubjectDialog;
import entity.Subject;

/**
 * Add subject controller, control add subject dialog
 * 
 * @author CuongNQ
 */
public class AddSubjectController {

	// Defined
	private Subject sub = null;
	private AddSubjectDialog view;

	/**
	 * Default constructor
	 * 
	 * @param view
	 */
	public AddSubjectController(AddSubjectDialog view) {
		this.view = view;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {
		// Create new employee
		sub = new Subject();

		// Add event close btn
		view.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sub = null;
				view.dispose();
			}
		});

		// Add event add btn
		view.getBtnAdd().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (LibValid.getInstance().Sub(view.getTxtName().getText())) {
					// set object
					toObject();
					// Dispose this dialog
					view.dispose();
				} else {
					JOptionPane.showMessageDialog(view,
							Messages.getString("AddSubjectController.0"),
							Messages.getString("ValidTitle"), //$NON-NLS-1$ 
							JOptionPane.INFORMATION_MESSAGE);
					view.getTxtName().requestFocus();
				}
			}
		});

		// Add window event
		view.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent evt) {
				sub = null;
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
	 * @return the view
	 */
	public AddSubjectDialog getView() {
		return view;
	}

	/**
	 * @param sub
	 *            the sub to set
	 */
	public void setSub(Subject sub) {
		this.sub = sub;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(AddSubjectDialog view) {
		this.view = view;
	}

	/*
	 * Transfer all field to object
	 */
	private void toObject() {
		sub.setSubName(view.getTxtName().getText());
		sub.setDescription(view.getTxtDes().getText());
	}
}
