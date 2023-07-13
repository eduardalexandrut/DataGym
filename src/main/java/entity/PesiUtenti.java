package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@jakarta.persistence.Table(name = "pesi_utenti", schema = "datagym")
//@jakarta.persistence.IdClass(entity.PesiUtentiPK.class)
public class PesiUtenti {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "valore")
    private BigDecimal valore;

    public BigDecimal getValore() {
        return valore;
    }

    public void setValore(BigDecimal valore) {
        this.valore = valore;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "unitàMisura")
    private String unitàMisura;

    public String getUnitàMisura() {
        return unitàMisura;
    }

    public void setUnitàMisura(String unitàMisura) {
        this.unitàMisura = unitàMisura;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "data")
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @jakarta.persistence.Column(name = "utente")
    private String utente;

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

        PesiUtenti that = (PesiUtenti) o;

        if (valore != null ? !valore.equals(that.valore) : that.valore != null) return false;
        if (unitàMisura != null ? !unitàMisura.equals(that.unitàMisura) : that.unitàMisura != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (utente != null ? !utente.equals(that.utente) : that.utente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = valore != null ? valore.hashCode() : 0;
        result = 31 * result + (unitàMisura != null ? unitàMisura.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (utente != null ? utente.hashCode() : 0);
        return result;
    }
}
