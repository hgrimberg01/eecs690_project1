public class Menu {
	private Hashmap<String, Item> items;
	private double salesTaxRate;

	/*

	*/
	public Menu(double salesTaxRate) {
		items = new Hashmap<String, Item>;
		this.salesTaxRate = salesTaxRate;
	}

	/*

	*/
	public void addItem(String name, double price) {
		Item item = new Item(name, price);
		Item.put(name, item);
	}

	/*

	*/
	public void addItem(String name, double price, String specialDay) {
		Item item = new Item(name, price, specialDay);
		Item.put(name, item);
	}

	/*

	*/
	public void addItemAddOn(String itemName, String addOnName, double addOnPrice) {
		Item item = items.get(name);
		item.addAddOn(addOnName, addOnPrice);
	}

	/*

	*/
	public void editItemPrice(String name, double newPrice) {
		Item item = items.get(name);
		item.editPrice(newPrice);
	}

	/*

	*/
	public void editItemSpecialDay(String name, String newSpecialDay) {
		Item item = items.get(name);
		item.editSpecialDay(newSpecialDay);
	}

	/*

	*/
	public double getPrice(Stirng name) {
		Item item = items.get(name);
		return item.getPrice();
	}

	/*

	*/
	public String getSpecialDay(String name) {
		Item item = items.get(name);
		return item.getSpecialDay();
	}

	/*

	*/
	public String getSalesTax() {
		return salesTaxRate;
	}

	/*

	*/
	public Hashmap<String, Item> getAllItems() {
		return items;
	}

	/*

	*/
	public Hashmap<String, Item> getAllItemAddOns(String itemName) {
		Item item = items.get(name);
		return items.getAllAddOns();
	}

	/*

	*/
	public void deleteItem(String name) {
		items.remove(name);
	}

	/*

	*/
	public void deleteItemAddOn(String itemName, String addOnName) {
		Item item = items.get(name);
		item.delteAddOn(addOnName);
	}
}