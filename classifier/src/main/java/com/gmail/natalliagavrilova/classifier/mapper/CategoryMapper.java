package com.gmail.natalliagavrilova.classifier.mapper;

import com.gmail.natalliagavrilova.classifier.dao.entity.Category;
import com.gmail.natalliagavrilova.classifier.dao.entity.Country;
import com.gmail.natalliagavrilova.classifier.dto.CategoryCreate;
import com.gmail.natalliagavrilova.classifier.dto.CategoryRead;
import com.gmail.natalliagavrilova.classifier.dto.CountryRead;
import com.gmail.natalliagavrilova.classifier.page.PageRead;
import com.gmail.natalliagavrilova.classifier.service.api.ICategoryService;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CategoryMapper {

    private final ICategoryService categoryService;

    public CategoryMapper(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public static Category mapCreate(CategoryCreate categoryCreate) {
        Category category = new Category();
        category.setDtCreate(LocalDateTime.now());
        category.setDtUpdate(LocalDateTime.now());
        category.setUuid(UUID.randomUUID());
        category.setTitle(categoryCreate.getTitle());

        return category;
    }

    public static CategoryRead mapRead(Category category) {
        CategoryRead categoryRead = new CategoryRead();

        categoryRead.setDtCreate(category.getDtCreate());
        categoryRead.setDtUpdate(category.getDtUpdate());
        categoryRead.setUuid(category.getUuid());
        categoryRead.setTitle(category.getTitle());

        return categoryRead;
    }

    public static PageRead<CategoryRead> mapPage(Page<Category> page) {

        PageRead<CategoryRead> pageDto = new PageRead<>();
        List<CategoryRead> contentDto = new ArrayList<>();

        for (Category category : page.getContent()) {

            contentDto.add(mapRead(category));
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