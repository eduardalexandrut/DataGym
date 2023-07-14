package application.controller;

import entity.Utenti;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class MainController extends Controller {
    static final List<String> GENDERS = List.of("M", "F");
    private Optional<Utenti> user = Optional.empty();
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
            setUser(Optional.of(t1));
        }));
    }

    @FXML
    public void addUser() {
        final Utenti newUser = new Utenti();
        newUser.setUsername(usernameField.getText());
        newUser.setNome(nameField.getText());
        newUser.setCognome(surnameField.getText());
        newUser.setSesso(genderField.getValue());
        newUser.setEmail(emailField.getText());
        newUser.setAltezza(BigDecimal.valueOf(Double.parseDouble(heightField.getText())));
        newUser.setDataNascita(Date.valueOf(birthField.getValue()));
        getQueryManager().addUser(newUser);
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
    public Optional<Utenti> getUser() {
        return this.user;
    }
    public void setUser(final Optional<Utenti> user) {
        this.user = user;
        this.profileController.setUser(user);
        this.schedeController.setUser(user);
    }
}
