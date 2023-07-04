package entity;

import jakarta.persistence.*;

@Entity
public class Diete {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codiceDieta")
    private int codiceDieta;
    @Basic
    @Column(name = "nomeDieta")
    private String nomeDieta;
    @Basic
    @Column(name = "utente")
    private String utente;

    public int getCodiceDieta() {
        return codiceDieta;
    }

    public void setCodiceDieta(int codiceDieta) {
        this.codiceDieta = codiceDieta;
    }

    public String getNomeDieta() {
        return nomeDieta;
    }

    public void setNomeDieta(String nomeDieta) {
        this.nomeDieta = nomeDieta;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diete diete = (Diete) o;

        if (codiceDieta != diete.codiceDieta) return false;
        if (nomeDieta != null ? !nomeDieta.equals(diete.nomeDieta) : diete.nomeDieta != null) return false;
        if (utente != null ? !utente.equals(diete.utente) : diete.utente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codiceDieta;
        result = 31 * result + (nomeDieta != null ? nomeDieta.hashCode() : 0);
        result = 31 * result + (utente != null ? utente.hashCode() : 0);
        return result;
    }
}
