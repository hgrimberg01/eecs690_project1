package edu.ku.eecs.agiledev.menu;

import java.util.UUID;

/**
 * 
 * @author hgrimberg
 * 
 */

public class AddOn implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4368556248209834181L;
	private String name;
	private float price;
	private UUID addOnID;

	/**
	 * 
	 */
	public AddOn() {

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the addOnID
	 */
	public UUID getAddOnID() {
		return addOnID;
	}

	/**
	 * @param addOnID
	 *            the addOnID to set
	 */
	public void setAddOnID(UUID addOnID) {
		this.addOnID = addOnID;
	}
	
	public String toString(){
		return getName();
	}

}