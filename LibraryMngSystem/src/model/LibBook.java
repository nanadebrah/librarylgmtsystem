/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Book;

/**
 * Process book's callnumber class
 * 
 * @author CuongNQ
 */
public class LibBook {

	// Defined instance of LibBook
	private static LibBook instance = new LibBook();

	/**
	 * Static method get instance of LibBook
	 */
	public static LibBook getInstance() {
		return instance;
	}

	// Defined
	private String callNumber = null;
	private String title, author, sequence;
	private Pattern pt;

	private Matcher ma;

	/**
	 * Edit callnumber, fix it base on new title and author name
	 * 
	 * @param book
	 * @return fixed call number
	 */
	public String fixCallNo(Book book) {
		// First 2 alphabets of title
		pt = Pattern.compile(Messages.getString("LibBook.0")); //$NON-NLS-1$
		ma = pt.matcher(book.getTitle());
		ma.find();
		title = ma.group().toUpperCase();
		// First 2 alphabets of author
		ma = pt.matcher(book.getAuthName());
		ma.find();
		author = ma.group().toUpperCase();
		// sequence number of book
		pt = Pattern.compile(Messages.getString("LibBook.1")); //$NON-NLS-1$
		ma = pt.matcher(book.getCallNumber());
		ma.find();
		sequence = ma.group();
		return title + Messages.getString("LibBook.2") + author
				+ Messages.getString("LibBook.3") + sequence; //$NON-NLS-1$ 
	}

	/**
	 * Generate callnumber base on title and author name
	 * 
	 * @param book
	 *            is Book added from dialog
	 * @return Callnumber generated
	 */
	public String generateCallNo(Book book) {
		Integer intSe = 0;
		// First 2 alphabets of title
		pt = Pattern.compile(Messages.getString("LibBook.4")); //$NON-NLS-1$
		ma = pt.matcher(book.getTitle());
		ma.find();
		title = ma.group().toUpperCase();
		// First 2 alphabets of author
		ma = pt.matcher(book.getAuthName());
		ma.find();
		author = ma.group().toUpperCase();
		// sequence number of book
		intSe = AccessBook.getInstance().getNewestBook();
		// increment sequence number of book
		intSe++;
		// set zero in head
		if (intSe < 10) {
			sequence = Messages.getString("LibBook.5") + intSe.toString(); //$NON-NLS-1$
		} else if (intSe < 100) {
			sequence = Messages.getString("LibBook.6") + intSe.toString(); //$NON-NLS-1$
		} else {
			sequence = intSe.toString();
		}
		// set complete call number and return it
		callNumber = title + Messages.getString("LibBook.7") + author
				+ Messages.getString("LibBook.8") + sequence; //$NON-NLS-1$ 
		return callNumber;
	}
}
