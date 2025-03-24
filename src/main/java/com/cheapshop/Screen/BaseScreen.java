package com.cheapshop.Screen;

import com.cheapshop.Controller;
import javafx.animation.PauseTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public abstract class BaseScreen {
    private Controller controller;
    protected TextField nameField, phoneField, postalCodeField, provinceField, cityField, addressField, creditCardField, dateField;
    protected  TextField itemNumberField, quantityField, costField, totalField, balanceOwingField;
    private PauseTransition inactivityTimer;

    public BaseScreen(Controller controller) {
        this.controller = controller;
    }

    public void resetFields() {
        nameField.clear();
        phoneField.clear();
        postalCodeField.clear();
        provinceField.clear();
        cityField.clear();
        addressField.clear();
        creditCardField.clear();
        dateField.clear();
        itemNumberField.clear();
        quantityField.clear();
        costField.clear();
        totalField.clear();
        balanceOwingField.clear();
    }
    public void cancelOrder() {
        resetFields();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Cancelled");
        alert.setHeaderText("Your order has been cancelled.");
        alert.showAndWait();
        controller.showScreen1();
    }


     void setupInactivityTimer() {
        inactivityTimer = new PauseTransition(Duration.seconds(30));
        inactivityTimer.setOnFinished(e -> {
            resetFields();
            controller.showScreen1();
        });
        controller.getPrimaryStage().addEventFilter(MouseEvent.ANY, e -> resetInactivityTimer());
    }
    public void resetInactivityTimer() {
        inactivityTimer.playFromStart();
    }
}
