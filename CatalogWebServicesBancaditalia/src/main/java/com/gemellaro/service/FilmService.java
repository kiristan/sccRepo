package com.gemellaro.service;

import java.util.List;

import com.gemellaro.entity.Film;

public interface FilmService {
    List<Film> listaFilm();

    Film selezionaFilm(int id);

    void inserisciFilm(Film f);

    void modificaFilm(Film f);

    public void rimuoviFilm(Film f);

}
