package com.gmail.natalliagavrilova.event.dao.api;

import com.gmail.natalliagavrilova.event.dao.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IConcertDao extends JpaRepository<Concert, UUID> {
}
