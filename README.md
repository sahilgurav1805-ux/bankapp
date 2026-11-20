# Bank Management System

![Java](https://img.shields.io/badge/Java-Backend-007396?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-REST_API-6DB33F?logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?logo=docker&logoColor=white)

A Spring Boot REST API for core banking operations, built with a layered Controller-Service-Repository architecture and MySQL persistence through Spring Data JPA.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Getting Started](#getting-started)
- [Docker](#docker)
- [API Testing](#api-testing)
- [Future Enhancements](#future-enhancements)
- [Author](#author)

## Features

| Feature | Description |
|---|---|
| Account creation | Create new bank accounts. |
| Deposit | Add funds to an account. |
| Withdrawal | Withdraw funds from an account. |
| Fund transfer | Transfer money between accounts. |
| Balance inquiry | View the current account balance. |
| Transaction history | Retrieve past transactions for an account. |

## Tech Stack

| Technology | Purpose |
|---|---|
| Java | Core backend language |
| Spring Boot | Application framework |
| Spring Data JPA | Data access and persistence |
| Hibernate | ORM implementation |
| MySQL | Relational database |
| Maven | Build and dependency management |
| Docker | Containerization |
| Postman | API testing |

## Architecture

The application follows a layered architecture:

| Layer | Responsibility |
|---|---|
| Controller | Handles HTTP requests and responses. |
| Service | Contains banking business logic. |
| Repository | Manages database operations through Spring Data JPA. |

## Getting Started

### Prerequisites

- Java JDK (version matching your `pom.xml`)
- MySQL
- Maven (or use the included Maven wrapper)

### Installation

1. Clone the repository and open the project directory:

   ```bash
   git clone https://github.com/sahilgurav1805-ux/bankapp.git
   cd bankapp
   ```

2. Create a MySQL database:

   ```sql
   CREATE DATABASE bankapp;
   ```

3. Configure your database details in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bankapp
   spring.datasource.username=YOUR_USERNAME
   spring.datasource.password=YOUR_PASSWORD
   ```

   > **Security note:** Never commit real passwords or secrets to version control.

4. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

   On Windows, use `mvnw.cmd spring-boot:run`.

## Docker

The project includes a `Dockerfile`. To build the image:

```bash
docker build -t bankapp .
```

## API Testing

All REST endpoints were developed and tested with Postman. Import your requests into Postman, or call the endpoints directly against the running application.

## Future Enhancements

- JWT authentication and role-based access control
- Unit and integration tests
- API documentation with Swagger / OpenAPI
- Frontend integration

## Author

**Sahil Gurav**

- GitHub: [sahilgurav1805-ux](https://github.com/sahilgurav1805-ux)
- LinkedIn: [sahilgurav18](https://www.linkedin.com/in/sahilgurav18/)
