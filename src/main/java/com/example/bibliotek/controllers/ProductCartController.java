package com.example.bibliotek.controllers;

import com.example.bibliotek.documents.Product;
import com.example.bibliotek.documents.ProductCart;
import com.example.bibliotek.services.ProductCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductCartController {

    ProductCartService productCartService;

    public ProductCartController(ProductCartService productCartService) {
        this.productCartService = productCartService;
    }

    @GetMapping("/cart")
    public String Controller(Model model){
        ProductCart productCart = productCartService.setProductCart();
        model.addAttribute("cart",productCart);
        return "cart";
    }

    @GetMapping("/cart/{id}")
    public String getCart(@PathVariable UUID id, Model model){
        model.addAttribute("product", productCartService.getAllProductCart(id));
        return "cart";
    }

    @PostMapping ("/cart/add")
    public String addProduct(UUID productId, int count, @PathVariable UUID cartId){
        productCartService.addProductToCart(productId,count,cartId);
        return "redirect:/cart";
    }
    @PostMapping ("/cart/delete")
    public String deleteProduct(UUID productId,  @PathVariable UUID cartId){
        productCartService.deleteProductInCart(productId,cartId);
        return "redirect:/cart";
    }
}
