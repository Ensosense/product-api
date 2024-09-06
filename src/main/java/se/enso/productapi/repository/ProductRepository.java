package se.enso.productapi.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import se.enso.productapi.domain.ProductEntity;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;

@Repository
public class ProductRepository {
  private final DynamoDbTable<ProductEntity> productTable;

  public ProductRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
    this.productTable = dynamoDbEnhancedClient.table("Products", ProductEntity.getTableSchema());
  }

  public void save(ProductEntity productEntity) {
    productTable.putItem(productEntity);
  }

  public List<ProductEntity> getAllProducts() {
    List<ProductEntity> products = new ArrayList<>();
    productTable.scan().items().forEach(products::add);
    return products;
  }

  public ProductEntity getProductById(String id) {
    Key key = Key.builder().partitionValue(id).build();
    return productTable.getItem(r -> r.key(key));
  }
}

