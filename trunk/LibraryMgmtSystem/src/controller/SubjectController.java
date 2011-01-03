/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author CuongNQ
 */
public class SubjectController {

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
        
    }
}
