/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Dimension;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author CuongNQ
 */
public class splashScreen extends JWindow {

    AbsoluteLayout absolute;
    AbsoluteConstraints absimage, absprocess;
    ImageIcon image;
    JLabel jlabel;
    JProgressBar process;

    public splashScreen() {
        absolute = new AbsoluteLayout();
        absimage = new AbsoluteConstraints(0, 0);
        absprocess = new AbsoluteConstraints(0, 278);
        jlabel = new JLabel();
        image = new ImageIcon(this.getClass().getResource(File.separator
                + "GUI" + File.separator + "Images" + File.separator + "splash.png"));
        jlabel.setIcon(image);
        process = new JProgressBar();
        process.setPreferredSize(new Dimension(768, 7));
        this.getContentPane().setLayout(absolute);

        this.getContentPane().add(process, absprocess);
        this.getContentPane().add(jlabel, absimage);

        new Thread() {

            public void run() {
                int i = 0;
                while (i < 101) {
                    process.setValue(i);
                    i++;
                    try {
                        sleep(70);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(splashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                dispose();
            }
        }.start();

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
