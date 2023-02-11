package com.example.springboot2h.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private int _year;
    private double price;
    private String url;
    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String productName, int _year, double price, String url) {
        this.productName = productName;
        this._year = _year;
        this.price = price;
        this.url = url;
    }
}
