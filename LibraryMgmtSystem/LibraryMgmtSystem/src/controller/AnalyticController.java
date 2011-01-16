/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.AccessAnalytic;
import model.AccessBorrow;
import model.LibUtil;
import view.PalAnalytic;
import view.SendAlertDialog;

/**
 * Analytic controller, control analytic panel
 * @author CuongNQ
 */
public class AnalyticController {

    //Defined
    private PalAnalytic view;
    private DefaultTableModel anaModel;
    private ManageController parent;
    private SendAlertController sendEmail;
    private int page;
    private int totalRow;
    private boolean isTopBook;
    private boolean isSearch;

    /**
     * Default constructer
     * @param view
     * @param anaModel
     * @param parent
     */
    public AnalyticController(PalAnalytic view,
            DefaultTableModel anaModel, ManageController parent) {
        this.view = view;
        this.parent = parent;
        this.anaModel = anaModel;
        initComponent();
    }

    /**
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

        //Add event search btn
        view.getBtnSearch().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                view.requestFocus();
                searchCheckingOut();
            }
        });

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

        //Add event send alert btn
        view.getBtnAlertAna().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                sendEmail();
            }
        });

        //Add event table
        view.getTblAna().addFocusListener(new FocusAdapter() {

            public void focusLost(java.awt.event.FocusEvent evt) {
                //Set disable acction button
                view.getBtnAlertAna().setEnabled(false);
            }
        });
        view.getTblAna().addMouseListener(new MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (isSearch) {
                    //Set enable acction button
                    view.getBtnAlertAna().setEnabled(true);
                } else {
                    //Set disable acction button
                    view.getBtnAlertAna().setEnabled(false);
                }
                //If double click display edit subject dialog
                if (evt.getClickCount() == 2) {
                    if (isSearch) {
                        sendEmail();
                    }
                }
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
                    if (isSearch) {
                        searchCheckingOut();
                    } else {
                        if (isTopBook) {
                            getTopBook();
                        } else {
                            getTopBorrower();
                        }
                    }
                }
            }
        });
        view.getBtnBack().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (page != 1 && LibUtil.getInstance().getPage(totalRow) != 0) {
                    page--;
                }
                if (isSearch) {
                    searchCheckingOut();
                } else {
                    if (isTopBook) {
                        getTopBook();
                    } else {
                        getTopBorrower();
                    }
                }
            }
        });
        view.getBtnFirst().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                page = 1;
                if (isSearch) {
                    searchCheckingOut();
                } else {
                    if (isTopBook) {
                        getTopBook();
                    } else {
                        getTopBorrower();
                    }
                }
            }
        });
        view.getBtnLast().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                page = LibUtil.getInstance().getPage(totalRow);
                if (isSearch) {
                    searchCheckingOut();
                } else {
                    if (isTopBook) {
                        getTopBook();
                    } else {
                        getTopBorrower();
                    }
                }
            }
        });
    }

    /**
     * Display dialog to send email
     */
    private void sendEmail() {
        parent.doBlur();
        //Get field borID selected
        int borID = Integer.parseInt(view.getTblAna().getValueAt(
                view.getTblAna().getSelectedRow(), 0).toString());
        //Get field empID selected
        int empID = Integer.parseInt(view.getTblAna().getValueAt(
                view.getTblAna().getSelectedRow(), 1).toString());
        //Get field bookID selected
        String bookID = view.getTblAna().getValueAt(
                view.getTblAna().getSelectedRow(), 2).toString();
        sendEmail = new SendAlertController(new SendAlertDialog(
                parent.getView(), true), borID, empID, Integer.parseInt(bookID));
        sendEmail.getView().setVisible(true);
        parent.doBlur();
    }

    /**
     * Search checking out to send alert
     */
    private void searchCheckingOut() {
        isSearch = true;
        //Clear column
        anaModel.setColumnCount(0);
        parent.removeModel(anaModel);
        //Set model
        anaModel.addColumn("Borrow No");
        anaModel.addColumn("Employee No");
        anaModel.addColumn("Book No");
        anaModel.addColumn("Employee Name");
        anaModel.addColumn("Call Number");
        anaModel.addColumn("Title");
        anaModel.addColumn("Issue Date");
        anaModel.addColumn("Due Date");

        totalRow = AccessBorrow.getInstance().searchCheckingOut(anaModel,
                view.getTxtDueDate().getDate(), (page - 1));
        view.getTxtPage().setText("Page " + page + "/"
                + LibUtil.getInstance().getPage(totalRow));
    }

    /**
     * Get top brrower
     */
    private void getTopBorrower() {
        isSearch = false;
        isTopBook = false;
        //Clear column
        anaModel.setColumnCount(0);
        parent.removeModel(anaModel);
        //Set model
        anaModel.addColumn("Employee No");
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
     * Get top book borrowed by employee
     */
    private void getTopBook() {
        isSearch = false;
        isTopBook = true;
        //Clear column
        anaModel.setColumnCount(0);
        parent.removeModel(anaModel);
        //Set model
        anaModel.addColumn("Book No");
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
