package com.cheapshop.Screen;

import com.cheapshop.Controller;
import com.cheapshop.Utils;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Screen2 extends BaseScreen implements Screen {

    private Controller controller;
    private Stage primaryStage;

    public Screen2(Controller controller, Stage primaryStage) {
        super(controller);
        this.primaryStage = primaryStage;
        setupInactivityTimer();
    }

    @Override
    public void display() {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(Utils.createHeaderLabel("Catalog Item Information"), 0, 0, 2, 1);

        nameField = Utils.createInputField(grid, "Name:", 1, 0);
        phoneField = Utils.createNumericField(grid, "Phone:", 1, 1);
        itemNumberField = Utils.createNumericField(grid, "Item Number:", 2, 0);
        quantityField = Utils.createNumericField(grid, "Quantity:", 2, 1);
        costField = Utils.createNumericField(grid, "Cost/Item:", 3, 0);
        totalField = Utils.createNumericField(grid, "Total:", 3, 1);
        balanceOwingField = Utils.createNumericField(grid, "Balance Owing:", 4, 0);

        Button triggerInvoiceButton = new Button("Trigger Invoice (PF8)");
        triggerInvoiceButton.setOnAction(e -> createInvoiceScreen());
        grid.add(triggerInvoiceButton, 0, 5, 2, 1);

        Button backButton = new Button("Back to Screen 1");
        backButton.setOnAction(e -> {
            resetFields();
            controller.showScreen1();
        });
        grid.add(backButton, 0, 6, 2, 1);

        Scene scene2 = new Scene(grid, 600, 500);
        primaryStage.setScene(scene2);

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
                    "Catalog Item: " + itemNumberField.getText() + "\n" +
                    "Quantity: " + quantityField.getText() + "\n" +
                    "Total: " + totalField.getText() + "\n" +
                    "Quantity: " + quantityField.getText() + "\n" +
                    "Cost/Item: " + costField.getText() + "\n" +
                    "Total: " + totalField.getText() + "\n" +
                    "Balance Owing: " + balanceOwingField.getText();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invoice Details");
            alert.setHeaderText("Your Invoice");
            alert.setContentText(invoiceData);
            alert.showAndWait();

            resetFields();
            controller.showScreen1();
        }
    }

    @Override
    public boolean areFieldsEmptyScreen() {
        return nameField.getText().isEmpty() || phoneField.getText().isEmpty() ||
                itemNumberField.getText().isEmpty() || quantityField.getText().isEmpty();
    }
}