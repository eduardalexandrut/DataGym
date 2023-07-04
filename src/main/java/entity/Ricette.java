package entity;

import jakarta.persistence.*;

@Entity
public class Ricette {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codiceRicetta")
    private int codiceRicetta;
    @Basic
    @Column(name = "nomeRicetta")
    private String nomeRicetta;
    @Basic
    @Column(name = "utente")
    private String utente;

    public int getCodiceRicetta() {
        return codiceRicetta;
    }

    public void setCodiceRicetta(int codiceRicetta) {
        this.codiceRicetta = codiceRicetta;
    }

    public String getNomeRicetta() {
        return nomeRicetta;
    }

    public void setNomeRicetta(String nomeRicetta) {
        this.nomeRicetta = nomeRicetta;
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

        Ricette ricette = (Ricette) o;

        if (codiceRicetta != ricette.codiceRicetta) return false;
        if (nomeRicetta != null ? !nomeRicetta.equals(ricette.nomeRicetta) : ricette.nomeRicetta != null) return false;
        if (utente != null ? !utente.equals(ricette.utente) : ricette.utente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codiceRicetta;
        result = 31 * result + (nomeRicetta != null ? nomeRicetta.hashCode() : 0);
        result = 31 * result + (utente != null ? utente.hashCode() : 0);
        return result;
    }
}
