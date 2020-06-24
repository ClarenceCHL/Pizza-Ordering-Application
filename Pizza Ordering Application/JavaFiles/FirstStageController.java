package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.net.URL;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;

/**
 * This class defines the basic properties and operations of the first stage GUI
 * 
 * @author Haolun Cheng
 */
public class FirstStageController implements Initializable {
	PizzaList pizzaList = new PizzaList();

	@FXML
	private Button addToppings;

	@FXML
	private Button removeToppings;

	@FXML
	private Button clearSelection;

	@FXML
	private Button addOrder;

	@FXML
	private Button showOrder;

	@FXML
	private TextArea outputText;

	@FXML
	private ListView<String> toppings;

	@FXML
	private ListView<String> toppingsSelected;

	@FXML
	private ComboBox<String> pizzaType;

	@FXML
	private ComboBox<String> pizzaSize;

	@FXML
	private ImageView pizzaPics;

	ObservableList<String> toppingNamesAll = FXCollections.observableArrayList("Beef", "Cheese", "Chicken",
			"Green Pepper", "Ham", "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
	ObservableList<String> DeluxeToppings = FXCollections.observableArrayList("Sausage", "Pepperoni", "Green Pepper",
			"Onion", "Mushroom");
	ObservableList<String> HawaiianToppings = FXCollections.observableArrayList("Ham", "Pineapple");

	Image DeluxePizza = new Image("DeluxePizza.png");
	Image HawaiianPizza = new Image("HawaiianPizza.png");
	Image BuildYourOwn = new Image("BuildYourOwn.png");

	/**
	 * This method initializes the default value settings for the GUI, and it is
	 * automatically called when the application is launched.
	 * 
	 * @param location  location of the stage
	 * @param resources resources
	 */
	public void initialize(URL location, ResourceBundle resources) {
		pizzaType.getItems().addAll("Deluxe", "Hawaiian", "Build your own");
		pizzaType.setValue("Build your own");
		pizzaSize.getItems().addAll("small", "medium", "large");
		pizzaSize.setValue("medium");
		toppings.getItems().addAll(toppingNamesAll);
		toppings.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		pizzaPics.setImage(BuildYourOwn);
	}

	/**
	 * This method defines the operations in the GUI when the Deluxe pizza is
	 * selected in the ComboBox.
	 */
	private void DeluxeType() {
		pizzaPics.setImage(DeluxePizza);
		addToppings.setDisable(true);
		removeToppings.setDisable(true);
		toppings.getItems().clear();
		toppings.setDisable(true);
		toppingsSelected.getItems().clear();
		toppingsSelected.getItems().addAll(DeluxeToppings);
	}

	/**
	 * This method defines the operations in the GUI when the Hawaiian pizza is
	 * selected in the ComboBox.
	 */
	private void HawaiianType() {
		pizzaPics.setImage(HawaiianPizza);
		addToppings.setDisable(true);
		removeToppings.setDisable(true);
		toppings.getItems().clear();
		toppings.setDisable(true);
		toppingsSelected.getItems().clear();
		toppingsSelected.getItems().addAll(HawaiianToppings);
	}

	/**
	 * This method defines the operations in the GUI when the BuildYourOwn pizza is
	 * selected in the ComboBox.
	 */
	private void BuildYourOwnType() {
		pizzaPics.setImage(BuildYourOwn);
		addToppings.setDisable(false);
		removeToppings.setDisable(false);
		toppings.setDisable(false);
		toppingsSelected.getItems().clear();
		toppings.getItems().addAll(toppingNamesAll);
	}

	/**
	 * This method calls the corresponding defined method for each pizza type.
	 * 
	 * @param evt happens when select one of the three pizza types in the ComboBox
	 */
	@FXML
	public void pizzaChoice(Event evt) {
		switch (pizzaType.getValue()) {
		case "Deluxe":
			DeluxeType();
			break;
		case "Hawaiian":
			HawaiianType();
			break;
		case "Build your own":
			BuildYourOwnType();
			break;
		}
	}

	/**
	 * This method defines the add toppings operation when users want to build their
	 * own pizza.
	 * 
	 * @param evt happens when the Add Toppings button is clicked
	 */
	@FXML
	public void toppingsAdd(Event evt) {
		String aTopping;
		try {
			aTopping = toppings.getSelectionModel().getSelectedItem();
			if (!aTopping.isEmpty()) {
				if (toppingsSelected.getItems().size() == 6) {
					outputText.appendText("You can only choose up to 6 toppings! \n");
				} else {
					toppings.getItems().removeAll(aTopping);
					toppingsSelected.getItems().addAll(aTopping);
				}
			}
		} catch (NullPointerException exception) {
			aTopping = null;
		}
		if (aTopping == null) {
			outputText.appendText("Please select a topping to be added! \n");
		}
	}

	/**
	 * This method defines the remove toppings operation when users want to build
	 * their own pizza.
	 * 
	 * @param evt happens when the Remove Toppings button is clicked
	 */
	@FXML
	public void toppingsRemove(Event evt) {
		String aBadChoice;
		if (toppingsSelected.getItems().size() > 0) {
			try {
				aBadChoice = toppingsSelected.getSelectionModel().getSelectedItem();
				if (!aBadChoice.isEmpty()) {
					toppingsSelected.getItems().remove(aBadChoice);
					toppings.getItems().add(aBadChoice);
				}
			} catch (NullPointerException exception) {
				aBadChoice = null;
			}
			if (aBadChoice == null) {
				outputText.appendText("Please select a topping to be removed! \n");
			}
		} else {
			outputText.appendText("There is no topping to be removed! \n");
		}
	}

	/**
	 * This method clears the current selection of pizza type and restores
	 * everything to default values.
	 * 
	 * @param evt happens when the Clear Selection button is clicked
	 */
	@FXML
	public void clearSelection(Event evt) {
		pizzaType.setValue("Build your own");
		pizzaSize.setValue("medium");
		toppings.getItems().clear();
		toppingsSelected.getItems().clear();
		toppings.getItems().addAll(toppingNamesAll);
		outputText.clear();
	}

	/**
	 * This method returns the string value of the selected pizza size.
	 * 
	 * @return string value of the selected pizza size
	 */
	private String sizeChoice() {
		if (pizzaSize.getValue().equals("small")) {
			return "small";
		} else if (pizzaSize.getValue().equals("medium")) {
			return "medium";
		} else {
			return "large";
		}
	}

	/**
	 * This method adds the selected pizza to the final order list.
	 * 
	 * @param evt happens when the Add to Order button is clicked
	 */
	@FXML
	public void orderAdd(Event evt) {
		ArrayList<String> BuildToppings = new ArrayList<String>();
		BuildToppings.addAll(toppingsSelected.getItems());
		ArrayList<String> DeluxeToppingsCollection = new ArrayList<String>();
		DeluxeToppingsCollection.addAll(DeluxeToppings);
		ArrayList<String> HawaiianToppingsCollection = new ArrayList<String>();
		HawaiianToppingsCollection.addAll(HawaiianToppings);

		if (pizzaType.getValue().equals("Deluxe")) {
			pizzaList.add(new Deluxe("Deluxe", sizeChoice(), DeluxeToppingsCollection));
			outputText.appendText("A new " + sizeChoice() + " Deluxe Pizza order has been added! \n");
		} else if (pizzaType.getValue().equals("Hawaiian")) {
			pizzaList.add(new Hawaiian("Hawaiian", sizeChoice(), HawaiianToppingsCollection));
			outputText.appendText("A new " + sizeChoice() + " Hawaiian Pizza order has been added! \n");
		} else {
			if (BuildToppings.size() < 1) {
				outputText.appendText("You need to choose at least one topping for your pizza! \n");
			} else {
				pizzaList.add(new BuildYourOwn("BuildYourOwn", sizeChoice(), BuildToppings));
				outputText.appendText("A new " + sizeChoice() + " Customized Pizza order has been added! \n");
			}
		}
	}

	/**
	 * This method shows the added pizza order in the second stage GUI by calling
	 * the second stage window.
	 * 
	 * @param evt happens when the Show Order button is clicked
	 */
	@FXML
	public void orderShow(Event evt) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondStage.fxml"));
			Parent secondWindow = loader.load();
			Scene scene2 = new Scene(secondWindow);
			Stage secondStage = new Stage();
			secondStage.setTitle("Order Summary");
			secondStage.setScene(scene2);
			secondStage.show();
			SecondStageController secController = loader.getController();
			if (pizzaList.isEmpty()) {
				secController.getText("Order is empty... \n");
			} else {
				secController.getText(pizzaList.toString() + "\n");
				secController.getText("Total Amount Due: $" + pizzaList.getTotalPrice());
				secController.getPizzaList(pizzaList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method copy the pizza list from the second stage controller class and
	 * overwrite the current pizza list.
	 * 
	 * @param p pizza list from the second stage controller class
	 */
	public void getClearPizzaList(PizzaList p) {
		pizzaList = p;
	}
}
