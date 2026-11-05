package com.example.product.repository;

import com.example.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository se save, findAll, findById, deleteById sab free me milta hai
public interface ProductRepository extends JpaRepository<Product, Long> {

    // name ya category me search (small/capital letter ka farak nahi padta)
    List<Product> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(String name, String category);
}
