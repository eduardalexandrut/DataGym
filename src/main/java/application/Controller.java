package application;

import entity.Utenti;
import jakarta.persistence.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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

    @FXML
    void initialize() {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("username"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("nome"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("cognome"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("email"));
        birthColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("data_nascita"));
        heightColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("altezza"));
        genderColumn.setCellValueFactory(new PropertyValueFactory<Utenti,String>("sesso"));
        ObservableList<Utenti> users = FXCollections.observableArrayList();
        try {
            transaction.begin();
            Query<Utenti> nativeQuery = (Query<Utenti>) entityManager.createNativeQuery("SELECT * FROM Utenti", Utenti.class);
            for (final var elem : nativeQuery.getResultList()) {
                users.add(elem);
            }
            System.out.println(nativeQuery.getResultList());
            usersTable.setItems(users);
            transaction.commit();
            genderField.getItems().setAll(GENDERS);
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
    @FXML
    public void searchUser() {
        try {
            Query<Utenti> query = (Query<Utenti>) entityManager.createNativeQuery("SELECT * FROM Utenti u WHERE u.username = :username", Utenti.class);
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    @FXML
    public void addUser() {
        try {
            transaction.begin();
            Utenti user = new Utenti();
            user.setUsername(this.usernameField.getText());
            user.setEmail(this.emailField.getText());
            user.setNome(this.nameField.getText());
            user.setCognome(this.nameField.getText());
            user.setSesso(this.genderField.getValue());
            user.setAltezza(BigDecimal.valueOf(Double.parseDouble(this.heightField.getText())));
            user.setDataNascita(Date.valueOf(this.birthField.getValue()));
            entityManager.persist(user);
            transaction.commit();
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
