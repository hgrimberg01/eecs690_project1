package edu.ku.eecs.agiledev.core;

import java.util.List;

import edu.ku.eecs.agiledev.floorplan.ServableTable;
import edu.ku.eecs.agiledev.menu.Menu;
import edu.ku.eecs.agiledev.users.BaseUser;

/**
 * 
 * @author hgrimberg
 * 
 */
public class Restaurant implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1302782511204573451L;
	
	
	private List<Menu> menus;
	private List<BaseUser> users;
	private List<ServableTable> tables;
	private List<Tax> taxes;

	public Restaurant() {

	}

	/**
	 * @return the menus
	 */
	public List<Menu> getMenus() {
		return menus;
	}

	/**
	 * @param menus
	 *            the menus to set
	 */
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	/**
	 * @return the users
	 */
	public List<BaseUser> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<BaseUser> users) {
		this.users = users;
	}

	/**
	 * @return the tables
	 */
	public List<ServableTable> getTables() {
		return tables;
	}

	/**
	 * @param tables
	 *            the tables to set
	 */
	public void setTables(List<ServableTable> tables) {
		this.tables = tables;
	}

	/**
	 * @return the taxes
	 */
	public List<Tax> getTaxes() {
		return taxes;
	}

	/**
	 * @param taxes the taxes to set
	 */
	public void setTaxes(List<Tax> taxes) {
		this.taxes = taxes;
	}

}
