/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.AccessSub;
import model.LibBook;
import view.AddBokDialog;

/**
 *
 * @author CuongNQ
 */
public class AddBookController {

    //Defined
    private Book book = null;
    private AddBokDialog view;

    public AddBookController(AddBokDialog view) {
        this.view = view;
        initComponent();
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {
        //Create new instance of book
        setBook(new Book());

        //Add default value
        getView().getTxtNoCop().setValue(1);
        getView().getTxtNoInLib().setValue(1);

        //Add event cancel btn
        getView().getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setBook(null);
                getView().dispose();
            }
        });

        //Add window event
        getView().addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                setBook(null);
            }
        });

        //Add event window opened
        getView().addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowOpened(java.awt.event.WindowEvent evt) {
                new Thread(new Runnable() {

                    public void run() {
                        //Load subject list
                        String[] subList = AccessSub.getInstance().getAllSubjectName().split(",");
                        for (String subName : subList) {
                            getView().getCbxSub().addItem(subName);
                        }
                    }
                }).start();
            }
        });

        //Add event add btn
        getView().getBtnAdd().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //set object
                toObject();
                //Dispose this dialog
                getView().dispose();
            }
        });

        //Add event sniper txt no book
        getView().getTxtNoCop().addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                //set min value
                if(Integer.parseInt(
                        getView().getTxtNoCop().getValue().toString())<1){
                    getView().getTxtNoCop().setValue(1);
                }
                //set both field
                getView().getTxtNoInLib().setValue(
                        getView().getTxtNoCop().getValue());
            }
        });
    }

    /*
     * get all field to object
     */
    private void toObject() {
        getBook().setISBN(getView().getTxtISBN().getText());
        getBook().setTitle(getView().getTxtTitle().getText());
        getBook().setAuthName(getView().getTxtAuthor().getText());
        getBook().setPublisher(getView().getTxtPublish().getText());
        getBook().setNoOfCopy(new Integer(
                getView().getTxtNoCop().getValue().toString()));
        getBook().setNoInLib(new Integer(
                getView().getTxtNoInLib().getValue().toString()));
        getBook().setSubID(AccessSub.getInstance().getSubjectID(
                getView().getCbxSub().getSelectedItem().toString()));
        getBook().setCallNumber(LibBook.getInstance().generateCallNo(getBook()));
        getBook().setFixCallNumber(getBook().getCallNumber());
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
    public AddBokDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(AddBokDialog view) {
        this.view = view;
    }
}
