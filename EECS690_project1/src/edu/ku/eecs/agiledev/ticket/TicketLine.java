/**
 * 
 */
package edu.ku.eecs.agiledev.ticket;

import edu.ku.eecs.agiledev.core.Tax;
import edu.ku.eecs.agiledev.menu.Item;
import edu.ku.eecs.agiledev.menu.promo.AbstractSpecial;
import edu.ku.eecs.agiledev.menu.promo.DailySpecial;

/**
 * @author hgrimberg
 * 
 */
public class TicketLine implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9206735189080541824L;
	private Item lineItem;
	private Tax lineTax;
	private DailySpecial lineSpecial;
	private String memo;

	/**
	 * 
	 */
	public TicketLine() {

	}

	/**
	 * @return the lineItem
	 */
	public Item getLineItem() {
		return lineItem;
	}

	/**
	 * @param lineItem
	 *            the lineItem to set
	 */
	public void setLineItem(Item lineItem) {
		this.lineItem = lineItem;
	}

	/**
	 * @return the lineTax
	 */
	public Tax getLineTax() {
		return lineTax;
	}

	/**
	 * @param lineTax
	 *            the lineTax to set
	 */
	public void setLineTax(Tax lineTax) {
		this.lineTax = lineTax;
	}

	/**
	 * @return the lineSpecial
	 */
	public DailySpecial getLineSpecial() {
		return lineSpecial;
	}

	/**
	 * @param lineSpecial
	 *            the lineSpecial to set
	 */
	public void setLineSpecial(DailySpecial lineSpecial) {
		this.lineSpecial = lineSpecial;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo
	 *            the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

}
