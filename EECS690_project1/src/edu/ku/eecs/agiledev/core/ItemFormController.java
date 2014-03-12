package edu.ku.eecs.agiledev.core;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import edu.ku.eecs.agiledev.menu.AddOn;
import edu.ku.eecs.agiledev.menu.Item;
import edu.ku.eecs.agiledev.menu.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ItemFormController {
	@FXML
	public ListView<Item> itemList;

	@FXML
	public ListView<AddOn> addonList;

	@FXML
	public TextField iPrice;

	@FXML
	public TextField iName;

	@FXML
	public void btnItemClickHandler(MouseEvent arg0) throws IOException {
		
		Item selected = itemList.getSelectionModel().getSelectedItem();

		iPrice.setText((new Float(selected.getPrice())).toString());
		iName.setText(selected.getName());
		Map<UUID, AddOn> adds = selected.getItemAddOns();
		if (adds.size() > 0) {
			AddOn[] addOns = new AddOn[1];
			AddOn[] adds2 = adds.values().toArray(addOns);

			ObservableList<AddOn> obs = FXCollections
					.observableArrayList(adds2);

			addonList.setItems(obs);
		} else {
			ObservableList<AddOn> obs = FXCollections.observableArrayList();

			addonList.setItems(obs);
		}
		Main.save();
	}

	@FXML
	public void btnSaveClickHandler() throws IOException {
		MultipleSelectionModel<Item> sel = itemList.getSelectionModel();

		Item selected = itemList.getSelectionModel().getSelectedItem();
		int i = itemList.getSelectionModel().getSelectedIndex();

		if (selected != null) {
			selected.setName(iName.getText());
			selected.setPrice(new Float(iPrice.getText()));
			itemList.getItems().remove(i);
			itemList.getItems().add(i, selected);

		}
		
		Main.save();
	}

	@FXML
	public void btnNewClickHandler() throws IOException {
		Item n = new Item();
		n.setItemID(UUID.randomUUID());
		n.setName("New Item");
		n.setPrice((float) 00.00);

		iName.setText("New Item");
		iPrice.setText("00.00");
		itemList.getItems().add(n);
		Main.db.getMenus().get(0).getMenuItems().add(n);
		
		Main.save();
	}

	@FXML
	public void btnDeleteClickHandler() throws IOException {
		MultipleSelectionModel<Item> sel = itemList.getSelectionModel();

		if (sel.getSelectedItem() != null) {
			Item i = sel.getSelectedItem();
			Main.db.getMenus().get(0).getMenuItems().remove(i);
			itemList.getItems().remove(i);
			iPrice.clear();
			iName.clear();
			addonList.getItems().clear();

		}
		
		Main.save();
	}

}
