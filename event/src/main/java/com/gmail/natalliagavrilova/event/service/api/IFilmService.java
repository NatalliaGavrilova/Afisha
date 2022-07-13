package com.gmail.natalliagavrilova.event.service.api;

import com.gmail.natalliagavrilova.event.dao.entity.Film;
import com.gmail.natalliagavrilova.event.dto.film.FilmCreate;
import com.gmail.natalliagavrilova.event.dto.film.FilmRead;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IFilmService {

    Film save(FilmCreate filmCreate);

    Film update(FilmCreate filmCreate, LocalDateTime dtUpdate, UUID uuid);

    List<FilmRead> getAll();


    Film get(UUID uuid);

    Page<Film> getPage(Pageable pageable);

}
