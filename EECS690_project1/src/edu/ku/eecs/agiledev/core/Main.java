package edu.ku.eecs.agiledev.core;

import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import edu.ku.eecs.agiledev.init.StartupWizard;
import edu.ku.eecs.agiledev.menu.Menu;
import edu.ku.eecs.agiledev.ticket.Ticket;
import edu.ku.eecs.agiledev.users.BaseUser;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	/**
	 * Session holds anything that relates to a given instance of an application
	 * (remote host/database connections, locale settings, etc.)
	 */
	@SuppressWarnings("unused")
	private static ApplicationSession session = new ApplicationSession();
	public static Restaurant db;
	public static Stage stage;

	public static void save() throws IOException {

		String homeDir = System.getProperty("user.home");
		String pathSep = System.getProperty("file.separator");

		String path = homeDir + pathSep + "pos.properties";
		File settings = new File(path);

		FileOutputStream fout = new FileOutputStream(path);

		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(Main.db);
		oos.flush();
		oos.close();

	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		// TODO Auto-generated method stub
		String homeDir = System.getProperty("user.home");
		String pathSep = System.getProperty("file.separator");

		String path = homeDir + pathSep + "pos.properties";
		File settings = new File(path);

		if (!settings.exists()) {

			try {
				StartupWizard.intro();
				BaseUser root = StartupWizard.StepOne();
				Tax tax = StartupWizard.SalesTaxCreation();
				Menu menu = StartupWizard.MenuCreation();

				Restaurant rst = new Restaurant();

				ArrayList<Menu> menus = new ArrayList<Menu>();
				ArrayList<Tax> taxes = new ArrayList<Tax>();
				ArrayList<BaseUser> users = new ArrayList<BaseUser>();

				menus.add(menu);
				users.add(root);
				taxes.add(tax);
				rst.setOpenTickets(new HashMap<UUID, Ticket>());
				rst.setMenus(menus);
				rst.setTaxes(taxes);
				rst.setUsers(users);

				FileOutputStream fout = new FileOutputStream(path);

				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(rst);
				oos.flush();
				oos.close();
				System.out.println("Restarting App...");
				/**
				 * I need to figure out how to cleanly restart the app without
				 * user intervention. This a bit tricky to do without the
				 * support of the OS. Perhaps I can refactor it such that I
				 * merely need to reload the ApplicationContext and go from
				 * there for hot restart.
				 */

				System.exit(0);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			FileInputStream fin = new FileInputStream(path);
			ObjectInputStream ins = new ObjectInputStream(fin);
			Main.db = (Restaurant) ins.readObject();

			launch(args);
		}
	}

	public void start(Stage primaryStage) {
		try {
			Main.stage = primaryStage;
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
					.getResource("Sample.fxml"));

			Scene scene = new Scene(root, 1024, 768);
			primaryStage.setTitle("Project 1");
			primaryStage.setResizable(false);

			scene.getStylesheets().add(
					getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			AnchorPane element = (AnchorPane) FXMLLoader.load(getClass()
					.getResource("order_screen.fxml"));

			ObservableList<Node> t = element.getChildren();
			ObservableList<Node> temp = root.getChildren();
			SplitPane f = (SplitPane) temp.get(0);
			ObservableList<Node> temp2 = f.getItems();
			AnchorPane ts = (AnchorPane) temp2.get(1);

			

			TabPane tPane = (TabPane) element.lookup("#ticketPane");
			if (Main.db.getOpenTickets() != null) {
				Collection<Ticket> loadTicks = Main.db.getOpenTickets()
						.values();

				for (Ticket tick : loadTicks) {
					Tab ticketTab = new Tab();
					ticketTab.textProperty().set("Ticket ".concat(tick.getTicketID().toString()));
					AnchorPane internalPane = (AnchorPane) FXMLLoader.load(getClass()
							.getResource("ticket_internal.fxml"));
					ticketTab.setContent(internalPane);
					tPane.getTabs().add(ticketTab);

				}

			}
			ts.getChildren().add(element);

			// // AnchorPane s2 = (AnchorPane) temp2.get(0);
			// s2.getChildren().set(0, element);
			primaryStage.setFullScreen(true);

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
