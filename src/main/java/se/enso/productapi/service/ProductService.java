package se.enso.productapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import se.enso.productapi.domain.ProductEntity;
import se.enso.productapi.domain.dto.ProductRequest;
import se.enso.productapi.domain.dto.ProductResponse;
import se.enso.productapi.repository.ProductRepository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void createProduct(ProductEntity entity) {
    productRepository.save(entity);
  }

}
