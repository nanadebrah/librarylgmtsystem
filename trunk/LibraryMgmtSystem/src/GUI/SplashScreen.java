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
public class SplashScreen extends JWindow {

    //Defined absolute content
    AbsoluteLayout absolute;
    AbsoluteConstraints absimage, absprocess;
    //Defined image label and image
    ImageIcon image;
    JLabel jlabel;
    JProgressBar process;

    public SplashScreen() {
        //Create new instance of content
        absolute = new AbsoluteLayout();
        absimage = new AbsoluteConstraints(0, 0);
        absprocess = new AbsoluteConstraints(0, 278);
        //Create new instance of label, image and process
        jlabel = new JLabel();
        process = new JProgressBar();
        image = new ImageIcon(this.getClass().getResource(
                "Images" + File.separator + "splash.png"));
        //Set jlabel to display image and prefersize of process bar
        jlabel.setIcon(image);
        process.setPreferredSize(new Dimension(768, 7));
        //Set this content pane absolute layout and add process, label
        this.getContentPane().setLayout(absolute);
        this.getContentPane().add(process, absprocess);
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
                        Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        try {
            t.start();//Start thread
            t.join();//Join thread
            dispose();//Disopse this splash screen when done
        } catch (InterruptedException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
