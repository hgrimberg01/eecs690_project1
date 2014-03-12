package edu.ku.eecs.agiledev.core;

import java.io.IOException;

import edu.ku.eecs.agiledev.menu.Item;
import edu.ku.eecs.agiledev.menu.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class WindowController {
	@FXML
	public SplitPane sPane;

	@FXML
	public AnchorPane rPane;

	@FXML
	public void btnExitHandle(ActionEvent event) throws IOException {
		System.exit(0);

	}

	@SuppressWarnings("unchecked")
	@FXML
	public void btnAddItemMenuHandler(ActionEvent event) throws IOException {
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource(
				"item.fxml"));

		ListView<Item> lst = (ListView<Item>) root.getChildren().get(10);
		Menu first = Main.db.getMenus().get(0);
		System.out.println(first.toString());
		System.out.println(first.getMenuItems().toArray().length);
		Item[] i = new Item[3];
		Item[] itms = first.getMenuItems().toArray(i);
		ObservableList<Item> items = FXCollections.observableArrayList(i);
		lst.setItems(items);
		
		System.out.println(rPane.getHeight());
		ObservableList<Node> temp2 = sPane.getItems();
		AnchorPane ts = (AnchorPane) temp2.get(1);
		ts.getChildren().remove(0);
		ts.getChildren().add(root);
	}

	@FXML
	public void btnMainSalesHandle(ActionEvent event) throws IOException {
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource(
				"order_screen.fxml"));

		System.out.println(rPane.getHeight());
		ObservableList<Node> temp2 = sPane.getItems();
		AnchorPane ts = (AnchorPane) temp2.get(1);
		ts.getChildren().remove(0);
		ts.getChildren().add(root);

	}

}
