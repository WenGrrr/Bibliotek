package com.example.bibliotek.repositories;

import com.example.bibliotek.documents.ProductCart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProductCartRepository  extends MongoRepository<ProductCart, UUID> {
}
