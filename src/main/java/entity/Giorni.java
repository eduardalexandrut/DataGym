package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Giorni {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Giorni giorni = (Giorni) o;

        if (data != null ? !data.equals(giorni.data) : giorni.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
