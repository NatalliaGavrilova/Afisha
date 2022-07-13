package com.gmail.natalliagavrilova.event.dao.api;

import com.gmail.natalliagavrilova.event.dao.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IEventDao extends JpaRepository<Film, UUID> {


}
