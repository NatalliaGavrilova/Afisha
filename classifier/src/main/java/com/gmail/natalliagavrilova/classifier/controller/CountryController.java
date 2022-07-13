package com.gmail.natalliagavrilova.classifier.controller;
import com.gmail.natalliagavrilova.classifier.dao.entity.Country;
import com.gmail.natalliagavrilova.classifier.dto.CountryCreate;
import com.gmail.natalliagavrilova.classifier.dto.CountryRead;
import com.gmail.natalliagavrilova.classifier.mapper.CountryMapper;
import com.gmail.natalliagavrilova.classifier.page.PageRead;
import com.gmail.natalliagavrilova.classifier.service.api.ICountryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/classifier/country")
public class CountryController {
    private final ICountryService countryService;

    public CountryController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Country create(@RequestBody CountryCreate dtoCreate) {
        return countryService.save(dtoCreate);
    }

   @GetMapping
    public ResponseEntity<PageRead<CountryRead>> getCountryPage(@RequestParam(defaultValue = "0") Integer page,
                                                                @RequestParam(defaultValue = "5") Integer size) {
       PageRequest pageRequest = PageRequest.of(page, size);

        return ResponseEntity.ok(CountryMapper.mapPage(countryService.getPage(pageRequest)));
    }

}
