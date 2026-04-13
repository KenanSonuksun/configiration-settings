# Config Settings

## Covers
- profile-based config (`application.yml`, `application-local.yml`, `application-prod.yml`)
- externalized configuration
- `@ConfigurationProperties`
- CORS and security basics
- Actuator management endpoints
- separate management port
- PostgreSQL integration
- Flyway migrations
- Docker-based local database

## Tech Stack
- Java 21
- Spring Boot 3.3.5
- Spring Web
- Spring Security
- Spring Validation
- Spring Boot Actuator
- Spring JDBC
- PostgreSQL
- Flyway
- Docker

## Purpose
This project was built to practice how a backend service should be prepared for real environments:
- clean config design
- local vs prod separation
- safe operational defaults
- versioned database changes

## Run Local
```bash
SPRING_PROFILES_ACTIVE=local mvn spring-boot:run
