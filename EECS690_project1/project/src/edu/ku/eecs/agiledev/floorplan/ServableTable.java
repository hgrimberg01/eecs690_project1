package edu.ku.eecs.agiledev.floorplan;

import java.util.UUID;

public class ServableTable implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3697182429939145519L;
	private UUID tableID;
	private int x;
	private int y;
	private String tableDesc;
	private int maxSeats;

	public ServableTable() {

	}

	/**
	 * @return the tableID
	 */
	public UUID getTableID() {
		return tableID;
	}

	/**
	 * @param tableID
	 *            the tableID to set
	 */
	public void setTableID(UUID tableID) {
		this.tableID = tableID;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the tableDesc
	 */
	public String getTableDesc() {
		return tableDesc;
	}

	/**
	 * @param tableDesc
	 *            the tableDesc to set
	 */
	public void setTableDesc(String tableDesc) {
		this.tableDesc = tableDesc;
	}

	/**
	 * @return the maxSeats
	 */
	public int getMaxSeats() {
		return maxSeats;
	}

	/**
	 * @param maxSeats
	 *            the maxSeats to set
	 */
	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}

}
