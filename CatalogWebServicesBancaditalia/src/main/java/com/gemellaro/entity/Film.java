package com.gemellaro.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "prodotto")
public class Film implements Serializable {

    private static final long serialVersionUID = 9028647748528082127L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titolo;
    private int anno;
    private int durata;

    @Column(name = "DESCRIZIONE", columnDefinition = "TEXT")
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "GENEREID", referencedColumnName = "id")
    private Genere genere;
    @Column(name = "DATACREAZIONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCreazione;

    @Column(name = "DATAULTIMAMODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataultimamodifica;

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Date dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDataultimamodifica() {
        return dataultimamodifica;
    }

    public void setDataultimamodifica(Date dataultimamodifica) {
        this.dataultimamodifica = dataultimamodifica;
    }
}

