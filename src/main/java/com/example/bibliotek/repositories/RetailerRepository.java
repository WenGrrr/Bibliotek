package com.example.bibliotek.repositories;

import com.example.bibliotek.documents.Retailer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface RetailerRepository  extends MongoRepository<Retailer, UUID> {
}
