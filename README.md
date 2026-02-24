# Accounts Microservice - Assignment 1

## Run
```bash
mvn spring-boot:run
```

## H2 Console
- http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- user: `sa`, password: empty

## API
### Customers
- POST   /api/customers
- GET    /api/customers?page=0&size=10&sort=name,asc
- GET    /api/customers/{customerId}
- PUT    /api/customers/{customerId}
- DELETE /api/customers/{customerId}

### Accounts (child resources)
- POST   /api/customers/{customerId}/accounts
- GET    /api/customers/{customerId}/accounts?page=0&size=10&sort=openedDate,desc
- GET    /api/customers/{customerId}/accounts?openedFrom=2026-01-01&openedTo=2026-02-01
- PUT    /api/customers/{customerId}/accounts/{accountNumber}
- DELETE /api/customers/{customerId}/accounts/{accountNumber}

## Features that match the brief
- Explicit 1:M relationship (Customer -> Accounts) exposed via endpoints
- DTOs + mappers (no entity exposure)
- Validation + consistent error responses
- Pagination with Pageable
- Date handling (openedDate) + date range filter
- JPA auditing columns (createdAt/createdBy/updatedAt/updatedBy)
