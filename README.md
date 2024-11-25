# Kinaxis Commerce Platform

## Overview

This project is a part of the Kinaxis Commerce Platform. It includes the implementation of various domain models, services, and REST controllers for managing order items and inventory items.

## Technologies Used

- Java
- Spring Boot
- Maven
- Jakarta Persistence API (JPA)
- Jakarta Validation API
- Lombok
- Swagger (OpenAPI)

## Project Structure

The project is organized into the following packages:

- `com.kinaxis.platform.u202014511.commerce.domain.model.aggregates`
- `com.kinaxis.platform.u202014511.commerce.domain.model.commands`
- `com.kinaxis.platform.u202014511.commerce.domain.model.valueobjects`
- `com.kinaxis.platform.u202014511.commerce.interfaces.rest`
- `com.kinaxis.platform.u202014511.commerce.interfaces.rest.resources`
- `com.kinaxis.platform.u202014511.commerce.interfaces.rest.transform`
- `com.kinaxis.platform.u202014511.shared.domain.model.aggregates`
- `com.kinaxis.platform.u202014511.wms.domain.model.aggregates`
- `com.kinaxis.platform.u202014511.wms.domain.model.commands`
- `com.kinaxis.platform.u202014511.wms.domain.model.events`
- `com.kinaxis.platform.u202014511.wms.domain.model.valueobjects`

## How to Build

To build the project, run the following command:

```sh
mvn clean install
```

## How to Run

To run the project, run the following command:

```sh
mvn spring-boot:run
```

## API Documentation
The project uses Swagger for API documentation. Once the application is running, you can access the API documentation at: 

```sh
http://localhost:8080/swagger-ui.html
```

## Author
Johan Principe Godoy (u202014511)
