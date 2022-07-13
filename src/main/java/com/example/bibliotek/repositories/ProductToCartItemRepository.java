package com.example.bibliotek.repositories;

import com.example.bibliotek.documents.CartItem;
import com.example.bibliotek.documents.ProductToCartItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProductToCartItemRepository extends MongoRepository<ProductToCartItem, UUID> {
    void deleteByCartItem(CartItem cartItem);
}
