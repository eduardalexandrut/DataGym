package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class SchedeController extends Controller {
    @FXML
    private TextField schedaName;
    @FXML
    public void addScheda() {
        super.getQueryManager().addScheda(schedaName.getText(), "EduardT", LocalDate.now());
    }
}
