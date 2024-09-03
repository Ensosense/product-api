package se.enso.productapi.repository;

import org.springframework.stereotype.Repository;
import se.enso.productapi.domain.ProductEntity;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

@Repository
public class ProductRepository {
  private final DynamoDbEnhancedClient dynamoDbEnhancedClient;

  public ProductRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
    this.dynamoDbEnhancedClient = dynamoDbEnhancedClient;
  }

  public void save(ProductEntity productEntity) {
    DynamoDbTable<ProductEntity>
        productTable = dynamoDbEnhancedClient.table("Products", ProductEntity.getTableSchema());
    productTable.putItem(productEntity);
  }

  public boolean isConnected() {
    try {
      DynamoDbTable<ProductEntity> productTable = dynamoDbEnhancedClient.table("Products", ProductEntity.getTableSchema());
      // Perform a simple operation, like counting items in the table
      productTable.describeTable();
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}

