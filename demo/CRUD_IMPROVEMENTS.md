# CRUD Improvements - Project Update

## Summary
Updated the Spring Boot project to implement proper CRUD operations with enhanced validation, error handling, and best practices.

## Changes Made

### 1. **Input Validation (ItemRequest.java)**
- Added `@NotBlank` validation for name field
- Added `@Size` constraint (2-100 characters)
- Added `@NotNull` and `@DecimalMin` for price validation
- Added `@Min` constraint for quantity (minimum 1)

### 2. **Enhanced Response DTO (ItemResponse.java)**
- Added `createdAt` and `updatedAt` timestamp fields
- Properly configured with `@Builder` and `@NoArgsConstructor`

### 3. **Improved Entity Model (Item.java)**
- Added `@Column(nullable = false)` constraints for data integrity
- Added `createdAt` field with `@CreationTimestamp` auto-populated
- Added `updatedAt` field with `@UpdateTimestamp` auto-updated
- Timestamps are immutable/read-only where appropriate

### 4. **RESTful Controller (ItemController.java)**
- Wrapped all responses in `ResponseEntity` for proper HTTP status codes
- Create endpoint returns `201 CREATED` (HTTP 201)
- Read endpoints return `200 OK` (HTTP 200)
- Delete endpoint returns `204 NO CONTENT` (HTTP 204)
- Added `@Valid` annotation for automatic request validation

### 5. **Service Implementation (ItemServiceImpl.java)**
- Added `@Transactional` annotation at class level for transaction management
- Added read-only transactions for GET operations
- Enhanced delete operation to check existence before deletion
- Improved error messages to include specific item IDs
- Proper transaction handling for data consistency

### 6. **Mapper Update (ItemMapper.java)**
- Updated to include timestamp fields in response mapping

### 7. **Exception Handling (GlobalExceptionHandler.java)**
- Added handler for `MethodArgumentNotValidException`
- Provides detailed validation error messages
- Returns `400 BAD REQUEST` for validation failures

### 8. **Dependencies (pom.xml)**
- Added `spring-boot-starter-validation` for Jakarta Validation support

## API Endpoints

```
POST   /api/items              - Create new item (201)
GET    /api/items              - Get all items (200)
GET    /api/items/{id}         - Get item by ID (200)
PUT    /api/items/{id}         - Update item (200)
DELETE /api/items/{id}         - Delete item (204)
```

## Request/Response Examples

### Create Item Request
```json
{
  "name": "Laptop",
  "price": 999.99,
  "quantity": 5
}
```

### Item Response
```json
{
  "id": 1,
  "name": "Laptop",
  "price": 999.99,
  "quantity": 5,
  "createdAt": "2025-11-25T00:45:00",
  "updatedAt": "2025-11-25T00:45:00"
}
```

## Error Handling

### Validation Error Response (400)
```json
{
  "message": "name: Name must be between 2 and 100 characters, price: Price must be greater than 0",
  "code": 400
}
```

### Not Found Error Response (404)
```json
{
  "message": "Item with id 999 not found",
  "code": 404
}
```

## Build Status
✅ **Build Successful** - All files compile without errors
