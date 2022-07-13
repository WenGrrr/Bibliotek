package com.example.bibliotek.repositories;

import com.example.bibliotek.documents.ShopCart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ShopCartRepository extends MongoRepository<ShopCart, UUID> {
}
