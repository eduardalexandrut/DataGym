package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "pesi_serie", schema = "datagym", catalog = "")
@IdClass(PesiSerieEntityPK.class)
public class PesiSerieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "valore")
    private BigDecimal valore;

    public BigDecimal getValore() {
        return valore;
    }

    public void setValore(BigDecimal valore) {
        this.valore = valore;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "unità_misura")
    private String unitàMisura;

    public String getUnitàMisura() {
        return unitàMisura;
    }

    public void setUnitàMisura(String unitàMisura) {
        this.unitàMisura = unitàMisura;
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
    @Column(name = "set_indice")
    private int setIndice;

    public int getSetIndice() {
        return setIndice;
    }

    public void setSetIndice(int setIndice) {
        this.setIndice = setIndice;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "set_esercizio")
    private int setEsercizio;

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

        PesiSerieEntity that = (PesiSerieEntity) o;

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
