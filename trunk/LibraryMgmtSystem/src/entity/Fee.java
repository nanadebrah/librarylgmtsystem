/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author dinh manh hai
 */
public class Fee {

    private String Fee;
    private float BorFee;
    private float LateFee;

    public Fee() {
    }

    /**
     * 
     * @param Fee
     * @param BorFee
     * @param LateFee
     */
    public Fee(String Fee, float BorFee, float LateFee) {
        this.BorFee = BorFee;
        this.Fee = Fee;
        this.LateFee = LateFee;
    }

    /**
     * @return the Fee
     */
    public String getFee() {
        return Fee;
    }

    /**
     * @param Fee the Fee to set
     */
    public void setFee(String Fee) {
        this.Fee = Fee;
    }

    /**
     * @return the BorFee
     */
    public float getBorFee() {
        return BorFee;
    }

    /**
     * @param BorFee the BorFee to set
     */
    public void setBorFee(float BorFee) {
        this.BorFee = BorFee;
    }

    /**
     * @return the LateFee
     */
    public float getLateFee() {
        return LateFee;
    }

    /**
     * @param LateFee the LateFee to set
     */
    public void setLateFee(float LateFee) {
        this.LateFee = LateFee;
    }
}
