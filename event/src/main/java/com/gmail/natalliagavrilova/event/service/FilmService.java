package com.gmail.natalliagavrilova.event.service;

import com.gmail.natalliagavrilova.event.dao.api.IFilmDao;
import com.gmail.natalliagavrilova.event.dao.entity.Film;
import com.gmail.natalliagavrilova.event.dto.film.FilmCreate;
import com.gmail.natalliagavrilova.event.dto.film.FilmRead;
import com.gmail.natalliagavrilova.event.mapper.FilmMapper;
import com.gmail.natalliagavrilova.event.service.api.IFilmService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FilmService implements IFilmService {

    private final IFilmDao eventDao;

    public FilmService(IFilmDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Film save(FilmCreate filmCreate) {
        Film film = FilmMapper.mapCreate(filmCreate);

        return this.eventDao.save(film);
    }


    @Override
    public List<FilmRead> getAll() {

        List<FilmRead> filmReads = new ArrayList<>();
        List<Film> films = eventDao.findAll();

        films.forEach(filmEvent -> filmReads.add(FilmMapper.mapRead(filmEvent)));

        return filmReads;
    }


    @Override
    public Page<Film> getPage(Pageable pageable) {
        return this.eventDao.findAll(pageable);
    }


    @Override
    public Film update(FilmCreate filmCreate, LocalDateTime dtUpdate, UUID uuid) {
        if (uuid == null || uuid.toString().isEmpty()) {
            throw new IllegalArgumentException("Поле uuid не может быть пустым");
        }

        if (filmCreate.getTitle() == null || filmCreate.getDescription() == null || filmCreate.getDtEvent() == null ||
                filmCreate.getDtEndOfSale() == null || filmCreate.getType() == null || filmCreate.getStatus() == null ||
                filmCreate.getCountry() == null || filmCreate.getReleaseYear() == 0 || filmCreate.getReleaseDate() == null ||
                filmCreate.getDuration() == 0
        ) {
            throw new IllegalArgumentException("Для обновления необходимо заполнить все поля");
        }

        Film filmFromDB = this.get(uuid);

        if (!filmFromDB.getDtUpdate().equals(dtUpdate)) {
            throw new IllegalArgumentException("Фильм был  обновлен кем-то ранее");
        }

        Film film = new Film();

        film.setUuid(film.getUuid());
        film.setDtCreate(filmFromDB.getDtCreate());
        film.setDtUpdate(filmFromDB.getDtUpdate());


        return this.eventDao.save(film);
    }


    @Override
    public Film get(UUID uuid) {
        if (uuid == null || uuid.toString().isEmpty()) {
            throw new IllegalArgumentException("Данное поле не может быть пустым");
        }

        return this.eventDao.findById(uuid).orElseThrow(() -> {
            throw new IllegalArgumentException("Данного фильма не существует");
        });
    }


}
