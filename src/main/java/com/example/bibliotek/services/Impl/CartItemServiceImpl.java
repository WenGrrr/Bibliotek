package com.example.bibliotek.services.Impl;

import com.example.bibliotek.documents.*;
import com.example.bibliotek.repositories.CartItemRepository;
import com.example.bibliotek.repositories.ProductToCartItemRepository;
import com.example.bibliotek.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class CartItemServiceImpl implements CartItemService {

    @Autowired
    public CartItemRepository cartItemRepository;

    @Autowired
    private ProductToCartItemRepository productToCartItemRepository;

    @Override
    public List<CartItem> findByShoppingCart(ShopCart shopCart) {
        return cartItemRepository.findByShopCart(shopCart);
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public CartItem addProductToCartItem(Product product, User user, int qty) {
        List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());

        for (CartItem cartItem : cartItemList) {
            if(product.getId() == cartItem.getProduct().getId()) {
                cartItem.setCount(cartItem.getCount()+qty);
                cartItem.setSubtotal(product.getPrice().multiply(new BigDecimal(qty)));
                cartItemRepository.save(cartItem);
                return cartItem;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setShopCart(user.getShoppingCart());
        cartItem.setProduct(product);

        cartItem.setCount(qty);
        cartItem.setSubtotal(product.getPrice().multiply(new BigDecimal(qty)));
        cartItem = cartItemRepository.save(cartItem);

        ProductToCartItem productToCartItem = new ProductToCartItem();
        productToCartItem.setProduct(product);
        productToCartItem.setCartItem(cartItem);
        productToCartItemRepository.save(productToCartItem);

        return cartItem;
    }

    @Override
    public CartItem findById(UUID id) {
        return cartItemRepository.findById(id).get();
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        productToCartItemRepository.deleteByCartItem(cartItem);
        cartItemRepository.delete(cartItem);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> findByOrder(Order order) {
        return cartItemRepository.findByOrder(order);
    }
}
