package com.gmail.natalliagavrilova.classifier.mapper;

import com.gmail.natalliagavrilova.classifier.dao.entity.Country;
import com.gmail.natalliagavrilova.classifier.dto.CountryCreate;
import com.gmail.natalliagavrilova.classifier.dto.CountryRead;
import com.gmail.natalliagavrilova.classifier.page.PageRead;
import com.gmail.natalliagavrilova.classifier.service.api.ICountryService;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CountryMapper {

    private final ICountryService filmService;

    public CountryMapper(ICountryService filmService) {
        this.filmService = filmService;
    }

// на создание
    public static Country mapCreate(CountryCreate countryCreate) {
        Country country = new Country();
        country.setDtCreate(LocalDateTime.now());
        country.setDtUpdate(LocalDateTime.now());
        country.setUuid(UUID.randomUUID());
        country.setDescription(countryCreate.getDescription());
        country.setTitle(countryCreate.getTitle());

        return country;
    }

// на получение получение
    public static CountryRead mapRead(Country country){
        CountryRead countryRead = new CountryRead();

        countryRead.setDtCreate(country.getDtCreate());
        countryRead.setDtUpdate(country.getDtUpdate());
        countryRead.setUuid(country.getUuid());
        countryRead.setTitle(country.getTitle());
        countryRead.setDescription(country.getDescription());


        return countryRead;
    }


    public static PageRead<CountryRead> mapPage(Page<Country> page){

        PageRead<CountryRead> pageDto = new PageRead<>();
        List<CountryRead> contentDto = new ArrayList<>();

        for (Country country : page.getContent()) {

            contentDto.add(mapRead(country));
        }
        pageDto.setNumber(page.getNumber());
        pageDto.setSize(page.getSize());
        pageDto.setSize(page.getTotalPages());
        pageDto.setFirst(page.isFirst());
        pageDto.setNumberOfElements(page.getNumberOfElements());
        pageDto.setLast(page.isLast());
        pageDto.setContent(contentDto);

        return pageDto;
    }
}
