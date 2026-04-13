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

## Migration 
Flyway migrations live under: `src/main/resources/db/migration`
- `V1__create_products_table.sql`
- `V2__add_description_to_products.sql`

## Run Commands

### Local
```bash
SPRING_PROFILES_ACTIVE=local \
DB_HOST=localhost \
DB_PORT=5432 \
DB_NAME=config_local \
DB_USERNAME=postgres \
DB_PASSWORD=postgres \
mvn spring-boot:run
```

### Production-style Run

```bash
SPRING_PROFILES_ACTIVE=prod \
SERVER_PORT=8080 \
MANAGEMENT_SERVER_PORT=9090 \
DB_HOST=your-prod-db-host \
DB_PORT=5432 \
DB_NAME=your-prod-db-name \
DB_USERNAME=your-prod-db-user \
DB_PASSWORD=your-prod-db-password \
APP_JWT_SECRET=your-strong-jwt-secret \
APP_CORS_ALLOWED_ORIGINS=https://your-frontend-domain.com \
APP_JWT_EXPIRATION_MINUTES=60 \
APP_HTTP_CONNECT_TIMEOUT_MS=3000 \
APP_HTTP_READ_TIMEOUT_MS=5000 \
APP_REQUEST_LOG_ENABLED=false \
mvn spring-boot:run
```
