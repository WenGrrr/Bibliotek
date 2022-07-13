package com.example.bibliotek.services;

import com.example.bibliotek.documents.Product;
import com.example.bibliotek.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductsService{

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productsRepository) {
        productRepository = productsRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProductByID(UUID uuid){
        return  productRepository.findById(uuid).get();
    }
    public void createProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(UUID uuid){
        productRepository.delete(getProductByID(uuid));
    }
    public void clearProducts(){
        productRepository.deleteAll();
    }
}
