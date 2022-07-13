package com.gmail.natalliagavrilova.event.service.api;

import com.gmail.natalliagavrilova.event.dao.entity.Concert;
import com.gmail.natalliagavrilova.event.dao.entity.Film;
import com.gmail.natalliagavrilova.event.dto.concert.ConcertCreate;
import com.gmail.natalliagavrilova.event.dto.concert.ConcertRead;
import com.gmail.natalliagavrilova.event.dto.film.FilmCreate;
import com.gmail.natalliagavrilova.event.dto.film.FilmRead;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IConcertService {
    Concert save(ConcertCreate concertCreate);

    Concert update(ConcertCreate concertCreate, LocalDateTime dtUpdate, UUID uuid);

    List<ConcertRead> getAll();


    Concert get(UUID uuid);

    Page<Concert> getPage(Pageable pageable);
}
