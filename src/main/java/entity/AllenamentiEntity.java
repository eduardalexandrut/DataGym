package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "allenamenti", schema = "datagym", catalog = "")
@IdClass(AllenamentiEntityPK.class)
public class AllenamentiEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ora_inizio")
    private Time oraInizio;

    public Time getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(Time oraInizio) {
        this.oraInizio = oraInizio;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ora_fine")
    private Time oraFine;

    public Time getOraFine() {
        return oraFine;
    }

    public void setOraFine(Time oraFine) {
        this.oraFine = oraFine;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "data")
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "utente")
    private String utente;

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "scheda")
    private int scheda;

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

        AllenamentiEntity that = (AllenamentiEntity) o;

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
