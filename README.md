# Category and Product CRUD API

This project implements Category and Product CRUD operations with Spring Boot, JPA, Hibernate, and MySQL database.

## Features:
- Category CRUD operations
- Product CRUD operations
- Server-side pagination for both categories and products
- Relationship between Category and Product (One-to-Many)

## How to Run:
1. Clone the repository.
2. Configure the MySQL database connection in `application.properties`.
3. Run the application using `mvn spring-boot:run` or through your IDE.
4. Use Postman to test the APIs.

## Endpoints:
- **GET** `/api/categories?page={page}` - Get all categories with pagination.
- **POST** `/api/categories` - Create a new category.
- **GET** `/api/categories/{id}` - Get category by ID.
- **PUT** `/api/categories/{id}` - Update category by ID.
- **DELETE** `/api/categories/{id}` - Delete category by ID.

- **GET** `/api/products?page={page}` - Get all products with pagination.
- **POST** `/api/products` - Create a new product.
- **GET** `/api/products/{id}` - Get product by ID.
- **PUT** `/api/products/{id}` - Update product by ID.
- **DELETE** `/api/products/{id}` - Delete product by ID.
