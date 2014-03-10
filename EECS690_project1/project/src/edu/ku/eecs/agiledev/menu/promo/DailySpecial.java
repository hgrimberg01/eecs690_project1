package edu.ku.eecs.agiledev.menu.promo;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import edu.ku.eecs.agiledev.menu.Item;

/**
 * 
 * @author hgrimberg FIXME: This is really tight coupling between an item and
 *         special. Need to split the actual special into a new class (ie
 *         SpecialType) and make this class bind the SpecialType with the item
 *         and amount.
 */
public class DailySpecial extends AbstractSpecial implements
		java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -608842634642236165L;
	/**
	 * 
	 */
	private int dayOfWeekValid;
	private Item menuItem;
	private float fixedAmountReduction;

	/**
	 * 
	 * @return
	 */
	public boolean isSpecialValid() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		if (dayOfWeek == this.dayOfWeekValid) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param basePrice
	 * @return
	 */

	public float getNewAmount(float basePrice) {
		return menuItem.getPrice() - this.fixedAmountReduction;
	}

	/**
	 * @return the dayOfWeekValid
	 */
	public int getDayOfWeekValid() {
		return dayOfWeekValid;
	}

	/**
	 * @param dayOfWeekValid
	 *            the dayOfWeekValid to set
	 */
	public void setDayOfWeekValid(int dayOfWeekValid) {
		this.dayOfWeekValid = dayOfWeekValid;
	}

	/**
	 * @return the menuItem
	 */
	public Item getMenuItem() {
		return menuItem;
	}

	/**
	 * @param menuItem
	 *            the menuItem to set
	 */
	public void setMenuItem(Item menuItem) {
		this.menuItem = menuItem;
	}

	/**
	 * @return the fixedAmountReduction
	 */
	public float getFixedAmountReduction() {
		return fixedAmountReduction;
	}

	/**
	 * @param fixedAmountReduction
	 *            the fixedAmountReduction to set
	 */
	public void setFixedAmountReduction(float fixedAmountReduction) {
		this.fixedAmountReduction = fixedAmountReduction;
	}

	public String toString() {
		return getSpecialName() + '@' + getMenuItem().getName();
	}

}
