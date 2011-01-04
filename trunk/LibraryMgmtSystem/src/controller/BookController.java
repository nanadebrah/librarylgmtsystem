/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.AccessBook;
import view.AddBokDialog;
import view.ManageFrm;
import view.PalBook;

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

    public BookController(PalBook view,
            DefaultTableModel bokModel, ManageController parent) {
        this.view = view;
        this.bookModel = bokModel;
        this.parent = parent;
        initComponent();
    }

    /*
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
        bookModel.addColumn("Subject");
        bookModel.addColumn("Copies/Store");

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
    }

    /*
     * Method search Book
     */
    private void searchBook() {
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

    /*
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
        }
        view.getTblBook().clearSelection();
        parent.doBlur();
    }

    /*
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
