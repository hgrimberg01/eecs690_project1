package edu.ku.eecs.agiledev.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.ku.eecs.agiledev.users.UserPermissions;

public class PermissionsFactory {

	public PermissionsFactory() {

	}

	public UserPermissions getPermissions(Object user) {

		String userPermHash = (new Integer(user.hashCode())).toString();

		return null;

	}

	public void setUserPermissions(Object user) {

	}

}
