package com.example.bibliotek.services;

import com.example.bibliotek.documents.Product;
import com.example.bibliotek.documents.ProductCart;

import java.util.Set;
import java.util.UUID;

public interface ProductCartService {

    void addProductToCart(UUID productId, int i, UUID cartId);
    ProductCart getProductCart(UUID uuid);
    ProductCart setProductCart();
    void deleteProductInCart(UUID productId,UUID cartId);
    Set<Product> getAllProductCart(UUID uuid);
    double getFullPrice(UUID uuid);
}
