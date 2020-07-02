package com.gemellaro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gemellaro.entity.Film;
import com.gemellaro.repository.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {


    @Autowired
    private FilmRepository fr;

    @Override
    public List<Film> listaFilm() {
        return fr.findAll();
    }

    @Override
    public Film selezionaFilm(int id) {
        return fr.findById(id);
    }

    @Override
    @Transactional
    public void inserisciFilm(Film f) {
        fr.saveAndFlush(f);
    }

    @Override
    @Transactional
    public void modificaFilm(Film f) {
        fr.saveAndFlush(f);

    }

    @Override
    @Transactional
    public void rimuoviFilm(Film f) {
        fr.delete(f);
    }
}
