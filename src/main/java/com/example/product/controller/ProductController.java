package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // GET /api/products  ya  /api/products?search=laptop
    @GetMapping
    public List<Product> getAll(@RequestParam(required = false) String search) {
        return service.getAllProducts(search);
    }

    // GET /api/products/5
    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return service.getProductById(id);
    }

    // POST /api/products
    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addProduct(product));
    }

    // PUT /api/products/5
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @Valid @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    // DELETE /api/products/5
    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable Long id) {
        service.deleteProduct(id);
        return Map.of("message", "Product delete ho gaya");
    }
}
