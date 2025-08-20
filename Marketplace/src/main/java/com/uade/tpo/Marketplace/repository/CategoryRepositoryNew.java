package com.uade.tpo.Marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uade.tpo.Marketplace.entity.Category;

@Repository
public interface CategoryRepositoryNew extends JpaRepository <Category, Long>{

}