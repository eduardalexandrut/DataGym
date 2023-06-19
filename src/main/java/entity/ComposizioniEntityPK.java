package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class ComposizioniEntityPK implements Serializable {
    @Column(name = "ricetta")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ricetta;
    @Column(name = "ingrediente")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ingrediente;

    public int getRicetta() {
        return ricetta;
    }

    public void setRicetta(int ricetta) {
        this.ricetta = ricetta;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComposizioniEntityPK that = (ComposizioniEntityPK) o;

        if (ricetta != that.ricetta) return false;
        if (ingrediente != null ? !ingrediente.equals(that.ingrediente) : that.ingrediente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ricetta;
        result = 31 * result + (ingrediente != null ? ingrediente.hashCode() : 0);
        return result;
    }
}
