# API Test Framework — Petstore

This project is a demonstration API test framework created as part of a **technical assignment**.  
The target API is the [Swagger Petstore](https://petstore.swagger.io/) (v2) - Store section.

## Tech stack
- **Java 17**
- **Maven**
- **JUnit 5**
- **Rest Assured**
- **Lombok**
- JSON Schema Validator

## Project structure
```
src
├── main
│   ├── java/autotests/api
│   │   ├── clients/        # StoreClient, ApiClient abstraction
│   │   ├── config/         # Config loader (system props > files)
│   │   ├── dto/            # DTO classes (OrderDto)
│   │   ├── enums/          # Enums (endpoints, statuses, schema resources)
│   │   ├── fixtures/       # Data factories (valid and invalid DTOs, raw payloads)
│   │   ├── spec/           # RequestSpec, ResponseSpec
│   │   └── utils/          # Helpers (random utils, date utils)
│   └── resources
│       ├── schemas/        # JSON schemas for response validation
│       └── *.properties    # Environment configs (qa.properties, dev.properties, etc.)
└── test
    └── java/autotests/api/tests
        ├── store/          # Tests for /store/order, /store/inventory
        ├── providers/      # JUnit providers for parameterized tests
        └── support/        # Infrastructure helpers for tests
```

## Configuration
- Config loaded via `Config` class.
- Priority: **System property `-Denv` > resource file**.
- Property files naming: `qa.properties`, `dev.properties`, etc.

Example (`qa.properties`):
```properties
base.url=https://petstore.swagger.io/v2
```

## How to run
All tests:
```properties
mvn clean test
```
With environment:
```properties
mvn clean test -Denv=qa
```
Run only store tests:
```properties
mvn -Dtest=*StoreTest* test
```

## Reports
JUnit reports are generated under:
```properties
target/surefire-reports/
```



