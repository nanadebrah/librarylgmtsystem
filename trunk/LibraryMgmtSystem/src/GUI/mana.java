/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * mana.java
 *
 * Created on Dec 31, 2010, 10:58:43 AM
 */

package GUI;

import com.jhlabs.image.BlurFilter;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.jxlayer.JXLayer;
import org.jdesktop.jxlayer.plaf.effect.BufferedImageOpEffect;
import org.jdesktop.jxlayer.plaf.ext.LockableUI;

/**
 *
 * @author CuongNQ
 */
public class mana extends javax.swing.JFrame {

    //Defined Icon
    Icon iconBook;
    Icon iconEmp;
    Icon iconBor;
    Icon iconSub;
    Icon iconAna;
    //Defined Jlabel
    JLabel lblBook;
    JLabel lblEmp;
    JLabel lblBor;
    JLabel lblSub;
    JLabel lblAna;
    //Defined Panel
    JPanel palBookIcon;
    JPanel palEmpIcon;
    JPanel palBorIcon;
    JPanel palSubIcon;
    JPanel palAnaIcon;

    //Defined Jxlayer
    private JXLayer<JComponent> layer;
    //Defined blurUI
    private LockableUI blurUI;
    //Defined Jcomponent
    JComponent jc;
    /** Creates new form mana */
    public mana() {
        initComponents();
        //Set this frame to center of monitor
        setLocationRelativeTo(null);
        //Left menu
        listMenuDesign();
        //Blur layer for frame
        blurLayer();
        lstMenu.setSelectionForeground(Color.yellow);
    }

        private void blurLayer(){
        //Create new instance of blurUI
        blurUI = new LockableUI(new BufferedImageOpEffect(new BlurFilter()));
        //Create new instance of Jcomponent
        jc = (JComponent) getContentPane();
        //Create new instance of layer
        layer = new JXLayer(jc);
        //Set layer blur effect
        layer.setUI(blurUI);
        blurUI.setLockedCursor(null);
        //set layer blur to pane
        setContentPane(layer);
    }

    /*
     * Blur main frame when dialog open
     */
    public void doBlur(){
        //set layer blur to pane
        setContentPane(layer);
        blurUI.setLocked(!blurUI.isLocked());
    }

    /*
     * This method contant the design of left menu, this all of main menu
     * of program
     */
    private void listMenuDesign() {        
        //construct the menuList as a JList
        lstMenu.setCellRenderer(new ImageListCellRenderer());
        //get our icon
        iconEmp = new ImageIcon(getClass().getResource(
                "Images" + File.separator + "employeeIcon.png"));
        iconBook = new ImageIcon(getClass().getResource(
                "Images" + File.separator + "bookIcon.png"));
        iconSub = new ImageIcon(getClass().getResource(
                "Images" + File.separator + "subIcon.png"));
        iconBor = new ImageIcon(getClass().getResource(
                "Images" + File.separator + "borIcon.png"));
        iconAna = new ImageIcon(getClass().getResource(
                "Images" + File.separator + "anaIcon.png"));
        //add the images to jlabels with text
        lblEmp = new JLabel("Employees", iconEmp, JLabel.LEFT);
        lblBook = new JLabel("Books", iconBook, JLabel.LEFT);
        lblSub = new JLabel("Subjects", iconSub, JLabel.LEFT);
        lblBor = new JLabel("Borrows", iconBor, JLabel.LEFT);
        lblAna = new JLabel("Analytics", iconAna, JLabel.LEFT);
        //create the corresponding panels
        palEmpIcon = new JPanel(new FlowLayout(FlowLayout.LEFT));
        palBookIcon = new JPanel(new FlowLayout(FlowLayout.LEFT));
        palSubIcon = new JPanel(new FlowLayout(FlowLayout.LEFT));
        palBorIcon = new JPanel(new FlowLayout(FlowLayout.LEFT));
        palAnaIcon = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //add the labels onto the panels
        palEmpIcon.add(lblEmp);
        palBookIcon.add(lblBook);
        palSubIcon.add(lblSub);
        palBorIcon.add(lblBor);
        palAnaIcon.add(lblAna);
        //create a panel array
        Object[] panels = {palEmpIcon, palBookIcon, palSubIcon, palBorIcon, palAnaIcon};
        //tell the jlist to use the panel array for its data
        lstMenu.setListData(panels);

        //Set selection listener event
        lstMenu.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                lstMenuActionPerformed(listSelectionEvent);
            }
        });
    }

    /*
     *
     */
    private void lstMenuActionPerformed(ListSelectionEvent evt) {
        //Get current cardlayout
        CardLayout cardlayout=(CardLayout) palMain.getLayout();
        //get menu index and show this panel
        if (!evt.getValueIsAdjusting()) {
            switch (lstMenu.getAnchorSelectionIndex()) {
                case 0:
                    cardlayout.show(palMain, "palEmployee");
                    break;
                case 1:
                    cardlayout.show(palMain, "palBook");
                    break;
                case 2:
                    cardlayout.show(palMain, "palSubject");
                    break;
                case 3:
                    cardlayout.show(palMain, "palBorrow");
                    break;
                case 4:
                    cardlayout.show(palMain, "palAnalytic");
                    break;
            }
        }
    }

    /*
     * About method
     */
    private void aboutUs() {
        setVisible(false);//hidden current frame
        new aboutWindow().addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosed(java.awt.event.WindowEvent evt) {
                setVisible(true);//show current frame
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrPanMenu = new javax.swing.JScrollPane();
        lstMenu = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstMenu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstMenu.setFocusable(false);
        lstMenu.setOpaque(false);
        lstMenu.setSize(new java.awt.Dimension(200, 200));
        scrPanMenu.setViewportView(lstMenu);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(scrPanMenu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(599, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(scrPanMenu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 269, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList lstMenu;
    private javax.swing.JScrollPane scrPanMenu;
    // End of variables declaration//GEN-END:variables

}
