package com.example.bibliotek.repositories;

import com.example.bibliotek.documents.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface RoleRepository extends MongoRepository<Role, UUID> {

}
