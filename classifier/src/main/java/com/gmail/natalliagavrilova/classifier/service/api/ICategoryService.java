package com.gmail.natalliagavrilova.classifier.service.api;

import com.gmail.natalliagavrilova.classifier.dao.entity.Category;
import com.gmail.natalliagavrilova.classifier.dao.entity.Country;
import com.gmail.natalliagavrilova.classifier.dto.CategoryCreate;
import com.gmail.natalliagavrilova.classifier.dto.CategoryRead;
import com.gmail.natalliagavrilova.classifier.dto.CountryCreate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICategoryService {

    Category save(CategoryCreate categoryCreate);


    Page<Category> getPage(Pageable pageable);


}
