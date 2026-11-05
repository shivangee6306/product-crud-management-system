package com.example.product.service;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Product addProduct(Product product) {
        product.setId(null); // naya record hamesha insert ho
        return repository.save(product);
    }

    // READ (all ya search ke saath)
    public List<Product> getAllProducts(String search) {
        if (search == null || search.trim().isEmpty()) {
            return repository.findAll();
        }
        String key = search.trim();
        return repository.findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(key, key);
    }

    // READ (single)
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Product id " + id + " nahi mila"));
    }

    // UPDATE
    public Product updateProduct(Long id, Product updated) {
        Product existing = getProductById(id);
        existing.setName(updated.getName());
        existing.setCategory(updated.getCategory());
        existing.setPrice(updated.getPrice());
        existing.setQuantity(updated.getQuantity());
        existing.setDescription(updated.getDescription());
        return repository.save(existing);
    }

    // DELETE
    public void deleteProduct(Long id) {
        Product existing = getProductById(id);
        repository.delete(existing);
    }
}
