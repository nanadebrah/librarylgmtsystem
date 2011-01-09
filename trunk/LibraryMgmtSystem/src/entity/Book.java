/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Vector;

/**
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

    public Book() {
    }

    /**
     * @return the CallNumber
     */
    public String getCallNumber() {
        return CallNumber;
    }

    /**
     * @param CallNumber the CallNumber to set
     */
    public void setCallNumber(String CallNumber) {
        this.CallNumber = CallNumber;
    }

    /**
     * @return the subID
     */
    public int getSubID() {
        return subID;
    }

    /**
     * @param subID the subID to set
     */
    public void setSubID(int subID) {
        this.subID = subID;
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
     * @return the Title
     */
    public String getTitle() {
        return Title;
    }

    /**
     * @param Title the Title to set
     */
    public void setTitle(String Title) {
        this.Title = Title;
    }

    /**
     * @return the AuthName
     */
    public String getAuthName() {
        return AuthName;
    }

    /**
     * @param AuthName the AuthName to set
     */
    public void setAuthName(String AuthName) {
        this.AuthName = AuthName;
    }

    /**
     * @return the Publisher
     */
    public String getPublisher() {
        return Publisher;
    }

    /**
     * @param Publisher the Publisher to set
     */
    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    /**
     * @return the noOfCopy
     */
    public int getNoOfCopy() {
        return noOfCopy;
    }

    /**
     * @param noOfCopy the noOfCopy to set
     */
    public void setNoOfCopy(int noOfCopy) {
        this.noOfCopy = noOfCopy;
    }

    /**
     * @return the noInLib
     */
    public int getNoInLib() {
        return noInLib;
    }

    /**
     * @param noInLib the noInLib to set
     */
    public void setNoInLib(int noInLib) {
        this.noInLib = noInLib;
    }

    /**
     * @return Vector ob book
     */
    public Vector toVector() {
        //Defined vector
        Vector vt = new Vector();
        vt.addElement(bookID);
        vt.addElement(CallNumber);
        vt.addElement(ISBN);
        vt.addElement(Title);
        vt.addElement(AuthName);
        vt.addElement(Publisher);
        vt.addElement(noOfCopy+"/"+noInLib);
        return vt;
    }

    /**
     * @return the subName
     */
    public String getSubName() {
        return subName;
    }

    /**
     * @param subName the subName to set
     */
    public void setSubName(String subName) {
        this.subName = subName;
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
