package com.example.bibliotek.services;

import com.example.bibliotek.documents.Product;
import com.example.bibliotek.documents.ShopCart;

import java.util.Set;
import java.util.UUID;

public interface ProductCartService {

    void addProductToCart(UUID productId, int i, UUID cartId);
    ShopCart getProductCart(UUID uuid);
    ShopCart setProductCart();
    void deleteProductInCart(UUID productId,UUID cartId);
    Set<Product> getAllProductCart(UUID uuid);
    double getFullPrice(UUID uuid);
}
