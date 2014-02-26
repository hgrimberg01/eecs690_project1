package edu.ku.eecs.agiledev.menu;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import edu.ku.eecs.agiledev.menu.promo.AbstractSpecial;
import edu.ku.eecs.agiledev.menu.promo.DailySpecial;

/**
 * 
 * @author hgrimberg
 * 
 */
public class Menu implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8039496140330772584L;
	private Set<Item> menuItems;
	private Set<DailySpecial> menuSpecials;
	private Date menuCreationDate;
	private Date menuModificationDate;
	private String menuName;
	private UUID menuID;

	/**
	 * @return the menuItems
	 */
	public Set<Item> getMenuItems() {
		return menuItems;
	}

	/**
	 * @param menuItems
	 *            the menuItems to set
	 */
	public void setMenuItems(Set<Item> menuItems) {
		this.menuItems = menuItems;
	}

	/**
	 * @return the menuSpecials
	 */
	public Set<DailySpecial> getMenuSpecials() {
		return menuSpecials;
	}

	/**
	 * @param menuSpecials
	 *            the menuSpecials to set
	 */
	public void setMenuSpecials(Set<DailySpecial> menuSpecials) {
		this.menuSpecials = menuSpecials;
	}

	/**
	 * @return the menuCreationDate
	 */
	public Date getMenuCreationDate() {
		return menuCreationDate;
	}

	/**
	 * @param menuCreationDate
	 *            the menuCreationDate to set
	 */
	public void setMenuCreationDate(Date menuCreationDate) {
		this.menuCreationDate = menuCreationDate;
	}

	/**
	 * @return the menuModificationDate
	 */
	public Date getMenuModificationDate() {
		return menuModificationDate;
	}

	/**
	 * @param menuModificationDate
	 *            the menuModificationDate to set
	 */
	public void setMenuModificationDate(Date menuModificationDate) {
		this.menuModificationDate = menuModificationDate;
	}

	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName
	 *            the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * @return the menuID
	 */
	public UUID getMenuID() {
		return menuID;
	}

	/**
	 * @param menuID
	 *            the menuID to set
	 */
	public void setMenuID(UUID menuID) {
		this.menuID = menuID;
	}

	public String toString() {
		return getMenuName();

	}

}