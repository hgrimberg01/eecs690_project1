package edu.ku.eecs.agiledev.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 
 * @author hgrimberg
 * 
 */
public class Item implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1367345438492652424L;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private float price;
	/**
	 * 
	 */
	private Map<UUID, AddOn> itemAddOns;
	/**
	 * 
	 */
	private UUID itemID;

	/**
	 * 
	 * @param name
	 * @param price
	 */
	public Item() {

	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * 
	 * @return
	 */
	public Map<UUID, AddOn> getItemAddOns() {
		return itemAddOns;
	}

	/**
	 * 
	 * @param itemAddOns
	 */
	public void setItemAddOns(Map<UUID, AddOn> itemAddOns) {
		this.itemAddOns = itemAddOns;
	}

	/**
	 * @return the itemID
	 */
	public UUID getItemID() {
		return itemID;
	}
	

	/**
	 * 
	 * @param id
	 */
	public void setItemID(UUID id) {
		this.itemID = id;
	}
	
	public String toString(){
		return getName();
	}

}
