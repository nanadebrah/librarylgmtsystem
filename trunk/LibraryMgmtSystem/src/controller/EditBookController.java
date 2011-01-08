/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.AccessSub;
import model.LibBook;
import view.EditBokDialog;

/**
 *
 * @author CuongNQ
 */
public class EditBookController {

    //Defined book and edit dialog
    private Book book = null;
    private EditBokDialog view;
    private int noCopies, noInLib;

    public EditBookController(EditBokDialog view, Book book) {
        this.view = view;
        this.book = book;
        initComponent();
    }

    /**
     *  initialize the controller.
     */
    private void initComponent() {
        //Set all field of form
        setField();

        //Add event add btn
        view.getBtnAdd().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                toObject();
                view.dispose();
            }
        });

        //Add event cancel btn
        view.getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                book = null;
                view.dispose();
            }
        });

        //Add event spinner txt no book
        view.getTxtNoCop().addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                balance();
            }
        });

        //Add event windows closing
        view.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent evt) {
                book = null;
                view.dispose();
            }
        });
    }

    /**
     * Transfer all field to object
     */
    private void toObject() {
        getBook().setISBN(view.getTxtISBN().getText());
        getBook().setTitle(view.getTxtTitle().getText());
        getBook().setAuthName(view.getTxtAuthor().getText());
        getBook().setPublisher(view.getTxtPublish().getText());
        getBook().setNoOfCopy(Integer.parseInt(
                view.getTxtNoCop().getValue().toString()));
        getBook().setNoInLib(Integer.parseInt(
                view.getTxtNoInLib().getValue().toString()));
        getBook().setSubID(AccessSub.getInstance().getSubjectID(
                view.getCbxSub().getSelectedItem().toString()));
        getBook().setFixCallNumber(LibBook.getInstance().fixCallNo(getBook()));
    }

    /**
     * Balance value copies and value in library
     */
    private void balance() {
        //Defined new no of copies value
        int newNoC = Integer.parseInt(view.getTxtNoCop().getValue().toString());
        
        //Neu so copy bang so trong kho
        if (noCopies == noInLib) {
            if (newNoC < 1) {
                view.getTxtNoCop().setValue(1);
                view.getTxtNoInLib().setValue(1);
            } else {
                view.getTxtNoInLib().setValue(newNoC);
            }
        } else {//Neu chung ko bang nhau
            //Neu so moi nho hon so cu tuc la tru
            if (newNoC < noCopies) {
                //Neu so giam di ma lon hon so trong kho
                if ((noCopies - newNoC) > noInLib) {
                    //set so trong kho bang 0 va set so copy bang hieu voi so trong kho
                    view.getTxtNoInLib().setValue(0);
                    view.getTxtNoCop().setValue(noCopies - noInLib);
                } else {//Neu khong la so tru di nho hon so trong kho
                    view.getTxtNoInLib().setValue(noInLib - (noCopies - newNoC));
                }
            } else {//Neu khong la cong
                view.getTxtNoInLib().setValue(noInLib + (newNoC - noCopies));
            }
        }
    }

    /**
     * Set all info to field
     */
    private void setField() {
        if (getBook() != null) {
            noCopies = getBook().getNoOfCopy();
            noInLib = getBook().getNoInLib();
            view.getTxtISBN().setText(getBook().getISBN());
            view.getTxtTitle().setText(getBook().getTitle());
            view.getTxtAuthor().setText(getBook().getAuthName());
            view.getTxtPublish().setText(getBook().getPublisher());
            view.getTxtNoCop().setValue(noCopies);
            view.getTxtNoInLib().setValue(noInLib);

            //Load subject list
            String[] subList = AccessSub.getInstance().getAllSubjectName().split(",");
            for (String subName : subList) {
                view.getCbxSub().addItem(subName);
                if (subName.equals(AccessSub.getInstance().getSubjectName(getBook().getSubID()))) {
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
     * @param book the book to set
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * @return the view
     */
    public EditBokDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(EditBokDialog view) {
        this.view = view;
    }
}
