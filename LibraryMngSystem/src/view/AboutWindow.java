/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dialog;
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
@SuppressWarnings("serial")
public class AboutWindow extends JWindow {

	// Defined absolute layout
	AbsoluteLayout absolute;
	// Defined absolute image and process bar
	AbsoluteConstraints absimage, absbutton;
	// Defined image for splash screen
	ImageIcon image;
	// Defined label
	JLabel lblImage;
	// Defined btnClose
	JButton btnClose;
	// Defined frame
	Frame frame;
	// Defined dialog
	Dialog dialog;

	public AboutWindow(Frame j, Dialog d) {
		// Create new instance of close button
		btnClose = new JButton("Close");
		// Create new instance of current frame & dialog
		this.frame = j;
		this.dialog = d;
		// Add action close when click
		btnClose.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// Show current frame
				dispose();
				if (frame != null)
					frame.setVisible(true);
				if (dialog != null)
					dialog.setVisible(true);
			}
		});
		// Create new instance of absolute layout
		absolute = new AbsoluteLayout();
		// Create new instance of absolute image
		absimage = new AbsoluteConstraints(0, 0);
		absbutton = new AbsoluteConstraints(690, 250);
		// Create new instance of lblImage
		lblImage = new JLabel();
		// Create new instance of image
		image = new ImageIcon(getClass().getResource(LibImages.ABOUT));
		// Set lblImage to display image
		lblImage.setIcon(image);
		// Set this content pane absolute layout
		this.getContentPane().setLayout(absolute);
		// Add close button to this pane
		this.getContentPane().add(btnClose, absbutton);
		// Add image & absolute absolute image to this pane
		this.getContentPane().add(lblImage, absimage);
		// Pack all component
		this.pack();
		// Set pane to center of monitor
		this.setLocationRelativeTo(null);
		// Set visible to display this pane
		this.setVisible(true);
	}
}
