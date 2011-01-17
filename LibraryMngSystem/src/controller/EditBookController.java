/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.AccessSub;
import model.LibBook;
import model.LibValid;
import view.EditBookDialog;
import entity.Book;

/**
 * Edit book controller, control edit book dialog
 * 
 * @author CuongNQ
 */
public class EditBookController {

	// Defined book and edit dialog
	private Book book = null;
	private EditBookDialog view;
	private int noCopies, noInLib;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param book
	 */
	public EditBookController(EditBookDialog view, Book book) {
		this.view = view;
		this.book = book;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {
		// Set all field of form
		setField();

		// Add event add btn
		view.getBtnSave().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (validBook()) {
					toObject();
					view.dispose();
				}
			}
		});

		// Add event cancel btn
		view.getBtnCancel().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				book = null;
				view.dispose();
			}
		});

		// Add event spinner txt no book
		view.getSpinCopy().addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				balance();
			}
		});

		// Add event windows closing
		view.addWindowListener(new java.awt.event.WindowAdapter() {

			public void windowClosing(java.awt.event.WindowEvent evt) {
				book = null;
				view.dispose();
			}
		});
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * Valid all field display appropriate message
	 * 
	 * @return
	 */
	private boolean validBook() {
		if (view.getCbxSub().getSelectedItem().toString().length() <= 0) {
			JOptionPane.showMessageDialog(view,
					"You need add minimum 1 subject!", "Error!",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!LibValid.getInstance().ISBN(view.getTxtISBN().getText())) {
			JOptionPane.showMessageDialog(view, "ISBN must valid.", "Valid!",
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtISBN().requestFocus();
			return false;
		}
		if (!LibValid.getInstance().Title(view.getTxtTitle().getText())) {
			JOptionPane.showMessageDialog(view, "Title must valid.", "Valid!",
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtTitle().requestFocus();
			return false;
		}
		if (!LibValid.getInstance().Auth(view.getTxtAuthor().getText())) {
			JOptionPane.showMessageDialog(view, "Author must valid.", "Valid!",
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtAuthor().requestFocus();
			return false;
		}
		if (!LibValid.getInstance().Publish(view.getTxtPublisher().getText())) {
			JOptionPane.showMessageDialog(view, "Publisher must valid.",
					"Valid!", JOptionPane.INFORMATION_MESSAGE);
			view.getTxtPublisher().requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * Transfer all field to object
	 */
	private void toObject() {
		book.setISBN(view.getTxtISBN().getText());
		book.setTitle(view.getTxtTitle().getText());
		book.setAuthName(view.getTxtAuthor().getText());
		book.setPublisher(view.getTxtPublisher().getText());
		book.setNoOfCopy(Integer.parseInt(view.getSpinCopy().getValue()
				.toString()));
		book.setNoInLib(Integer.parseInt(view.getSpinLib().getValue()
				.toString()));
		book.setSubID(AccessSub.getInstance().getSubjectID(
				view.getCbxSub().getSelectedItem().toString()));
		book.setSubName(view.getCbxSub().getSelectedItem().toString());
		book.setCallNumber(LibBook.getInstance().fixCallNo(book));
	}

	/**
	 * Balance value copies and value in library
	 */
	private void balance() {
		// Defined new no of copies value
		int newNoC = Integer.parseInt(view.getSpinCopy().getValue().toString());

		// Neu so copy bang so trong kho
		if (noCopies == noInLib) {
			if (newNoC < 1) {
				view.getSpinCopy().setValue(1);
				view.getSpinLib().setValue(1);
			} else {
				view.getSpinLib().setValue(newNoC);
			}
		} else {// Neu chung ko bang nhau
			// Neu so moi nho hon so cu tuc la tru
			if (newNoC < noCopies) {
				// Neu so giam di ma lon hon so trong kho
				if ((noCopies - newNoC) > noInLib) {
					// set so trong kho bang 0 va set so copy bang hieu voi so
					// trong kho
					view.getSpinLib().setValue(0);
					view.getSpinCopy().setValue(noCopies - noInLib);
				} else {// Neu khong la so tru di nho hon so trong kho
					view.getSpinLib().setValue(noInLib - (noCopies - newNoC));
				}
			} else {// Neu khong la cong
				view.getSpinLib().setValue(noInLib + (newNoC - noCopies));
			}
		}
	}

	/**
	 * Set all info to field
	 */
	private void setField() {
		if (book != null) {
			noCopies = book.getNoOfCopy();
			noInLib = book.getNoInLib();
			view.getTxtISBN().setText(book.getISBN());
			view.getTxtTitle().setText(book.getTitle());
			view.getTxtAuthor().setText(book.getAuthName());
			view.getTxtPublisher().setText(book.getPublisher());
			view.getSpinCopy().setValue(noCopies);
			view.getSpinLib().setValue(noInLib);

			// Load subject list
			String[] subList = AccessSub.getInstance().getAllSubjectName()
					.split(",");
			for (String subName : subList) {
				view.getCbxSub().addItem(subName);
				if (subName.equals(book.getSubName())) {
					view.getCbxSub().setSelectedItem(subName);
				}
			}
		}
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book
	 *            the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @return the view
	 */
	public EditBookDialog getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(EditBookDialog view) {
		this.view = view;
	}
}
