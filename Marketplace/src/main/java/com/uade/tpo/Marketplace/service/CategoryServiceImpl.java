package com.uade.tpo.Marketplace.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.tpo.Marketplace.entity.Category;
import com.uade.tpo.Marketplace.exceptions.CategoryDuplicateException;
import com.uade.tpo.Marketplace.repository.CategoryRepositoryNew;

@Service  //bins --> contenedor de dependencias
public class CategoryServiceImpl implements CategoryService { //solo JAVA, no usa librerias, hay que hacer código

    @Autowired
    private CategoryRepositoryNew categoryRepository;


    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }


    public Optional<Category> getCategoryById(Long categoryId) {
        
        return categoryRepository.findById(categoryId);
    }


    
    public Category createCategory(String description) throws CategoryDuplicateException {
        List<Category> categories = categoryRepository.findAll();
        if (categories.stream().anyMatch (
                category -> category.getDescription().equals(description)))
            throw new CategoryDuplicateException();
        return categoryRepository.save(new Category(description));
    }

}
