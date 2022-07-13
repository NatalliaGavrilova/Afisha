package com.gmail.natalliagavrilova.classifier.controller;

import com.gmail.natalliagavrilova.classifier.dao.entity.Category;
import com.gmail.natalliagavrilova.classifier.dto.CategoryCreate;
import com.gmail.natalliagavrilova.classifier.dto.CategoryRead;
import com.gmail.natalliagavrilova.classifier.mapper.CategoryMapper;
import com.gmail.natalliagavrilova.classifier.page.PageRead;
import com.gmail.natalliagavrilova.classifier.service.api.ICategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/classifier/concert/category")
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody CategoryCreate categoryCreate) {
        return categoryService.save(categoryCreate);
    }

    @GetMapping
    public ResponseEntity<PageRead<CategoryRead>> getCategoryPage(@RequestParam(defaultValue = "0") Integer page,
                                                                 @RequestParam(defaultValue = "5") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return ResponseEntity.ok(CategoryMapper.mapPage(categoryService.getPage(pageRequest)));
    }

}
