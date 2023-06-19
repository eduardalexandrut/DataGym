package entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "schede", schema = "datagym", catalog = "")
public class SchedeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codiceScheda")
    private int codiceScheda;
    @Basic
    @Column(name = "nomeScheda")
    private String nomeScheda;
    @Basic
    @Column(name = "data_creazione")
    private Date dataCreazione;
    @Basic
    @Column(name = "utente")
    private String utente;

    public int getCodiceScheda() {
        return codiceScheda;
    }

    public void setCodiceScheda(int codiceScheda) {
        this.codiceScheda = codiceScheda;
    }

    public String getNomeScheda() {
        return nomeScheda;
    }

    public void setNomeScheda(String nomeScheda) {
        this.nomeScheda = nomeScheda;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SchedeEntity that = (SchedeEntity) o;

        if (codiceScheda != that.codiceScheda) return false;
        if (nomeScheda != null ? !nomeScheda.equals(that.nomeScheda) : that.nomeScheda != null) return false;
        if (dataCreazione != null ? !dataCreazione.equals(that.dataCreazione) : that.dataCreazione != null)
            return false;
        if (utente != null ? !utente.equals(that.utente) : that.utente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codiceScheda;
        result = 31 * result + (nomeScheda != null ? nomeScheda.hashCode() : 0);
        result = 31 * result + (dataCreazione != null ? dataCreazione.hashCode() : 0);
        result = 31 * result + (utente != null ? utente.hashCode() : 0);
        return result;
    }
}
