package entity;

import jakarta.persistence.*;

@Entity
@IdClass(PeriodiPK.class)
public class Periodi {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "indice")
    private int indice;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codiceDieta")
    private int codiceDieta;
    @Basic
    @Column(name = "codiceRicetta")
    private int codiceRicetta;

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

        Periodi periodi = (Periodi) o;

        if (indice != periodi.indice) return false;
        if (codiceDieta != periodi.codiceDieta) return false;
        if (codiceRicetta != periodi.codiceRicetta) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = indice;
        result = 31 * result + codiceDieta;
        result = 31 * result + codiceRicetta;
        return result;
    }

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Ricette ricette;

    public Ricette getRicette() {
        return ricette;
    }

    public void setRicette(Ricette ricette) {
        this.ricette = ricette;
    }
}
