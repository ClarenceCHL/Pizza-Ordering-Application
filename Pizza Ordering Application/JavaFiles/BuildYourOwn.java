package application;

import java.util.ArrayList;

/**
 * This class creates an instance of a BuildYourOwn pizza and calculate the
 * price for this pizza.
 * 
 * @author Haolun Cheng
 */
public class BuildYourOwn extends Pizza {
	private final int eachTopping = 2;
	private final int smallPrice = 5;
	private final int mediumPrice = smallPrice + 2;
	private final int largePrice = smallPrice + 4;
	private ArrayList<String> toppings;

	/**
	 * Constructor; initialize the style, size, and toppings of a BuildYourOwn pizza
	 * object by calling the super class constructor.
	 * 
	 * @param style    a pizza style
	 * @param size     a pizza size
	 * @param toppings a list of toppings a pizza has
	 */
	public BuildYourOwn(String style, String size, ArrayList<String> toppings) {
		super("BuildYourOwn", size, toppings);
		this.toppings = toppings;
	}

	/**
	 * This method calculates the price for a BuildYourOwn pizza based on its size
	 * selection and its toppings amount.
	 * 
	 * @return the price for a BuildYourOwn pizza
	 */
	@Override
	public int pizzaPrice() {
		if (this.size == "small") {
			return smallPrice + (this.toppings.size() * eachTopping);
		} else if (this.size == "medium") {
			return mediumPrice + (this.toppings.size() * eachTopping);
		} else {
			return largePrice + (this.toppings.size() * eachTopping);
		}
	}

	/**
	 * This method creates a string formatted by style, size, toppings, and price.
	 * 
	 * @return a formatted string representing the details of a BuildYourOwn pizza
	 *         object
	 */
	@Override
	public String toString() {
		String str = super.toString();
		str = str + "Price: $" + pizzaPrice() + "\n";
		return str;
	}
}
