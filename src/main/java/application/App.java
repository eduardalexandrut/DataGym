package application;

import application.view.JavaFX;
import javafx.application.Application;

public final class App {
    private App() { }
    public static void main(String[] args) {

        Application.launch(JavaFX.class, args);
    }
}
