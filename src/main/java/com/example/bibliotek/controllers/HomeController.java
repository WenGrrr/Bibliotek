package com.example.bibliotek.controllers;

import com.example.bibliotek.documents.Product;
import com.example.bibliotek.documents.User;
import com.example.bibliotek.services.ProductsService;
import com.example.bibliotek.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductsService productsService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {

        return "myAccount";
    }

    @RequestMapping("/product")
    public String productDetail(
            @PathParam("id") UUID id, Model model, Principal principal) {
        if(principal != null) {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }

        Product product = productsService.getProductByID(id);

        model.addAttribute("product", product);
        model.addAttribute("productCount", 1);

        return "product";
    }
}
