package com.example.bibliotek.services;

import com.example.bibliotek.documents.User;

import java.util.Set;
import java.util.UUID;

public interface UserService {


    User findByUsername(String username);

    User findByEmail (String email);

    User findById(Long id);

    User createUser(User user) throws Exception;

    User save(User user);
}
