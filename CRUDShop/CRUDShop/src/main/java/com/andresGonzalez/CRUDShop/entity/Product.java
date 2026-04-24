package com.andresGonzalez.CRUDShop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Integer productId;

    @Column(name = "productName", nullable = false, length = 80)
    private String productName;

    @Column(name = "productPrice", nullable = false)
    private Double productPrice;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "brand", length = 50)
    private String brand;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product() {
    }

    // Getters y Setters
    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Double getProductPrice() { return productPrice; }
    public void setProductPrice(Double productPrice) { this.productPrice = productPrice; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}