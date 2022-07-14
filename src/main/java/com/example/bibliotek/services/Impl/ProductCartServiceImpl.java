package com.example.bibliotek.services.Impl;

import com.example.bibliotek.documents.CartItem;
import com.example.bibliotek.documents.Product;
import com.example.bibliotek.documents.ShopCart;
import com.example.bibliotek.repositories.CartItemRepository;
import com.example.bibliotek.repositories.ShopCartRepository;
import com.example.bibliotek.repositories.ProductRepository;
import com.example.bibliotek.services.CartItemService;
import com.example.bibliotek.services.ProductCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
@Service
public class ProductCartServiceImpl implements ProductCartService {
    @Autowired
    private ShopCartRepository shopCartRepository;

    private CartItemService cartItemService;

    public ProductCartServiceImpl(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @Override
    public ShopCart updateShoppingCart(ShopCart shopCart) {
        BigDecimal cartTotal = new BigDecimal(0);

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shopCart);

        for (CartItem cartItem : cartItemList) {
            if(cartItem.getProduct().getCount() > 0) {
                cartItemService.updateCartItem(cartItem);
                cartTotal = cartTotal.add(cartItem.getSubtotal());
            }
        }

        shopCart.setGrandTotal(cartTotal);

        shopCartRepository.save(shopCart);

        return shopCart;
    }

}
