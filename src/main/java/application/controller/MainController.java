package application.controller;

import entity.Utenti;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;

public class MainController extends Controller {
    @FXML
    private TabPane tabPane;
    private Utenti user;

    public void initialize() {
        tabPane.getSelectionModel().selectedItemProperty().addListener((observableValue, tab, t1) -> {
            switch (t1.getText()) {
                case "Home":
                    System.out.println("home");
                    break;
                case "Profile":
                    System.out.println("profiel");
                    break;
                case "Schede":
                    System.out.println("schede");
                    break;
                case "Diete":
                    System.out.println("diete");
                    break;
                case "Ricette":
                    System.out.println("Ricette");
                    break;
            }
        });
    }
    public Utenti getUser() {
        return this.user;
    }
    public void setUser(final Utenti user) {
        this.user = user;
    }
}
