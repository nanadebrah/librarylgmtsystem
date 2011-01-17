/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import model.AccessBorrow;
import model.AccessFee;
import model.LibConfig;
import model.LibEmailSender;
import view.SendAlertDialog;

/**
 * Send alert dialog controller
 * @author CuongNQ
 */
public class SendAlertController {
    //Defined

    private SendAlertDialog view;
    private int borID, empID, bookID;
    private String[] arr;
    private String[] arrEmail;
    private String content = "";
    private boolean isSent;
    private entity.Fee fee;

    public SendAlertController(SendAlertDialog view, int borID, int empID,
            int bookID) {
        this.bookID = bookID;
        this.borID = borID;
        this.empID = empID;
        this.view = view;
        initComponent();
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {
        arrEmail = LibConfig.getInstance().loadEmailConfig();
        arr = new String[21];
        //Access get full borrow details
        AccessBorrow.getInstance().getFullBorInfo(arr, borID, empID, bookID);
        //Access get fee details
        fee=AccessFee.getInstance().getFee();
        view.getTxtTo().setText(arr[4]);
        view.getTxtForm().setText(arrEmail[2]);
        createContent();

        //Add event send btn
        view.getBtnSend().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                doSendMail();
            }
        });
        //Add event close btn
        view.getBtnClose().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
        //Escape dialog by key
        model.LibUtil.installEscapeCloseOperation(view);
    }

    /**
     * Send mail
     */
    private void doSendMail() {
        try {
            Thread t = new Thread(new Runnable() {

                public void run() {
                    try {
                        view.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                        LibEmailSender.getInstance().send(view.getTxtTo().getText(),
                                view.getTxtForm().getText(), arrEmail[0],
                                arrEmail[1], view.getTxtSubject().getText(),
                                content, null, null, arrEmail[2], arrEmail[3]);
                        isSent = true;
                    } catch (Exception ex) {
                        isSent = false;
                        ex.printStackTrace();
                    }
                }
            });
            t.start();
            t.join();
            view.setCursor(null);
            if (isSent) {
                JOptionPane.showMessageDialog(view, "Send successful!", "Send Alert",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(view, "Send failed!\n"
                        + "Please recheck your email config", "Send Alert",
                        JOptionPane.ERROR_MESSAGE);
            }
            view.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Create default content of mail
     */
    private void createContent() {        
        //Design mail content
        view.getTxtSubject().setText("Library Management System: Borrow #" + arr[9]);
        content += "Dear " + arr[1] + ",\n\n";
        content += "This email notify to email about your book borrow detail and "
                + arr[12] + " is your borrow's due-date.\n"
                + "If you return late, you will be fine.\n\n";
        content += "========== GENERAL INFORMATION =========\n"
                + "Date/Time: " + new Date().toString() + "\n"
                + "Borrow No: " + arr[9] + "\n"
                + "Issue Date: " + arr[11] + "\n"
                + "Due Date: " + arr[12] + "\n"
                + "Borrow Fee: $"+fee.getBorFee()+"/Day\n"
                + "Late Fee: $"+fee.getLateFee()+"/Day\n\n";
        content += "========= EMPLOYEE INFORMATION =========\n"
                + "Name: " + arr[1] + "\n"
                + "Email: " + arr[4] + "\n"
                + "Address: " + arr[6] + "\n"
                + "Phone: " + arr[7] + "\n"
                + "Department: " + arr[5] + "\n\n";
        content += "=========== BOOK INFORMATION ==========\n"
                + "CallNumber: " + arr[15] + "\n"
                + "ISBN: " + arr[16] + "\n"
                + "Title: " + arr[17] + "\n"
                + "Author Name: " + arr[18] + "\n"
                + "Publisher: " + arr[19] + "\n"
                + "Subject: " + arr[20] + "\n\n";
        content += "*********************************************************\n"
                + "This e-mail was generated by a mail handling system.\n"
                + "If you have any question please reply this email.\n\n\n";
        content += "On behalf of library manager,\n"
                + "Regards.";
        view.getTxtContent().setText(content);
    }

    /**
     * @return the view
     */
    public SendAlertDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(SendAlertDialog view) {
        this.view = view;
    }
}
