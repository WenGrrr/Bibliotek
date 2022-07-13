package com.example.bibliotek.services;

import com.example.bibliotek.documents.*;

import java.util.List;
import java.util.UUID;

public interface CartItemService {

    List<CartItem> findByShoppingCart(ShopCart shoppingCart);

    CartItem updateCartItem(CartItem cartItem);

    CartItem addProductToCartItem(Product product, User user, int qty);

    CartItem findById(UUID id);

    void removeCartItem(CartItem cartItem);

    CartItem save(CartItem cartItem);

    List<CartItem> findByOrder(Order order);
}
