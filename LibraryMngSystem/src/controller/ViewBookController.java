/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import model.AccessBook;
import view.ViewBookDialog;
import entity.Book;

/**
 * View book controller, control view book dialog
 * 
 * @author CuongNQ
 */
public class ViewBookController {

	// Defined
	private Book book = null;
	private ViewBookDialog view;
	private DefaultTableModel borModel;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param book
	 */
	public ViewBookController(ViewBookDialog view, Book book) {
		this.view = view;
		this.book = book;
		initComponent();
		getBookBorDetail();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {
		// Set all information
		view.getLblID().setText(Integer.toString(book.getBookID()));
		view.getLblCallNo().setText(book.getCallNumber());
		view.getLblISBN().setText(book.getISBN());
		view.getLblTitle().setText(book.getTitle());
		view.getLblAuthor().setText(book.getAuthName());
		view.getLblPublish().setText(book.getPublisher());
		view.getLblSubject().setText(book.getSubName());
		view.getLblCopy().setText(String.valueOf(book.getNoOfCopy()));
		view.getLblLib().setText(String.valueOf(book.getNoInLib()));

		// Add event btn close
		view.getBtnClose().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				view.dispose();
			}
		});

		// Create bor model
		borModel = new DefaultTableModel() {

			public boolean isCellEditable(int column, int row) {
				return false;
			}
		};
		borModel.addColumn("Borrow No");
		borModel.addColumn("Employee No");
		borModel.addColumn("Name");
		borModel.addColumn("Department");
		borModel.addColumn("Issue Date");
		borModel.addColumn("Due Date");
		borModel.addColumn("Issue Status");
		borModel.addColumn("Return Date");
		borModel.addColumn("Total Fee");

		// Add model to table
		view.getTblBor().setModel(borModel);
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * Get borrow information of book
	 */
	private void getBookBorDetail() {
		AccessBook.getInstance().getBookBorInfo(borModel, book.getBookID());
	}

	/**
	 * @return the view
	 */
	public ViewBookDialog getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(ViewBookDialog view) {
		this.view = view;
	}
}
