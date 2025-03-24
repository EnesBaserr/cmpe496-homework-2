package com.cheapshop;

import com.cheapshop.Screen.Screen1;
import com.cheapshop.Screen.Screen2;
import javafx.stage.Stage;

public class Controller {

    private Stage primaryStage;


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Controller(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showScreen1() {
        Screen1 screen1 = new Screen1(this, primaryStage);
        screen1.display();
    }

    public void showScreen2() {
        Screen2 screen2 = new Screen2(this, primaryStage);
        screen2.display();
    }



}