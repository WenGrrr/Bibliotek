package com.example.bibliotek.documents;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Document("shop")
public class Shop {
    @Id
    private UUID id;

    private String name;

    @DocumentReference
    private User retailerId;
    @Nullable
    @DocumentReference
    private User userId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(User retailerId) {
        this.retailerId = retailerId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}