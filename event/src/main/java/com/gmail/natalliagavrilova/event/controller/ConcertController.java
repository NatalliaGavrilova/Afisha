package com.gmail.natalliagavrilova.event.controller;

import com.gmail.natalliagavrilova.event.dao.entity.Concert;
import com.gmail.natalliagavrilova.event.dao.entity.Film;
import com.gmail.natalliagavrilova.event.dto.concert.ConcertCreate;
import com.gmail.natalliagavrilova.event.dto.film.FilmCreate;
import com.gmail.natalliagavrilova.event.service.api.IConcertService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.TimeZone;

public class ConcertController {
    {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    private final IConcertService concertService;

    public ConcertController(IConcertService concertService) {
        this.concertService = concertService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Concert create(@RequestBody ConcertCreate concertCreate) {
        return concertService.save(concertCreate);
    }
}
