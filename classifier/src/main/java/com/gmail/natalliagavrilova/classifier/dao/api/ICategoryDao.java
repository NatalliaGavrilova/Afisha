package com.gmail.natalliagavrilova.classifier.dao.api;

import com.gmail.natalliagavrilova.classifier.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryDao extends JpaRepository<Category, Long> {


}
