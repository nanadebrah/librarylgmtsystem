/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Book;
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
import view.AddBokDialog;
import view.EditBokDialog;
import view.ManageFrm;
import view.PalBook;
import view.ViewBookDialog;

/**
 *
 * @author CuongNQ
 */
public class BookController {

    //Defined
    private PalBook view;
    private ManageController parent;
    private DefaultTableModel bookModel;
    private AddBookController addBook;
    private ViewBookController viewBook;
    private EditBookController editBook;

    public BookController(PalBook view,
            DefaultTableModel bokModel, ManageController parent) {
        this.view = view;
        this.bookModel = bokModel;
        this.parent = parent;
        initComponent();
    }

    /**
     *  initialize the controller.
     */
    private void initComponent() {

        //Set selection mode
        getView().getTblBook().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Add model to table
        getView().getTblBook().setModel(bookModel);
        //Set model
        bookModel.addColumn("Call Number");
        bookModel.addColumn("ISBN");
        bookModel.addColumn("Title");
        bookModel.addColumn("Author");
        bookModel.addColumn("Publisher");
        bookModel.addColumn("Copies/Store");

        //Add event to book table
        getView().getTblBook().addFocusListener(new FocusAdapter() {

            public void focusLost(java.awt.event.FocusEvent evt) {
                tableFocus();
            }
        });

        getView().getTblBook().addMouseListener(new MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //Set enable acction button
                view.getBtnEditBook().setEnabled(true);
                view.getBtnDelBook().setEnabled(true);
                view.getBtnViewBook().setEnabled(true);
                //If double click display edit employee dialog
                if (evt.getClickCount() == 2) {
                    viewBook();
                }
            }
        });

        //Add event view btn
        getView().getBtnViewBook().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                viewBook();
            }
        });

        //Add event add btn
        getView().getBtnAddBook().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tableFocus();
                addBook();
            }
        });

        //Add event search btn
        getView().getBtnSearchBook().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tableFocus();
                searchBook();
            }
        });

        //Add event edit btn
        getView().getBtnEditBook().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                editBook();
            }
        });

        //Add enter key search
        getView().getTxtAthBook().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    searchBook();
                }
            }
        });
        getView().getTxtCallNoBook().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    searchBook();
                }
            }
        });
        getView().getTxtISBNBook().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    searchBook();
                }
            }
        });
        getView().getTxtTitlBook().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    searchBook();
                }
            }
        });
    }

    /**
     *Method edit book on databse and edit on book table
     */
    private void editBook() {
        parent.doBlur();
        //Get call no of book selected
        String callNo = view.getTblBook().getValueAt(
                view.getTblBook().getSelectedRow(), 0).toString();
        //Get employee from database
        Book book = AccessBook.getInstance().getBook(callNo);
        //Create instance of book edit dialog and display it
        editBook = new EditBookController(
                new EditBokDialog(parent.getView(), true), book);
        editBook.getView().setVisible(true);
        //Update data on database
        if (editBook.getBook() != null) {
            if (AccessBook.getInstance().editBook(editBook.getBook())) {
                JOptionPane.showMessageDialog(getView(), "Update successful",
                        "Successful!", JOptionPane.INFORMATION_MESSAGE);
                //Remove old data on table model
                bookModel.removeRow(view.getTblBook().getSelectedRow());
                //Add new row
                bookModel.addRow(book.toVector());
            }
        }
        view.getTblBook().clearSelection();
        parent.doBlur();
    }

    /**
     * View a book
     */
    private void viewBook() {
        //Get Id employee selected
        String callNo = view.getTblBook().getValueAt(
                view.getTblBook().getSelectedRow(), 0).toString();
        //Get employee from database
        Book book = AccessBook.getInstance().getBook(callNo);
        parent.doBlur();
        //Create instance of Employee edit dialog and display it
        viewBook = new ViewBookController(new ViewBookDialog(parent.getView(), true), book);
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
                AccessBook.getInstance().searchBook(bookModel,
                        getView().getTxtCallNoBook().getText(),
                        getView().getTxtISBNBook().getText(),
                        getView().getTxtTitlBook().getText(),
                        getView().getTxtAthBook().getText());
            }
        }).start();
    }

    /**
     *Method add employee on database
     */
    private void addBook() {
        parent.doBlur();
        //Display Add employee dialog
        addBook = new AddBookController(new AddBokDialog(parent.getView(), true));
        addBook.getView().setVisible(true);
        //invoked method add employee
        if (addBook.getBook() != null) {
            if (AccessBook.getInstance().addBook(addBook.getBook())) {
                JOptionPane.showMessageDialog(getView(), "Add successful",
                        "Successful!", JOptionPane.INFORMATION_MESSAGE);
            }
            //Add new row
            bookModel.addRow(addBook.getBook().toVector());
        }
        view.getTblBook().clearSelection();
        parent.doBlur();
    }

    /**
     * Do lost focus table
     */
    private void tableFocus() {
        //Set disable acction button
        view.getBtnDelBook().setEnabled(false);
        view.getBtnEditBook().setEnabled(false);
        view.getBtnViewBook().setEnabled(false);
        view.getTblBook().setFocusable(false);
    }

    /**
     * @return the view
     */
    public PalBook getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(PalBook view) {
        this.view = view;
    }
}
