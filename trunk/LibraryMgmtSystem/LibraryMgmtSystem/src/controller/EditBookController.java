/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.AccessSub;
import model.LibBook;
import model.LibValid;
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
                if (validBook()) {
                    toObject();
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(view, "All field must valid.",
                            "Valid!", JOptionPane.INFORMATION_MESSAGE);
                }
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
     *
     * @return
     */
    private boolean validBook() {
        if (!LibValid.getInstance().ISBN(view.getTxtISBN().getText())) {
            return false;
        }
        if (!LibValid.getInstance().Title(view.getTxtTitle().getText())) {
            return false;
        }
        if (!LibValid.getInstance().Auth(view.getTxtAuthor().getText())) {
            return false;
        }
        if (!LibValid.getInstance().Publish(view.getTxtPublish().getText())) {
            return false;
        }
        return true;
    }

    /**
     * Transfer all field to object
     */
    private void toObject() {        
        book.setISBN(view.getTxtISBN().getText());
        book.setTitle(view.getTxtTitle().getText());
        book.setAuthName(view.getTxtAuthor().getText());
        book.setPublisher(view.getTxtPublish().getText());
        book.setNoOfCopy(Integer.parseInt(
                view.getTxtNoCop().getValue().toString()));
        book.setNoInLib(Integer.parseInt(
                view.getTxtNoInLib().getValue().toString()));
        book.setSubID(AccessSub.getInstance().getSubjectID(
                view.getCbxSub().getSelectedItem().toString()));
        book.setCallNumber(LibBook.getInstance().fixCallNo(book));
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
        if (book != null) {
            noCopies = book.getNoOfCopy();
            noInLib = book.getNoInLib();
            view.getTxtISBN().setText(book.getISBN());
            view.getTxtTitle().setText(book.getTitle());
            view.getTxtAuthor().setText(book.getAuthName());
            view.getTxtPublish().setText(book.getPublisher());
            view.getTxtNoCop().setValue(noCopies);
            view.getTxtNoInLib().setValue(noInLib);

            //Load subject list
            String[] subList = AccessSub.getInstance().getAllSubjectName().split(",");
            for (String subName : subList) {
                view.getCbxSub().addItem(subName);
                if (subName.equals(book.getSubName())) {
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
