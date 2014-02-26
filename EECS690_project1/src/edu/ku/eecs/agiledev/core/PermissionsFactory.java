package edu.ku.eecs.agiledev.core;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

import edu.ku.eecs.agiledev.users.UserPermissions;


public class PermissionsFactory {
	private Gson gson;
	
	public PermissionsFactory(Gson inGson){
		gson = inGson;
	}
	
	public UserPermissions getPermissions(Object user){
		
		String userPermHash = (new Integer(user.hashCode())).toString();
		
	
		return null;
		
		
		
	}
	
	public void setUserPermissions(Object user){
			
		
		
	}
	
	
	
	
}
