package com.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
