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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.AccessSub;
import model.LibBook;
import model.LibValid;
import view.AddBookDialog;
import entity.Book;

/**
 * Add a book controller, control add book dialog
 * 
 * @author CuongNQ
 */
public class AddBookController {

	// Defined
	private Book book = null;
	private AddBookDialog view;

	/**
	 * Default constructor
	 * 
	 * @param view
	 */
	public AddBookController(AddBookDialog view) {
		this.view = view;
		initComponent();
	}

	/**
	 * initialize the controller.
	 */
	private void initComponent() {
		// Create new instance of book
		book = new Book();

		// Add default value
		view.getSpinCopy().setValue(1);
		view.getSpinLib().setValue(1);

		// Add event cancel btn
		view.getBtnCancel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				book = null;
				view.dispose();
			}
		});

		// Add window event
		view.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent evt) {
				book = null;
			}
		});

		// Add event window opened
		view.addWindowListener(new java.awt.event.WindowAdapter() {

			@Override
			public void windowOpened(java.awt.event.WindowEvent evt) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						// Load subject list
						String[] subList = AccessSub
								.getInstance()
								.getAllSubjectName()
								.split(Messages
										.getString("AddBookController.0")); //$NON-NLS-1$
						for (String subName : subList) {
							view.getCbxSub().addItem(subName);
						}
					}
				}).start();
			}
		});

		// Add event add btn
		view.getBtnAdd().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (validBook()) {
					// set object
					toObject();
					// Dispose this dialog
					view.dispose();
				}
			}
		});

		// Add event sniper txt no book
		view.getSpinCopy().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// set min value
				if (Integer.parseInt(view.getSpinCopy().getValue().toString()) < 1) {
					view.getSpinCopy().setValue(1);
				}
				// set both field
				view.getSpinLib().setValue(view.getSpinCopy().getValue());
			}
		});
		// Escape dialog by key
		model.LibUtil.installEscapeCloseOperation(view);
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @return the view
	 */
	public AddBookDialog getView() {
		return view;
	}

	/**
	 * @param book
	 *            the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(AddBookDialog view) {
		this.view = view;
	}

	/**
	 * Set all field to object
	 */
	private void toObject() {
		book.setISBN(view.getTxtISBN().getText());
		book.setTitle(view.getTxtTitle().getText());
		book.setAuthName(view.getTxtAuthor().getText());
		book.setPublisher(view.getTxtPublisher().getText());
		book.setNoOfCopy(new Integer(view.getSpinCopy().getValue().toString()));
		book.setNoInLib(new Integer(view.getSpinLib().getValue().toString()));
		book.setSubID(AccessSub.getInstance().getSubjectID(
				view.getCbxSub().getSelectedItem().toString()));
		book.setCallNumber(LibBook.getInstance().generateCallNo(book));
	}

	/**
	 * Valid all field display appropriate message
	 * 
	 * @return
	 */
	private boolean validBook() {
		if (view.getCbxSub().getSelectedItem().toString().length() <= 0) {
			JOptionPane.showMessageDialog(view,
					Messages.getString("AddBookController.1"),//$NON-NLS-1$
					Messages.getString("ErrorTitle"), //$NON-NLS-1$ 
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!LibValid.getInstance().ISBN(view.getTxtISBN().getText())) {
			JOptionPane.showMessageDialog(view,
					Messages.getString("AddBookController.3"),//$NON-NLS-1$
					Messages.getString("ValidTitle"), //$NON-NLS-1$ 
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtISBN().requestFocus();
			return false;
		}
		if (!LibValid.getInstance().Title(view.getTxtTitle().getText())) {
			JOptionPane.showMessageDialog(view,
					Messages.getString("AddBookController.5"),//$NON-NLS-1$
					Messages.getString("ValidTitle"), //$NON-NLS-1$ 
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtTitle().requestFocus();
			return false;
		}
		if (!LibValid.getInstance().Auth(view.getTxtAuthor().getText())) {
			JOptionPane.showMessageDialog(view,
					Messages.getString("AddBookController.7"),//$NON-NLS-1$
					Messages.getString("ValidTitle"), //$NON-NLS-1$ 
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtAuthor().requestFocus();
			return false;
		}
		if (!LibValid.getInstance().Publish(view.getTxtPublisher().getText())) {
			JOptionPane.showMessageDialog(view,
					Messages.getString("AddBookController.9"), //$NON-NLS-1$
					Messages.getString("ValidTitle"),//$NON-NLS-1$
					JOptionPane.INFORMATION_MESSAGE);
			view.getTxtPublisher().requestFocus();
			return false;
		}
		return true;
	}
}
