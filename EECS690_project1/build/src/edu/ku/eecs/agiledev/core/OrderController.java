package edu.ku.eecs.agiledev.core;

import java.io.IOException;
import java.util.UUID;

import edu.ku.eecs.agiledev.ticket.Ticket;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

/**
 * 
 * @author Howard
 * 
 */
public class OrderController {
	@FXML
	public TabPane ticketPane;

	@FXML
	public void btnNewTicketHandler() throws IOException {
		Ticket newTicket = new Ticket();
		newTicket.setTicketID(UUID.randomUUID());
		Main.db.getOpenTickets().put(newTicket.getTicketID(), newTicket);
		Tab ticketTab = new Tab();

		ticketTab.textProperty().set(
				"Ticket ".concat(newTicket.getTicketID().toString()));
		AnchorPane internalPane = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("ticket_internal.fxml"));

		ticketTab.setContent(internalPane);

		ticketPane.getTabs().add(ticketTab);
		Main.save();
	}

	@FXML
	public void removeItemButtonHandler() {
		
	}

	@FXML
	public void splitItemHandler() {

	}

}
