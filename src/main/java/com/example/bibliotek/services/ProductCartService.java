package com.example.bibliotek.services;

import com.example.bibliotek.documents.Product;
import com.example.bibliotek.documents.ShopCart;

import java.util.Set;
import java.util.UUID;

public interface ProductCartService {

    ShopCart updateShoppingCart(ShopCart shopCart);
}
