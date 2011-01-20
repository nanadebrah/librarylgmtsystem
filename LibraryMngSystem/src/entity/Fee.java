/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 * Fee entiy
 * 
 * @author dinh manh hai
 */
public class Fee {

	private String Fee;
	private float BorFee;
	private float LateFee;

	/**
	 * @return the BorFee
	 */
	public float getBorFee() {
		return BorFee;
	}

	/**
	 * @return the Fee
	 */
	public String getFee() {
		return Fee;
	}

	/**
	 * @return the LateFee
	 */
	public float getLateFee() {
		return LateFee;
	}

	/**
	 * @param BorFee
	 *            the BorFee to set
	 */
	public void setBorFee(float BorFee) {
		this.BorFee = BorFee;
	}

	/**
	 * @param Fee
	 *            the Fee to set
	 */
	public void setFee(String Fee) {
		this.Fee = Fee;
	}

	/**
	 * @param LateFee
	 *            the LateFee to set
	 */
	public void setLateFee(float LateFee) {
		this.LateFee = LateFee;
	}
}
