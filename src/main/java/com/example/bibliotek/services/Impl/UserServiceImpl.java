package com.example.bibliotek.services.Impl;

import com.example.bibliotek.documents.User;
import com.example.bibliotek.repositories.ShopCartRepository;
import com.example.bibliotek.repositories.UserRepository;
import com.example.bibliotek.services.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ShopCartRepository shopCartRepository;

    public UserServiceImpl(UserRepository userRepository, ShopCartRepository shopCartRepository) {
        this.userRepository = userRepository;
        this.shopCartRepository = shopCartRepository;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(UUID id) {
        return null;
    }

    @Override
    public User createUser(User user) throws Exception {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
