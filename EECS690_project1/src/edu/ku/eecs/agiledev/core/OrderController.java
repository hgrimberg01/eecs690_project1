package edu.ku.eecs.agiledev.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import edu.ku.eecs.agiledev.menu.Item;
import edu.ku.eecs.agiledev.ticket.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 * 
 * @author Howard
 * 
 */
public class OrderController {
	@FXML
	public TabPane ticketPane;

	@FXML
	public AnchorPane orderFrame;

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

	@FXML
	public void addItemHandler() throws IOException {
		final Popup popup = new Popup();

		AnchorPane internalPane = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("menuPopup.fxml"));

		@SuppressWarnings("unchecked")
		ListView<Item> lView = (ListView<Item>) internalPane.lookup("#menuItems");

		ArrayList<Item> its = new ArrayList<Item>(Main.db.getMenus().get(0)
				.getMenuItems());
		ObservableList<Item> fits = FXCollections.observableArrayList(its);

		lView.setItems(fits);

		SubWindow w = new SubWindow(Main.stage, "Menu Items", internalPane);

	}

	@FXML
	public void closeTicketHandler() throws IOException {
		Tab rTab = ticketPane.getSelectionModel().getSelectedItem();
		String id = rTab.getText().split(" ")[1];
		Main.db.getOpenTickets().remove(UUID.fromString(id));
		ticketPane.getTabs().remove(rTab);
		Main.save();
		System.gc();
	}

}
