package se.enso.productapi.domain.dto;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
public class ProductResponse {

  private String id;
  private String category;
  private int price;
  private String title;

  public ProductResponse(String id, String category, int price, String title) {
    this.id = id;
    this.category = category;
    this.price = price;
    this.title = title;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
