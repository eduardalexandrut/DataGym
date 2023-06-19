package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "giorni", schema = "datagym", catalog = "")
public class GiorniEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "data")
    private Date data;
    @Basic
    @Column(name = "dieta")
    private int dieta;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getDieta() {
        return dieta;
    }

    public void setDieta(int dieta) {
        this.dieta = dieta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GiorniEntity that = (GiorniEntity) o;

        if (dieta != that.dieta) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + dieta;
        return result;
    }
}
