/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.AccessBorrow;
import view.ViewBorrowDialog;

/**
 * View borrow controller, control view borrow dialog
 * 
 * @author CuongNQ
 */
public class ViewBorrowController {

	// Defined
	private ViewBorrowDialog view;
	private int borID;
	private int empID;
	private int bookID;
	private String[] arr;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param borID
	 * @param empID
	 * @param bookID
	 */
	public ViewBorrowController(ViewBorrowDialog view, int borID, int empID,
			int bookID) {
		this.view = view;
		this.borID = borID;
		this.empID = empID;
		this.bookID = bookID;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {
		arr = new String[21];
		AccessBorrow.getInstance().getFullBorInfo(arr, borID, empID, bookID);
		view.getLblEmpID().setText(arr[0]);
		view.getLblName().setText(arr[1]);
		view.getLblDOB().setText(arr[2]);
		view.getLblGender().setText(arr[3]);
		view.getLblEmail().setText(arr[4]);
		view.getLblDepart().setText(arr[5]);
		view.getLblAdd().setText(arr[6]);
		view.getLblPhone().setText(arr[7]);
		view.getLblPermission().setText(arr[8]);
		view.getLblBorID().setText(arr[9]);
		view.getLblIssueStatus().setText(arr[10]);
		view.getLblIssueDate().setText(arr[11]);
		view.getLblDueDate().setText(arr[12]);
		view.getLblReturnDate().setText(arr[13]);
		view.getLblFee().setText(arr[14]);
		view.getLblCallNo().setText(arr[15]);
		view.getLblISBN().setText(arr[16]);
		view.getLblTitle().setText(arr[17]);
		view.getLblAuthor().setText(arr[18]);
		view.getLblPublish().setText(arr[19]);
		view.getLblSubject().setText(arr[20]);

		// Add event close btn
		view.getBtnClose().addActionListener(new ActionListener() {

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
	public ViewBorrowDialog getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(ViewBorrowDialog view) {
		this.view = view;
	}
}
