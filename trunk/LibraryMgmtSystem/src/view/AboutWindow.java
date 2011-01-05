/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JWindow;
import model.LibImages;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author CuongNQ
 */
public class AboutWindow extends JWindow {

    //Defined absolute layout
    AbsoluteLayout absolute;
    //Defined absolute image and process bar
    AbsoluteConstraints absimage, absbutton;
    //Defined image for splash screen
    ImageIcon image;
    //Defined label    
    JLabel jlabel;
    //Defined btnClose
    JButton btnClose;
    //Defined Jframe
    Frame jframe;

    public AboutWindow(Frame j) {
        //Create new instance of close button
        btnClose = new JButton("Close");
        //Create new instance of current frame
        this.jframe=j;
        //Add action close when click
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //Show current jframe
                jframe.setVisible(true);
                dispose();
            }
        });
        //Create new instance of absolute layout
        absolute = new AbsoluteLayout();
        //Create new instance of absolute image
        absimage = new AbsoluteConstraints(0, 0);
        absbutton = new AbsoluteConstraints(690, 250);
        //Create new instance of jlabel
        jlabel = new JLabel();
        //Create new instance of image
        image = new ImageIcon(getClass().getResource(LibImages.ABOUT));
        //Set jlabel to display image
        jlabel.setIcon(image);
        //Set this content pane absolute layout
        this.getContentPane().setLayout(absolute);
        //Add close button to this pane
        this.getContentPane().add(btnClose, absbutton);
        //Add image & absolute absolute image to this pane
        this.getContentPane().add(jlabel, absimage);
        //Pack all component
        this.pack();
        //Set pane to center of monitor
        this.setLocationRelativeTo(null);
        //Setvisibe to display this pane
        this.setVisible(true);     
    }
}
