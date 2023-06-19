package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class AllenamentiEntityPK implements Serializable {
    @Column(name = "ora_inizio")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Time oraInizio;
    @Column(name = "ora_fine")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Time oraFine;
    @Column(name = "data")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date data;
    @Column(name = "utente")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String utente;
    @Column(name = "scheda")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheda;

    public Time getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(Time oraInizio) {
        this.oraInizio = oraInizio;
    }

    public Time getOraFine() {
        return oraFine;
    }

    public void setOraFine(Time oraFine) {
        this.oraFine = oraFine;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public int getScheda() {
        return scheda;
    }

    public void setScheda(int scheda) {
        this.scheda = scheda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllenamentiEntityPK that = (AllenamentiEntityPK) o;

        if (scheda != that.scheda) return false;
        if (oraInizio != null ? !oraInizio.equals(that.oraInizio) : that.oraInizio != null) return false;
        if (oraFine != null ? !oraFine.equals(that.oraFine) : that.oraFine != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (utente != null ? !utente.equals(that.utente) : that.utente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = oraInizio != null ? oraInizio.hashCode() : 0;
        result = 31 * result + (oraFine != null ? oraFine.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (utente != null ? utente.hashCode() : 0);
        result = 31 * result + scheda;
        return result;
    }
}
