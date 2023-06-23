package application;

import entity.Utenti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Optional;

//This is a class whose job is to do all the queries, and return their result.
public class QueryManager {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction transaction = entityManager.getTransaction();

    //Method to get all the users.
    public Optional<Query<Utenti>> getAllUsers() {
        Optional<Query<Utenti>> result;
        try {
            transaction.begin();
            result = Optional.of((Query<Utenti>) entityManager.createNativeQuery("SELECT * FROM Utenti", Utenti.class));

            transaction.commit();
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
        }
        return result;
    }

    //Method to add a new user.
    public boolean addUser(final String username,
                        final String name,
                        final String surname,
                        final String email,
                        final LocalDate birth,
                        final String gender,
                        final String height) {
        try {
            transaction.begin();
            Query query = (Query) entityManager.createNativeQuery(
                    "INSERT INTO Utenti (username, email, nome, cognome, altezza, sesso, data_nascita)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)");
            query.setParameter(1, username);
            query.setParameter(2, email);
            query.setParameter(3, name);
            query.setParameter(4, surname);
            query.setParameter(5, height);
            query.setParameter(6, gender);
            query.setParameter(7, birth);
            query.executeUpdate();
            transaction.commit();
            return true;
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
}
