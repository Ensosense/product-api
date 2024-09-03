package se.enso.productapi.domain.dto;

public class ProductRequest {

  private String category;
  private int price;
  private String title;

  public ProductRequest(String category, int price, String title) {
    this.category = category;
    this.price = price;
    this.title = title;
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
