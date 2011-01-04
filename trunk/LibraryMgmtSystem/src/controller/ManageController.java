/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jhlabs.image.BlurFilter;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.jxlayer.JXLayer;
import org.jdesktop.jxlayer.plaf.effect.BufferedImageOpEffect;
import org.jdesktop.jxlayer.plaf.ext.LockableUI;
import view.AboutWindow;
import view.ManageFrm;
import view.PalAnalytic;
import view.PalBook;
import view.PalBorrow;
import view.PalEmployee;
import view.PalSubject;

/**
 *
 * @author CuongNQ
 */
public class ManageController {

    //Defined cardlayout
    private CardLayout cardLayout;
    //Defined EmployeeController & employee model
    private EmployeeController empControl;
    private DefaultTableModel empModel;
    //Defined BookController & book model
    private BookController bookControl;
    private DefaultTableModel bookModel;
    //Defined SubjectController & subject model
    private SubjectController subControl;
    private DefaultTableModel subModel;
    //Defined SubjectController & subject model
    private BorrowController borControl;
    private DefaultTableModel borModel;
    //Defined SubjectController & subject model
    private AnalyticController anaControl;
    private DefaultTableModel anaModel;
    //Defined about window
    private AboutWindow about;
    //Defined Setting Dialog
    private ManageFrm view;
    //Defined Jxlayer
    private JXLayer<JComponent> layer;
    //Defined blurUI
    private LockableUI blurUI;
    //Defined Jcomponent
    private JComponent jc;
    //Defined connection, rs and cs to connect and query database
    private Connection cn = null;
    private ResultSet rsDetails = null;
    private CallableStatement csDetails = null;

    public ManageController(ManageFrm view) {
        this.view = view;
        initComponent();
    }

    /*
     *  initialize the controller.
     */
    private void initComponent() {

        //Create instance of card layout
        cardLayout = (CardLayout) view.getPalMain().getLayout();

        //Create employee model
        empModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        //Create book model
        bookModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        //Create subject model
        subModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        //Create borrow model
        borModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        //Create analytic model
        anaModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };

        //Create new employee controller
        empControl = new EmployeeController(new PalEmployee(), empModel, this);
        //Create new book controller
        bookControl = new BookController(new PalBook(), bookModel, this);
        //Create new subject controller
        subControl = new SubjectController(new PalSubject(), subModel, this);
        //Create new borrow controller
        borControl = new BorrowController(new PalBorrow(), borModel, this);
        //Create new analytic controller
        anaControl = new AnalyticController(new PalAnalytic(), anaModel, this);

        //Add employee panel
        view.getPalMain().add(empControl.getView(), "PalEmployee");
        //Add ebook panel
        view.getPalMain().add(bookControl.getView(), "PalBook");
        //Add subject panel
        view.getPalMain().add(subControl.getView(), "PalSubject");
        //Add borrow panel
        view.getPalMain().add(borControl.getView(), "PalBorrow");
        //Add subject panel
        view.getPalMain().add(anaControl.getView(), "PalAnalytic");

        //Add btn Employee manage
        view.getBtnEmpMan().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(view.getPalMain(), "PalEmployee");
                setBorSelect(view.getBtnEmpMan());
            }
        });
        //Add btn Book manage
        view.getBtnBookMan().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(view.getPalMain(), "PalBook");
                setBorSelect(view.getBtnBookMan());
            }
        });
        //Add btn Subject Manage
        view.getBtnSubMan().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(view.getPalMain(), "PalSubject");
                setBorSelect(view.getBtnSubMan());
            }
        });
        //Add btn Borrow Manage
        view.getBtnBorMan().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(view.getPalMain(), "PalBorrow");
                setBorSelect(view.getBtnBorMan());
            }
        });
        //Add btn Analytics Manage
        view.getBtnAnaMan().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(view.getPalMain(), "PalAnalytic");
                setBorSelect(view.getBtnAnaMan());
            }
        });


        //Add event window opened
        view.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowOpened(java.awt.event.WindowEvent evt) {
                empControl.searchEmp();
                subControl.searchSubject();
            }
        });

        //Add event quit
        view.getMnQuit().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                view.dispose();
                System.exit(0);
            }
        });

        //Add event about us
        view.getMnAbout().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                getView().setVisible(false);//hidden current frame
                about = new AboutWindow(getView());
            }
        });


        //Create new instance of blurUI
        blurUI = new LockableUI(new BufferedImageOpEffect(new BlurFilter()));
        //Create new instance of Jcomponent
        jc = (JComponent) getView().getContentPane();
        //Create new instance of layer
        layer = new JXLayer<JComponent>(jc);
        //Set layer blur effect
        layer.setUI(blurUI);
        blurUI.setLockedCursor(null);
        //set layer blur to pane
        view.setContentPane(layer);
    }

    /*
     * Set border painted for button selected
     */
    private void setBorSelect(JButton btSelected) {
        view.getBtnEmpMan().setBorderPainted(false);
        view.getBtnBookMan().setBorderPainted(false);
        view.getBtnSubMan().setBorderPainted(false);
        view.getBtnBorMan().setBorderPainted(false);
        view.getBtnAnaMan().setBorderPainted(false);
        btSelected.setBorderPainted(true);
    }

    /*
     * Remove all field on model
     */
    public void removeModel(DefaultTableModel model) {
        int row = model.getRowCount();
        for (int i = 0; i < row; i++) {
            model.removeRow(0);
        }
    }

    /*
     * Blur main frame when dialog open
     */
    public void doBlur() {
        //set layer blur to pane
        view.setContentPane(layer);
        blurUI.setLocked(!blurUI.isLocked());
    }

    /**
     * @return the view
     */
    public ManageFrm getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(ManageFrm view) {
        this.view = view;
    }
}
