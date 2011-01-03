/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import view.ManageFrm;
import view.PalBook;

/**
 *
 * @author CuongNQ
 */
public class BookController {

    //Defined
    private PalBook view;
    private ManageFrm parent;
    private DefaultTableModel bookModel;

    public BookController(PalBook view,
            DefaultTableModel bokModel, ManageFrm parent){
        this.view=view;
        this.bookModel=bokModel;
        this.parent=parent;
        initComponent();
    }

    /*
     *  initialize the controller.
     */
    private void initComponent() {

        //Set selection mode
        getView().getTblBook().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Add model to table
        getView().getTblBook().setModel(bookModel);
        //Set model
        bookModel.addColumn("Call Number");
        bookModel.addColumn("ISBN");
        bookModel.addColumn("Title");
        bookModel.addColumn("Author");
        bookModel.addColumn("Subject");
        bookModel.addColumn("No of copy");
    }

    /**
     * @return the view
     */
    public PalBook getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(PalBook view) {
        this.view = view;
    }
}
