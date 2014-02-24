public class AddOn {
	private String name;
	private double price;

	/*
	
	*/
	public Addons(String name, double price) {
		this.name = name;
		this.price = price;
	}

	/*
	
	*/
	public editPrice(double newPrice) {
		price = newPrice;
	}

	/*
	
	*/
	public double getPrice() {
		return price;
	}

}