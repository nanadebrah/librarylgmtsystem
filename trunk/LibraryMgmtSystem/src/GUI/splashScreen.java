/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author CuongNQ
 * This class contant funcition to display splash screeen
 */
public class splashScreen extends JWindow {

    //Defined absolute layout
    AbsoluteLayout absolute;
    //Defined absolute image and process bar
    AbsoluteConstraints absimage, absprocess;
    //Defined image for splash screen
    ImageIcon image;
    //Defined label
    JLabel jlabel;
    //Defined process bar
    JProgressBar process;

    public splashScreen() {
        //Create new instance of absolute layout
        absolute = new AbsoluteLayout();
        //Create new instance of absolute image
        absimage = new AbsoluteConstraints(0, 0);
        //Create new instance of absolute process bar
        absprocess = new AbsoluteConstraints(0, 278);
        //Create new instance of jlabel
        jlabel = new JLabel();
        //Create new instance of process bar
        process = new JProgressBar();
        //Create new instance of image
        image = new ImageIcon(this.getClass().getResource(File.separator
                + "GUI" + File.separator + "Images" + File.separator + "splash.png"));
        //Set jlabel to display image
        jlabel.setIcon(image);
        //Set size & position of process bar
        process.setPreferredSize(new Dimension(768, 7));
        //Set this content pane absolute layout
        this.getContentPane().setLayout(absolute);
        //Add process bar & absolute process bar to this pane
        this.getContentPane().add(process, absprocess);
        //Add image & absolute absolute image to this pane
        this.getContentPane().add(jlabel, absimage);
        //Pack all component
        this.pack();
        //Set pane to center of monitor
        this.setLocationRelativeTo(null);
        //Setvisibe to display this pane
        this.setVisible(true);
    }
    /*
     *Functinon to excute processing bar
     */
    public void loadProcess() {
        //Create new thread to run process bar
        Thread t=new Thread() {

            public void run() {
                int i = 0;
                while (i < 101) {
                    process.setValue(i);//Set value to process bar
                    i++;
                    try {
                        sleep(10);//Sleep 70 minisecond
                    } catch (InterruptedException ex) {
                        Logger.getLogger(splashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        try {
            t.start();//Start thread
            t.join();//Join thread
            dispose();//Disopse this splash screen when done
        } catch (InterruptedException ex) {
            Logger.getLogger(splashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
