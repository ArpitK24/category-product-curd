package com.example.demo.service;

import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    Page<Product> getAllProducts(Pageable pageable);
    ProductResponseDTO getProductById(Long id);

}
