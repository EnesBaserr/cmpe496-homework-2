# JavaFX Order Management System

* This project is a JavaFX-based application that manages order entry, invoice creation, and screen navigation for a catalog-based system. It includes multiple screens and handles user interactions such as form filling, order cancellation, and invoice generation.
* For preview of the application, please refer to the [**Images folder**](images) file.
* For API documentation, please refer to the [**API_DOC.MD**](API_DOC.MD) file.
## Prerequisites

- Java 11 or later
- Apache Maven
- JavaFX SDK (if not included in your JDK)

Ensure that you have the appropriate JavaFX SDK for your platform and have it set up in your environment.
 ### Using Maven
To run the application with Maven, use the following command:

```bash
mvn javafx:run
```


## Project Structure
The project consists of the following key files:

- Main.java: The entry point of the JavaFX application. It launches the primary stage and shows the first screen.
- Controller.java: Manages the flow between different screens (e.g., Screen1 and Screen2).
- BaseScreen.java: The base class for the screens that provides common functionalities like form resetting and inactivity timers.
- Screen.java: This is an interface that defines the contract for screen classes. All screen classes (e.g., Screen1, Screen2) must implement this interface. It includes methods like display() for showing the screen, createInvoiceScreen() for triggering invoice generation, and areFieldsEmptyScreen() to check if form fields are filled.
- Screen1.java & Screen2.java: Two different screens for the user to interact with, allowing the user to enter order details and generate invoices.
- Utils.java: Utility functions for creating form elements like text fields, labels, and numeric input validation.
