/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import model.AccessBook;
import view.ViewBookDialog;

/**
 * View book controller, control view book dialog
 * @author CuongNQ
 */
public class ViewBookController {

    //Defined
    private Book book = null;
    private ViewBookDialog view;
    private DefaultTableModel borModel;

    /**
     * Default constructor
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
        //Set all information
        view.getLblBookID1().setText(Integer.toString(book.getBookID()));
        view.getLblCallNo1().setText(book.getCallNumber());
        view.getLblISBN1().setText(book.getISBN());
        view.getLblTitle1().setText(book.getTitle());
        view.getLblAth1().setText(book.getAuthName());
        view.getLblPub1().setText(book.getPublisher());
        view.getLblSub1().setText(book.getSubName());
        view.getLblNoC1().setText(String.valueOf(book.getNoOfCopy()));
        view.getLblNoInL1().setText(String.valueOf(book.getNoInLib()));

        //Add event btn close
        view.getBtnClose().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });

        //Create bor model
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

        //Add model to table
        view.getTblBor().setModel(borModel);
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
     * @param view the view to set
     */
    public void setView(ViewBookDialog view) {
        this.view = view;
    }
}
