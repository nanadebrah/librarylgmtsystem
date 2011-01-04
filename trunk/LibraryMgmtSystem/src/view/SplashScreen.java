/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LoginController;
import controller.ManageController;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import model.LibImages;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author CuongNQ
 * This class contant funcition to display splash screeen
 */
public class SplashScreen extends JWindow {

    //Defined absolute content
    AbsoluteLayout absolute;
    AbsoluteConstraints absimage, absprocess, abslbl;
    //Defined image label and image
    ImageIcon image;
    JLabel jlabel;
    JLabel jlabel2;
    JProgressBar process;
    //Defined login frame
    LoginController loginControl;
    //Defined Management frame
    ManageController manControl;

    public SplashScreen() {
        //Create new instance of content
        absolute = new AbsoluteLayout();
        absimage = new AbsoluteConstraints(0, 0);
        absprocess = new AbsoluteConstraints(0, 278);
        abslbl = new AbsoluteConstraints(500, 250);
        //Create new instance of label, image and process
        jlabel = new JLabel();
        jlabel2 = new JLabel("Loading..........");
        process = new JProgressBar();
        image = new ImageIcon(this.getClass().getResource(LibImages.Splash));
        //Set jlabel to display image and prefersize of process bar
        jlabel.setIcon(image);
        process.setPreferredSize(new Dimension(768, 7));
        //Set this content pane absolute layout and add process, label
        this.getContentPane().setLayout(absolute);
        this.getContentPane().add(process, absprocess);
        this.getContentPane().add(jlabel2, abslbl);
        this.getContentPane().add(jlabel, absimage);
        //Pack all component
        this.pack();
        //Set pane to center of monitor
        this.setLocationRelativeTo(null);
        //Setvisibe to display this pane
        this.setVisible(true);
        //Do splashscreen
        loadProcess();
    }

    /*
     *Functinon to excute processing bar
     */
    private void loadProcess() {
        //Create new thread to run process bar
        Thread t = new Thread() {

            public void run() {
                int i = 0;
                while (i < 101) {
                    process.setValue(i);//Set value to process bar
                    jlabel2.setText("Loading "+i+"%");
                    i++;
                    try {
                        switch (i) {
                            case 30:
                                jlabel2.setText("Loading Manager Controller");
                                manControl = new ManageController(new ManageFrm());
                                break;
                            case 60:
                                jlabel2.setText("Loading Login Controller");
                                loginControl = new LoginController(new LoginFrm(), manControl);
                                break;
                            case 65:
                                break;
                            case 70:
                                break;
                            case 75:
                                break;
                            default:
                                sleep(10);//Sleep 70 minisecond
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
            //Display login frame
            loginControl.getView().setVisible(true);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
