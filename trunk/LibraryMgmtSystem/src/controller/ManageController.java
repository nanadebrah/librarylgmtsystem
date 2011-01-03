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
import view.PalEmployee;

/**
 *
 * @author CuongNQ
 */
public class ManageController {

    //
    private CardLayout cardLayout;
    //Defined EmployeeController & employee panel
    private EmployeeController empControl;
    private DefaultTableModel empModel;
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
        //Create model
        empModel = new DefaultTableModel() {

            public boolean isCellEditable(int column, int row) {
                return false;
            }
        };
        //Create instance of card layout
        cardLayout = (CardLayout) view.getPalMain().getLayout();
        //Create new employee panel
        empControl = new EmployeeController(new PalEmployee(), empModel, view);
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

        //Add employee panel
        view.getPalMain().add(empControl.getView(), "palEmployee");

        //Add btn Employee manage
        view.getBtnEmpMan().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(view.getPalMain(), "palEmployee");
                setBorSelect(view.getBtnEmpMan());
            }
        });

        //Add event window open
        view.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowOpened(java.awt.event.WindowEvent evt) {
                empControl.searchEmp();
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
     * Blur main frame when dialog open
     */
    private void doBlur() {
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
