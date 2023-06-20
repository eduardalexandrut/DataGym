package application;

import entity.Utenti;
import jakarta.persistence.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction transaction = entityManager.getTransaction();

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField userSearchBox;

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
}
