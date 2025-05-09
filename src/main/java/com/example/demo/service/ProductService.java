package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    Product getProductById(Long id);
    Page<Product> getAllProducts(Pageable pageable);
}
