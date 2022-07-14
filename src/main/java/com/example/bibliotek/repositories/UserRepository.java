package com.example.bibliotek.repositories;

import com.example.bibliotek.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends MongoRepository<User, UUID> {
    List<User> findByEmailStartsWith(@Param("email") String email);
    User findByUsername(String username);
}