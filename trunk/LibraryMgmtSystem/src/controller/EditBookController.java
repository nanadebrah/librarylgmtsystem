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

    /*
     *  initialize the controller.
     */
    private void initComponent() {
        //Set all field of form
        setField();

        //Add event add btn
        getView().getBtnAdd().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                toObject();
                getView().dispose();
            }
        });

        //Add event cancel btn
        getView().getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                book = null;
                getView().dispose();
            }
        });

        //Add event spinner txt no book
        getView().getTxtNoCop().addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                balance();
            }
        });

        //Add event windows closing
        getView().addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent evt) {
                book = null;
                getView().dispose();
            }
        });
    }

    /**
     * Transfer all field to object
     */
    private void toObject() {
        getBook().setISBN(getView().getTxtISBN().getText());
        getBook().setTitle(getView().getTxtTitle().getText());
        getBook().setAuthName(getView().getTxtAuthor().getText());
        getBook().setPublisher(getView().getTxtPublish().getText());
        getBook().setNoOfCopy(Integer.parseInt(
                getView().getTxtNoCop().getValue().toString()));
        getBook().setNoInLib(Integer.parseInt(
                getView().getTxtNoInLib().getValue().toString()));
        getBook().setSubID(AccessSub.getInstance().getSubjectID(
                getView().getCbxSub().getSelectedItem().toString()));
        getBook().setFixCallNumber(LibBook.getInstance().fixCallNo(getBook()));
    }

    /**
     * Balance value copies and value in library
     */
    private void balance() {
        //Defined new no of copies value
        int newNoC = Integer.parseInt(getView().getTxtNoCop().getValue().toString());

        //new copies value equals new no in lib or value copies equals zero
        if (newNoC == Integer.parseInt(
                getView().getTxtNoInLib().getValue().toString()) || newNoC == 0) {
            //if new copies value to less than one
            if (newNoC < 1) {
                getView().getTxtNoCop().setValue(1);
                getView().getTxtNoInLib().setValue(1);
            } else {
                getView().getTxtNoInLib().setValue(newNoC);
            }
        } else if (newNoC < noCopies) {//if new copies value less than old value - it's subtract
            //new value offset by old value less than no in lib
            if ((noCopies - newNoC) <= noInLib) {
                //set value in lib is no in lib subtract
                //old value and new value copies offset
                getView().getTxtNoInLib().setValue(noInLib - (noCopies - newNoC));
            } else {
                //min value, add one to new value copies
                getView().getTxtNoCop().setValue(newNoC + 1);
            }
        } else {//it's add
            //Add no in lib is sum of offset new and old copies value
            getView().getTxtNoInLib().setValue(noInLib + (newNoC - noCopies));
        }
    }

    /**
     * Set all info to field
     */
    private void setField() {
        if (getBook() != null) {
            noCopies = getBook().getNoOfCopy();
            noInLib = getBook().getNoInLib();
            getView().getTxtISBN().setText(getBook().getISBN());
            getView().getTxtTitle().setText(getBook().getTitle());
            getView().getTxtAuthor().setText(getBook().getAuthName());
            getView().getTxtPublish().setText(getBook().getPublisher());
            getView().getTxtNoCop().setValue(noCopies);
            getView().getTxtNoInLib().setValue(noInLib);

            //Load subject list
            String[] subList = AccessSub.getInstance().getAllSubjectName().split(",");
            for (String subName : subList) {
                getView().getCbxSub().addItem(subName);
                if (subName.equals(AccessSub.getInstance().getSubjectName(getBook().getSubID()))) {
                    getView().getCbxSub().setSelectedItem(subName);
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
