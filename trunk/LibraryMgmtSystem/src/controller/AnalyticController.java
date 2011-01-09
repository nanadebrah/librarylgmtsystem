/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.AccessAnalytic;
import model.LibUtil;
import view.PalAnalytic;

/**
 *
 * @author CuongNQ
 */
public class AnalyticController {

    //Defined
    private PalAnalytic view;
    private DefaultTableModel anaModel;
    private ManageController parent;
    private int page;
    private int totalRow;
    private boolean isTopBook;

    public AnalyticController(PalAnalytic view,
            DefaultTableModel anaModel, ManageController parent) {
        this.view = view;
        this.parent = parent;
        this.anaModel = anaModel;
        initComponent();
    }

    /*
     *  initialize the controller.
     */
    private void initComponent() {

        //Set default page
        page = 1;
        totalRow = 1;
        //Set selection mode
        view.getTblAna().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Add model to table
        view.getTblAna().setModel(anaModel);


        //Add event top book btn
        view.getBtnTBookAna().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                getTopBook();
            }
        });

        //Add event top borrower btn
        view.getBtnTBorAna().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                getTopBorrower();
            }
        });

        //Add event navigation btn
        view.getBtnNext().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (page == LibUtil.getInstance().getPage(totalRow)
                        || LibUtil.getInstance().getPage(totalRow) == 0) {
                    return;
                } else {
                    page++;
                    if (isTopBook) {
                        getTopBook();
                    } else {
                        getTopBorrower();
                    }
                }
            }
        });
        view.getBtnBack().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (page != 1 && LibUtil.getInstance().getPage(totalRow) != 0) {
                    page--;
                }
                if (isTopBook) {
                    getTopBook();
                } else {
                    getTopBorrower();
                }
            }
        });
        view.getBtnFirst().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                page = 1;
                if (isTopBook) {
                    getTopBook();
                } else {
                    getTopBorrower();
                }
            }
        });
        view.getBtnLast().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                page = LibUtil.getInstance().getPage(totalRow);
                if (isTopBook) {
                    getTopBook();
                } else {
                    getTopBorrower();
                }
            }
        });
    }

    /**
     * 
     */
    private void getTopBorrower() {
        isTopBook = false;
        //Clear column
        anaModel.setColumnCount(0);
        parent.removeModel(anaModel);
        //Set model
        anaModel.addColumn("Employee ID");
        anaModel.addColumn("Name");
        anaModel.addColumn("Gender");
        anaModel.addColumn("Email");
        anaModel.addColumn("Department");
        anaModel.addColumn("Phone");
        anaModel.addColumn("Permission");
        anaModel.addColumn("No borrowed");
        totalRow = AccessAnalytic.getInstance().getTopBorrower(anaModel, (page - 1));
        view.getTxtPage().setText("Page " + page + "/"
                + LibUtil.getInstance().getPage(totalRow));
    }

    /**
     *
     */
    private void getTopBook() {
        isTopBook = true;
        //Clear column
        anaModel.setColumnCount(0);
        parent.removeModel(anaModel);
        //Set model
        anaModel.addColumn("Call Number");
        anaModel.addColumn("ISBN");
        anaModel.addColumn("Title");
        anaModel.addColumn("Author");
        anaModel.addColumn("Publisher");
        anaModel.addColumn("Subject");
        anaModel.addColumn("No of borrowed");
        totalRow = AccessAnalytic.getInstance().getTopBook(anaModel, (page - 1));
        view.getTxtPage().setText("Page " + page + "/"
                + LibUtil.getInstance().getPage(totalRow));
    }

    /**
     * @return the view
     */
    public PalAnalytic getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(PalAnalytic view) {
        this.view = view;
    }
}
