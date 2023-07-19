package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class PeriodiPK implements Serializable {
    @Column(name = "indice")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int indice;
    @Column(name = "codiceDieta")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codiceDieta;

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getCodiceDieta() {
        return codiceDieta;
    }

    public void setCodiceDieta(int codiceDieta) {
        this.codiceDieta = codiceDieta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeriodiPK periodiPK = (PeriodiPK) o;

        if (indice != periodiPK.indice) return false;
        if (codiceDieta != periodiPK.codiceDieta) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = indice;
        result = 31 * result + codiceDieta;
        return result;
    }
}
