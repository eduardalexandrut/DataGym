package application.controller;

import entity.Diete;
import entity.Utenti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;

public class DietsController extends Controller {
    private Optional<Diete> diet =  Optional.empty();

    public Optional<Utenti> getUser() {
        return user;
    }

    public void setUser(Optional<Utenti> user) {
        this.user = user;
        initialize();
    }

    private Optional<Utenti> user = Optional.empty();
    @FXML
    private TextField dietNameField;
    @FXML
    private DatePicker dateField;
    @FXML
    private TableView<Diete> dietsTable;
    @FXML
    private TableColumn nameCol;
    @FXML
    private TableColumn dietIdCol;

    @FXML
    void initialize() {
        if (getUser().isPresent()) {
            dietsTable.getSelectionModel()
                    .selectedItemProperty()
                    .addListener(e -> setDiet(Optional.ofNullable(dietsTable.getSelectionModel().getSelectedItem())));
        }
        initDietsTable();
    }

    @FXML
    private void addDiet() {
        if (getDiet().isPresent()) {
            final Diete diet = new Diete();
            diet.setUtente(getUser().get().getUsername());
            diet.setNomeDieta(dietNameField.getText());
            getQueryManager().addDiet(diet);
            initDietsTable();
        }
    }

    @FXML
    private void addDate() {

    }

    private void initDietsTable() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("nomeDieta"));
        dietIdCol.setCellValueFactory(new PropertyValueFactory<>("codiceDieta"));
        if (user.isPresent()) {
            ObservableList<Diete> diets = FXCollections.observableArrayList(getQueryManager().getDiete(getUser().get().getUsername()));
            dietsTable.setItems(diets);
        }
    }

    public Optional<Diete> getDiet() {
        return diet;
    }

    public void setDiet(final Optional<Diete> diet) {
        this.diet = diet;
    }
}
