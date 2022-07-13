package com.example.bibliotek.services;

import com.example.bibliotek.documents.Product;
import com.example.bibliotek.documents.ProductCart;
import com.example.bibliotek.repositories.ProductCartRepository;
import com.example.bibliotek.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
@Service
public class ProductCartServiceImpl implements ProductCartService{
    @Autowired
    private ProductCartRepository productCartRepository;
    @Autowired
    public ProductRepository productRepository;

    public ProductCartServiceImpl(ProductCartRepository productCartRepository, ProductRepository productRepository) {
        this.productCartRepository = productCartRepository;
        this.productRepository = productRepository;
    }
    @Override
    public void addProductToCart(UUID productId, int i, UUID cartId){
        for (int j = 0; j < i; j++) {
            productCartRepository.findById(cartId).get().addProduct(productRepository.findById(productId).get());
        }
    }

    @Override
    public ProductCart getProductCart(UUID uuid) {
        return productCartRepository.findById(uuid).get();
    }

    @Override
    public ProductCart setProductCart() {
        ProductCart productCart = new ProductCart();
        productCart.getProducts();
        productCart.setId(UUID.randomUUID());
        productCart.setDate(LocalDateTime.now());
        return productCart;
    }
    @Override
    public void deleteProductInCart(UUID productId, UUID cartId){
            var products = getAllProductCart(cartId);
        for (Product product: products) {
            if(product.getId() == productId){
                products.remove(product);
            }
        }
    }

    @Override
    public Set<Product> getAllProductCart(UUID uuid){
        return productCartRepository.findById(uuid).get().getProducts();
    }
    @Override
    public double getFullPrice(UUID uuid){
        double result = 0.0;
        var products = getAllProductCart(uuid);
        for (Product product: products) {
            if(product.getPrice() != null)
                result += product.getPrice().doubleValue();
        }
        return  result;
    }

}
