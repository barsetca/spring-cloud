package com.cherniak.common;

public class OrderDto {

  private Long id;
  private int cost;
  private int quantity;

  public OrderDto(Long id, int cost, int quantity) {
    this.id = id;
    this.cost = cost;
    this.quantity = quantity;
  }

  public Long getId() {
    return id;
  }

  public int getCost() {
    return cost;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

}
