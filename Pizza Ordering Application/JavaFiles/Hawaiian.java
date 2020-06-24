package application;

import java.util.ArrayList;

/**
 * This class creates an instance of a Hawaiian pizza and calculate the price
 * for this pizza.
 * 
 * @author Haolun Cheng
 */
public class Hawaiian extends Pizza {
	private final int smallPrice = 8;
	private final int mediumPrice = smallPrice + 2;
	private final int largePrice = smallPrice + 4;

	/**
	 * Constructor; initialize the style, size, and toppings of a Hawaiian pizza
	 * object by calling the super class constructor.
	 * 
	 * @param style    a pizza style
	 * @param size     a pizza size
	 * @param toppings a list of toppings a pizza has
	 */
	public Hawaiian(String style, String size, ArrayList<String> toppings) {
		super("Hawaiian", size, toppings);
	}

	/**
	 * This method calculates the price for a Hawaiian pizza based on its size
	 * selection.
	 * 
	 * @return the price for a Hawaiian pizza
	 */
	@Override
	public int pizzaPrice() {
		if (this.size == "small") {
			return smallPrice;
		} else if (this.size == "medium") {
			return mediumPrice;
		} else {
			return largePrice;
		}
	}

	/**
	 * This method creates a string formatted by style, size, toppings, and price.
	 * 
	 * @return a formatted string representing the details of a Hawaiian pizza
	 *         object
	 */
	@Override
	public String toString() {
		String str = super.toString();
		str = str + "Price: $" + pizzaPrice() + "\n";
		return str;
	}
}
