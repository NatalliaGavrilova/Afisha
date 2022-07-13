package com.gmail.natalliagavrilova.event.service;

import com.gmail.natalliagavrilova.event.dao.entity.Concert;
import com.gmail.natalliagavrilova.event.dao.entity.Film;
import com.gmail.natalliagavrilova.event.dto.concert.ConcertCreate;
import com.gmail.natalliagavrilova.event.dto.concert.ConcertRead;
import com.gmail.natalliagavrilova.event.service.api.IConcertService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ConcertService implements IConcertService {

    @Override
    public Concert save(ConcertCreate concertCreate) {
        return null;
    }

    @Override
    public Concert update(ConcertCreate concertCreate, LocalDateTime dtUpdate, UUID uuid) {
        return null;
    }

    @Override
    public List<ConcertRead> getAll() {
        return null;
    }

    @Override
    public Concert get(UUID uuid) {
        return null;
    }

    @Override
    public Page<Concert> getPage(Pageable pageable) {
        return null;
    }
}
