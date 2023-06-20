package application;

import entity.Utenti;
import jakarta.persistence.*;
import javafx.application.Application;

import java.math.BigDecimal;
import java.sql.Date;

public final class App {
    private App() { }
    public static void main(String[] args) {

        Application.launch(JavaFX.class, args);
    }
}
