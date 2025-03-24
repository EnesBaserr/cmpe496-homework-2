
# JavaFX Order Management System - API Documentation

## Overview

This application allows users to enter order details, generate invoices, and navigate between different screens. It uses JavaFX for UI components and supports basic order management functionality.
For preview of the application, please refer to the [Images folder](images) file.
## Main Classes and Interfaces

### `Main.java`

-   **Description**: The entry point of the JavaFX application.
-   **Methods**:
    -   `start(Stage primaryStage)`: Initializes the main screen and starts the application by showing `Screen1`.
    -   `main(String[] args)`: Launches the JavaFX application.

### `Controller.java`

-   **Description**: Manages navigation between different screens.
-   **Constructor**:
    -   `Controller(Stage primaryStage)`: Initializes the controller with the main stage.
-   **Methods**:
    -   `getPrimaryStage()`: Returns the main stage.
    -   `showScreen1()`: Displays the first screen (`Screen1`).
    -   `showScreen2()`: Displays the second screen (`Screen2`).

### `BaseScreen.java`

-   **Description**: The base class for all screens. It provides common functionality for handling form resets and inactivity timers.
-   **Constructor**:
    -   `BaseScreen(Controller controller)`: Initializes the base screen with the controller.
-   **Methods**:
    -   `resetFields()`: Clears all input fields.
    -   `cancelOrder()`: Resets fields and shows a cancel order alert, then navigates to `Screen1`.
    -   `setupInactivityTimer()`: Sets a 30-second inactivity timer that resets the form and navigates to `Screen1`.
    -   `resetInactivityTimer()`: Resets the inactivity timer on user action.

### `Screen.java` (Interface)

-   **Description**: Defines the contract for screen classes.
-   **Methods**:
    -   `display()`: Displays the screen content.
    -   `createInvoiceScreen()`: Creates and shows the invoice based on entered data.
    -   `areFieldsEmptyScreen()`: Checks if required fields are empty. System shows an alert if fields are empty.
    -   `showAlert(String title, String message)`: Shows an error alert (default method in the interface).

### `Screen1.java`

-   **Description**: Implements `Screen` interface. Represents the first screen where the user enters order details.
-   **Constructor**:
    -   `Screen1(Controller controller, Stage primaryStage)`: Initializes the screen with the controller and primary stage.
-   **Methods**:
    -   `display()`: Sets up and displays the form for entering order details.
    -   `createInvoiceScreen()`: Validates fields and generates the invoice.
    -   `areFieldsEmptyScreen()`: Checks if any fields are empty. System shows an alert if fields are empty.

### `Screen2.java`

-   **Description**: Implements `Screen` interface. Represents the second screen for catalog item details.
-   **Constructor**:
    -   `Screen2(Controller controller, Stage primaryStage)`: Initializes the screen with the controller and primary stage.
-   **Methods**:
    -   `display()`: Sets up and displays the catalog form.
    -   `createInvoiceScreen()`: Validates fields and generates the invoice.
    -   `areFieldsEmptyScreen()`: Checks if any fields are empty.

### `Utils.java`

-   **Description**: Provides utility methods for creating form elements.
-   **Methods**:
    -   `createHeaderLabel(String text)`: Creates a header label with a larger font for section titles.
    -   `createInputField(GridPane grid, String labelText, int rowIndex, int colIndex)`: Creates a labeled input field.
    -   `createNumericField(GridPane grid, String labelText, int rowIndex, int colIndex)`: Creates a numeric-only input field.