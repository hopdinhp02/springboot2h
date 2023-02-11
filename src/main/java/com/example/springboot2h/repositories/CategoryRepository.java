package com.example.springboot2h.repositories;

import com.example.springboot2h.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
