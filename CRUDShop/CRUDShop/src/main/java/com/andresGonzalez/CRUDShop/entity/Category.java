package com.andresGonzalez.CRUDShop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name = "categoryName", nullable = false, length = 60)
    private String categoryName;

    @Column(name = "categoryDescription", length = 150)
    private String categoryDescription;

    @Column(name = "isActive")
    private Boolean isActive;

    public Category() {
    }

    // Getters y Setters
    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getCategoryDescription() { return categoryDescription; }
    public void setCategoryDescription(String categoryDescription) { this.categoryDescription = categoryDescription; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}