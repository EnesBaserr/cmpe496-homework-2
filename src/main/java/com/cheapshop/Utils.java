package com.cheapshop;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.TextFormatter;

public class Utils {

    // Create a header label with a larger font style for section titles
    public static Label createHeaderLabel(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 14));  // Set font style to bold and size 14
        label.setTextAlignment(TextAlignment.CENTER);  // Center the text
        label.setStyle("-fx-text-fill: navy;");  // Set the color of the text (optional, can customize)

        return label;
    }

    // Create an input field with a label and a text field in the same row
    public static TextField createInputField(GridPane grid, String labelText, int rowIndex, int colIndex) {
        Label label = new Label(labelText);
        TextField textField = new TextField();
        HBox hbox = new HBox(10, label, textField);  // Group label and text field with spacing
        grid.add(hbox, colIndex, rowIndex);
        return textField;
    }

    // Create a numeric-only input field with a label in the same row
    public static TextField createNumericField(GridPane grid, String labelText, int rowIndex, int colIndex) {
        Label label = new Label(labelText);
        TextField textField = new TextField();

        // Restrict input to numbers only
        textField.setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getText();
            if (newText.matches("[0-9]*")) {
                return change;
            }
            return null; // Reject non-numeric input
        }));

        HBox hbox = new HBox(10, label, textField);  // Group label and text field with spacing
        grid.add(hbox, colIndex, rowIndex);
        return textField;
    }
}