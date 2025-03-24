package com.cheapshop.Screen;

import javafx.scene.control.Alert;

public interface Screen {
    void display();
    void createInvoiceScreen();
    boolean areFieldsEmptyScreen();
    default void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}