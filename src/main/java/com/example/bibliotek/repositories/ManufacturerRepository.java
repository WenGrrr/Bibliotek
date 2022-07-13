package com.example.bibliotek.repositories;

import com.example.bibliotek.documents.Manufacturer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ManufacturerRepository extends MongoRepository<Manufacturer, UUID> {
}
