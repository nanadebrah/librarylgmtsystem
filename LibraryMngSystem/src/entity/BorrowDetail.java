/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Vector;

import model.LibUtil;

/**
 * Borrow detail entity
 * 
 * @author CuongNQ
 */
public class BorrowDetail {

	private int empID;
	private int borID;
	private int bookID;
	private int IssueStatus;
	private long IssueDate;
	private long DueDate;
	private long ReturnDate;
	private float TotalFee;

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
	 * @return the DueDate
	 */
	public long getDueDate() {
		return DueDate;
	}

	/**
	 * @return the empID
	 */
	public int getEmpID() {
		return empID;
	}

	/**
	 * @return the IssueDate
	 */
	public long getIssueDate() {
		return IssueDate;
	}

	/**
	 * @return the IssueStatus
	 */
	public int getIssueStatus() {
		return IssueStatus;
	}

	/**
	 * @return the ReturnDate
	 */
	public long getReturnDate() {
		return ReturnDate;
	}

	/**
	 * @return the TotalFee
	 */
	public float getTotalFee() {
		return TotalFee;
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
	 * @param DueDate
	 *            the DueDate to set
	 */
	public void setDueDate(long DueDate) {
		this.DueDate = DueDate;
	}

	/**
	 * @param empID
	 *            the empID to set
	 */
	public void setEmpID(int empID) {
		this.empID = empID;
	}

	/**
	 * @param IssueDate
	 *            the IssueDate to set
	 */
	public void setIssueDate(long IssueDate) {
		this.IssueDate = IssueDate;
	}

	/**
	 * @param IssueStatus
	 *            the IssueStatus to set
	 */
	public void setIssueStatus(int IssueStatus) {
		this.IssueStatus = IssueStatus;
	}

	/**
	 * @param ReturnDate
	 *            the ReturnDate to set
	 */
	public void setReturnDate(long ReturnDate) {
		this.ReturnDate = ReturnDate;
	}

	/**
	 * @param TotalFee
	 *            the TotalFee to set
	 */
	public void setTotalFee(float TotalFee) {
		this.TotalFee = TotalFee;
	}

	public Vector<Object> toVector() {
		Vector<Object> vt = new Vector<Object>();
		vt.add(borID);
		vt.add(empID);
		vt.addElement(getBookID());
		vt.add(LibUtil.getInstance().convertDate(
				new java.sql.Date(IssueDate).toString()));
		vt.add(LibUtil.getInstance().convertDate(
				new java.sql.Date(DueDate).toString()));
		if (IssueStatus == 0) {
			vt.addElement(Messages.getString("BorrowDetail.0")); //$NON-NLS-1$
		} else {
			vt.addElement(Messages.getString("BorrowDetail.1")); //$NON-NLS-1$
		}
		return vt;
	}
}
