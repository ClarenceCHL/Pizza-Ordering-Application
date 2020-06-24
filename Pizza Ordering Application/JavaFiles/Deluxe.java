package application;

import java.util.ArrayList;

/**
 * This class creates an instance of a Deluxe pizza and calculate the price for
 * this pizza.
 * 
 * @author Haolun Cheng
 */
public class Deluxe extends Pizza {
	private final int smallPrice = 14;
	private final int mediumPrice = smallPrice + 2;
	private final int largePrice = smallPrice + 4;

	/**
	 * Constructor; initialize the style, size, and toppings of a Deluxe pizza
	 * object by calling the super class constructor.
	 * 
	 * @param style    a pizza style
	 * @param size     a pizza size
	 * @param toppings a list of toppings a pizza has
	 */
	public Deluxe(String style, String size, ArrayList<String> toppings) {
		super("Deluxe", size, toppings);
	}

	/**
	 * This method calculates the price for a Deluxe pizza based on its size
	 * selection.
	 * 
	 * @return the price for a Deluxe pizza
	 */
	@Override
	public int pizzaPrice() {
		if (size == "small") {
			return smallPrice;
		} else if (size == "medium") {
			return mediumPrice;
		} else {
			return largePrice;
		}
	}

	/**
	 * This method creates a string formatted by style, size, toppings, and price.
	 * 
	 * @return a formatted string representing the details of a Deluxe pizza object
	 */
	@Override
	public String toString() {
		String str = super.toString();
		str = str + "Price: $" + pizzaPrice() + "\n";
		return str;
	}
}
