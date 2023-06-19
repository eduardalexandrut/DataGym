package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "serie", schema = "datagym", catalog = "")
@IdClass(SerieEntityPK.class)
public class SerieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "indice")
    private int indice;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "esercizio")
    private int esercizio;
    @Basic
    @Column(name = "numeroRep")
    private Integer numeroRep;
    @Basic
    @Column(name = "pausa")
    private int pausa;
    @Basic
    @Column(name = "durata")
    private Integer durata;

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

    public Integer getNumeroRep() {
        return numeroRep;
    }

    public void setNumeroRep(Integer numeroRep) {
        this.numeroRep = numeroRep;
    }

    public int getPausa() {
        return pausa;
    }

    public void setPausa(int pausa) {
        this.pausa = pausa;
    }

    public Integer getDurata() {
        return durata;
    }

    public void setDurata(Integer durata) {
        this.durata = durata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SerieEntity that = (SerieEntity) o;

        if (indice != that.indice) return false;
        if (esercizio != that.esercizio) return false;
        if (pausa != that.pausa) return false;
        if (numeroRep != null ? !numeroRep.equals(that.numeroRep) : that.numeroRep != null) return false;
        if (durata != null ? !durata.equals(that.durata) : that.durata != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = indice;
        result = 31 * result + esercizio;
        result = 31 * result + (numeroRep != null ? numeroRep.hashCode() : 0);
        result = 31 * result + pausa;
        result = 31 * result + (durata != null ? durata.hashCode() : 0);
        return result;
    }
}
