/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author dinh manh hai
 */
public class Borrow {

    private int BorID;
    private String CallNumber;
    private int EmpID;
    private int IssueStatus;
    private String ChkOutDate;
    private String DueDate;
    private String ChkInDate;
    private float TotalFee;

    public Borrow() {
    }

    public Borrow(int BorID, String CallNumber, int EmpID, int IssueStatus,
            String ChkOutDate, String DueDate, String ChkInDate, float TotalFee) {
        this.BorID = BorID;
        this.CallNumber = CallNumber;
        this.ChkInDate = ChkInDate;
        this.ChkOutDate = ChkOutDate;
        this.DueDate = DueDate;
        this.EmpID = EmpID;
        this.IssueStatus = IssueStatus;
        this.TotalFee = TotalFee;
    }

    /**
     * @return the BorID
     */
    public int getBorID() {
        return BorID;
    }

    /**
     * @param BorID the BorID to set
     */
    public void setBorID(int BorID) {
        this.BorID = BorID;
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
     * @return the EmpID
     */
    public int getEmpID() {
        return EmpID;
    }

    /**
     * @param EmpID the EmpID to set
     */
    public void setEmpID(int EmpID) {
        this.EmpID = EmpID;
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
     * @return the ChkOutDate
     */
    public String getChkOutDate() {
        return ChkOutDate;
    }

    /**
     * @param ChkOutDate the ChkOutDate to set
     */
    public void setChkOutDate(String ChkOutDate) {
        this.ChkOutDate = ChkOutDate;
    }

    /**
     * @return the DueDate
     */
    public String getDueDate() {
        return DueDate;
    }

    /**
     * @param DueDate the DueDate to set
     */
    public void setDueDate(String DueDate) {
        this.DueDate = DueDate;
    }

    /**
     * @return the ChklnDate
     */
    public String getChkInDate() {
        return ChkInDate;
    }

    /**
     * @param ChklnDate the ChklnDate to set
     */
    public void setChkInDate(String ChkInDate) {
        this.ChkInDate = ChkInDate;
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
}
