package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "esercizi", schema = "datagym", catalog = "")
public class EserciziEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codiceEsercizio")
    private int codiceEsercizio;
    @Basic
    @Column(name = "nomeEsercizio")
    private String nomeEsercizio;
    @Basic
    @Column(name = "tipo")
    private Object tipo;
    @Basic
    @Column(name = "scheda")
    private int scheda;

    public int getCodiceEsercizio() {
        return codiceEsercizio;
    }

    public void setCodiceEsercizio(int codiceEsercizio) {
        this.codiceEsercizio = codiceEsercizio;
    }

    public String getNomeEsercizio() {
        return nomeEsercizio;
    }

    public void setNomeEsercizio(String nomeEsercizio) {
        this.nomeEsercizio = nomeEsercizio;
    }

    public Object getTipo() {
        return tipo;
    }

    public void setTipo(Object tipo) {
        this.tipo = tipo;
    }

    public int getScheda() {
        return scheda;
    }

    public void setScheda(int scheda) {
        this.scheda = scheda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EserciziEntity that = (EserciziEntity) o;

        if (codiceEsercizio != that.codiceEsercizio) return false;
        if (scheda != that.scheda) return false;
        if (nomeEsercizio != null ? !nomeEsercizio.equals(that.nomeEsercizio) : that.nomeEsercizio != null)
            return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codiceEsercizio;
        result = 31 * result + (nomeEsercizio != null ? nomeEsercizio.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + scheda;
        return result;
    }
}
