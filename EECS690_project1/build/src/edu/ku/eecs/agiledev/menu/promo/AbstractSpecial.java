package edu.ku.eecs.agiledev.menu.promo;

import java.util.UUID;

public abstract class AbstractSpecial implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -931971882792296831L;
	private String specialName;
	private UUID specialID;

	
	/**
	 * @return the specialName
	 */
	public String getSpecialName() {
		return specialName;
	}

	/**
	 * @param specialName
	 *            the specialName to set
	 */
	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}

	/**
	 * @return the specialID
	 */
	public UUID getSpecialID() {
		return specialID;
	}

	/**
	 * @param specialID
	 *            the specialID to set
	 */
	public void setSpecialID(UUID specialID) {
		this.specialID = specialID;
	}
	
	
	
	
	
	


}
