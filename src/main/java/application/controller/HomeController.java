package application.controller;

import entity.Utenti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class HomeController extends Controller {
    static final List<String> GENDERS = List.of("M", "F");
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField emailField;
    @FXML
    private ChoiceBox<String> genderField;
    @FXML
    private DatePicker birthField;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField heightField;
    @FXML
    private TableView<Utenti> usersTable;
    @FXML
    private TableColumn<Utenti, String> usernameColumn;
    @FXML
    private TableColumn<Utenti, String> nameColumn;
    @FXML
    private TableColumn<Utenti, String> surnameColumn;
    @FXML
    private TableColumn<Utenti, String> emailColumn;
    @FXML
    private TableColumn<Utenti, String> genderColumn;
    @FXML
    private TableColumn<Utenti, String> birthColumn;
    @FXML
    private TableColumn<Utenti, String> heightColumn;

    @FXML
    void initialize() {
        initUsersTable();
        genderField.getItems().setAll(GENDERS);
    }

    @FXML
    public void addUser() {
        if (getQueryManager().addUser(usernameField.getText(), nameField.getText(), surnameField.getText(), emailField.getText(),
                birthField.getValue(),
                genderField.getValue(),
                heightField.getText())
        ) {
            initUsersTable();
        }
    }

    private void initUsersTable() {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("data_nascita"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("altezza"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("sesso"));
        final var ris = getQueryManager().getAllUsers();
        if(ris.isPresent()) {
            ObservableList<Utenti> users = FXCollections.observableArrayList(ris.get().getResultList());
            usersTable.setItems(users);
        }
    }
}
