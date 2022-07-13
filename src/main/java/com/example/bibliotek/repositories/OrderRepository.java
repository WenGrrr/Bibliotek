package com.example.bibliotek.repositories;

import com.example.bibliotek.documents.CartItem;
import com.example.bibliotek.documents.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrderRepository extends MongoRepository<Order, UUID> {
}
