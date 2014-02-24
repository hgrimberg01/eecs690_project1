public class Item {
	private String name;
	private double price;
	private String specialDay;
	private Hashmap<String, AddOn> addOns;

	/*
	
	*/
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
		specialDay = "";
		addOns = new Hashmap<AddOn>;
	}

	/*

	*/
	public Item(String name, double price, String specialDay) {
		this.name = name;
		this.price = price;
		this.specialDay = specialDay;
	}

	/*

	*/
	public void editPrice(double newPrice) {
		price = newPrice;
	}

	/*

	*/
	public void editSpecialDay(String newSpecialDay) {
		specialDay = newSpecialDay;
	}

	/*

	*/
	public void addAddOn(String addOnName, double addOnPrice) {
		AddOn addOn = new AddOn(addOnName, addOnPrice);
		addOns.put(addOnName, addOn);
	}

	/*

	*/
	public double getPrice() {
		return price;
	}

	/*

	*/
	public String getSpecialDay() {
		return specialDay;
	}

	/*

	*/
	public Hashmap<String, AddOn> getAllAddOns() {
		return addOns;
	}

	/*

	*/
	public void delteAddOn(String addOnName) {
		addOns.remove(addOnName);
	}
}