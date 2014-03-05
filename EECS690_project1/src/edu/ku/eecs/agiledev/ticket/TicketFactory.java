package edu.ku.eecs.agiledev.ticket;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import edu.ku.eecs.agiledev.floorplan.ServableTable;
import edu.ku.eecs.agiledev.menu.Item;
import edu.ku.eecs.agiledev.menu.Menu;
import edu.ku.eecs.agiledev.users.BaseUser;

public class TicketFactory {
	
	//GUI will have to have the Menu type, Ticket Lines, the tables, and the servers for the tables prepared
	public static Ticket getNewTicket(BaseUser server, Set<TicketLine> itemsAdded, Menu type, Set<ServableTable> tablesServed){
		Ticket newTicket = new Ticket();
		
		Set<BaseUser> servers = new HashSet<BaseUser>();
		servers.add( server);
		newTicket.settServers(servers);
		
		Date currentdate = new Date();
		newTicket.setOpenDate(currentdate);
		
		newTicket.setTicketID(UUID.randomUUID());
		
		//these will need to be provided by the server
		newTicket.setTicketMenu(type);
		newTicket.setTicketLines(itemsAdded);
		newTicket.setTicketTables(tablesServed);
		
		return newTicket;
	}
	
}
