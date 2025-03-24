package com.cheapshop.Screen;

import com.cheapshop.Controller;
import com.cheapshop.Utils;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Screen1  extends BaseScreen implements Screen {

    private Controller controller;
    private Stage primaryStage;

    public Screen1(Controller controller, Stage primaryStage) {
        super(controller);
        this.controller = controller;
        this.primaryStage = primaryStage;
        setupInactivityTimer();
    }

    @Override
    public void display() {
        GridPane grid = createFormLayout();

        Button nextButton = new Button("Next Catalog Item (PF5)");
        nextButton.setOnAction(e -> controller.showScreen2());
        grid.add(nextButton, 0, 14, 2, 1);

        Button triggerInvoiceButton = new Button("Trigger Invoice (PF8)");
        triggerInvoiceButton.setOnAction(e -> createInvoiceScreen());
        grid.add(triggerInvoiceButton, 0, 15, 2, 1);

        Button cancelButton = new Button("Cancel Order");
        cancelButton.setOnAction(e -> cancelOrder());
        grid.add(cancelButton, 0, 16, 2, 1);

        Scene scene = new Scene(grid, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();

        resetInactivityTimer();
    }

    @Override
    public void createInvoiceScreen() {
        if (areFieldsEmptyScreen()) {
            showAlert("Incomplete Form", "Please fill in all fields before triggering the invoice.");
        } else {
            String invoiceData = "Invoice Generated:\n" +
                    "Name: " + nameField.getText() + "\n" +
                    "Phone: " + phoneField.getText() + "\n" +
                    "Postal Code: " + postalCodeField.getText() + "\n" +
                    "Province: " + provinceField.getText() + "\n" +
                    "City: " + cityField.getText() + "\n" +
                    "Delivery Address: " + addressField.getText() + "\n" +
                    "Today's Date: " + dateField.getText() + "\n" +
                    "Credit Card No: " + creditCardField.getText() + "\n" +
                    "Item Number: " + itemNumberField.getText() + "\n" +
                    "Quantity: " + quantityField.getText() + "\n" +
                    "Cost/Item: " + costField.getText() + "\n" +
                    "Total: " + totalField.getText() + "\n" +
                    "Balance Owing: " + balanceOwingField.getText();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invoice Details");
            alert.setHeaderText("Your Invoice");
            alert.setContentText(invoiceData);
            alert.showAndWait();
        }


    }

    private GridPane createFormLayout() {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(Utils.createHeaderLabel("Purchaser Information"), 0, 0, 2, 1);

        nameField = Utils.createInputField(grid, "Name:", 1, 0);
        phoneField = Utils.createNumericField(grid, "Phone:", 1, 1);
        postalCodeField = Utils.createInputField(grid, "Postal Code:", 2, 0);
        provinceField = Utils.createInputField(grid, "Province:", 2, 1);
        cityField = Utils.createInputField(grid, "City:", 3, 0);
        addressField = Utils.createInputField(grid, "Delivery Address:", 3, 1);
        dateField = Utils.createInputField(grid, "Today's Date:", 4, 0);
        creditCardField = Utils.createInputField(grid, "Credit Card No:", 4, 1);

        itemNumberField = Utils.createNumericField(grid, "Item Number:", 5, 0);
        quantityField = Utils.createNumericField(grid, "Quantity:", 5, 1);
        costField = Utils.createNumericField(grid, "Cost/Item:", 6, 0);
        totalField = Utils.createNumericField(grid, "Total:", 6, 1);
        balanceOwingField = Utils.createNumericField(grid, "Balance Owing:", 7, 0);

        return grid;
    }


    @Override
    public boolean areFieldsEmptyScreen() {
        return nameField.getText().isEmpty() || phoneField.getText().isEmpty() ||
                postalCodeField.getText().isEmpty() || provinceField.getText().isEmpty() ||
                cityField.getText().isEmpty() || addressField.getText().isEmpty() ||
                dateField.getText().isEmpty() || creditCardField.getText().isEmpty() ||
                itemNumberField.getText().isEmpty() || quantityField.getText().isEmpty();
    }

}