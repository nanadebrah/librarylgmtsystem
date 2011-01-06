/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.SQLClientInfoException;
import java.util.Vector;
import model.AccessBorrow;
import model.LibUtil;

/**
 *
 * @author CuongNQ
 */
public class BorrowDetail {

    private int empID;
    private int borID;
    private String callNumber;
    private int IssueStatus;
    private long IssueDate;
    private long DueDate;
    private long ReturnDate;
    private float TotalFee;

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
     * @return the IssueStatus
     */
    public int getIssueStatus() {
        return IssueStatus;
    }

    /**
     * @param IssueStatus the IssueStatus to set
     */
    public void setIssueStatus(int IssueStatus) {
        this.IssueStatus = IssueStatus;
    }

    /**
     * @return the IssueDate
     */
    public long getIssueDate() {
        return IssueDate;
    }

    /**
     * @param IssueDate the IssueDate to set
     */
    public void setIssueDate(long IssueDate) {
        this.IssueDate = IssueDate;
    }

    /**
     * @return the DueDate
     */
    public long getDueDate() {
        return DueDate;
    }

    /**
     * @param DueDate the DueDate to set
     */
    public void setDueDate(long DueDate) {
        this.DueDate = DueDate;
    }

    /**
     * @return the ReturnDate
     */
    public long getReturnDate() {
        return ReturnDate;
    }

    /**
     * @param ReturnDate the ReturnDate to set
     */
    public void setReturnDate(long ReturnDate) {
        this.ReturnDate = ReturnDate;
    }

    /**
     * @return the TotalFee
     */
    public float getTotalFee() {
        return TotalFee;
    }

    /**
     * @param TotalFee the TotalFee to set
     */
    public void setTotalFee(float TotalFee) {
        this.TotalFee = TotalFee;
    }

    public Vector toVector() {
        Vector vt = new Vector();
        vt.add(borID);
        vt.add(empID);
        vt.addElement(callNumber);
        vt.add(LibUtil.getInstance().convertDate(new java.sql.Date(IssueDate).toString()));
        vt.add(LibUtil.getInstance().convertDate(new java.sql.Date(DueDate).toString()));
        if (IssueStatus==0) {
            vt.addElement("Check-out");
        }else{
            vt.addElement("Check-in");
        }
        return vt;
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
}
