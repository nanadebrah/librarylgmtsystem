/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/**
 * Utility Class
 * 
 * @author CuongNQ
 */
public class LibUtil {

	// Defined instance of LibBook
	private static LibUtil instance = new LibUtil();
	// Defined
	private Pattern pt;
	private Matcher ma;
	// This setting no of row display on a page
	public static int noRow = 20;
	// Defined key
	private static final KeyStroke escapeStroke = KeyStroke.getKeyStroke(
			KeyEvent.VK_ESCAPE, 0);
	public static final String dispatchWindowClosingActionMapKey = "com.spodding.tackline.dispatch:WINDOW_CLOSING";

	/**
	 * Install close by escape key function
	 * 
	 * @param dialog
	 */
	public static void installEscapeCloseOperation(final JDialog dialog) {
		Action dispatchClosing = new AbstractAction() {

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

	/*
	 * Static method get instance of Libook
	 */
	public static LibUtil getInstance() {
		return instance;
	}

	/**
	 * Convert date to format mm/dd/yyyy
	 * 
	 * @param date
	 * @return date converted
	 */
	public String convertDate(String date) {
		// Get year
		pt = Pattern.compile("^\\d{4}");
		ma = pt.matcher(date);
		ma.find();
		String y = ma.group();
		// Get day
		pt = Pattern.compile("\\d{2}$");
		ma = pt.matcher(date);
		ma.find();
		String d = ma.group();
		// get moth
		pt = Pattern.compile("-\\d{2}-");
		ma = pt.matcher(date);
		ma.find();
		String m = ma.group().substring(1).substring(0, 2);

		return m + "/" + d + "/" + y;
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
}
