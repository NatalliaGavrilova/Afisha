package com.gmail.natalliagavrilova.event.controller;

import com.gmail.natalliagavrilova.event.dao.entity.Concert;
import com.gmail.natalliagavrilova.event.dto.concert.ConcertCreate;
import com.gmail.natalliagavrilova.event.dto.concert.ConcertRead;
import com.gmail.natalliagavrilova.event.dto.film.FilmRead;
import com.gmail.natalliagavrilova.event.mapper.ConcertMapper;
import com.gmail.natalliagavrilova.event.mapper.FilmMapper;
import com.gmail.natalliagavrilova.event.page.PageRead;
import com.gmail.natalliagavrilova.event.service.api.IConcertService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.TimeZone;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<PageRead<ConcertRead>> getConcertPage(@RequestParam(defaultValue = "0") Integer page,
                                                                     @RequestParam(defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return ResponseEntity.ok(ConcertMapper.mapPage(concertService.getPage(pageRequest)));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ConcertRead> get(@PathVariable UUID uuid) {

        return ResponseEntity.ok(ConcertMapper.mapRead(concertService.get(uuid)));
    }

}
