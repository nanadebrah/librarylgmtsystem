/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Vector;

/**
 * Book entity
 * 
 * @author dinh manh hai
 */
public class Book {

	private int bookID;
	private String CallNumber;
	private int subID;
	private String subName;
	private String ISBN;
	private String Title;
	private String AuthName;
	private String Publisher;
	private int noOfCopy;
	private int noInLib;

	/**
	 * @return the AuthName
	 */
	public String getAuthName() {
		return AuthName;
	}

	/**
	 * @return the bookID
	 */
	public int getBookID() {
		return bookID;
	}

	/**
	 * @return the CallNumber
	 */
	public String getCallNumber() {
		return CallNumber;
	}

	/**
	 * @return the ISBN
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * @return the noInLib
	 */
	public int getNoInLib() {
		return noInLib;
	}

	/**
	 * @return the noOfCopy
	 */
	public int getNoOfCopy() {
		return noOfCopy;
	}

	/**
	 * @return the Publisher
	 */
	public String getPublisher() {
		return Publisher;
	}

	/**
	 * @return the subID
	 */
	public int getSubID() {
		return subID;
	}

	/**
	 * @return the subName
	 */
	public String getSubName() {
		return subName;
	}

	/**
	 * @return the Title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param AuthName
	 *            the AuthName to set
	 */
	public void setAuthName(String AuthName) {
		this.AuthName = AuthName;
	}

	/**
	 * @param bookID
	 *            the bookID to set
	 */
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	/**
	 * @param CallNumber
	 *            the CallNumber to set
	 */
	public void setCallNumber(String CallNumber) {
		this.CallNumber = CallNumber;
	}

	/**
	 * @param ISBN
	 *            the ISBN to set
	 */
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	/**
	 * @param noInLib
	 *            the noInLib to set
	 */
	public void setNoInLib(int noInLib) {
		this.noInLib = noInLib;
	}

	/**
	 * @param noOfCopy
	 *            the noOfCopy to set
	 */
	public void setNoOfCopy(int noOfCopy) {
		this.noOfCopy = noOfCopy;
	}

	/**
	 * @param Publisher
	 *            the Publisher to set
	 */
	public void setPublisher(String Publisher) {
		this.Publisher = Publisher;
	}

	/**
	 * @param subID
	 *            the subID to set
	 */
	public void setSubID(int subID) {
		this.subID = subID;
	}

	/**
	 * @param subName
	 *            the subName to set
	 */
	public void setSubName(String subName) {
		this.subName = subName;
	}

	/**
	 * @param Title
	 *            the Title to set
	 */
	public void setTitle(String Title) {
		this.Title = Title;
	}

	/**
	 * @return Vector ob book
	 */
	public Vector<Object> toVector() {
		// Defined vector
		Vector<Object> vt = new Vector<Object>();
		vt.addElement(bookID);
		vt.addElement(CallNumber);
		vt.addElement(ISBN);
		vt.addElement(Title);
		vt.addElement(AuthName);
		vt.addElement(Publisher);
		vt.addElement(subName);
		vt.addElement(noOfCopy + Messages.getString("Book.0") + noInLib); //$NON-NLS-1$
		return vt;
	}
}
