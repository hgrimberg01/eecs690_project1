package edu.ku.eecs.agiledev.ticket;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import edu.ku.eecs.agiledev.floorplan.ServableTable;
import edu.ku.eecs.agiledev.menu.Menu;
import edu.ku.eecs.agiledev.users.BaseUser;

/**
 * 
 * @author hgrimberg
 * 
 */
public class Ticket implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3004214449928553498L;
	private Set<ServableTable> ticketTables;
	private Menu ticketMenu;
	private Set<TicketLine> ticketLines;
	private Date openDate;
	private Date closeDate;
	private boolean voided;
	private boolean taxExempt;
	private String memo;
	private UUID ticketID;
	private Set<BaseUser> tServers;
	
	/**
	 * @return the ticketTables
	 */
	public Set<ServableTable> getTicketTables() {
		return ticketTables;
	}

	/**
	 * @param ticketTables
	 *            the ticketTables to set
	 */
	public void setTicketTables(Set<ServableTable> ticketTables) {
		this.ticketTables = ticketTables;
	}

	/**
	 * @return the openDate
	 */
	public Date getOpenDate() {
		return openDate;
	}

	/**
	 * @param openDate
	 *            the openDate to set
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	/**
	 * @return the closeDate
	 */
	public Date getCloseDate() {
		return closeDate;
	}

	/**
	 * @param closeDate
	 *            the closeDate to set
	 */
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	/**
	 * @return the voided
	 */
	public boolean isVoided() {
		return voided;
	}

	/**
	 * @param voided
	 *            the voided to set
	 */
	public void setVoided(boolean voided) {
		this.voided = voided;
	}

	/**
	 * @return the taxExempt
	 */
	public boolean isTaxExempt() {
		return taxExempt;
	}

	/**
	 * @param taxExempt
	 *            the taxExempt to set
	 */
	public void setTaxExempt(boolean taxExempt) {
		this.taxExempt = taxExempt;
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

	/**
	 * @return the ticketID
	 */
	public UUID getTicketID() {
		return ticketID;
	}

	/**
	 * @param ticketID
	 *            the ticketID to set
	 */
	public void setTicketID(UUID ticketID) {
		this.ticketID = ticketID;
	}

	/**
	 * TODO: Specials are not calculated
	 * 
	 * @return
	 */
	public float getSubTotal() {
		Iterator<TicketLine> iTicketLine = this.ticketLines.iterator();

		float subTotal = 0;

		while (iTicketLine.hasNext()) {
			TicketLine tLine = iTicketLine.next();

			subTotal += tLine.getLineItem().getPrice();

		}

		return subTotal;
	}

	public float getTaxTotal() {
		if (this.taxExempt) {
			return (float) 0.00;
		} else {
			Iterator<TicketLine> iTicketLine = this.ticketLines.iterator();
			float taxTotal = 0;

			while (iTicketLine.hasNext()) {
				TicketLine tLine = iTicketLine.next();

				taxTotal += tLine.getLineTax().getSalesTaxAmount(
						tLine.getLineItem().getPrice());

			}
			return taxTotal;

		}

	}

	public float getFinalTotal() {
		return getTaxTotal() + getSubTotal();
	}

	/**
	 * @return the ticketLines
	 */
	public Set<TicketLine> getTicketLines() {
		return ticketLines;
	}

	/**
	 * @param ticketLines
	 *            the ticketLines to set
	 */
	public void setTicketLines(Set<TicketLine> ticketLines) {
		this.ticketLines = ticketLines;
	}

	/**
	 * @return the ticketMenu
	 */
	public Menu getTicketMenu() {
		return ticketMenu;
	}

	/**
	 * @param ticketMenu
	 *            the ticketMenu to set
	 */
	public void setTicketMenu(Menu ticketMenu) {
		this.ticketMenu = ticketMenu;
	}

	/**
	 * @return the tServers
	 */
	public Set<BaseUser> gettServers() {
		return tServers;
	}

	/**
	 * @param tServers the tServers to set
	 */
	public void settServers(Set<BaseUser> tServers) {
		this.tServers = tServers;
	}

}
