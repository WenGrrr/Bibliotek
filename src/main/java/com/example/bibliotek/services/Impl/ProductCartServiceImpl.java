package com.example.bibliotek.services.Impl;

import com.example.bibliotek.documents.Product;
import com.example.bibliotek.documents.ShopCart;
import com.example.bibliotek.repositories.ShopCartRepository;
import com.example.bibliotek.repositories.ProductRepository;
import com.example.bibliotek.services.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
@Service
public class ProductCartServiceImpl implements ProductCartService {
    @Autowired
    private ShopCartRepository shopCartRepository;
    @Autowired
    public ProductRepository productRepository;

    public ProductCartServiceImpl(ShopCartRepository shopCartRepository, ProductRepository productRepository) {
        this.shopCartRepository = shopCartRepository;
        this.productRepository = productRepository;
    }
    @Override
    public void addProductToCart(UUID productId, int i, UUID cartId){
        for (int j = 0; j < i; j++) {
            shopCartRepository.findById(cartId).get().addProduct(productRepository.findById(productId).get());
        }
    }

    @Override
    public ShopCart getProductCart(UUID uuid) {
        return shopCartRepository.findById(uuid).get();
    }

    @Override
    public ShopCart setProductCart() {
        ShopCart shopCart = new ShopCart();
        shopCart.getProducts();
        shopCart.setId(UUID.randomUUID());
        shopCart.setDate(LocalDateTime.now());
        return shopCart;
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
        return shopCartRepository.findById(uuid).get().getProducts();
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
