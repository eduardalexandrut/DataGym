package application.model;

import entity.Allenamenti;
import entity.Utenti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

//This is a class whose job is to do all the queries, and return their result.
public class QueryManager {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction transaction = entityManager.getTransaction();

    //Method to get all the users.
    public List<Utenti> getAllUsers() {
       return entityManager.createNativeQuery("SELECT * FROM utenti", Utenti.class)
               .getResultList();
    }

    //Method to add a new user.
    public void addUser(final String username,
                        final String name,
                        final String surname,
                        final String email,
                        final LocalDate birth,
                        final String gender,
                        final String height) {
        entityManager.createNativeQuery("INSERT INTO Utenti (username, email, nome, cognome, altezza, sesso, data_nascita)" +
                "VALUES (:username, :email, :nome, :cognome, :altezza, :sesso, :data_nascita)")
                .setParameter("username", username)
                .setParameter("email", email)
                .setParameter("nome", name)
                .setParameter("cognome", surname)
                .setParameter("altezza", height)
                .setParameter("sesso", gender)
                .setParameter("data_nascita", birth).executeUpdate();
    }

    //Method to get all the allenamenti of a particular user.
    public List getAllenamenti(final String username) {
        return entityManager.createNativeQuery("SELECT * FROM allenamenti WHERE utente = :username", Allenamenti.class)
                .setParameter("username", username)
                .getResultList();
    }
}
