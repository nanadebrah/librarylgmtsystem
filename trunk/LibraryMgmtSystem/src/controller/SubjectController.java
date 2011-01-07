/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Subject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.AccessSub;
import view.AddSubDialog;
import view.EditSubDialog;
import view.PalSubject;
import view.ViewSubDialog;

/**
 *
 * @author CuongNQ
 */
public class SubjectController {

    //Defined
    private PalSubject view;
    private DefaultTableModel subModel;
    private AddSubjectController addSubject;
    private EditSubjectController editSubject;
    private ViewSubjectController viewSubject;
    private ManageController parent;

    /**
     * 
     * @param view
     * @param subModel
     * @param manage
     */
    public SubjectController(PalSubject view,
            DefaultTableModel subModel, ManageController manage) {
        this.view = view;
        this.subModel = subModel;
        this.parent = manage;
        initComponent();
    }

    /**
     *  initialize the controller.
     */
    private void initComponent() {

        //Set selection mode
        getView().getTblSub().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Add model to table
        getView().getTblSub().setModel(subModel);
        //Set model
        subModel.addColumn("Subject ID");
        subModel.addColumn("Subject Name");
        subModel.addColumn("Description");

        //Add event add btn
        view.getBtnAddSub().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                addSubject();
            }
        });

        //Add event search btn
        view.getBtnSearchSub().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                searchSubject();
            }
        });

        //Add event edit btn
        view.getBtnEditSub().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                editSubject();
            }
        });

        //Add event view btn
        view.getBtnViewSub().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                viewSubject();
            }
        });

        //Add event del btn
        view.getBtnDelSub().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                deleteEmp();
            }
        });

        //Add event to subject table
        view.getTblSub().addFocusListener(new FocusAdapter() {

            public void focusLost(java.awt.event.FocusEvent evt) {
                tableFocus();
            }
        });
        view.getTblSub().addMouseListener(new MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //Set enable acction button
                view.getBtnDelSub().setEnabled(true);
                view.getBtnEditSub().setEnabled(true);
                view.getBtnViewSub().setEnabled(true);
                //If double click display edit employee dialog
                if (evt.getClickCount() == 2) {
                    viewSubject();
                }
            }
        });

        //Add event enter key
        getView().getTxtIdSub().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    searchSubject();
                }
            }
        });
        getView().getTxtNameSub().addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    searchSubject();
                }
            }
        });
    }

    private void deleteEmp() {
        parent.doBlur();
        int sure = JOptionPane.showConfirmDialog(parent.getView(),
                "You sure want delete this subject!",
                "Delete subject", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (sure == JOptionPane.OK_OPTION) {
            //Get Id employee selected
            String subID = view.getTblSub().getValueAt(
                    view.getTblSub().getSelectedRow(), 0).toString();
            if (!AccessSub.getInstance().deleteSub(Integer.parseInt(subID))) {
                JOptionPane.showMessageDialog(parent.getView(), "Delete failed!\n"
                        + "Because many book is using this subject.", "Error!",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parent.getView(),
                        "Delete successful!", "Successful!",
                        JOptionPane.INFORMATION_MESSAGE);
                subModel.removeRow(view.getTblSub().getSelectedRow());
            }
        }
        parent.doBlur();
    }

    /**
     * View subject
     */
    private void viewSubject() {
        //Get Id employee selected
        String subID = view.getTblSub().getValueAt(
                view.getTblSub().getSelectedRow(), 0).toString();
        //Get employee from database
        Subject sub = AccessSub.getInstance().getSubject(new Integer(subID));
        parent.doBlur();
        //Create instance of Employee edit dialog and display it
        viewSubject = new ViewSubjectController(new ViewSubDialog(parent.getView(), true), sub);
        viewSubject.getView().setVisible(true);
        tableFocus();
        parent.doBlur();
    }

    /**
     * Edit subject
     */
    private void editSubject() {
        parent.doBlur();
        //Get Id employee selected
        String subID = view.getTblSub().getValueAt(
                view.getTblSub().getSelectedRow(), 0).toString();
        //Get employee from database
        Subject sub = AccessSub.getInstance().getSubject(new Integer(subID));
        //Create instance of Employee edit dialog and display it
        editSubject = new EditSubjectController(
                new EditSubDialog(parent.getView(), true), sub);
        editSubject.getView().setVisible(true);
        //Update data on database
        if (editSubject.getSub() != null) {
            if (AccessSub.getInstance().editSub(editSubject.getSub())) {
                JOptionPane.showMessageDialog(getView(), "Update successful",
                        "Successful!", JOptionPane.INFORMATION_MESSAGE);
                //Remove old data on table model
                subModel.removeRow(view.getTblSub().getSelectedRow());
                //Add new row
                subModel.addRow(sub.toVector());
            }
        }
        view.getTblSub().clearSelection();
        parent.doBlur();
    }

    /**
     * Do lost focus table
     */
    private void tableFocus() {
        //Set disable acction button
        view.getBtnEditSub().setEnabled(false);
        view.getBtnDelSub().setEnabled(false);
        view.getBtnViewSub().setEnabled(false);
        view.getTblSub().setFocusable(false);
    }

    /**
     * Seacrh subject
     */
    public void searchSubject() {
        parent.removeModel(subModel);
        AccessSub.getInstance().searchSubject(subModel,
                getView().getTxtIdSub().getText(), getView().getTxtNameSub().getText());
    }

    /**
     * Add an subject
     */
    private void addSubject() {
        parent.doBlur();
        //Display Add employee dialog
        addSubject = new AddSubjectController(new AddSubDialog(parent.getView(), true));
        addSubject.getView().setVisible(true);
        //invoked method add employee
        if (addSubject.getSub() != null) {
            if (AccessSub.getInstance().addSubject(addSubject.getSub())) {
                JOptionPane.showMessageDialog(getView(), "Add subject successful",
                        "Successful!", JOptionPane.INFORMATION_MESSAGE);
                //Add subject to table
                addSubject.getSub().setSubID(AccessSub.getInstance().getNewestSub());
                subModel.addRow(addSubject.getSub().toVector());
            }
        }
        view.getTblSub().clearSelection();
        parent.doBlur();
    }

    /**
     * @return the view
     */
    public PalSubject getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(PalSubject view) {
        this.view = view;
    }
}
