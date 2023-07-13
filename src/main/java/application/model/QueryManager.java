package application.model;

import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
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
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO Utenti (username, email, nome, cognome, altezza, sesso, dataNascita)" +
                "VALUES (:username, :email, :nome, :cognome, :altezza, :sesso, :data_nascita)")
                .setParameter("username", username)
                .setParameter("email", email)
                .setParameter("nome", name)
                .setParameter("cognome", surname)
                .setParameter("altezza", height)
                .setParameter("sesso", gender)
                .setParameter("dataNascita", birth).executeUpdate();
        transaction.commit();
    }

    //Method to get all the allenamenti of a particular user.
    public List getAllenamenti(final String username) {
        return entityManager.createNativeQuery("SELECT * FROM allenamenti WHERE utente = :username", Allenamenti.class)
                .setParameter("username", username)
                .getResultList();
    }

    //Method to add a new scheda into the db.
    public void addScheda(final String name, final String user, final LocalDate dataCreazione) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO schede (nomeScheda, dataCreazione, utente)" +
                "VALUES (:nomeScheda, :data_creazione, :utente)", Schede.class)
                .setParameter("nomeScheda", name)
                .setParameter("data_creazione", dataCreazione)
                .setParameter("utente", user)
                .executeUpdate();
        transaction.commit();
    }

    //Method to get all the schede of an utente.
    public List<Schede> getSchede(final String user) {
        return entityManager.createNativeQuery("SELECT * FROM schede WHERE utente = :utente", Schede.class)
                .setParameter("utente", user)
                .getResultList();
    }

    //Method to get all the diets of a user.
    public List<Diete> getDiete(final String user) {
        return entityManager.createNativeQuery("SELECT * FROM diete WHERE utente = :utente", Diete.class)
                .setParameter("utente", user)
                .getResultList();
    }

    //Method to add a new weight to a specific user.
    public void addWeight(final PesiUtenti userWeight) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO pesi_utenti(valore, unitàMisura, data, utente) " +
                "VALUES (:valore, :unitàMisura, :data, :utente)", PesiUtenti.class)
                .setParameter("valore", userWeight.getValore())
                .setParameter("unitàMisura", userWeight.getUnitàMisura())
                .setParameter("data", userWeight.getData())
                .setParameter("utente", userWeight.getUtente())
                .executeUpdate();
        transaction.commit();
    }
}
