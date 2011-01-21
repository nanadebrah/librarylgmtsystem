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
		bookModel.addColumn(Messages.getString("BookController.21")); //$NON-NLS-1$
		bookModel.addColumn(Messages.getString("BookController.22")); //$NON-NLS-1$
		bookModel.addColumn(Messages.getString("BookController.23")); //$NON-NLS-1$
		bookModel.addColumn(Messages.getString("BookController.24")); //$NON-NLS-1$
		bookModel.addColumn(Messages.getString("BookController.25")); //$NON-NLS-1$
		bookModel.addColumn(Messages.getString("BookController.26")); //$NON-NLS-1$
		bookModel.addColumn(Messages.getString("BookController.27")); //$NON-NLS-1$
		bookModel.addColumn(Messages.getString("BookController.28")); //$NON-NLS-1$

		// Add event to book table
		view.getTblBook().addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(java.awt.event.FocusEvent evt) {
				tableFocus();
			}
		});

		view.getTblBook().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getButton() == MouseEvent.BUTTON1) {
					// Set enable action button
					view.getBtnEdit().setEnabled(true);
					view.getBtnDelete().setEnabled(true);
					view.getBtnView().setEnabled(true);
					// If double click display edit book dialog
					if (evt.getClickCount() == 2) {
						viewBook();
					}
				}
			}
		});

		// Add event view btn
		view.getBtnView().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewBook();
			}
		});

		// Add event add btn
		view.getBtnAdd().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableFocus();
				addBook();
			}
		});

		// Add event search btn
		view.getBtnSearch().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tableFocus();
				page = 1;
				searchBook();
			}
		});

		// Add event edit btn
		view.getBtnEdit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editBook();
			}
		});

		// Add event del btn
		view.getBtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deleteBook();
			}
		});

		// Add enter key search
		view.getTxtAuthor().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBook();
				}
			}
		});
		view.getTxtCallNo().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBook();
				}
			}
		});
		view.getTxtISBN().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBook();
				}
			}
		});
		view.getTxtTitle().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					searchBook();
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
					searchBook();
				}
			}
		});
		view.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (page != 1 && LibUtil.getInstance().getPage(totalRow) != 0) {
					page--;
				}
				searchBook();
			}
		});
		view.getBtnFirst().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = 1;
				searchBook();
			}
		});
		view.getBtnLast().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				page = LibUtil.getInstance().getPage(totalRow);
				searchBook();
			}
		});
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
				JOptionPane.showMessageDialog(
						view,
						Messages.getString("BookController.0"), //$NON-NLS-1$
						Messages.getString("BookController.1"),
						JOptionPane.INFORMATION_MESSAGE);
				// Move to last page, show newest book
				view.getTxtAuthor().setText(
						Messages.getString("EmptyText")); //$NON-NLS-1$
				view.getTxtCallNo().setText(
						Messages.getString("EmptyText")); //$NON-NLS-1$
				view.getTxtISBN().setText(
						Messages.getString("EmptyText")); //$NON-NLS-1$
				view.getTxtTitle().setText(
						Messages.getString("EmptyText")); //$NON-NLS-1$
				view.getBtnLast().doClick();
			} else {
				JOptionPane.showMessageDialog(
						view,
						Messages.getString("BookController.6") //$NON-NLS-1$
								+ Messages.getString("BookController.7"), //$NON-NLS-1$
						Messages.getString("BookController.8"),
						JOptionPane.ERROR_MESSAGE);
			}
		}
		parent.doBlur();
		// Set selection to new book
		view.getTblBook().changeSelection(view.getTblBook().getRowCount() - 1,
				0, false, false);
	}

	/**
	 * Delete a book selected
	 */
	private void deleteBook() {
		parent.doBlur();
		int sure = JOptionPane.showConfirmDialog(parent.getView(),
				Messages.getString("BookController.9"),
				Messages.getString("BookController.10"), //$NON-NLS-1$ 
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (sure == JOptionPane.OK_OPTION) {
			// Get book id selected
			String bookID = view.getTblBook()
					.getValueAt(view.getTblBook().getSelectedRow(), 0)
					.toString();
			if (!AccessBook.getInstance().deleteBook(Integer.parseInt(bookID))) {
				JOptionPane.showMessageDialog(
						parent.getView(),
						Messages.getString("BookController.11") //$NON-NLS-1$
								+ Messages.getString("BookController.12"), //$NON-NLS-1$
						Messages.getString("ErrorTitle"),
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(parent.getView(),
						Messages.getString("BookController.14"),
						Messages.getString("BookController.15"), //$NON-NLS-1$ 
						JOptionPane.INFORMATION_MESSAGE);
				bookModel.removeRow(view.getTblBook().getSelectedRow());
			}
		}
		tableFocus();
		parent.doBlur();
	}

	/**
	 * Method edit book on database and edit on book table
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
				JOptionPane.showMessageDialog(
						view,
						Messages.getString("BookController.16"), //$NON-NLS-1$
						Messages.getString("BookController.17"),
						JOptionPane.INFORMATION_MESSAGE);
				// Remove old data on table model
				bookModel.removeRow(view.getTblBook().getSelectedRow());
				// Add new row
				bookModel.addRow(book.toVector());
			} else {
				JOptionPane.showMessageDialog(
						parent.getView(),
						Messages.getString("BookController.18")
								+ Messages.getString("BookController.19"), //$NON-NLS-1$ 
						Messages.getString("BookController.20"),
						JOptionPane.ERROR_MESSAGE);
			}
		}
		parent.doBlur();
		// Set selection to edited book
		view.getTblBook().changeSelection(view.getTblBook().getRowCount() - 1,
				0, false, false);
	}

	/**
	 * @return the view
	 */
	public BookPanel getView() {
		return view;
	}

	/**
	 * Method search Book
	 */
	public void searchBook() {
		parent.removeModel(bookModel);
		new Thread(new Runnable() {

			@Override
			public void run() {
				totalRow = AccessBook.getInstance().searchBook(bookModel,
						view.getTxtCallNo().getText(),
						view.getTxtISBN().getText(),
						view.getTxtTitle().getText(),
						view.getTxtAuthor().getText(), (page - 1));
				view.getLblPage().setText(
						Messages.getString("BookController.29") + page
								+ Messages.getString("Slash") //$NON-NLS-1$ 
								+ LibUtil.getInstance().getPage(totalRow));
			}
		}).start();
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(BookPanel view) {
		this.view = view;
	}

	/**
	 * Do lost focus table
	 */
	private void tableFocus() {
		// Set disable action button
		view.getBtnDelete().setEnabled(false);
		view.getBtnEdit().setEnabled(false);
		view.getBtnView().setEnabled(false);
		view.getTblBook().setFocusable(false);
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
}
