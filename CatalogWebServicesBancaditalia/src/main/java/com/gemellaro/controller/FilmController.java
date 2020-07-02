package com.gemellaro.controller;


import java.util.List;

import com.gemellaro.config.CustomerClient;
import com.gemellaro.dto.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gemellaro.entity.Film;
import com.gemellaro.service.FilmService;

@RestController
@RequestMapping("/rest/film")
public class FilmController {

    @Autowired
    private FilmService fs;

    @Autowired
    private CustomerClient customerClient;

    @RequestMapping(value = "/lista", produces = "application/json")
    public ResponseEntity<List<Film>> listaFilm() {
        List<Film> lista = fs.listaFilm();
        if (lista.isEmpty()) {
            return new ResponseEntity<List<Film>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Film>>(lista, HttpStatus.OK);
    }

    @RequestMapping(value = "/findById/{id}", produces = "application/json")
    public ResponseEntity<Film> findByIdFilm(@PathVariable("id") int id) {
        Film film = fs.selezionaFilm(id);
        if (film == null) {
            return new ResponseEntity<Film>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Film>(film, HttpStatus.OK);
    }


    @RequestMapping(value = "/creaFilmJson", method = RequestMethod.POST)
    public ResponseEntity<Film> creaFilm(@RequestBody Film f) {
        if (f.getId() == 0) {
            fs.inserisciFilm(f);
        } else {
            fs.modificaFilm(f);
        }

        return new ResponseEntity<Film>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/findByInfoCliente/{username}", produces = "application/json")
    public ResponseEntity<Cliente> findByInfoCliente(@PathVariable("username") String username){
        Cliente cliente = customerClient.getInfoCliente(username);
        if(cliente == null){
            return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }



}
