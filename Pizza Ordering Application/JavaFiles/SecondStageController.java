package application;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * This class defines Clear, Back, and show order details operations for the
 * second stage GUI. It allows users to check or modify their selected pizza.
 * 
 * @author Haolun Cheng
 */
public class SecondStageController {
	PizzaList copyPizzaList = new PizzaList();
	private FirstStageController firstControl;

	@FXML
	private Button clear;

	@FXML
	private Button back;

	@FXML
	private TextArea orderDetail;

	/**
	 * This method displays a list of selected pizza and the total order price of
	 * all selection.
	 * 
	 * @param text a list of pizza been selected and the total order price
	 */
	public void getText(String text) {
		orderDetail.appendText(text);
	}

	/**
	 * This method clears the list of selected pizza when the button Clear is
	 * clicked.
	 * 
	 * @param evt happens when the Clear button is clicked
	 */
	@FXML
	public void clearOrder(Event evt) {
		if (copyPizzaList.isEmpty()) {
			orderDetail.appendText("Order is empty. Please go back and select your pizza! \n");
		} else {
			try {
				orderDetail.clear();
				copyPizzaList.clearPizzaList();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("FirstStage.fxml"));
				loader.load();
				firstControl = loader.getController();
				firstControl.getClearPizzaList(copyPizzaList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method closes the current second stage window and goes back to the first
	 * stage window when the button Back is clicked.
	 * 
	 * @param evt happens when the Back button is clicked
	 */
	@FXML
	public void backToMenu(Event evt) {
		Stage secStage = (Stage) back.getScene().getWindow();
		secStage.close();
	}

	/**
	 * This method copy the pizza list from the first stage controller class and
	 * overwrite the current pizza list.
	 * 
	 * @param p pizza list from the first stage controller class
	 */
	public void getPizzaList(PizzaList p) {
		copyPizzaList = p;
	}
}
