# Product-api

## Description

`product-api` is a Spring Boot microservice designed to manage products in an e-commerce system. It provides endpoints for creating, editing, deleting, and retrieving products. 

## Integration
Utilizes AWS DynamoDB for storing and managing product data.


## Deployment
Hosted on AWS ECS with Fargate. The deployment process is automated using GitHub Actions.

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

2. **Install Dependencies(local development)**:
    ```bash
    mvn install
    ```

## Configuration

- **AWS DynamoDB Configuration**: Ensure that your AWS credentials are configured properly. For local development you can set environment variables or use an AWS credentials file(used in this application).

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
      "product_id": "7",
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
      "product_id": "7",
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

For deployment, `product-api` is hosted on Amazon ECS using Fargate. The deployment process is automated with GitHub Actions, and it triggers on pushes to the main branch.

### CI/CD Pipeline

The CI/CD pipeline automates the following steps:

- **Build**: The application is built using Maven.
- **Docker Image**: A Docker image for the product-api is created and pushed to Amazon ECR.
- **Update Task Definition**: The ECS task definition is updated with the new Docker image.
- **Deploy**: The updated task definition is deployed to the ECS cluster.

