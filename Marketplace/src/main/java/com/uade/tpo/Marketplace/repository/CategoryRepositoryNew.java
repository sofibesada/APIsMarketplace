package com.uade.tpo.Marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uade.tpo.Marketplace.entity.Category;

@Repository
public interface CategoryRepositoryNew extends JpaRepository <Category, Long>{
    @Query(value = "select c from Category c where c.description =?1") //query de sql pero para jpa (q busque y devuelva lista conx descripcion)
    List<Category> findByDescription(String description);
}