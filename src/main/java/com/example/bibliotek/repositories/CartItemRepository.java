package com.example.bibliotek.repositories;

import com.example.bibliotek.documents.CartItem;
import com.example.bibliotek.documents.Order;
import com.example.bibliotek.documents.ShopCart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface CartItemRepository extends MongoRepository<CartItem, UUID> {
    List<CartItem> findByShopCart(ShopCart shopCart);
    List<CartItem> findByOrder(Order order);
}
