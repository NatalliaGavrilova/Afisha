
package com.gmail.natalliagavrilova.classifier.service;

import com.gmail.natalliagavrilova.classifier.dao.api.ICategoryDao;
import com.gmail.natalliagavrilova.classifier.dao.entity.Category;
import com.gmail.natalliagavrilova.classifier.dto.CategoryCreate;
import com.gmail.natalliagavrilova.classifier.mapper.CategoryMapper;
import com.gmail.natalliagavrilova.classifier.service.api.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CategoryService implements ICategoryService {

    private final ICategoryDao categoryDao;

    public CategoryService(ICategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @Override
    public Category save(CategoryCreate categoryCreate) {
        Category category = CategoryMapper.mapCreate(categoryCreate);
        if (category.getUuid() == null) {
            throw new IllegalArgumentException("Это поле не может быть пустым");
        }

        return this.categoryDao.save(category);
    }

    @Override
    public Page<Category> getPage(Pageable pageable) {
        return categoryDao.findAll(pageable);
    }

}