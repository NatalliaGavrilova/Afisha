package com.gmail.natalliagavrilova.classifier.dao.api;

import com.gmail.natalliagavrilova.classifier.dao.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface ICountryDao extends JpaRepository<Country, Long> {

}
