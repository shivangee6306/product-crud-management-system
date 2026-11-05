package com.example.product.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name zaroori hai")
    @Size(max = 100, message = "Name 100 characters se zyada nahi ho sakta")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Category zaroori hai")
    @Size(max = 50, message = "Category 50 characters se zyada nahi ho sakti")
    @Column(nullable = false, length = 50)
    private String category;

    @NotNull(message = "Price zaroori hai")
    @DecimalMin(value = "0.01", message = "Price 0 se zyada honi chahiye")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @NotNull(message = "Quantity zaroori hai")
    @Min(value = 0, message = "Quantity negative nahi ho sakti")
    @Column(nullable = false)
    private Integer quantity;

    @Size(max = 255, message = "Description 255 characters se zyada nahi ho sakta")
    private String description;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ---------- Getters & Setters ----------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
