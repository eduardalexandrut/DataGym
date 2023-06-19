package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class PesiSerieEntityPK implements Serializable {
    @Column(name = "valore")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal valore;
    @Column(name = "unità_misura")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String unitàMisura;
    @Column(name = "data")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date data;
    @Column(name = "set_indice")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int setIndice;
    @Column(name = "set_esercizio")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int setEsercizio;

    public BigDecimal getValore() {
        return valore;
    }

    public void setValore(BigDecimal valore) {
        this.valore = valore;
    }

    public String getUnitàMisura() {
        return unitàMisura;
    }

    public void setUnitàMisura(String unitàMisura) {
        this.unitàMisura = unitàMisura;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getSetIndice() {
        return setIndice;
    }

    public void setSetIndice(int setIndice) {
        this.setIndice = setIndice;
    }

    public int getSetEsercizio() {
        return setEsercizio;
    }

    public void setSetEsercizio(int setEsercizio) {
        this.setEsercizio = setEsercizio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PesiSerieEntityPK that = (PesiSerieEntityPK) o;

        if (setIndice != that.setIndice) return false;
        if (setEsercizio != that.setEsercizio) return false;
        if (valore != null ? !valore.equals(that.valore) : that.valore != null) return false;
        if (unitàMisura != null ? !unitàMisura.equals(that.unitàMisura) : that.unitàMisura != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = valore != null ? valore.hashCode() : 0;
        result = 31 * result + (unitàMisura != null ? unitàMisura.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + setIndice;
        result = 31 * result + setEsercizio;
        return result;
    }
}
