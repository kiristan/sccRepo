package it.corsosc.customerwebservice.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int role;
    private String username;
    private String password;
    @Column(name = "DATACREAZIONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCreazione;
    @Column(name = "DATAULTIMAMODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaModifica;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public Date getDataUltimaModifica() {
        return dataUltimaModifica;
    }

    public void setDataUltimaModifica(Date dataUltimaModifica) {
        this.dataUltimaModifica = dataUltimaModifica;
    }
}
