# Product-api

## Description

`product-api` is a Spring Boot microservice designed to manage products in an e-commerce system. It provides endpoints for creating, editing, deleting, and retrieving products. This service interacts with AWS DynamoDB to store and manage product data.

## Features

- **Create Product**: Add new products to the database.
- **Edit Product**: Update details of existing products.
- **Delete Product**: Remove products from the database.
- **Get Product By ID**: Retrieve details of a specific product by its ID.
- **Get All Products**: Fetch a list of all products.

## Installation

### Prerequisites

- Java 17 or higher
- AWS SDK for Java 2.0
- AWS DynamoDB Enhanced Client (ensure AWS credentials are configured)

### Setup

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/Ensosense/product-api.git
    cd product-api
    ```

2. **Install Dependencies**:
    ```bash
    mvn install
    ```

## Configuration

- **AWS DynamoDB Configuration**: Ensure that your AWS credentials are configured properly. You can set environment variables or use an AWS credentials file(used in this application).

## Usage

### API Endpoints

- **Create Product**
    - `POST /api/product`
    - **Request Body**:
    ```json
    {
      "category": "Product category",
      "price": 100.0,
      "title": "Product Title"
    }
    ```
    - **Response**: `201 Created`

- **Edit Product**
    - `PUT /api/product/{id}`
    - **Request Body**:
    ```json
    {
      "category": "Updated category",
      "price": 100.0,
      "title": "Updated Title"
    }
    ```
    - **Response**: `200 OK`

- **Delete Product**
    - `DELETE /api/product/{id}`
    - **Response**: `204 No Content`

- **Get Product By ID**
    - `GET /api/product/{id}`
    - **Response**:
    ```json
    {
      "pruduct_id": "7",
      "category": "Product category",
      "price": 100.0,
      "title": "Product Title"
    }
    ```

- **Get All Products**
    - `GET /api/products`
    - **Response**:
    ```json
    [
      {
      "pruduct_id": "7",
      "category": "Product category",
      "price": 100.0,
      "title": "Product Title"
      }
    ]
    ```

## Testing

### JUnit Tests

- **Unit Tests**: Verify individual components or methods in isolation to ensure they work as expected.
- **Integration Tests**: Test the interaction between components, such as how the service layer interacts with the database or external systems. These include full service operations (CRUD operations). For these tests, the Testcontainers library is used to spin up and manage lightweight, disposable containers for dependencies like databases.


## Deployment

For deployment, `product-api` will be hosted on Amazon ECS using Fargate. ECS with Fargate was chosen for its scalability, ease of use, and the ability to manage containers without handling the underlying infrastructure.


# Steps to deploy:

1. **Create a Docker image** for the `product-api`.
2. **Push the image to Amazon ECR**.
3. **Create an ECS cluster** and configure it to use Fargate.
4. **Deploy the service** on ECS, specifying the desired tasks and resources.

