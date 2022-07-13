package com.example.bibliotek.documents;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Document("product")
public class Product {
    @Id
    private UUID id;
    @Nullable
    private String name;
    @Nullable
    private Integer count;
    @Nullable
    private BigDecimal price;
    @Nullable
    @DocumentReference
    private Manufacturer manufacturer;

    @Nullable
    @DocumentReference
    private Shop shop;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Nullable
    public Shop getShop() {
        return shop;
    }

    public void setShop(@Nullable Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", manufacturer=" + manufacturer +
                ", shop=" + shop +
                '}';
    }
}