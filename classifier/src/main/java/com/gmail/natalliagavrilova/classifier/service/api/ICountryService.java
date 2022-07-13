package com.gmail.natalliagavrilova.classifier.service.api;
import com.gmail.natalliagavrilova.classifier.dao.entity.Country;
import com.gmail.natalliagavrilova.classifier.dto.CountryCreate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICountryService {

    Country save(CountryCreate dtoCreate);

    Page<Country> getPage(Pageable pageable);



}
