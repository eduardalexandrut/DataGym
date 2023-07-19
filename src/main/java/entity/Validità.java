package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
@jakarta.persistence.IdClass(entity.ValiditàPK.class)
public class Validità {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "dieta")
    private int dieta;

    public int getDieta() {
        return dieta;
    }

    public void setDieta(int dieta) {
        this.dieta = dieta;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "giorno")
    private Date giorno;

    public Date getGiorno() {
        return giorno;
    }

    public void setGiorno(Date giorno) {
        this.giorno = giorno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Validità validità = (Validità) o;

        if (dieta != validità.dieta) return false;
        if (giorno != null ? !giorno.equals(validità.giorno) : validità.giorno != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dieta;
        result = 31 * result + (giorno != null ? giorno.hashCode() : 0);
        return result;
    }
}
