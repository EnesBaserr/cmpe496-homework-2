package com.cheapshop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Controller controller = new Controller(primaryStage);
        controller.showScreen1();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
