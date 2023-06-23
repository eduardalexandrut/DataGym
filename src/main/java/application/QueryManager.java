package application;

import entity.Utenti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.query.Query;

import java.util.Optional;

public class QueryManager {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final EntityTransaction transaction = entityManager.getTransaction();
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
}
