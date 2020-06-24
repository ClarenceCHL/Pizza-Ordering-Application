package application;

import java.util.*;

/**
 * This class, which contains two constructors, creates a pizza object.
 * 
 * @author Haolun Cheng
 */
public abstract class Pizza {
	protected String style;
	protected String size;
	protected ArrayList<String> toppings;

	/**
	 * Constructor 1; initialize the style, size, and toppings of a pizza object.
	 * 
	 * @param style    a pizza style
	 * @param size     a pizza size
	 * @param toppings a list of toppings a pizza has
	 */
	public Pizza(String style, String size, ArrayList<String> toppings) {
		this.style = style;
		this.size = size;
		this.toppings = toppings;
	}

	/**
	 * Constructor 2; initialize the style and size of a pizza object.
	 * 
	 * @param style a pizza style
	 * @param size  a pizza size
	 */
	public Pizza(String style, String size) {
		this.style = style;
		this.size = size;
	}

	/**
	 * This abstract method calculates the price for a pizza.
	 * 
	 * @return the total price for a pizza
	 */
	public abstract int pizzaPrice();

	/**
	 * This method returns a formatted string representing the details of a selected
	 * pizza.
	 * 
	 * @return a formatted string representing the details of a pizza object
	 */
	public String toString() {
		return "\n" + this.style + ": " + this.size + "\n" + "Toppings:\n" + toppings + "\n";
	}
}
