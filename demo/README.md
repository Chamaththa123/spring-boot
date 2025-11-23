# Spring Boot JWT Authentication & Item Management API

A secure REST API built with Spring Boot that implements JWT-based authentication with role-based access control and item management functionality.

## Features

- User Registration & Login with JWT Authentication
- Password Encryption
- JWT Token Generation
- Stateless Authentication
- Protected Item Management Endpoints
- JSON Error Responses (401/403)
- Exception Handling
- PostgreSQL Database Integration

## Project Structure

```
demo/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java              # Main Spring Boot entry point
│   │   │   │
│   │   │   ├── config/                           # Security & configuration
│   │   │   │   ├── SecurityConfig.java           # Spring Security configuration
│   │   │   │   ├── JwtAuthFilter.java            # JWT token extraction & validation
│   │   │   │   ├── JwtAuthenticationEntryPoint.java  # 401 error handler
│   │   │   │   └── CustomAccessDeniedHandler.java    # 403 error handler
│   │   │   │
│   │   │   ├── controller/                       # HTTP endpoints
│   │   │   │   ├── AuthController.java           # /api/auth/* (register, login)
│   │   │   │   └── ItemController.java           # /api/items/* (CRUD operations)
│   │   │   │
│   │   │   ├── service/                          # Business logic layer
│   │   │   │   ├── UserService.java              # User service interface
│   │   │   │   ├── ItemService.java              # Item service interface
│   │   │   │   └── impl/
│   │   │   │       ├── UserServiceImpl.java       # Authentication logic
│   │   │   │       └── ItemServiceImpl.java       # Item management logic
│   │   │   │
│   │   │   ├── repository/                       # Data access layer (JPA)
│   │   │   │   ├── UserRepository.java           # User database queries
│   │   │   │   └── ItemRepository.java           # Item database queries
│   │   │   │
│   │   │   ├── entity/                           # ORM models
│   │   │   │   ├── User.java                     # User entity
│   │   │   │   └── Item.java                     # Item entity
│   │   │   │
│   │   │   ├── dto/                              # Data transfer objects
│   │   │   │   ├── RegisterRequest.java          # Registration payload
│   │   │   │   ├── LoginRequest.java             # Login payload
│   │   │   │   ├── AuthResponse.java             # Authentication response
│   │   │   │   ├── ItemRequest.java              # Item creation/update payload
│   │   │   │   └── ItemResponse.java             # Item response
│   │   │   │
│   │   │   ├── exception/                        # Exception handling
│   │   │   │   ├── GlobalExceptionHandler.java   # Centralized exception handler
│   │   │   │   ├── ErrorResponse.java            # Error response format
│   │   │   │   └── ResourceNotFoundException.java # Custom exception
│   │   │   │
│   │   │   ├── mapper/                           # Entity to DTO mapping
│   │   │   │   └── ItemMapper.java               # Item entity ↔ DTO conversion
│   │   │   │
│   │   │   └── util/                             # Utility classes
│   │   │       └── JwtUtil.java                  # JWT generation & validation
│   │   │
│   │   └── resources/
│   │       ├── application.yml                   # Application configuration
│   │       ├── static/                           # Static assets
│   │       └── templates/                        # HTML templates
│   │
│   └── test/
│       └── java/com/example/demo/
│           └── DemoApplicationTests.java         # Unit tests
│
├── target/                                       # Compiled files (Maven)
├── pom.xml                                       # Maven dependencies & build config
├── mvnw & mvnw.cmd                               # Maven wrapper scripts
└── README.md                                     # This file

```

## API Endpoints

**BASE URL** `http://localhost:8080`


### Authentication Endpoints (PUBLIC - No JWT Required)

#### Register New User
POST /api/auth/register

#### Login User
POST /api/auth/login

### Item Endpoints (PROTECTED - JWT Required)

All item endpoints require `Authorization: Bearer <token>` header

#### Create Item

#### Get All Items
GET /api/items

#### Get Item by ID
GET /api/items/{id}

#### Update Item
PUT /api/items/{id}

#### Delete Item
DELETE /api/items/{id}
