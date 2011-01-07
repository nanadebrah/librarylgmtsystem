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

    /**
     * 
     * @param view
     * @param book
     */
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
        view.getLblCallNo1().setText(book.getCallNumber());
        view.getLblISBN1().setText(book.getISBN());
        view.getLblTitle1().setText(book.getTitle());
        view.getLblAth1().setText(book.getAuthName());
        view.getLblPub1().setText(book.getPublisher());
        view.getLblSub1().setText(
                AccessSub.getInstance().getSubjectName(book.getSubID()));
        view.getLblNoC1().setText(String.valueOf(book.getNoOfCopy()));
        view.getLblNoInL1().setText(String.valueOf(book.getNoInLib()));

        //Add event btn close
        view.getBtnClose().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                view.dispose();
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
