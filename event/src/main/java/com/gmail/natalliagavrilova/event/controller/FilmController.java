package com.gmail.natalliagavrilova.event.controller;

import com.gmail.natalliagavrilova.event.dao.entity.Film;
import com.gmail.natalliagavrilova.event.dto.film.FilmCreate;
import com.gmail.natalliagavrilova.event.dto.film.FilmRead;
import com.gmail.natalliagavrilova.event.mapper.FilmMapper;
import com.gmail.natalliagavrilova.event.page.PageRead;
import com.gmail.natalliagavrilova.event.service.api.IFilmService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/afisha/event/film")
public class FilmController {
    {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    private final IFilmService filmService;

    public FilmController(IFilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Film create(@RequestBody FilmCreate filmCreate) {
        return filmService.save(filmCreate);
    }

    @GetMapping
    public ResponseEntity<PageRead<FilmRead>> getFilmPage(@RequestParam(defaultValue = "0") Integer page,
                                                          @RequestParam(defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return ResponseEntity.ok(FilmMapper.mapPage(filmService.getPage(pageRequest)));
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<FilmRead> get(@PathVariable UUID uuid) {

        return ResponseEntity.ok(FilmMapper.mapRead(filmService.get(uuid)));
    }


    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public Film update(@PathVariable UUID uuid,
                       @RequestBody FilmCreate film,
                       @PathVariable Long dt_update) {
        LocalDateTime lastKnowDtUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(dt_update), ZoneId.systemDefault());


        return this.filmService.update(film, lastKnowDtUpdate,uuid);
    }
}
