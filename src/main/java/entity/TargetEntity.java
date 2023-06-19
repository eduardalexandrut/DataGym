package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "target", schema = "datagym", catalog = "")
public class TargetEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "esercizio")
    private int esercizio;
    @Basic
    @Column(name = "muscolo")
    private String muscolo;

    public int getEsercizio() {
        return esercizio;
    }

    public void setEsercizio(int esercizio) {
        this.esercizio = esercizio;
    }

    public String getMuscolo() {
        return muscolo;
    }

    public void setMuscolo(String muscolo) {
        this.muscolo = muscolo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TargetEntity that = (TargetEntity) o;

        if (esercizio != that.esercizio) return false;
        if (muscolo != null ? !muscolo.equals(that.muscolo) : that.muscolo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = esercizio;
        result = 31 * result + (muscolo != null ? muscolo.hashCode() : 0);
        return result;
    }
}
