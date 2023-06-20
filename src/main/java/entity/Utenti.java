package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@NamedQuery(name = "Utenti.byUsername", query = "SELECT u FROM Utenti u WHERE u.username = ?1 ")
@NamedQuery(name = "Utenti.getAllUsers", query = "FROM Utenti ")
public class Utenti {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "cognome")
    private String cognome;
    @Basic
    @Column(name = "altezza")
    private BigDecimal altezza;
    @Basic
    @Column(name = "sesso")
    private String sesso;
    @Basic
    @Column(name = "data_nascita")
    private Date dataNascita;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public BigDecimal getAltezza() {
        return altezza;
    }

    public void setAltezza(BigDecimal altezza) {
        this.altezza = altezza;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utenti utenti = (Utenti) o;

        if (username != null ? !username.equals(utenti.username) : utenti.username != null) return false;
        if (email != null ? !email.equals(utenti.email) : utenti.email != null) return false;
        if (nome != null ? !nome.equals(utenti.nome) : utenti.nome != null) return false;
        if (cognome != null ? !cognome.equals(utenti.cognome) : utenti.cognome != null) return false;
        if (altezza != null ? !altezza.equals(utenti.altezza) : utenti.altezza != null) return false;
        if (sesso != null ? !sesso.equals(utenti.sesso) : utenti.sesso != null) return false;
        if (dataNascita != null ? !dataNascita.equals(utenti.dataNascita) : utenti.dataNascita != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (cognome != null ? cognome.hashCode() : 0);
        result = 31 * result + (altezza != null ? altezza.hashCode() : 0);
        result = 31 * result + (sesso != null ? sesso.hashCode() : 0);
        result = 31 * result + (dataNascita != null ? dataNascita.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Utenti{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", altezza=" + altezza +
                ", sesso='" + sesso + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }
}
