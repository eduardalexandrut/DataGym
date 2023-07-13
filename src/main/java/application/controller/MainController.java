package application.controller;

import entity.Utenti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class MainController extends Controller {
    static final List<String> GENDERS = List.of("M", "F");
    private Utenti user;
    @FXML
    private TabPane tabPane;
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
    private TableColumn birthColumn;
    @FXML
    private TableColumn<Utenti, String> heightColumn;
    @FXML
    private ProfileController profileController;
    @FXML
    private SchedeController schedeController;
    @FXML
    private DietsController dietsController;
    @FXML RecipesController recipesController;

    public void initialize() {
        initUsersTable();
        genderField.getItems().setAll(GENDERS);
        usersTable.getSelectionModel().selectedItemProperty().addListener(((observableValue, utenti, t1) -> {
            setUser(t1);
            System.out.println(getUser().toString());
        }));
        tabPane.getSelectionModel().selectedItemProperty().addListener((observableValue, tab, t1) -> {
            switch (t1.getText()) {
                case "Home":
                    System.out.println(user);
                    break;
                case "Profile":
                    System.out.println("profiel");
                    this.profileController.setUsername(user);
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
                default:
                    System.out.println(getUser().toString());
                    break;
            }
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
        birthColumn.setCellValueFactory(new PropertyValueFactory<>("dataNascita"));
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
