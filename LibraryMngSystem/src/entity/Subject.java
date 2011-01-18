/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Vector;

/**
 * Subject entity
 * 
 * @author dinh manh hai
 */
public class Subject {

	private int SubID;
	private String SubName;
	private String Description;

	/**
	 * Default constructor
	 */
	public Subject() {
	}

	/**
	 * Constructor with param
	 * 
	 * @param SubID
	 * @param SubName
	 * @param Description
	 */
	public Subject(int SubID, String SubName, String Description) {
		this.Description = Description;
		this.SubID = SubID;
		this.SubName = SubName;
	}

	/**
	 * @return the SubID
	 */
	public int getSubID() {
		return SubID;
	}

	/**
	 * @param SubID
	 *            the SubID to set
	 */
	public void setSubID(int SubID) {
		this.SubID = SubID;
	}

	/**
	 * @return the SubName
	 */
	public String getSubName() {
		return SubName;
	}

	/**
	 * @param SubName
	 *            the SubName to set
	 */
	public void setSubName(String SubName) {
		this.SubName = SubName;
	}

	/**
	 * @return the Description
	 */
	public String getDescription() {
		return Description;
	}

	/**
	 * @param Description
	 *            the Description to set
	 */
	public void setDescription(String Description) {
		this.Description = Description;
	}

	/*
	 * subject to vector
	 */
	public Vector<Object> toVector() {
		Vector<Object> vt = new Vector<Object>();
		vt.addElement(SubID);
		vt.addElement(SubName);
		vt.addElement(Description);
		return vt;
	}
}
