package application.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

import java.util.List;

public class ProfileController extends MainController {
    static final List<String> MEASURE_UNITS = List.of("Kg", "Lbs");
    //Profile fx elements.
   /* @FXML
    private LineChart<String, String> LineChart;*/
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    private ChoiceBox<String> measuresBox;
    @FXML
    private TextField weightField;
    @FXML
    private DatePicker dataField;

    @FXML
    void initialize() {
        this.measuresBox.getItems().setAll(MEASURE_UNITS);
        this.measuresBox.setValue(MEASURE_UNITS.stream().filter(e -> e.equals("Kg")).findAny().get());
    }
}
