package edu.ku.eecs.agiledev.init;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import edu.ku.eecs.agiledev.core.Tax;
import edu.ku.eecs.agiledev.menu.AddOn;
import edu.ku.eecs.agiledev.menu.Item;
import edu.ku.eecs.agiledev.menu.Menu;
import edu.ku.eecs.agiledev.users.BaseUser;
import edu.ku.eecs.agiledev.users.UserPermissions;

public class StartupWizard {
	private static List<AddOn> ADDONS = new ArrayList<AddOn>();
	private static List<Item> ITEMS = new ArrayList<Item>();
	private static Menu menu = new Menu();
	private static BaseUser root = new BaseUser();
	private static UserPermissions perms = new UserPermissions();
	private static BufferedReader bufferRead = new BufferedReader(
			new InputStreamReader(System.in));
	private static Tax tax = new Tax();

	public static void intro() {
		System.out.println("***WELCOME TO POS SOFT***");
		System.out
				.println("No Coniguration Found, starting first time configuration");

	}

	public static BaseUser StepOne() throws IOException {

		System.out.println("***Initial User***");
		System.out.print("Please enter the master user's first name:");
		String s = bufferRead.readLine();
		root.setFirstName(s);
		System.out.print("Please enter the master user's lastname:");
		s = bufferRead.readLine();
		root.setLastName(s);
		System.out.print("Please enter the master user's PIN:");
		s = bufferRead.readLine();
		root.setPin(s);
		root.setPersonID(UUID.randomUUID());
		return root;
	}

	public static Tax SalesTaxCreation() throws IOException {

		System.out.println("***Initial Tax***");
		System.out.print("Please enter the Initial Tax Name:");
		tax.setTaxID(UUID.randomUUID());
		String s = bufferRead.readLine();
		tax.setTaxName(s);
		System.out.print("Please enter the Initial Tax Rate(as a decimal):");
		s = bufferRead.readLine();
		tax.setTaxPercent(new Float(s));

		return tax;
	}

	public static Item ItemCreation() throws IOException {
		Item item = new Item();
		System.out.print("Enter Item Name:");
		String s = bufferRead.readLine();
		item.setName(s);
		System.out.print("Enter Item Price:");
		s = bufferRead.readLine();
		item.setPrice(new Float(s));
		item.setItemID(UUID.randomUUID());

		System.out
				.println("Select an addon for this item. Enter -1 of no addon is needed");
		for (AddOn aOn : ADDONS) {
			Integer i = ADDONS.indexOf(aOn);
			System.out.println(i.toString() + "  " + aOn.toString());
		}
		s = bufferRead.readLine();
		Integer ind = new Integer(s);

		Map<UUID, AddOn> nOn = new HashMap<UUID, AddOn>();
		if (ind != -1) {
			AddOn a = ADDONS.get(ind);

			nOn.put(a.getAddOnID(), a);
		}
		item.setItemAddOns(nOn);
		ITEMS.add(item);
		return item;

	}

	public static AddOn AddOnCreation() throws IOException {
		AddOn aOn = new AddOn();
		System.out.print("Enter AddOn Name:");
		String s = bufferRead.readLine();
		aOn.setName(s);
		aOn.setAddOnID(UUID.randomUUID());

		System.out.print("Enter AddOn Price:");

		s = bufferRead.readLine();
		if (s.equals("")) {
			s = "0.00";
		}
		aOn.setPrice(new Float(s));

		ADDONS.add(aOn);
		return aOn;

	}

	@SuppressWarnings("unchecked")
	public static Menu MenuCreation() throws IOException {

		menu.setMenuID(UUID.randomUUID());
		System.out.println("***Initial Menu***");

		System.out.print("Please enter the Initial Menu Name:");
		String s = bufferRead.readLine();
		menu.setMenuModificationDate(new Date());
		menu.setMenuCreationDate(new Date());
		menu.setMenuName(s);

		boolean more = true;

		while (more) {
			AddOn someAddon = StartupWizard.AddOnCreation();
			System.out.print("More AddOns (y/n)?:");
			s = bufferRead.readLine();
			if (s.equals("n")) {
				more = false;
				break;

			}
		}
		more = true;
		while (more) {
			Item someItem = StartupWizard.ItemCreation();
			System.out.print("More Items (y/n)?:");
			s = bufferRead.readLine();
			if (s.equals("n")) {
				more = false;
				break;

			}
		}
		menu.setMenuItems(new HashSet<Item>(ITEMS));
		menu.setAddOns(new HashSet<AddOn>(ADDONS));
		return menu;

	}

	public static void StepFour() {

	}

	public static void StepFive() {

	}
}
