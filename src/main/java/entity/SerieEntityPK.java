package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class SerieEntityPK implements Serializable {
    @Column(name = "indice")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int indice;
    @Column(name = "esercizio")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int esercizio;

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getEsercizio() {
        return esercizio;
    }

    public void setEsercizio(int esercizio) {
        this.esercizio = esercizio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SerieEntityPK that = (SerieEntityPK) o;

        if (indice != that.indice) return false;
        if (esercizio != that.esercizio) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = indice;
        result = 31 * result + esercizio;
        return result;
    }
}
