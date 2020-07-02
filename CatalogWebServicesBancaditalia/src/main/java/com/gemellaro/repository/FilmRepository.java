package com.gemellaro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gemellaro.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {

    Film findById(int id);
}
