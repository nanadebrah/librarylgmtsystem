/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/**
 * Utility Class
 * 
 * @author CuongNQ
 */
public class LibUtil {

	// Defined instance of LibUtil
	private static LibUtil instance = new LibUtil();
	// Defined
	private Pattern pt;
	private Matcher ma;
	// This setting no of row display on a page
	public static int noRow = 20;
	// Defined key
	private static final KeyStroke escapeStroke = KeyStroke.getKeyStroke(
			KeyEvent.VK_ESCAPE, 0);
	public static final String dispatchWindowClosingActionMapKey = Messages
			.getString("LibUtil.0"); //$NON-NLS-1$

	/**
	 * Check OS
	 */
	private static String os = System.getProperty(
			Messages.getString("LibUtil.1")).toLowerCase(); //$NON-NLS-1$

	public static boolean isWindows = os.indexOf(Messages
			.getString("LibUtil.2")) >= 0; //$NON-NLS-1$
	public static boolean isMac = os.indexOf(Messages.getString("LibUtil.3")) >= 0; //$NON-NLS-1$

	/*
	 * Static method get instance of LibUtil
	 */
	public static LibUtil getInstance() {
		return instance;
	}

	/**
	 * Install close by escape key function
	 * 
	 * @param dialog
	 */
	public static void installEscapeCloseOperation(final JDialog dialog) {
		@SuppressWarnings("serial")
		Action dispatchClosing = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent event) {
				dialog.dispatchEvent(new WindowEvent(dialog,
						WindowEvent.WINDOW_CLOSING));
			}
		};
		JRootPane root = dialog.getRootPane();
		root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeStroke,
				dispatchWindowClosingActionMapKey);
		root.getActionMap().put(dispatchWindowClosingActionMapKey,
				dispatchClosing);
	}

	/**
	 * Convert date to format mm/dd/yyyy
	 * 
	 * @param date
	 * @return date converted
	 */
	public String convertDate(String date) {
		// Get year
		pt = Pattern.compile(Messages.getString("LibUtil.4")); //$NON-NLS-1$
		ma = pt.matcher(date);
		ma.find();
		String y = ma.group();
		// Get day
		pt = Pattern.compile(Messages.getString("LibUtil.5")); //$NON-NLS-1$
		ma = pt.matcher(date);
		ma.find();
		String d = ma.group();
		// get moth
		pt = Pattern.compile(Messages.getString("LibUtil.6")); //$NON-NLS-1$
		ma = pt.matcher(date);
		ma.find();
		String m = ma.group().substring(1).substring(0, 2);

		return m
				+ Messages.getString("LibUtil.7") + d + Messages.getString("LibUtil.8") + y; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * Calculate page with total row and no. row of a page
	 * 
	 * @param totalRow
	 * @return total page
	 */
	public int getPage(int totalRow) {
		return (int) Math.ceil((float) totalRow / noRow);
	}

	/**
	 * Check is Windows
	 * 
	 * @return
	 */
	public boolean isWindows() {
		return isWindows;
	}

	/**
	 * Open help file
	 */
	public void openHelp() {
		if (isMac) {
			java.io.File f = new java.io.File(System.getProperty(Messages
					.getString("LibUtil.9")) //$NON-NLS-1$
					+ java.io.File.separator + Messages.getString("LibUtil.10")); //$NON-NLS-1$
			try {
				Runtime.getRuntime().exec(
						Messages.getString("LibUtil.11") + f.getPath()); //$NON-NLS-1$
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else if (isWindows) {
			java.io.File f = new java.io.File(System.getProperty(Messages
					.getString("LibUtil.12")) //$NON-NLS-1$
					+ java.io.File.separator + Messages.getString("LibUtil.13")); //$NON-NLS-1$
			try {
				Runtime.getRuntime().exec(
						Messages.getString("LibUtil.14") + f.getPath()); //$NON-NLS-1$
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else {
			JOptionPane
					.showMessageDialog(
							null,
							Messages.getString("LibUtil.15") //$NON-NLS-1$
									+ Messages.getString("LibUtil.16"), //$NON-NLS-1$
							Messages.getString("LibUtil.17"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
		}
	}
}
