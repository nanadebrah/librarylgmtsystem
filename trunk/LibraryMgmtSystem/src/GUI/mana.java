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
        palMain = new javax.swing.JPanel();
        palEmployee = new javax.swing.JPanel();
        tolbarEmp = new javax.swing.JToolBar();
        btnAddEmp = new javax.swing.JButton();
        separator1 = new javax.swing.JToolBar.Separator();
        btnEditEmp = new javax.swing.JButton();
        btnViewEmp = new javax.swing.JButton();
        btnDelEmp = new javax.swing.JButton();
        separator2 = new javax.swing.JToolBar.Separator();
        btnSearchEmp = new javax.swing.JButton();
        scrPanEmp = new javax.swing.JScrollPane();
        tblEmp = new javax.swing.JTable();
        lblIDEmp = new javax.swing.JLabel();
        lblNameEmp = new javax.swing.JLabel();
        txtNameEmp = new javax.swing.JTextField();
        txtIdEmp = new javax.swing.JTextField();
        palBook = new javax.swing.JPanel();
        tolbarBook1 = new javax.swing.JToolBar();
        btnAddBook1 = new javax.swing.JButton();
        separator3 = new javax.swing.JToolBar.Separator();
        btnEditBook = new javax.swing.JButton();
        btnViewBook = new javax.swing.JButton();
        btnDelBook = new javax.swing.JButton();
        separator4 = new javax.swing.JToolBar.Separator();
        btnSearchBook = new javax.swing.JButton();
        scrPanBook = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        lblTitlBook = new javax.swing.JLabel();
        lblAthBook = new javax.swing.JLabel();
        txtAthBook = new javax.swing.JTextField();
        txtTitlBook = new javax.swing.JTextField();
        lblCallNo = new javax.swing.JLabel();
        lblISBNBook = new javax.swing.JLabel();
        txtCallNoBook = new javax.swing.JTextField();
        txtISBNBook = new javax.swing.JTextField();
        palSubject = new javax.swing.JPanel();
        tolbarSub = new javax.swing.JToolBar();
        btnAddSub = new javax.swing.JButton();
        separator5 = new javax.swing.JToolBar.Separator();
        btnEditSub = new javax.swing.JButton();
        btnViewSub = new javax.swing.JButton();
        btnDelSub = new javax.swing.JButton();
        separator6 = new javax.swing.JToolBar.Separator();
        btnSearchSub = new javax.swing.JButton();
        scrPanSub = new javax.swing.JScrollPane();
        tblSub = new javax.swing.JTable();
        lblIDSub = new javax.swing.JLabel();
        lblNameSub = new javax.swing.JLabel();
        txtNameSub = new javax.swing.JTextField();
        txtIdSub = new javax.swing.JTextField();
        palBorrow = new javax.swing.JPanel();
        tolbarBor = new javax.swing.JToolBar();
        btnChkOut = new javax.swing.JButton();
        btnChkIn = new javax.swing.JButton();
        btnFee = new javax.swing.JButton();
        separator7 = new javax.swing.JToolBar.Separator();
        btnEditBor = new javax.swing.JButton();
        btnViewBor = new javax.swing.JButton();
        btnDelBor = new javax.swing.JButton();
        separator8 = new javax.swing.JToolBar.Separator();
        btnSearchBor = new javax.swing.JButton();
        scrPanBor = new javax.swing.JScrollPane();
        tblBor = new javax.swing.JTable();
        lblCallNoBor = new javax.swing.JLabel();
        lblEmNmBor = new javax.swing.JLabel();
        txtEmNamBor = new javax.swing.JTextField();
        txtCallNoBor = new javax.swing.JTextField();
        palAnalytic = new javax.swing.JPanel();
        tolbarAna = new javax.swing.JToolBar();
        btnTBookAna = new javax.swing.JButton();
        btnTBorAna = new javax.swing.JButton();
        btnViewAna = new javax.swing.JButton();
        btnAlertAna = new javax.swing.JButton();
        btnRevAna = new javax.swing.JButton();
        scrPanAna = new javax.swing.JScrollPane();
        tblAna = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        mnSystem = new javax.swing.JMenu();
        menuSetting = new javax.swing.JMenuItem();
        separator = new javax.swing.JPopupMenu.Separator();
        mnLogout = new javax.swing.JMenuItem();
        mnQuit = new javax.swing.JMenuItem();
        mnEmp = new javax.swing.JMenu();
        mnBook = new javax.swing.JMenu();
        mbSub = new javax.swing.JMenu();
        mnBor = new javax.swing.JMenu();
        mnAna = new javax.swing.JMenu();
        mnHelp = new javax.swing.JMenu();
        mnSubHelp = new javax.swing.JMenuItem();
        mnAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstMenu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstMenu.setFocusable(false);
        lstMenu.setOpaque(false);
        lstMenu.setSize(new java.awt.Dimension(200, 200));
        scrPanMenu.setViewportView(lstMenu);

        palMain.setLayout(new java.awt.CardLayout());

        tolbarEmp.setBorder(null);
        tolbarEmp.setFloatable(false);
        tolbarEmp.setBorderPainted(false);
        tolbarEmp.setOpaque(false);

        btnAddEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/addIcon.png"))); // NOI18N
        btnAddEmp.setMnemonic('a');
        btnAddEmp.setText("Add");
        btnAddEmp.setBorderPainted(false);
        btnAddEmp.setFocusable(false);
        btnAddEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddEmp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmpActionPerformed(evt);
            }
        });
        tolbarEmp.add(btnAddEmp);
        tolbarEmp.add(separator1);

        btnEditEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/editIcon.png"))); // NOI18N
        btnEditEmp.setMnemonic('e');
        btnEditEmp.setText("Edit");
        btnEditEmp.setBorderPainted(false);
        btnEditEmp.setEnabled(false);
        btnEditEmp.setFocusable(false);
        btnEditEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditEmp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarEmp.add(btnEditEmp);

        btnViewEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/viewIcon.png"))); // NOI18N
        btnViewEmp.setMnemonic('v');
        btnViewEmp.setText("View");
        btnViewEmp.setBorderPainted(false);
        btnViewEmp.setEnabled(false);
        btnViewEmp.setFocusable(false);
        btnViewEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewEmp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarEmp.add(btnViewEmp);

        btnDelEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/deleteIcon.png"))); // NOI18N
        btnDelEmp.setMnemonic('d');
        btnDelEmp.setText("Delete");
        btnDelEmp.setBorderPainted(false);
        btnDelEmp.setEnabled(false);
        btnDelEmp.setFocusable(false);
        btnDelEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelEmp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarEmp.add(btnDelEmp);
        tolbarEmp.add(separator2);

        btnSearchEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/searchIcon.png"))); // NOI18N
        btnSearchEmp.setMnemonic('s');
        btnSearchEmp.setText("Search");
        btnSearchEmp.setBorderPainted(false);
        btnSearchEmp.setFocusable(false);
        btnSearchEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchEmp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarEmp.add(btnSearchEmp);

        tblEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrPanEmp.setViewportView(tblEmp);

        lblIDEmp.setText("Emp ID:");

        lblNameEmp.setText("Emp Name:");

        org.jdesktop.layout.GroupLayout palEmployeeLayout = new org.jdesktop.layout.GroupLayout(palEmployee);
        palEmployee.setLayout(palEmployeeLayout);
        palEmployeeLayout.setHorizontalGroup(
            palEmployeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(scrPanEmp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .add(palEmployeeLayout.createSequentialGroup()
                .add(tolbarEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEmployeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblNameEmp)
                    .add(lblIDEmp))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palEmployeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtNameEmp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .add(txtIdEmp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)))
        );
        palEmployeeLayout.setVerticalGroup(
            palEmployeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palEmployeeLayout.createSequentialGroup()
                .add(palEmployeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, tolbarEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, palEmployeeLayout.createSequentialGroup()
                        .add(palEmployeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblIDEmp)
                            .add(txtIdEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(2, 2, 2)
                        .add(palEmployeeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblNameEmp)
                            .add(txtNameEmp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(scrPanEmp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        );

        palMain.add(palEmployee, "palEmployee");

        tolbarBook1.setBorder(null);
        tolbarBook1.setFloatable(false);
        tolbarBook1.setBorderPainted(false);
        tolbarBook1.setOpaque(false);

        btnAddBook1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/addIcon.png"))); // NOI18N
        btnAddBook1.setMnemonic('a');
        btnAddBook1.setText("Add");
        btnAddBook1.setBorderPainted(false);
        btnAddBook1.setFocusable(false);
        btnAddBook1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddBook1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAddBook1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBook1ActionPerformed(evt);
            }
        });
        tolbarBook1.add(btnAddBook1);
        tolbarBook1.add(separator3);

        btnEditBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/editIcon.png"))); // NOI18N
        btnEditBook.setMnemonic('e');
        btnEditBook.setText("Edit");
        btnEditBook.setBorderPainted(false);
        btnEditBook.setEnabled(false);
        btnEditBook.setFocusable(false);
        btnEditBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBook1.add(btnEditBook);

        btnViewBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/viewIcon.png"))); // NOI18N
        btnViewBook.setMnemonic('v');
        btnViewBook.setText("View");
        btnViewBook.setBorderPainted(false);
        btnViewBook.setEnabled(false);
        btnViewBook.setFocusable(false);
        btnViewBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBook1.add(btnViewBook);

        btnDelBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/deleteIcon.png"))); // NOI18N
        btnDelBook.setMnemonic('d');
        btnDelBook.setText("Delete");
        btnDelBook.setBorderPainted(false);
        btnDelBook.setEnabled(false);
        btnDelBook.setFocusable(false);
        btnDelBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBook1.add(btnDelBook);
        tolbarBook1.add(separator4);

        btnSearchBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/searchIcon.png"))); // NOI18N
        btnSearchBook.setMnemonic('s');
        btnSearchBook.setText("Search");
        btnSearchBook.setBorderPainted(false);
        btnSearchBook.setFocusable(false);
        btnSearchBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBook1.add(btnSearchBook);

        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrPanBook.setViewportView(tblBook);

        lblTitlBook.setText("Title:");

        lblAthBook.setText("Author:");

        lblCallNo.setText("CallNo:");

        lblISBNBook.setText("ISBN:");

        org.jdesktop.layout.GroupLayout palBookLayout = new org.jdesktop.layout.GroupLayout(palBook);
        palBook.setLayout(palBookLayout);
        palBookLayout.setHorizontalGroup(
            palBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(scrPanBook, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .add(palBookLayout.createSequentialGroup()
                .add(tolbarBook1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblCallNo)
                    .add(lblISBNBook))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(txtISBNBook)
                    .add(txtCallNoBook, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblAthBook)
                    .add(lblTitlBook))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(txtTitlBook, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .add(txtAthBook, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
        );
        palBookLayout.setVerticalGroup(
            palBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palBookLayout.createSequentialGroup()
                .add(palBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, tolbarBook1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, palBookLayout.createSequentialGroup()
                        .add(palBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtTitlBook, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblCallNo)
                            .add(lblTitlBook)
                            .add(txtCallNoBook, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(2, 2, 2)
                        .add(palBookLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtAthBook, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblISBNBook)
                            .add(lblAthBook)
                            .add(txtISBNBook, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(scrPanBook, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        );

        palMain.add(palBook, "palBook");

        tolbarSub.setBorder(null);
        tolbarSub.setFloatable(false);
        tolbarSub.setBorderPainted(false);
        tolbarSub.setOpaque(false);

        btnAddSub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/addIcon.png"))); // NOI18N
        btnAddSub.setMnemonic('a');
        btnAddSub.setText("Add");
        btnAddSub.setBorderPainted(false);
        btnAddSub.setFocusable(false);
        btnAddSub.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAddSub.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarSub.add(btnAddSub);
        tolbarSub.add(separator5);

        btnEditSub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/editIcon.png"))); // NOI18N
        btnEditSub.setMnemonic('e');
        btnEditSub.setText("Edit");
        btnEditSub.setBorderPainted(false);
        btnEditSub.setEnabled(false);
        btnEditSub.setFocusable(false);
        btnEditSub.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditSub.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarSub.add(btnEditSub);

        btnViewSub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/viewIcon.png"))); // NOI18N
        btnViewSub.setMnemonic('v');
        btnViewSub.setText("View");
        btnViewSub.setBorderPainted(false);
        btnViewSub.setEnabled(false);
        btnViewSub.setFocusable(false);
        btnViewSub.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewSub.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarSub.add(btnViewSub);

        btnDelSub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/deleteIcon.png"))); // NOI18N
        btnDelSub.setMnemonic('d');
        btnDelSub.setText("Delete");
        btnDelSub.setBorderPainted(false);
        btnDelSub.setEnabled(false);
        btnDelSub.setFocusable(false);
        btnDelSub.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelSub.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarSub.add(btnDelSub);
        tolbarSub.add(separator6);

        btnSearchSub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/searchIcon.png"))); // NOI18N
        btnSearchSub.setMnemonic('s');
        btnSearchSub.setText("Search");
        btnSearchSub.setBorderPainted(false);
        btnSearchSub.setFocusable(false);
        btnSearchSub.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchSub.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarSub.add(btnSearchSub);

        tblSub.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrPanSub.setViewportView(tblSub);

        lblIDSub.setText("Subject ID:");

        lblNameSub.setText("Subject Name:");

        org.jdesktop.layout.GroupLayout palSubjectLayout = new org.jdesktop.layout.GroupLayout(palSubject);
        palSubject.setLayout(palSubjectLayout);
        palSubjectLayout.setHorizontalGroup(
            palSubjectLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(scrPanSub, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .add(palSubjectLayout.createSequentialGroup()
                .add(tolbarSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palSubjectLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblNameSub)
                    .add(lblIDSub))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palSubjectLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtNameSub, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .add(txtIdSub, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)))
        );
        palSubjectLayout.setVerticalGroup(
            palSubjectLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palSubjectLayout.createSequentialGroup()
                .add(palSubjectLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, tolbarSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, palSubjectLayout.createSequentialGroup()
                        .add(palSubjectLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblIDSub)
                            .add(txtIdSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(2, 2, 2)
                        .add(palSubjectLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblNameSub)
                            .add(txtNameSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(scrPanSub, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        );

        palMain.add(palSubject, "palSubject");

        tolbarBor.setBorder(null);
        tolbarBor.setFloatable(false);
        tolbarBor.setBorderPainted(false);
        tolbarBor.setOpaque(false);

        btnChkOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/chkoutIcon.png"))); // NOI18N
        btnChkOut.setMnemonic('o');
        btnChkOut.setText("Check-Out");
        btnChkOut.setBorderPainted(false);
        btnChkOut.setFocusable(false);
        btnChkOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChkOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnChkOut);

        btnChkIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/chkinIcon.png"))); // NOI18N
        btnChkIn.setMnemonic('i');
        btnChkIn.setText("Check-In");
        btnChkIn.setBorderPainted(false);
        btnChkIn.setFocusable(false);
        btnChkIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChkIn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnChkIn);

        btnFee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/feeIcon.png"))); // NOI18N
        btnFee.setMnemonic('f');
        btnFee.setText("Fee rate");
        btnFee.setBorderPainted(false);
        btnFee.setFocusable(false);
        btnFee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFee.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnFee);
        tolbarBor.add(separator7);

        btnEditBor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/editIcon.png"))); // NOI18N
        btnEditBor.setMnemonic('e');
        btnEditBor.setText("Edit");
        btnEditBor.setBorderPainted(false);
        btnEditBor.setEnabled(false);
        btnEditBor.setFocusable(false);
        btnEditBor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditBor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnEditBor);

        btnViewBor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/viewIcon.png"))); // NOI18N
        btnViewBor.setMnemonic('v');
        btnViewBor.setText("View");
        btnViewBor.setBorderPainted(false);
        btnViewBor.setEnabled(false);
        btnViewBor.setFocusable(false);
        btnViewBor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewBor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnViewBor);

        btnDelBor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/deleteIcon.png"))); // NOI18N
        btnDelBor.setMnemonic('d');
        btnDelBor.setText("Delete");
        btnDelBor.setBorderPainted(false);
        btnDelBor.setEnabled(false);
        btnDelBor.setFocusable(false);
        btnDelBor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelBor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnDelBor);
        tolbarBor.add(separator8);

        btnSearchBor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/searchIcon.png"))); // NOI18N
        btnSearchBor.setMnemonic('s');
        btnSearchBor.setText("Search");
        btnSearchBor.setBorderPainted(false);
        btnSearchBor.setFocusable(false);
        btnSearchBor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchBor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarBor.add(btnSearchBor);

        tblBor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrPanBor.setViewportView(tblBor);

        lblCallNoBor.setText("CallNo:");

        lblEmNmBor.setText("Emp Name:");

        org.jdesktop.layout.GroupLayout palBorrowLayout = new org.jdesktop.layout.GroupLayout(palBorrow);
        palBorrow.setLayout(palBorrowLayout);
        palBorrowLayout.setHorizontalGroup(
            palBorrowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(scrPanBor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .add(palBorrowLayout.createSequentialGroup()
                .add(tolbarBor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palBorrowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblEmNmBor)
                    .add(lblCallNoBor))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palBorrowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtEmNamBor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .add(txtCallNoBor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
        );
        palBorrowLayout.setVerticalGroup(
            palBorrowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 417, Short.MAX_VALUE)
            .add(palBorrowLayout.createSequentialGroup()
                .add(palBorrowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, tolbarBor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, palBorrowLayout.createSequentialGroup()
                        .add(palBorrowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblCallNoBor)
                            .add(txtCallNoBor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(2, 2, 2)
                        .add(palBorrowLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(lblEmNmBor)
                            .add(txtEmNamBor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(scrPanBor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        );

        palMain.add(palBorrow, "palBorrow");

        tolbarAna.setBorder(null);
        tolbarAna.setFloatable(false);
        tolbarAna.setBorderPainted(false);
        tolbarAna.setOpaque(false);

        btnTBookAna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/topBookIcon.png"))); // NOI18N
        btnTBookAna.setMnemonic('a');
        btnTBookAna.setText("Top Book");
        btnTBookAna.setBorderPainted(false);
        btnTBookAna.setFocusable(false);
        btnTBookAna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTBookAna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarAna.add(btnTBookAna);

        btnTBorAna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/topBorIcon.png"))); // NOI18N
        btnTBorAna.setMnemonic('e');
        btnTBorAna.setText("Top Borrower");
        btnTBorAna.setBorderPainted(false);
        btnTBorAna.setFocusable(false);
        btnTBorAna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTBorAna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarAna.add(btnTBorAna);

        btnViewAna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/viewIcon.png"))); // NOI18N
        btnViewAna.setMnemonic('v');
        btnViewAna.setText("View");
        btnViewAna.setBorderPainted(false);
        btnViewAna.setEnabled(false);
        btnViewAna.setFocusable(false);
        btnViewAna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewAna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarAna.add(btnViewAna);

        btnAlertAna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/sendAlertIcon.png"))); // NOI18N
        btnAlertAna.setMnemonic('s');
        btnAlertAna.setText("Overdue Alert");
        btnAlertAna.setBorderPainted(false);
        btnAlertAna.setEnabled(false);
        btnAlertAna.setFocusable(false);
        btnAlertAna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAlertAna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarAna.add(btnAlertAna);

        btnRevAna.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/revenueIcon.png"))); // NOI18N
        btnRevAna.setText("Revenue");
        btnRevAna.setBorderPainted(false);
        btnRevAna.setFocusable(false);
        btnRevAna.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRevAna.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tolbarAna.add(btnRevAna);

        tblAna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrPanAna.setViewportView(tblAna);

        org.jdesktop.layout.GroupLayout palAnalyticLayout = new org.jdesktop.layout.GroupLayout(palAnalytic);
        palAnalytic.setLayout(palAnalyticLayout);
        palAnalyticLayout.setHorizontalGroup(
            palAnalyticLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palAnalyticLayout.createSequentialGroup()
                .add(tolbarAna, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
            .add(scrPanAna, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        );
        palAnalyticLayout.setVerticalGroup(
            palAnalyticLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(palAnalyticLayout.createSequentialGroup()
                .add(tolbarAna, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(scrPanAna, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
        );

        palMain.add(palAnalytic, "palAnalytic");

        mnSystem.setText("System");

        menuSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/settingMenu.png"))); // NOI18N
        menuSetting.setText("Setting");
        mnSystem.add(menuSetting);
        mnSystem.add(separator);

        mnLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK));
        mnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/logoutIcon.png"))); // NOI18N
        mnLogout.setText("Logout");
        mnSystem.add(mnLogout);

        mnQuit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        mnQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/quitIcon.png"))); // NOI18N
        mnQuit.setText("Quit");
        mnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnQuitActionPerformed(evt);
            }
        });
        mnSystem.add(mnQuit);

        menuBar.add(mnSystem);

        mnEmp.setText("Employees");
        menuBar.add(mnEmp);

        mnBook.setText("Books");
        menuBar.add(mnBook);

        mbSub.setText("Subjects");
        menuBar.add(mbSub);

        mnBor.setText("Borrows");
        menuBar.add(mnBor);

        mnAna.setText("Analytics");
        menuBar.add(mnAna);

        mnHelp.setText("Help");

        mnSubHelp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        mnSubHelp.setText("Help");
        mnHelp.add(mnSubHelp);

        mnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/aboutMenu.png"))); // NOI18N
        mnAbout.setText("About us");
        mnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAboutActionPerformed(evt);
            }
        });
        mnHelp.add(mnAbout);

        menuBar.add(mnHelp);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(scrPanMenu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(palMain, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(palMain, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                    .add(scrPanMenu, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 269, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        //Add manage Panel to Main panel
        //palMain.add(new palEmployee(), "palEmployee");
        //palMain.add(new palBook(), "palBook");
        //palMain.add(new palSubject(), "palSubject");
        //palMain.add(new palBorrow(), "palBorrow");
        //palMain.add(new palAnalytic(), "palAnalytic");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnQuitActionPerformed
        //Dispose this frame
        dispose();
        System.exit(0);
}//GEN-LAST:event_mnQuitActionPerformed

    private void mnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAboutActionPerformed
        //call aboutUs method
        aboutUs();
}//GEN-LAST:event_mnAboutActionPerformed

    private void btnAddEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmpActionPerformed
        // TODO add your handling code here:
        doBlur();
        new addEmpDialog(this, true).setVisible(true);
        doBlur();
}//GEN-LAST:event_btnAddEmpActionPerformed

    private void btnAddBook1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBook1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_btnAddBook1ActionPerformed

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
    private javax.swing.JButton btnAddBook1;
    private javax.swing.JButton btnAddEmp;
    private javax.swing.JButton btnAddSub;
    private javax.swing.JButton btnAlertAna;
    private javax.swing.JButton btnChkIn;
    private javax.swing.JButton btnChkOut;
    private javax.swing.JButton btnDelBook;
    private javax.swing.JButton btnDelBor;
    private javax.swing.JButton btnDelEmp;
    private javax.swing.JButton btnDelSub;
    private javax.swing.JButton btnEditBook;
    private javax.swing.JButton btnEditBor;
    private javax.swing.JButton btnEditEmp;
    private javax.swing.JButton btnEditSub;
    private javax.swing.JButton btnFee;
    private javax.swing.JButton btnRevAna;
    private javax.swing.JButton btnSearchBook;
    private javax.swing.JButton btnSearchBor;
    private javax.swing.JButton btnSearchEmp;
    private javax.swing.JButton btnSearchSub;
    private javax.swing.JButton btnTBookAna;
    private javax.swing.JButton btnTBorAna;
    private javax.swing.JButton btnViewAna;
    private javax.swing.JButton btnViewBook;
    private javax.swing.JButton btnViewBor;
    private javax.swing.JButton btnViewEmp;
    private javax.swing.JButton btnViewSub;
    private javax.swing.JLabel lblAthBook;
    private javax.swing.JLabel lblCallNo;
    private javax.swing.JLabel lblCallNoBor;
    private javax.swing.JLabel lblEmNmBor;
    private javax.swing.JLabel lblIDEmp;
    private javax.swing.JLabel lblIDSub;
    private javax.swing.JLabel lblISBNBook;
    private javax.swing.JLabel lblNameEmp;
    private javax.swing.JLabel lblNameSub;
    private javax.swing.JLabel lblTitlBook;
    private javax.swing.JList lstMenu;
    private javax.swing.JMenu mbSub;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuSetting;
    private javax.swing.JMenuItem mnAbout;
    private javax.swing.JMenu mnAna;
    private javax.swing.JMenu mnBook;
    private javax.swing.JMenu mnBor;
    private javax.swing.JMenu mnEmp;
    private javax.swing.JMenu mnHelp;
    private javax.swing.JMenuItem mnLogout;
    private javax.swing.JMenuItem mnQuit;
    private javax.swing.JMenuItem mnSubHelp;
    private javax.swing.JMenu mnSystem;
    private javax.swing.JPanel palAnalytic;
    private javax.swing.JPanel palBook;
    private javax.swing.JPanel palBorrow;
    private javax.swing.JPanel palEmployee;
    private javax.swing.JPanel palMain;
    private javax.swing.JPanel palSubject;
    private javax.swing.JScrollPane scrPanAna;
    private javax.swing.JScrollPane scrPanBook;
    private javax.swing.JScrollPane scrPanBor;
    private javax.swing.JScrollPane scrPanEmp;
    private javax.swing.JScrollPane scrPanMenu;
    private javax.swing.JScrollPane scrPanSub;
    private javax.swing.JPopupMenu.Separator separator;
    private javax.swing.JToolBar.Separator separator1;
    private javax.swing.JToolBar.Separator separator2;
    private javax.swing.JToolBar.Separator separator3;
    private javax.swing.JToolBar.Separator separator4;
    private javax.swing.JToolBar.Separator separator5;
    private javax.swing.JToolBar.Separator separator6;
    private javax.swing.JToolBar.Separator separator7;
    private javax.swing.JToolBar.Separator separator8;
    private javax.swing.JTable tblAna;
    private javax.swing.JTable tblBook;
    private javax.swing.JTable tblBor;
    private javax.swing.JTable tblEmp;
    private javax.swing.JTable tblSub;
    private javax.swing.JToolBar tolbarAna;
    private javax.swing.JToolBar tolbarBook1;
    private javax.swing.JToolBar tolbarBor;
    private javax.swing.JToolBar tolbarEmp;
    private javax.swing.JToolBar tolbarSub;
    private javax.swing.JTextField txtAthBook;
    private javax.swing.JTextField txtCallNoBook;
    private javax.swing.JTextField txtCallNoBor;
    private javax.swing.JTextField txtEmNamBor;
    private javax.swing.JTextField txtISBNBook;
    private javax.swing.JTextField txtIdEmp;
    private javax.swing.JTextField txtIdSub;
    private javax.swing.JTextField txtNameEmp;
    private javax.swing.JTextField txtNameSub;
    private javax.swing.JTextField txtTitlBook;
    // End of variables declaration//GEN-END:variables

}
