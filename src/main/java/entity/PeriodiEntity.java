package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "periodi", schema = "datagym", catalog = "")
@IdClass(PeriodiEntityPK.class)
public class PeriodiEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "indice")
    private int indice;

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codiceDieta")
    private int codiceDieta;

    public int getCodiceDieta() {
        return codiceDieta;
    }

    public void setCodiceDieta(int codiceDieta) {
        this.codiceDieta = codiceDieta;
    }

    @Basic
    @Column(name = "codiceRicetta")
    private int codiceRicetta;

    public int getCodiceRicetta() {
        return codiceRicetta;
    }

    public void setCodiceRicetta(int codiceRicetta) {
        this.codiceRicetta = codiceRicetta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeriodiEntity that = (PeriodiEntity) o;

        if (indice != that.indice) return false;
        if (codiceDieta != that.codiceDieta) return false;
        if (codiceRicetta != that.codiceRicetta) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = indice;
        result = 31 * result + codiceDieta;
        result = 31 * result + codiceRicetta;
        return result;
    }
}
