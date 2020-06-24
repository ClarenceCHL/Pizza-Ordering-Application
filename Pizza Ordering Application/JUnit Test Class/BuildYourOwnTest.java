package application;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class tests the pizzaPrice method of BuildYourOwn class by using
 * Black-Box testing technique in JUnit Test.
 * 
 * @author Haolun Cheng
 */
public class BuildYourOwnTest {
	private final int aToppingPrice = 2;
	private final int aSmallPrice = 5;
	private final int aMediumPrice = aSmallPrice + 2;
	private final int aLargePrice = aSmallPrice + 4;

	/**
	 * Test method for {@link application.BuildYourOwn#pizzaPrice()}.
	 */
	@Test
	public void testPizzaPrice() {
		// Test BuildYourOwn pizza price of each size with only one topping
		ArrayList<String> oneTopping = new ArrayList<String>();
		oneTopping.add("Beef");
		Pizza p1Small = new BuildYourOwn("BuildYourOwn", "small", oneTopping);
		Pizza p1Medium = new BuildYourOwn("BuildYourOwn", "medium", oneTopping);
		Pizza p1Large = new BuildYourOwn("BuildYourOwn", "large", oneTopping);
		assertTrue(p1Small.pizzaPrice() == aSmallPrice + (aToppingPrice * 1));
		assertTrue(p1Medium.pizzaPrice() == aMediumPrice + (aToppingPrice * 1));
		assertTrue(p1Large.pizzaPrice() == aLargePrice + (aToppingPrice * 1));

		// Test BuildYourOwn pizza price of each size with six toppings
		ObservableList<String> sixToppingsList = FXCollections.observableArrayList("Beef", "Cheese", "Chicken",
				"Green Pepper", "Ham", "Mushroom");
		ArrayList<String> sixToppings = new ArrayList<String>();
		sixToppings.addAll(sixToppingsList);
		Pizza p2Small = new BuildYourOwn("BuildYourOwn", "small", sixToppings);
		Pizza p2Medium = new BuildYourOwn("BuildYourOwn", "medium", sixToppings);
		Pizza p2Large = new BuildYourOwn("BuildYourOwn", "large", sixToppings);
		assertTrue(p2Small.pizzaPrice() == aSmallPrice + (aToppingPrice * 6));
		assertTrue(p2Medium.pizzaPrice() == aMediumPrice + (aToppingPrice * 6));
		assertTrue(p2Large.pizzaPrice() == aLargePrice + (aToppingPrice * 6));

		// Test the price of BuildYourOwn pizza of each size with the price of pizza
		// with different topping number
		assertFalse(p1Small.pizzaPrice() == p2Small.pizzaPrice());
		assertFalse(p1Medium.pizzaPrice() == p2Medium.pizzaPrice());
		assertFalse(p1Large.pizzaPrice() == p2Large.pizzaPrice());
	}

}
