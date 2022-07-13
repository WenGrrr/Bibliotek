package com.example.bibliotek.services;

import com.example.bibliotek.documents.Order;
import com.example.bibliotek.documents.ShopCart;
import com.example.bibliotek.documents.User;

import java.util.UUID;

public interface OrderService {
    Order createOrder(ShopCart shoppingCart, User user);

    Order findById(UUID id);
}
