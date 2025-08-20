package com.uade.tpo.Marketplace.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.uade.tpo.Marketplace.entity.Category;
import com.uade.tpo.Marketplace.exceptions.CategoryDuplicateException;

public interface CategoryService {
    public List<Category> getCategories();

    public Optional<Category> getCategoryById(Long categoryId);

    public Category createCategory (String description) throws CategoryDuplicateException;
}

