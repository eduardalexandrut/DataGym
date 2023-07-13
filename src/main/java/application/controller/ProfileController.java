package application.controller;

import entity.PesiUtenti;
import entity.Utenti;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ProfileController extends MainController {
    static final List<String> MEASURE_UNITS = List.of("Kg", "Lbs");
    private Optional<Utenti> user = Optional.empty();
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
    private DatePicker dateField;
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
    private Label username;

    @FXML
    public void initialize() {
        this.measuresBox.getItems().setAll(MEASURE_UNITS);
        this.measuresBox.setValue(MEASURE_UNITS.stream().filter(e -> e.equals("Kg")).findAny().get());
        this.dateField.setValue(LocalDate.now());

    }

    @FXML
    public void addUserWeight() {
        final PesiUtenti userWeight = new PesiUtenti();
        userWeight.setUtente(this.user.get().getUsername());
        userWeight.setData(Date.valueOf(LocalDate.now()));
        userWeight.setUnitàMisura(this.measuresBox.getValue());
        userWeight.setValore(BigDecimal.valueOf(Double.parseDouble(this.weightField.getText())));
        getQueryManager().addUserWeight(userWeight);
    }
    @Override
    public Optional<Utenti> getUser() {
        return user;
    }

    @Override
    public void setUser(final Optional<Utenti> user) {
        this.user = user;
    }

    public void setUserInfo(final Optional<Utenti> user) {
        if (user.isPresent()) {
            usernameLabel.setText("User:" + "\n" + user.get().getUsername());
            nameLabel.setText("Nome:" + "\n" + user.get().getNome());
            surnameLabel.setText("Cognome:" + "\n" + user.get().getCognome());
            heightLabel.setText("Altezza:" + "\n" + getUser().get().getAltezza() + "m");
            genderLabel.setText("Sesso:" + "\n" + getUser().get().getSesso());
            birthLabel.setText("Data di nascita:" + "\n" + getUser().get().getDataNascita().toString());
        }
    }
}
