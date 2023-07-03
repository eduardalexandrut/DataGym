package application.controller;

import entity.Utenti;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class HomeController extends Controller {
    static final List<String> GENDERS = List.of("M", "F");
    private Utenti user;
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
        usersTable.getSelectionModel().selectedItemProperty().addListener(e -> {
            setUser(usersTable.getSelectionModel().getSelectedItem());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/ProfileView.fxml"));
            try {
                Parent root = loader.load();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            ProfileController controller = loader.getController();
            controller.setUser(usersTable.getSelectionModel().getSelectedItem());
            //controller.setUserInfo(usersTable.getSelectionModel().getSelectedItem());
        });
    }

    @FXML
    public void addUser() {
        getQueryManager().addUser(usernameField.getText(), nameField.getText(), surnameField.getText(), emailField.getText(),
                birthField.getValue(),
                genderField.getValue(),
                heightField.getText());
        initUsersTable();
    }

    private void initUsersTable() {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("cognome"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("data_nascita"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<>("altezza"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("sesso"));
        ObservableList<Utenti> users = FXCollections.observableArrayList(getQueryManager().getAllUsers());
        usersTable.setItems(users);
    }
    public Utenti getUser() {
        return this.user;
    }
    public void setUser(final Utenti user) {
        this.user = user;
    }
}
