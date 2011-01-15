/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 * Check in entity
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
     * @return the borID
     */
    public int getBorID() {
        return borID;
    }

    /**
     * @param borID the borID to set
     */
    public void setBorID(int borID) {
        this.borID = borID;
    }

    /**
     * @return the empID
     */
    public int getEmpID() {
        return empID;
    }

    /**
     * @param empID the empID to set
     */
    public void setEmpID(int empID) {
        this.empID = empID;
    }

    /**
     * @return the callNumber
     */
    public String getCallNumber() {
        return callNumber;
    }

    /**
     * @param callNumber the callNumber to set
     */
    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the auth
     */
    public String getAuth() {
        return auth;
    }

    /**
     * @param auth the auth to set
     */
    public void setAuth(String auth) {
        this.auth = auth;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the dueDate
     */
    public long getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return the issueDate
     */
    public long getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate the issueDate to set
     */
    public void setIssueDate(long issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the bookID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * @param bookID the bookID to set
     */
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
