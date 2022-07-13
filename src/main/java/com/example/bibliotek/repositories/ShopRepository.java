package com.example.bibliotek.repositories;

import com.example.bibliotek.documents.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ShopRepository extends MongoRepository<Shop, UUID> {
}
