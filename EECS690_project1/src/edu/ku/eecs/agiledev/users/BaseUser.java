package edu.ku.eecs.agiledev.users;

import java.util.UUID;

/**
 * 
 * @author hgrimberg
 * 
 */
public class BaseUser implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3766785575117179476L;
	private String firstName;
	private String lastName;
	private String pin;
	private UUID personID;
	private UserPermissions userPerms;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the personID
	 */
	public UUID getPersonID() {
		return personID;
	}

	/**
	 * @param personID
	 *            the personID to set
	 */
	public void setPersonID(UUID personID) {
		this.personID = personID;
	}

	/**
	 * @return the userPerms
	 */
	public UserPermissions getUserPerms() {
		return userPerms;
	}

	/**
	 * @param userPerms
	 *            the userPerms to set
	 */
	public void setUserPerms(UserPermissions userPerms) {
		this.userPerms = userPerms;
	}

	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public String toString(){
		return this.getFirstName() + " " + this.getLastName();
	}

}
