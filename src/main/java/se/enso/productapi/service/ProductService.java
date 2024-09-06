package se.enso.productapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import se.enso.productapi.domain.ProductEntity;
import se.enso.productapi.repository.ProductRepository;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void createProduct(ProductEntity entity) {
    productRepository.save(entity);
  }

  public List<ProductEntity> getAllProducts() {
    return productRepository.getAllProducts();
  }

  public ProductEntity getProductById(String id) {
    return productRepository.getProductById(id);
  }
}
