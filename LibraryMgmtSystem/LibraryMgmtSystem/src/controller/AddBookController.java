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
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.AccessSub;
import model.LibBook;
import model.LibValid;
import view.AddBokDialog;

/**
 * Add a boook controller, control add book dialog
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
        book = new Book();

        //Add default value
        view.getTxtNoCop().setValue(1);
        view.getTxtNoInLib().setValue(1);

        //Add event cancel btn
        view.getBtnCancel().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                book = null;
                view.dispose();
            }
        });

        //Add window event
        view.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent evt) {
                book = null;
            }
        });

        //Add event window opened
        view.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowOpened(java.awt.event.WindowEvent evt) {
                new Thread(new Runnable() {

                    public void run() {
                        //Load subject list
                        String[] subList = AccessSub.getInstance()
                                .getAllSubjectName().split(",");
                        for (String subName : subList) {
                            view.getCbxSub().addItem(subName);
                        }
                    }
                }).start();
            }
        });

        //Add event add btn
        view.getBtnAdd().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (validBook()) {
                    //set object
                    toObject();
                    //Dispose this dialog
                    view.dispose();
                }
            }
        });

        //Add event sniper txt no book
        view.getTxtNoCop().addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                //set min value
                if (Integer.parseInt(
                        view.getTxtNoCop().getValue().toString()) < 1) {
                    view.getTxtNoCop().setValue(1);
                }
                //set both field
                view.getTxtNoInLib().setValue(
                        view.getTxtNoCop().getValue());
            }
        });
    }

    /**
     * Valid all field display appropriate message
     * @return
     */
    private boolean validBook() {
        if (view.getCbxSub().getSelectedItem().toString().length() <= 0) {
            JOptionPane.showMessageDialog(view,
                    "You need add minimum 1 subject!", "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!LibValid.getInstance().ISBN(view.getTxtISBN().getText())) {
            JOptionPane.showMessageDialog(view, "ISBN must valid.",
                    "Valid!", JOptionPane.INFORMATION_MESSAGE);
            view.getTxtISBN().requestFocus();
            return false;
        }
        if (!LibValid.getInstance().Title(view.getTxtTitle().getText())) {
            JOptionPane.showMessageDialog(view, "Title must valid.",
                    "Valid!", JOptionPane.INFORMATION_MESSAGE);
            view.getTxtTitle().requestFocus();
            return false;
        }
        if (!LibValid.getInstance().Auth(view.getTxtAuthor().getText())) {
            JOptionPane.showMessageDialog(view, "Author must valid.",
                    "Valid!", JOptionPane.INFORMATION_MESSAGE);
            view.getTxtAuthor().requestFocus();
            return false;
        }
        if (!LibValid.getInstance().Publish(view.getTxtPublish().getText())) {
            JOptionPane.showMessageDialog(view, "Publisher must valid.",
                    "Valid!", JOptionPane.INFORMATION_MESSAGE);
            view.getTxtPublish().requestFocus();
            return false;
        }
        return true;
    }

    /**
     * Set all field to object
     */
    private void toObject() {
        book.setISBN(view.getTxtISBN().getText());
        book.setTitle(view.getTxtTitle().getText());
        book.setAuthName(view.getTxtAuthor().getText());
        book.setPublisher(view.getTxtPublish().getText());
        book.setNoOfCopy(new Integer(
                view.getTxtNoCop().getValue().toString()));
        book.setNoInLib(new Integer(
                view.getTxtNoInLib().getValue().toString()));
        book.setSubID(AccessSub.getInstance().getSubjectID(
                view.getCbxSub().getSelectedItem().toString()));
        book.setCallNumber(LibBook.getInstance().generateCallNo(book));
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
