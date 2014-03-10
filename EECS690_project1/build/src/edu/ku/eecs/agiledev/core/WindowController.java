package edu.ku.eecs.agiledev.core;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

public class WindowController {
	@FXML
	public SplitPane sPane;

	@FXML
	public AnchorPane rPane;

	@FXML
	public void btnExitHandle(ActionEvent event) throws IOException {
		System.exit(0);

	}

	@FXML
	public void btnAddItemMenuHandler(ActionEvent event) throws IOException {
		AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource(
				"item.fxml"));

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
