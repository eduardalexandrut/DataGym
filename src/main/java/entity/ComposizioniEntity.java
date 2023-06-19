package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "composizioni", schema = "datagym", catalog = "")
@IdClass(ComposizioniEntityPK.class)
public class ComposizioniEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ricetta")
    private int ricetta;

    public int getRicetta() {
        return ricetta;
    }

    public void setRicetta(int ricetta) {
        this.ricetta = ricetta;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ingrediente")
    private String ingrediente;

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Basic
    @Column(name = "quantità")
    private BigDecimal quantità;

    public BigDecimal getQuantità() {
        return quantità;
    }

    public void setQuantità(BigDecimal quantità) {
        this.quantità = quantità;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComposizioniEntity that = (ComposizioniEntity) o;

        if (ricetta != that.ricetta) return false;
        if (ingrediente != null ? !ingrediente.equals(that.ingrediente) : that.ingrediente != null) return false;
        if (quantità != null ? !quantità.equals(that.quantità) : that.quantità != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ricetta;
        result = 31 * result + (ingrediente != null ? ingrediente.hashCode() : 0);
        result = 31 * result + (quantità != null ? quantità.hashCode() : 0);
        return result;
    }
}
