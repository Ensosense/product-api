package se.enso.productapi.controller;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import se.enso.productapi.domain.ProductEntity;
import se.enso.productapi.domain.dto.ProductRequest;
import se.enso.productapi.domain.dto.ProductResponse;
import se.enso.productapi.repository.ProductRepository;
import se.enso.productapi.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

  private final ProductService productService;
  private final ProductRepository productRepository;

  public ProductController(ProductService productService, ProductRepository productRepository) {
    this.productService = productService;
    this.productRepository = productRepository;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void createProduct(@RequestBody ProductEntity entity){
     productService.createProduct(entity);
  }

  @GetMapping("/dynamodb/health-check")
  public String dynamoDbHealthCheck() {
    return productRepository.isConnected() ? "DynamoDB is connected!" : "DynamoDB connection failed!";
  }

//  @GetMapping
//  @ResponseStatus(HttpStatus.OK)
//  public List<ProductResponse> getAllProducts(){
//    return productService.getAllProducts();
//  }

}
