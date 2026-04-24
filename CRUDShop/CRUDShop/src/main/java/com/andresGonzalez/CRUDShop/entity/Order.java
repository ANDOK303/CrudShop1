package com.andresGonzalez.CRUDShop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "orderDate", nullable = false, length = 60)
    private String orderDate;

    @Column(name = "orderTotal", nullable = false)
    private Double orderTotal;

    @Column(name = "shippingAddress", length = 150)
    private String shippingAddress;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Order() {
    }

    // Getters y Setters
    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public Double getOrderTotal() { return orderTotal; }
    public void setOrderTotal(Double orderTotal) { this.orderTotal = orderTotal; }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}