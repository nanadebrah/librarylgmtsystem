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

import model.AccessBook;
import model.LibUtil;
import view.AddBookDialog;
import view.BookPanel;
import view.EditBookDialog;
import view.ViewBookDialog;
import entity.Book;

/**
 * Book controller, control book panel
 * 
 * @author CuongNQ
 */
public class BookController {

	// Defined
	private BookPanel view;
	private ManageController parent;
	private DefaultTableModel bookModel;
	private AddBookController addBook;
	private ViewBookController viewBook;
	private EditBookController editBook;
	private int page;
	private int totalRow;

	/**
	 * Default constructor
	 * 
	 * @param view
	 * @param bokModel
	 * @param parent
	 */
	public BookController(BookPanel view, DefaultTableModel bokModel,
			ManageController parent) {
		this.view = view;
		this.bookModel = bokModel;
		this.parent = parent;
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
		view.getTblBook().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Add model to table
		view.getTblBook().setModel(bookModel);
		// Set model
		bookModel.addColumn("No");
		bookModel.addColumn("Call Number");
		bookModel.addColumn("ISBN");
		bookModel.addColumn("Title");
		bookModel.addColumn("Author");
		bookModel.addColumn("Publisher");
		bookModel.addColumn("Subject");
		bookModel.addColumn("Copies/Store");

		// Add event to book table
		view.getTblBook().addFocusListener(new FocusAdapter() {

			public void focusLost(java.awt.event.FocusEvent evt) {
				tableFocus();
			}
		});

		view.getTblBook().addMouseListener(new MouseAdapter() {

			public void mouseClicked(java.awt.event.MouseEvent evt) {
				// Set enable acction button
				view.getBtnEdit().setEnabled(true);
				view.getBtnDelete().setEnabled(true);
				view.getBtnView().setEnabled(true);
				// If double click display edit book dialog
				if (evt.getClickCount() == 2) {
					viewBook();
				}
			}
		});

		// Add event view btn
		view.getBtnView().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				viewBook();
			}
		});

		// Add event add btn
		view.getBtnAdd().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tableFocus();
				addBook();
			}
		});

		// Add event search btn
		view.getBtnSearch().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				tableFocus();
				page = 1;
				searchBook();
			}
		});

		// Add event edit btn
		view.getBtnEdit().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				editBook();
			}
		});

		// Add event del btn
		view.getBtnDelete().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				deleteBook();
			}
		});

		// Add enter key search
		view.getTxtAuthor().addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBook();
				}
			}
		});
		view.getTxtCallNo().addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBook();
				}
			}
		});
		view.getTxtISBN().addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBook();
				}
			}
		});
		view.getTxtTitle().addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBook();
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
					searchBook();
				}
			}
		});
		view.getBtnBack().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (page != 1 && LibUtil.getInstance().getPage(totalRow) != 0) {
					page--;
				}
				searchBook();
			}
		});
		view.getBtnFirst().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				page = 1;
				searchBook();
			}
		});
		view.getBtnLast().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				page = LibUtil.getInstance().getPage(totalRow);
				searchBook();
			}
		});
	}

	/**
	 * Delete a book selected
	 */
	private void deleteBook() {
		parent.doBlur();
		int sure = JOptionPane.showConfirmDialog(parent.getView(),
				"You sure want delete this book!", "Delete book",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (sure == JOptionPane.OK_OPTION) {
			// Get book id selected
			String bookID = view.getTblBook()
					.getValueAt(view.getTblBook().getSelectedRow(), 0)
					.toString();
			if (!AccessBook.getInstance().deleteBook(Integer.parseInt(bookID))) {
				JOptionPane.showMessageDialog(parent.getView(),
						"Delete failed!\n"
								+ "May be this book is borrowing by some one!",
						"Error!", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(parent.getView(),
						"Delete successful!", "Successful!",
						JOptionPane.INFORMATION_MESSAGE);
				bookModel.removeRow(view.getTblBook().getSelectedRow());
			}
		}
		parent.doBlur();
	}

	/**
	 * Method edit book on databse and edit on book table
	 */
	private void editBook() {
		parent.doBlur();
		// Get call no of book selected
		String bookID = view.getTblBook()
				.getValueAt(view.getTblBook().getSelectedRow(), 0).toString();
		// Get book from database
		Book book = AccessBook.getInstance().getBookInfo(new Integer(bookID));
		// Create instance of book edit dialog and display it
		editBook = new EditBookController(new EditBookDialog(parent.getView()),
				book);
		editBook.getView().setVisible(true);
		// Update data on database
		if (editBook.getBook() != null) {
			if (AccessBook.getInstance().editBook(editBook.getBook())) {
				JOptionPane.showMessageDialog(view, "Update successful",
						"Successful!", JOptionPane.INFORMATION_MESSAGE);
				// Remove old data on table model
				bookModel.removeRow(view.getTblBook().getSelectedRow());
				// Add new row
				bookModel.addRow(book.toVector());
			} else {
				JOptionPane.showMessageDialog(parent.getView(),
						"Edit failed!\n" + "May be ISBN isn't unique.",
						"Edit Book!", JOptionPane.ERROR_MESSAGE);
			}
		}
		tableFocus();
		parent.doBlur();
	}

	/**
	 * View a book
	 */
	private void viewBook() {
		// Get Id book selected
		String bookID = view.getTblBook()
				.getValueAt(view.getTblBook().getSelectedRow(), 0).toString();
		// Get book from database
		Book book = AccessBook.getInstance().getBookInfo(new Integer(bookID));
		parent.doBlur();
		// Create instance of book edit dialog and display it
		viewBook = new ViewBookController(new ViewBookDialog(parent.getView()),
				book);
		viewBook.getView().setVisible(true);
		tableFocus();
		parent.doBlur();
	}

	/**
	 * Method search Book
	 */
	public void searchBook() {
		parent.removeModel(bookModel);
		new Thread(new Runnable() {

			public void run() {
				totalRow = AccessBook.getInstance().searchBook(bookModel,
						view.getTxtCallNo().getText(),
						view.getTxtISBN().getText(),
						view.getTxtTitle().getText(),
						view.getTxtAuthor().getText(), (page - 1));
				view.getLblPage().setText(
						"Page " + page + "/"
								+ LibUtil.getInstance().getPage(totalRow));
			}
		}).start();
	}

	/**
	 * Method add a book on database
	 */
	private void addBook() {
		parent.doBlur();
		// Display Add book dialog
		addBook = new AddBookController(new AddBookDialog(parent.getView()));
		addBook.getView().setVisible(true);
		// invoked method add book
		if (addBook.getBook() != null) {
			if (AccessBook.getInstance().addBook(addBook.getBook())) {
				JOptionPane.showMessageDialog(view, "Add successful",
						"Successful!", JOptionPane.INFORMATION_MESSAGE);
				// Move to last page, show newestbook
				view.getTxtAuthor().setText("");
				view.getTxtCallNo().setText("");
				view.getTxtISBN().setText("");
				view.getTxtTitle().setText("");
				view.getBtnLast().doClick();
			} else {
				JOptionPane.showMessageDialog(view, "Add failed!\n"
						+ "May be this book have added or ISBN is duplicate.",
						"Update Book", JOptionPane.ERROR_MESSAGE);
			}
		}
		parent.doBlur();
	}

	/**
	 * Do lost focus table
	 */
	private void tableFocus() {
		// Set disable acction button
		view.getBtnDelete().setEnabled(false);
		view.getBtnEdit().setEnabled(false);
		view.getBtnView().setEnabled(false);
		view.getTblBook().setFocusable(false);
	}

	/**
	 * @return the view
	 */
	public BookPanel getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(BookPanel view) {
		this.view = view;
	}
}
