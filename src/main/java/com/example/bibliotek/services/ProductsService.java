package com.example.bibliotek.services;

import com.example.bibliotek.documents.Product;
import com.example.bibliotek.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.*;


public interface ProductsService {
    List<Product> getAllProducts();
    Product getProductByID(UUID uuid);
    void createProduct(Product product);
    void deleteProduct(UUID uuid);
    void clearProducts();

}
