/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.AccessSub;
import view.ViewBookDialog;

/**
 *
 * @author CuongNQ
 */
public class ViewBookController {

    //Defined
    private Book book = null;
    private ViewBookDialog view;

    public ViewBookController(ViewBookDialog view, Book book) {
        this.view = view;
        this.book = book;
        initComponent();
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {
        //Set all information
        getView().getLblCallNo1().setText(book.getCallNumber());
        getView().getLblISBN1().setText(book.getISBN());
        getView().getLblTitle1().setText(book.getTitle());
        getView().getLblAth1().setText(book.getAuthName());
        getView().getLblPub1().setText(book.getPublisher());
        getView().getLblSub1().setText(
                AccessSub.getInstance().getSubjectName(book.getSubID()));
        getView().getLblNoC1().setText(String.valueOf(book.getNoOfCopy()));
        getView().getLblNoInL1().setText(String.valueOf(book.getNoInLib()));

        //Add event btn close
        getView().getBtnClose().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                getView().dispose();
            }
        });
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
