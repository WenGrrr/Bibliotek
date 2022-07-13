package com.example.bibliotek.controllers;

import com.example.bibliotek.documents.Product;
import com.example.bibliotek.services.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductsController {
    ProductsService productService;

    public ProductsController(ProductsService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String productsController(Model model){
        List<Product> products = new ArrayList<>(productService.getAllProducts());
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable UUID id, Model model){
        model.addAttribute("product", productService.getProductByID(id));
        return "product";
    }
    @PostMapping("/create")
    public String createProduct(String name, String price, int count){
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setName(name);
        product.setCount(count);
        product.setPrice(BigDecimal.valueOf(Double.valueOf(price)));
        productService.createProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") UUID id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
    @PostMapping("/clear")
    public String deleteAllProducts(){
        productService.clearProducts();
        return "redirect:/";
    }

}
