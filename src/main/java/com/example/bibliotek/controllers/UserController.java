package com.example.bibliotek.controllers;

import com.example.bibliotek.documents.Product;
import com.example.bibliotek.documents.User;
import com.example.bibliotek.repositories.*;
import com.example.bibliotek.services.ProductCartService;
import com.example.bibliotek.services.ProductsService;
import com.example.bibliotek.services.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserService userService;
    private ProductCartService productCartService;
    private ProductsService productService;


    @GetMapping("/")
    public String productsController(Model model, Principal principal){
        List<Product> products = new ArrayList<>(productService.getAllProducts());
        userService.
        productCartService.
        model.addAttribute("products", products);
        return "products";
    }
}
