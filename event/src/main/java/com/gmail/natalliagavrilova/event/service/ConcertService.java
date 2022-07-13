package com.gmail.natalliagavrilova.event.service;

import com.gmail.natalliagavrilova.event.dao.api.IConcertDao;
import com.gmail.natalliagavrilova.event.dao.entity.Concert;
import com.gmail.natalliagavrilova.event.dto.concert.ConcertCreate;
import com.gmail.natalliagavrilova.event.dto.concert.ConcertRead;
import com.gmail.natalliagavrilova.event.mapper.ConcertMapper;
import com.gmail.natalliagavrilova.event.service.api.IConcertService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ConcertService implements IConcertService {
    private final IConcertDao concertDao;

    public ConcertService(IConcertDao concertDao) {
        this.concertDao = concertDao;
    }


    @Override
    public Concert save(ConcertCreate concertCreate) {
        Concert concert = ConcertMapper.mapCreate(concertCreate);

        return this.concertDao.save(concert);
    }

    @Override
    public Concert update(ConcertCreate concertCreate, LocalDateTime dtUpdate, UUID uuid) {
        return null;
    }

    @Override
    public List<ConcertRead> getAll() {
        List<ConcertRead> concertReads = new ArrayList<>();
        List<Concert> concerts = concertDao.findAll();

        concerts.forEach(concert -> concertReads.add(ConcertMapper.mapRead(concert)));

        return concertReads;

    }

    @Override
    public Concert get(UUID uuid) {
        if (uuid == null || uuid.toString().isEmpty()) {
            throw new IllegalArgumentException("Данное поле не может быть пустым");
        }

        return this.concertDao.findById(uuid).orElseThrow(() -> {
            throw new IllegalArgumentException("Данного концерта не существует");
        });
    }

    @Override
    public Page<Concert> getPage(Pageable pageable) {
        return this.concertDao.findAll(pageable);
    }
}
