package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET all products with pagination
    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {
        Page<Product> products = productService.getAllProducts(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // POST create a new product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // GET product by id with category details
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return product != null 
            ? new ResponseEntity<>(product, HttpStatus.OK) 
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // PUT update product by id
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return updatedProduct != null 
            ? new ResponseEntity<>(updatedProduct, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE product by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
