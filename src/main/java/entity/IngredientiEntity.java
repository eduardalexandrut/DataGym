package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ingredienti", schema = "datagym", catalog = "")
public class IngredientiEntity {
    @Basic
    @Column(name = "calorie")
    private BigDecimal calorie;
    @Basic
    @Column(name = "carboidrati")
    private BigDecimal carboidrati;
    @Basic
    @Column(name = "proteine")
    private BigDecimal proteine;
    @Basic
    @Column(name = "grassi")
    private BigDecimal grassi;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "nome")
    private String nome;

    public BigDecimal getCalorie() {
        return calorie;
    }

    public void setCalorie(BigDecimal calorie) {
        this.calorie = calorie;
    }

    public BigDecimal getCarboidrati() {
        return carboidrati;
    }

    public void setCarboidrati(BigDecimal carboidrati) {
        this.carboidrati = carboidrati;
    }

    public BigDecimal getProteine() {
        return proteine;
    }

    public void setProteine(BigDecimal proteine) {
        this.proteine = proteine;
    }

    public BigDecimal getGrassi() {
        return grassi;
    }

    public void setGrassi(BigDecimal grassi) {
        this.grassi = grassi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IngredientiEntity that = (IngredientiEntity) o;

        if (calorie != null ? !calorie.equals(that.calorie) : that.calorie != null) return false;
        if (carboidrati != null ? !carboidrati.equals(that.carboidrati) : that.carboidrati != null) return false;
        if (proteine != null ? !proteine.equals(that.proteine) : that.proteine != null) return false;
        if (grassi != null ? !grassi.equals(that.grassi) : that.grassi != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = calorie != null ? calorie.hashCode() : 0;
        result = 31 * result + (carboidrati != null ? carboidrati.hashCode() : 0);
        result = 31 * result + (proteine != null ? proteine.hashCode() : 0);
        result = 31 * result + (grassi != null ? grassi.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }
}
