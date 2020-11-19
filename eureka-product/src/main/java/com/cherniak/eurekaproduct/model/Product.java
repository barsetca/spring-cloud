package com.cherniak.eurekaproduct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title", nullable = false, unique = true)
  @Size(min = 2, max = 1000)
  private String title;

  @Column(name = "cost")
  @Min(1)
  private Integer cost;

  public Product(String title, int cost) {
    this(null, title, cost);
  }

  public Product(Long id, String title, Integer cost) {
    this.id = id;
    this.title = title;
    this.cost = cost;
  }
}
