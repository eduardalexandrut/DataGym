package application.controller;

import entity.Utenti;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

import java.util.List;

public class ProfileController extends MainController {
    static final List<String> MEASURE_UNITS = List.of("Kg", "Lbs");


    private Utenti user;
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
    private Label usernameLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label surnameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label heightLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Label birthLabel;

    @FXML
    public void initialize() {
        System.out.println(getQueryManager().getAllenamenti("EduardT"));
        this.measuresBox.getItems().setAll(MEASURE_UNITS);
        this.measuresBox.setValue(MEASURE_UNITS.stream().filter(e -> e.equals("Kg")).findAny().get());

    }
    @Override
    public Utenti getUser() {
        return user;
    }

    @Override
    public void setUser(Utenti user) {
        this.user = user;
    }

    public void setUserInfo(Utenti user) {
        usernameLabel.setText(usernameLabel.getText() + "\t" + user.getUsername());
        nameLabel.setText(nameLabel.getText() + "\t" + user.getNome());
        surnameLabel.setText("ciao");
       /* heightLabel.setText(heightLabel.getText() + "\t" + getUser().getAltezza());
        genderLabel.setText(genderLabel.getText() + "\t" + getUser().getSesso());
        emailLabel.setText(emailLabel.getText() + "\t" + getUser().getEmail());
        birthLabel.setText(birthLabel.getText() + "\t" + getUser().getDataNascita());*/
    }
}
