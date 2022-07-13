package com.example.bibliotek.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
@Document("cartItem")
public class CartItem {
    @Id
    private UUID id;
    private int count;
    private BigDecimal subtotal;
    private Product product;
    @DocumentReference
    private List<ProductToCartItem> productToCartItemList;
    @DocumentReference
    private ShopCart shopCart;
    @DocumentReference
    private Order order;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<ProductToCartItem> getProductToCartItemList() {
        return productToCartItemList;
    }

    public void setProductToCartItemList(List<ProductToCartItem> productToCartItemList) {
        this.productToCartItemList = productToCartItemList;
    }

    public ShopCart getShopCart() {
        return shopCart;
    }

    public void setShopCart(ShopCart shopCart) {
        this.shopCart = shopCart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
