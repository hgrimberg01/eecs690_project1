package edu.ku.eecs.agiledev.core;

import java.awt.Window;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;

import edu.ku.eecs.agiledev.init.StartupWizard;
import edu.ku.eecs.agiledev.menu.Menu;
import edu.ku.eecs.agiledev.users.BaseUser;

public class Main {
	/**
	 * Session holds anything that relates to a given instance of an application
	 * (remote host/database connections, locale settings, etc.)
	 */
	@SuppressWarnings("unused")
	private static ApplicationSession session = new ApplicationSession();

	public static void main(String[] args) {
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
			System.out
					.println("Settings are correct, Fire up main menu here...");
		}
	}
}
