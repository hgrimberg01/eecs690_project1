package edu.ku.eecs.agiledev.core;

import java.util.UUID;

public class Tax implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5199134300858598565L;
	private float taxPercent;
	private String taxName;
	private UUID taxID;
	
	
	/**
	 * 
	 */
	public Tax(){
		
	}



	/**
	 * @return the taxPercent
	 */
	public float getTaxPercent() {
		return taxPercent;
	}



	/**
	 * @param taxPercent the taxPercent to set
	 */
	public void setTaxPercent(float taxPercent) {
		this.taxPercent = taxPercent;
	}



	/**
	 * @return the taxName
	 */
	public String getTaxName() {
		return taxName;
	}



	/**
	 * @param taxName the taxName to set
	 */
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	
	
	public float getSalesTaxAmount(float subTotal){
		return	this.taxPercent * subTotal;
	}



	public UUID getTaxID() {
		return taxID;
	}



	public void setTaxID(UUID taxID) {
		this.taxID = taxID;
	}
	
	
	

}
