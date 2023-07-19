package application.model;

import entity.*;
import jakarta.persistence.*;

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
    public void addUser(final Utenti user) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO Utenti (username, email, nome, cognome, altezza, sesso, dataNascita)" +
                "VALUES (:username, :email, :nome, :cognome, :altezza, :sesso, :data_nascita)")
                .setParameter("username", user.getUsername())
                .setParameter("email", user.getEmail())
                .setParameter("nome", user.getNome())
                .setParameter("cognome", user.getCognome())
                .setParameter("altezza", user.getAltezza())
                .setParameter("sesso", user.getSesso())
                .setParameter("data_nascita", user.getDataNascita()).executeUpdate();
        transaction.commit();
    }

    //Method to get all the allenamenti of a particular user.
    public List getAllenamenti(final String username) {
        return entityManager.createNativeQuery("SELECT * FROM allenamenti WHERE utente = :username", Allenamenti.class)
                .setParameter("username", username)
                .getResultList();
    }

    //Method to add an allenamento to the db.
    public void addAllenamento(final Allenamenti allenamento) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO allenamenti (oraInizio, oraFine, data, utente, scheda, commento) " +
                "VALUES (:oraInizio, :oraFine, :data, :utente, :scheda, :commento)", Allenamenti.class)
                .setParameter("oraInizio", allenamento.getOraInizio())
                .setParameter("oraFine", allenamento.getOraFine())
                .setParameter("data", allenamento.getData())
                .setParameter("utente", allenamento.getUtente())
                .setParameter("scheda", allenamento.getScheda())
                .setParameter("commento", allenamento.getCommento())
                .executeUpdate();
        transaction.commit();
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

    public List<Esercizi> getEserciziOfScheda(final int scheda) {
        return entityManager.createNativeQuery("SELECT * FROM esercizi WHERE scheda = :scheda", Esercizi.class)
                .setParameter("scheda",scheda)
                .getResultList();
    }

    public void addExercise(final Esercizi exercise) {
        transaction.begin();
        entityManager.createNativeQuery("INSERT INTO esercizi(codiceEsercizio, nomeEsercizio, tipo, scheda) " +
                "VALUES (:codiceEsercizio, :nomeEsercizio, :tipo, :scheda)")
                .setParameter("codiceEsercizio", exercise.getCodiceEsercizio())
                .setParameter("nomeEsercizio", exercise.getNomeEsercizio())
                .setParameter("tipo", exercise.getTipo())
                .setParameter("scheda", exercise.getScheda())
                .executeUpdate();
        transaction.commit();
    }

    public List<Serie> getSerieOfEsercizio(final int esercizio) {
        return entityManager.createNativeQuery("SELECT * FROM serie WHERE esercizio = :esercizio", Serie.class)
                .setParameter("esercizio", esercizio)
                .getResultList();
    }

    //Method to get all the diets of a user.
    public List<Diete> getDiete(final String user) {
        return entityManager.createNativeQuery("SELECT * FROM diete WHERE utente = :utente", Diete.class)
                .setParameter("utente", user)
                .getResultList();
    }

    //Method to add a new weight to a specific user.
    public void addUserWeight(final PesiUtenti userWeight) {
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

    //Method to get all the weights of a user.
    public List<PesiUtenti> getUserWeights(final Utenti user) {
        return entityManager.createNativeQuery("SELECT * FROM pesi_utenti WHERE utente = :user", PesiUtenti.class)
                .setParameter("user", user.getUsername())
                .getResultList();
    }
}
