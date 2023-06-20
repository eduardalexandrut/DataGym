package application;

import entity.Utenti;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

public final class App {
    private App() { }
    public static void main(String[] args) {

        //Application.launch(JavaFX.class, args);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            TypedQuery<Utenti> empByUsernameQuery = entityManager.createNamedQuery("Utenti.byUsername", Utenti.class);
            empByUsernameQuery.setParameter(1, "EduardT");
            for(var u : empByUsernameQuery.getResultList()) {
                System.out.println(u);
            }
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
