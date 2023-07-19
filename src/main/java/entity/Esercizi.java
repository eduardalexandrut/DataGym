package entity;

import jakarta.persistence.*;

@Entity
public class Esercizi {
    enum Tipologie {
        CALISTHENICS("Calisthenics"), FREEWEIGHT("Free-weight"), CARDIO("Cardio");
        private String name;
        Tipologie(final String name) {
            this.name = name;
        }
    }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codiceEsercizio")
    private int codiceEsercizio;
    @Basic
    @Column(name = "nomeEsercizio")
    private String nomeEsercizio;
    @Basic
    @Column(name = "tipo")
    private String tipo;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

        Esercizi esercizi = (Esercizi) o;

        if (codiceEsercizio != esercizi.codiceEsercizio) return false;
        if (scheda != esercizi.scheda) return false;
        if (nomeEsercizio != null ? !nomeEsercizio.equals(esercizi.nomeEsercizio) : esercizi.nomeEsercizio != null)
            return false;
        if (tipo != null ? !tipo.equals(esercizi.tipo) : esercizi.tipo != null) return false;

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
