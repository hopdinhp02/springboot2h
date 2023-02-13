package com.example.springboot2h.controllers;

import com.example.springboot2h.models.Product;
import com.example.springboot2h.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private ProductRepository repository;
    @GetMapping("/") // Nếu người dùng request tới địa chỉ "/"
    String dasfda(){
        return "index.html";
    }
    @GetMapping("/ddd") // Nếu người dùng request tới địa chỉ "/"
    String ddd(){
        return "login.html";
    }

    @GetMapping("/dđ") // Nếu người dùng request tới địa chỉ "/"
    String xxx(){
        return "index.html";
    }
}
