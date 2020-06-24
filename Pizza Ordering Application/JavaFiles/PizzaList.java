package application;

/**
 * This class defines and implements the operations of a pizza list.
 * 
 * @author Haolun Cheng
 */
public class PizzaList {
	private final int GROW_SIZE = 4;
	private Pizza[] pizzaobjs;
	private int pizzaNum;

	/**
	 * Default constructor; initialize the number of pizza counter to 0 and the size
	 * of the list to 4.
	 */
	public PizzaList() {
		pizzaNum = 0;
		pizzaobjs = new Pizza[GROW_SIZE];
	}

	/**
	 * This method grows the length of pizza list if pizzaNum reaches the maximum
	 * capacity of the pizza list.
	 */
	public void grow() {
		if (pizzaNum >= pizzaobjs.length) {
			Pizza[] pizzaGrow = new Pizza[pizzaNum + GROW_SIZE];
			System.arraycopy(pizzaobjs, 0, pizzaGrow, 0, pizzaNum);
			pizzaobjs = pizzaGrow;
			pizzaGrow = null;
		}
	}

	/**
	 * This method adds a pizza p to the pizza list.
	 * 
	 * @param p a pizza that needs to be added
	 */
	public void add(Pizza p) {
		if (pizzaobjs.length == pizzaNum) {
			grow();
		}
		pizzaobjs[pizzaNum] = p;
		pizzaNum++;

	}

	/**
	 * This method checks if the pizza list is empty.
	 * 
	 * @return true if the pizza list is empty, false otherwise
	 */
	public boolean isEmpty() {
		if (pizzaNum == 0) {
			return true;
		}
		return false;
	}

	/**
	 * This method returns the information of each pizza in the pizza list.
	 * 
	 * @return a string format of the information of each pizza in the pizza list
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < pizzaNum; ++i) {
			str = str + pizzaobjs[i].toString();
		}
		return str;
	}

	/**
	 * This method calculates the total running price for all added pizza.
	 * 
	 * @return the total running price for all added pizza
	 */
	public int getTotalPrice() {
		int TotalPrice = 0;
		for (int i = 0; i < pizzaNum; ++i) {
			TotalPrice += pizzaobjs[i].pizzaPrice();
		}
		return TotalPrice;
	}

	/**
	 * This method clears the entire pizza list and resets the pizza number counter
	 * to 0.
	 */
	public void clearPizzaList() {
		for (int i = 0; i < pizzaNum; ++i) {
			pizzaobjs[i] = null;
		}
		pizzaNum = 0;
	}
}
