/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Util.Objects;

/**
 *
 * @author dinh manh hai
 */
public class Book {
    private String CallNumber;
    private int subID;
    private String ISBN;
    private String Title;
    private String AuthName;
    private String Publisher;
    private int Department;

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
     * @return the Department
     */
    public int getDepartment() {
        return Department;
    }

    /**
     * @param Department the Department to set
     */
    public void setDepartment(int Department) {
        this.Department = Department;
    }
}