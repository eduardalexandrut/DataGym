package application;

import entity.Utenti;
import jakarta.persistence.*;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
    private BorderPane homeBPane;
    @FXML
    private GridPane usersTable;

    //Profile fx elements.
    @FXML
    private Label usernameLabel;
    @FXML
    private TextField userSearchBox;

    @FXML
    void initialize() {
        try {
            TypedQuery<Utenti> empGetAllUsersQuery = entityManager.createNamedQuery("Utenti.getAllUsers", Utenti.class);
            for(var elem : empGetAllUsersQuery.getResultList()) {
                this.usersTable.add(new Label(elem.getUsername()),0, empGetAllUsersQuery.getResultList().indexOf(elem) + 1);
                this.usersTable.add(new Label(elem.getNome()),1, empGetAllUsersQuery.getResultList().indexOf(elem) + 1);
                this.usersTable.add(new Label(elem.getCognome()),2, empGetAllUsersQuery.getResultList().indexOf(elem) + 1);
                this.usersTable.add(new Label(elem.getSesso()),3, empGetAllUsersQuery.getResultList().indexOf(elem) + 1);
                this.usersTable.add(new Label(elem.getEmail()),4, empGetAllUsersQuery.getResultList().indexOf(elem) + 1);
                this.usersTable.add(new Label(elem.getDataNascita().toString()),5, empGetAllUsersQuery.getResultList().indexOf(elem) + 1);
            }
            genderField.getItems().setAll(GENDERS);
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    @FXML
    public void searchUser() {
        try {
            TypedQuery<Utenti> empByUsernameQuery = entityManager.createNamedQuery("Utenti.byUsername", Utenti.class);
            empByUsernameQuery.setParameter(1, userSearchBox.getText());
            usernameLabel.setText(usernameLabel.getText() + empByUsernameQuery.getSingleResult().getUsername());

        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @FXML
    public void addUser() {

    }
}
