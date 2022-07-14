package com.example.bibliotek.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserLoginService {
    UserDetails loadUserByUsername(String var1);
}
