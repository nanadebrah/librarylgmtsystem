/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Book;
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
        
    }
}
