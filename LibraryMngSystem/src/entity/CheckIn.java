/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 * Check in entity
 * 
 * @author CuongNQ
 */
public class CheckIn {
	private int borID;
	private int empID;
	private int bookID;
	private String callNumber;
	private String ISBN;
	private String title;
	private String auth;
	private String publisher;
	private long dueDate;
	private long issueDate;

	/**
	 * @return the auth
	 */
	public String getAuth() {
		return auth;
	}

	/**
	 * @return the bookID
	 */
	public int getBookID() {
		return bookID;
	}

	/**
	 * @return the borID
	 */
	public int getBorID() {
		return borID;
	}

	/**
	 * @return the callNumber
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/**
	 * @return the dueDate
	 */
	public long getDueDate() {
		return dueDate;
	}

	/**
	 * @return the empID
	 */
	public int getEmpID() {
		return empID;
	}

	/**
	 * @return the ISBN
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * @return the issueDate
	 */
	public long getIssueDate() {
		return issueDate;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param auth
	 *            the auth to set
	 */
	public void setAuth(String auth) {
		this.auth = auth;
	}

	/**
	 * @param bookID
	 *            the bookID to set
	 */
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	/**
	 * @param borID
	 *            the borID to set
	 */
	public void setBorID(int borID) {
		this.borID = borID;
	}

	/**
	 * @param callNumber
	 *            the callNumber to set
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	/**
	 * @param dueDate
	 *            the dueDate to set
	 */
	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @param empID
	 *            the empID to set
	 */
	public void setEmpID(int empID) {
		this.empID = empID;
	}

	/**
	 * @param ISBN
	 *            the ISBN to set
	 */
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	/**
	 * @param issueDate
	 *            the issueDate to set
	 */
	public void setIssueDate(long issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * @param publisher
	 *            the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
