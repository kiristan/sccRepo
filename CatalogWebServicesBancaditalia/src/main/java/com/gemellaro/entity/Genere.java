package com.gemellaro.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Genere implements Serializable {

    private static final long serialVersionUID = 9137644053298584059L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @Column(name = "DESCRIZIONE", columnDefinition = "TEXT")
    private String descrizione;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
