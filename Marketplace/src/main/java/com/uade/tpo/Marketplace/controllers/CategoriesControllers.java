package com.uade.tpo.Marketplace.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.Marketplace.entity.Category;
import com.uade.tpo.Marketplace.entity.CategoryRequest;
import com.uade.tpo.Marketplace.service.CategoryService;
import com.uade.tpo.Marketplace.exceptions.CategoryDuplicateException;
import java.util.ArrayList;
import java.util.List;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController //declaro que esta clase es un endpoint HTTP (voy a recibir trafico HTTP)
@RequestMapping("categories") // solicitud que empiece con categories

public class CategoriesControllers {

    @Autowired //es una notacion que delega al framework todo lo q tenga que ver con la inyeccion de dependencias
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById (@PathVariable Long categoryId){
        Optional<Category> result = categoryService.getCategoryById(categoryId);
        if (result.isPresent())
            return ResponseEntity.ok(result.get());
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> createCategory(@RequestBody CategoryRequest categoryRequest)
            throws CategoryDuplicateException {
        Category result = categoryService.createCategory(categoryRequest.getDescription());
        return ResponseEntity.created(URI.create("/categories/" + result.getId())).body(result);
    }
    
}
