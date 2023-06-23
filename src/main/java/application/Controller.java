package application;

import entity.Utenti;
import jakarta.persistence.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Controller {
    static final List<String> GENDERS = Collections.unmodifiableList(new ArrayList<>(){{add("M");add("F");}});
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction transaction = entityManager.getTransaction();
    private final QueryManager qManager = new QueryManager();

    //Home fx elements.
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

    //Profile fx elements.
   /* @FXML
    private LineChart<String, String> LineChart;*/
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;

    @FXML
    void initialize() {
        initUsersTable();
        genderField.getItems().setAll(GENDERS);
    }
    @FXML
    public void searchUser() {
        try {
            Query<Utenti> query = (Query<Utenti>) entityManager.createNativeQuery(
                                "SELECT * FROM Utenti u WHERE u.username = :username",
                                    Utenti.class);
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @FXML
    public void addUser() {
       if (qManager.addUser(
                        usernameField.getText(),
                        nameField.getText(),
                        surnameField.getText(),
                        emailField.getText(),
                        birthField.getValue(),
                        genderField.getValue(),
                        heightField.getText())
       ) {
           initUsersTable();
       };

    }
    //Method to initialize the user's table.
    private void initUsersTable() {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("nome"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("cognome"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("email"));
        birthColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("data_nascita"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("altezza"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("sesso"));
        ObservableList<Utenti> users = FXCollections.observableArrayList(qManager.getAllUsers().get().getResultList());
        usersTable.setItems(users);
    }
}
