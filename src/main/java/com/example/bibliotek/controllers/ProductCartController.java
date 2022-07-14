package com.example.bibliotek.controllers;

import com.example.bibliotek.documents.CartItem;
import com.example.bibliotek.documents.Product;
import com.example.bibliotek.documents.ShopCart;
import com.example.bibliotek.documents.User;
import com.example.bibliotek.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductCartController {
    @Autowired
    private UserService userService;


    private CartItemService cartItemService;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductCartService productCartService;


    @RequestMapping("/cart")
    public String shopcart(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShopCart shopCart = user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shopCart);

        productCartService.updateShoppingCart(shopCart);

        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("shopCart", shopCart);

        return "shopCart";
    }

    @RequestMapping("/addItem")
    public String addItem(
            @ModelAttribute("product") Product product,
            @ModelAttribute("productCount") String productCount,
            Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        product = productsService.getProductByID(product.getId());
        if (Integer.parseInt(productCount) > product.getCount()) {
            model.addAttribute("notEnoughStock", true);
            return "forward:/bookDetail?id="+product.getId();
        }
        CartItem cartItem = cartItemService.addProductToCartItem(product, user, Integer.parseInt(productCount));
        model.addAttribute("addBookSuccess", true);
        return "forward:/bookDetail?id="+product.getId();
    }

    @RequestMapping("/updateCartItem")
    public String updateShoppingCart(
            @ModelAttribute("id") UUID cartItemId,
            @ModelAttribute("productCount") int productCount) {
        CartItem cartItem = cartItemService.findById(cartItemId);
        cartItem.setCount(productCount);
        cartItemService.updateCartItem(cartItem);
        return "forward:/shoppingCart/cart";
    }

    @RequestMapping("/removeItem")
    public String removeItem(@RequestParam("id") UUID id) {
        cartItemService.removeCartItem(cartItemService.findById(id));
        return "forward:/shoppingCart/cart";
    }

}

