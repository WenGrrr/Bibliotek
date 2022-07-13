package com.example.bibliotek.documents;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Таблица корзины
 */
@Document("productCart")
public class ProductCart {
    @Id
    private UUID id;

    private LocalDateTime date;
    @Nullable
    @DocumentReference
    private User userId;
    @DocumentReference
    private Set<Product> products = new LinkedHashSet<>();


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", user=" + userId + '\'' +
                ", products=" + products +
                '}';
    }
}
