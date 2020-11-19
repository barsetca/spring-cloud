package com.cherniak.common;

public class ProductDto {

  private Long id;
  private String title;
  private Integer cost;

  public ProductDto() {
  }

  public ProductDto(Long id, String title, Integer cost) {
    this.id = id;
    this.title = title;
    this.cost = cost;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Integer getCost() {
    return cost;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCost(Integer cost) {
    this.cost = cost;
  }


  @Override
  public String toString() {
    return "ProductDto{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", cost=" + cost +
        '}';
  }
}
