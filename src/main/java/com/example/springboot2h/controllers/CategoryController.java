package com.example.springboot2h.controllers;

import com.example.springboot2h.models.Category;
import com.example.springboot2h.models.Product;
import com.example.springboot2h.models.ResponseObject;
import com.example.springboot2h.repositories.CategoryRepository;
import com.example.springboot2h.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/Categories")
public class CategoryController {
    @Autowired
    private CategoryRepository repository;

    @GetMapping("")
    List<Category> getAllCategories() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Category> foundProduct = repository.findById(id);
        return foundProduct.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query product successfull", foundProduct)
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false", "Cannot find product with id = " + id, ""
                ));

    }
}
