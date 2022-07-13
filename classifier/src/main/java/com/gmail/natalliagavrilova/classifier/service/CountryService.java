package com.gmail.natalliagavrilova.classifier.service;

import com.gmail.natalliagavrilova.classifier.dao.api.ICountryDao;
import com.gmail.natalliagavrilova.classifier.dao.entity.Country;
import com.gmail.natalliagavrilova.classifier.dto.CountryCreate;
import com.gmail.natalliagavrilova.classifier.mapper.CountryMapper;
import com.gmail.natalliagavrilova.classifier.service.api.ICountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CountryService implements ICountryService {

    private final ICountryDao countryDao;

    public CountryService(ICountryDao countryDao) {
        this.countryDao = countryDao;
    }


    @Override
    public Country save(CountryCreate dtoCreate) {

        Country country = CountryMapper.mapCreate(dtoCreate);
        if (country.getUuid() == null) {
            throw new IllegalArgumentException("Это поле не может быть пустым");
        }

        return this.countryDao.save(country);
    }

    @Override
    public Page<Country> getPage(Pageable pageable) {
        return this.countryDao.findAll(pageable);
    }


}
