package edu.ku.eecs.agiledev.core;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SubWindow extends Stage {
	Stage owner;
	static Stage stage;
	BorderPane root;
	Node content;
	static boolean postStatus;

	public SubWindow(Stage owner, String title, Node content) {
		root = new BorderPane();

		stage = this;

		this.content = content;
		Button yes = (Button) content.lookup("#yes");
		yes.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				postStatus = true;
				stage.close(); // Close the pop up. Transfer control to
								// PostTransaction.java and execute the
								// PostTransaction() method.

			}
		});

		Button no = (Button) content.lookup("#no");
		no.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				postStatus = false;
				stage.close(); // Close the pop up only
			}

		});

		this.owner = owner;
		initModality(Modality.APPLICATION_MODAL);
		initOwner(owner);
		initStyle(StageStyle.UTILITY);
		setTitle(title);
		setContents();
	}

	public void setContents() {
		root.getChildren().add(content);
		Scene scene = new Scene(root, content.prefWidth(getHeight()),
				content.prefHeight(getWidth()));
		stage.setResizable(false);
		setScene(scene);

		stage.show();
	}

	public static boolean confirmTranactionPosting(Stage owner, String title,
			Node content) {

		new SubWindow(owner, title, content);

		return postStatus;
	}

}