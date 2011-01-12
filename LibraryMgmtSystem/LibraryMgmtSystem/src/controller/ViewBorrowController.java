/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.AccessBorrow;
import view.ViewBorrowDialog;

/**
 *
 * @author CuongNQ
 */
public class ViewBorrowController {

    //Defined
    private ViewBorrowDialog view;
    private int borID;
    private int empID;
    private int bookID;
    private String[] arr;

    public ViewBorrowController(ViewBorrowDialog view, int borID,
            int empID, int bookID) {
        this.view = view;
        this.borID=borID;
        this.empID=empID;
        this.bookID=bookID;
        initComponent();
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {
        arr=new String[20];
        AccessBorrow.getInstance().getFullBorInfo(arr, borID, empID, bookID);
        view.getLblID1().setText(arr[0]);
        view.getLblName1().setText(arr[1]);
        view.getLblDOB1().setText(arr[2]);
        view.getLblGender1().setText(arr[3]);
        view.getLblEmail1().setText(arr[4]);
        view.getLblDepart1().setText(arr[5]);
        view.getLblAddress1().setText(arr[6]);
        view.getLblPhone1().setText(arr[7]);
        view.getLblPermission1().setText(arr[8]);
        view.getLblBorID1().setText(arr[9]);
        view.getLblIssueStatus1().setText(arr[10]);
        view.getLblIssueDate1().setText(arr[11]);
        view.getLblDueDate1().setText(arr[12]);
        view.getLblReDate1().setText(arr[13]);
        view.getLblTolFee1().setText(arr[14]);
        view.getLblCallNo1().setText(arr[15]);
        view.getLblISBN1().setText(arr[16]);
        view.getLblTitle1().setText(arr[17]);
        view.getLblAuth1().setText(arr[18]);
        view.getLblPublisher1().setText(arr[19]);

        //Add event close btn
        view.getBtnClose().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
    }

    /**
     * @return the view
     */
    public ViewBorrowDialog getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(ViewBorrowDialog view) {
        this.view = view;
    }
}
