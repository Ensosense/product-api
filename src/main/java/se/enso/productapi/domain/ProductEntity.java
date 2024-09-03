package se.enso.productapi.domain;


import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class ProductEntity {

  private String product_id;
  private String category;
  private int price;
  private String title;

  public ProductEntity() {
  }

  public ProductEntity(String product_id, String category, int price, String title) {
    this.product_id = product_id;
    this.category = category;
    this.price = price;
    this.title = title;
  }

  @DynamoDbAttribute("product_id")
  @DynamoDbPartitionKey
  public String getProduct_id() {
    return product_id;
  }


  public void setProduct_id(String product_id) {
    this.product_id = product_id;
  }


  @DynamoDbAttribute("category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @DynamoDbAttribute("price")
  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @DynamoDbAttribute("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public static TableSchema<ProductEntity> getTableSchema() {
    return TableSchema.fromBean(ProductEntity.class);
  }
}
