/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ManageController;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import model.LibImages;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * Main class to run program
 * @author CuongNQ
 * This class contant function to display splash screeen
 */
public class SplashScreen extends JWindow {

    //Defined absolute content
    AbsoluteLayout absolute;
    AbsoluteConstraints absimage, absprocess, abslbl;
    //Defined image label and image
    ImageIcon image;
    JLabel lblImage;
    JLabel Lblstatus;
    JProgressBar process;
    //Defined login dialog
    LoginDialog loginDialog;
    //Defined Management controller
    ManageController manControl;
    //Defined Management frame
    ManageFrm manage;

    /**
     * Default consttuctor
     */
    public SplashScreen() {
        initComponent();
        //Pack all component
        this.pack();
        //Set pane to center of monitor
        this.setLocationRelativeTo(null);
        //Setvisibe to display this pane
        this.setVisible(true);
    }

    /**
     * initialize the controller.
     */
    private void initComponent() {
        //Create new instance of content
        absolute = new AbsoluteLayout();
        absimage = new AbsoluteConstraints(0, 0);
        absprocess = new AbsoluteConstraints(0, 278);
        abslbl = new AbsoluteConstraints(500, 250);
        //Create new instance of label, image and process
        lblImage = new JLabel();
        Lblstatus = new JLabel("Loading..........");
        process = new JProgressBar();
        image = new ImageIcon(this.getClass().getResource(LibImages.SPLASH));
        //Set lblImage to display image and prefersize of process bar
        lblImage.setIcon(image);
        process.setPreferredSize(new Dimension(768, 7));
        //Set this content pane absolute layout and add process, label
        this.getContentPane().setLayout(absolute);
        this.getContentPane().add(process, absprocess);
        this.getContentPane().add(Lblstatus, abslbl);
        this.getContentPane().add(lblImage, absimage);
    }

    /**
     * Functinon to excute processing bar
     */
    private void loadProcess() {
        //Create new thread to run process bar
        Thread t = new Thread() {

            public void run() {
                int i = 0;
                while (i < 101) {
                    process.setValue(i);//Set value to process bar
                    Lblstatus.setText("Loading " + i + "%");
                    i++;
                    try {
                        switch (i) {
                            case 25:
                                Lblstatus.setText("Loading Manager Frame");
                                manage = new ManageFrm();
                                break;
                            case 50:
                                Lblstatus.setText("Loading Login Controller");
                                loginDialog = new LoginDialog(manage, true);
                                break;
                            case 80:
                                Lblstatus.setText("Loading Manager Controller");
                                manControl = new ManageController(manage, loginDialog);
                                break;
                            default:
                                sleep(10);//Sleep
                                break;
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        try {
            t.start();//Start thread
            t.join();//Join thread
            dispose();//Disopse this splash screen when done
            //Display login dialog
            manControl.Run();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * START PROGRAM
     * @param args START LIBRARY MANAGEMENT SYSTEM
     */
    public static void main(String[] args) {
        javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
        new SplashScreen().loadProcess();
    }
}
