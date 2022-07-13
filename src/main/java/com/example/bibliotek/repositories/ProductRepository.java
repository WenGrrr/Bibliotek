package com.example.bibliotek.repositories;

import com.example.bibliotek.documents.Manufacturer;
import com.example.bibliotek.documents.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Set;
import java.util.UUID;

public interface ProductRepository extends MongoRepository<Product, UUID> {
    Set<Product> findProductByManufacturerId(Manufacturer manufacturerId);

}
