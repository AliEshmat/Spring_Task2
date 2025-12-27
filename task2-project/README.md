# Spring Boot REST API - Product Management

## Description

REST API for product management. Simple application with H2 database demonstrating all basic CRUD operations.

## Technologies

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- Maven
- Swagger UI

## How to Run
1. Run `Task2Application.java`
2. Application starts on `http://localhost:8080`

## Project Structure
```
product/
├── api/
│   ├── controller/ProductController.java
│   ├── request/ProductRequest.java
│   └── response/ProductResponse.java
├── domain/Product.java (Entity)
├── repository/ProductRepository.java
├── service/ProductService.java
└── support/
    ├── ProductMapper.java
    ├── ProductExceptionHandler.java
    └── exception/ProductNotFoundException.java
```
# all screenshots and endpoint work are located in task2-project\screenshots

## Useful Links

- Swagger: http://localhost:8080/swagger-ui/index.html
- H2 Console: http://localhost:8080/console
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Username: `sa`
  - Password: (empty)

## API Endpoints

### 1. Create Product
```bash
POST http://localhost:8080/api/v1/products
Content-Type: application/json

{
  "name": "Laptop Dell"
}

# Response: 201 Created
{
  "id": 1,
  "name": "Laptop Dell"
}
```

### 2. Get Product by ID
```bash
GET http://localhost:8080/api/v1/products/1

# Response: 200 OK
{
  "id": 1,
  "name": "Laptop Dell"
}
```

### 3. Get All Products
```bash
GET http://localhost:8080/api/v1/products

# Response: 200 OK
[
  {
    "id": 1,
    "name": "Laptop Dell"
  },
  {
    "id": 2,
    "name": "iPhone 15"
  }
]
```

### 4. Update Product
```bash
PUT http://localhost:8080/api/v1/products/1
Content-Type: application/json

{
  "name": "Laptop Dell XPS 15"
}

# Response: 200 OK
{
  "id": 1,
  "name": "Laptop Dell XPS 15"
}
```

### 5. Delete Product
```bash
DELETE http://localhost:8080/api/v1/products/1

# Response: 204 No Content
```

## Error Handling

When trying to get/update/delete a non-existent product:
```bash
GET http://localhost:8080/api/v1/products/999

# Response: 404 Not Found
{
  "message": "Product with id: 999 not found"
}
```

## Testing via Swagger

1. Open http://localhost:8080/swagger-ui/index.html
2. Select the desired endpoint
3. Click "Try it out"
4. Enter data and click "Execute"

## Database Verification

1. Open http://localhost:8080/console
```sql
SELECT * FROM PRODUCT;
```

## Main Components

**Product (Entity)** - data model for database
```java
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
```

**ProductRepository** - database operations
```java
public interface ProductRepository extends JpaRepository<Product, Long> {
}
```

**ProductService** - business logic
```java
@Service
public class ProductService {
}
```

**ProductController** - REST API endpoints
```java
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
}
```

**ProductMapper** - conversion between DTO and Entity
```java
@Component
public class ProductMapper {
}
```

**ProductExceptionHandler** - error handling
```java
@ControllerAdvice
public class ProductExceptionHandler {
}
```