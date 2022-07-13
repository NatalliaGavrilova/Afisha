package com.gmail.natalliagavrilova.event.mapper;

import com.gmail.natalliagavrilova.event.dao.entity.Film;
import com.gmail.natalliagavrilova.event.dto.film.FilmCreate;
import com.gmail.natalliagavrilova.event.dto.film.FilmRead;
import com.gmail.natalliagavrilova.event.page.PageRead;
import com.gmail.natalliagavrilova.event.service.api.IFilmService;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FilmMapper {

    private final IFilmService filmService;

    public FilmMapper(IFilmService filmService) {
        this.filmService = filmService;
    }

    public static Film mapCreate(FilmCreate filmCreate) {

        Film film = new Film();
        film.setUuid(UUID.randomUUID());
        film.setDtCreate(LocalDateTime.now());
        film.setDtUpdate(LocalDateTime.now());
        film.setTitle(filmCreate.getTitle());
        film.setDtEvent(filmCreate.getDtEvent());
        film.setDuration((int) filmCreate.getDuration());
        film.setStatus(filmCreate.getStatus());
        film.setReleaseDate(filmCreate.getReleaseDate());
        film.setReleaseYear((int) filmCreate.getReleaseYear());
        film.setType(filmCreate.getType());
        film.setStatus(filmCreate.getStatus());
        film.setCountry(filmCreate.getCountry());
        film.setDescription(filmCreate.getDescription());

        return film;

    }

    public static FilmRead mapRead(Film film) {
        return FilmRead.create().setDtCreate(film.getDtCreate())
                .setDtUpdate(film.getDtUpdate())
                .setTitle(film.getTitle()).setDtEvent(film.getDtEvent())
                .setStatus(film.getStatus())
                .setUuid(film.getUuid())
                .setDescription(film.getDescription()).setDtEndOfSale(film.getDtEndOfSale())
                .setType(film.getType()).build();
    }

    public static PageRead<FilmRead> mapPage(Page<Film> page) {
        PageRead<FilmRead> pageDto = new PageRead<>();
        List<FilmRead> contentDto = new ArrayList<>();

        for (Film film : page.getContent()) {
            contentDto.add(mapRead(film));
        }

        pageDto.setNumber(page.getNumber());
        pageDto.setSize(page.getSize());
        pageDto.setSize(page.getTotalPages());
        pageDto.setFirst(page.isFirst());
        pageDto.setNumberOfElements(page.getNumberOfElements());
        pageDto.setLast(page.isLast());
        pageDto.setContent(contentDto);

        return pageDto;
    }




}