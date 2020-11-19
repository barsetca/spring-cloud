package com.cherniak.eurekaorder.controller;

import com.cherniak.common.OrderDto;
import com.cherniak.common.ProductDto;
import com.cherniak.eurekaorder.model.Order;
import com.cherniak.eurekaorder.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

  private final ProductAppConnect productAppConnect;

  private final OrderService orderService;


  @RequestMapping("/products/{id}")
  public ProductDto getProduct(@PathVariable(value = "id") Long id) {
    ProductDto answer = productAppConnect.getProduct(id);
    return answer;
  }

  @GetMapping("/orders")
  public List<OrderDto> getAll() {
    return orderService.fromOrdersList();
  }

  @GetMapping("/products")
  List<ProductDto> getProduct() {
    return productAppConnect.getAllProducts();
  }

  @PostMapping("/orders")
  public OrderDto create(@RequestBody List<Long> productIds) {
    int cost = 0;
    int quantity = 0;
    for (Long productId : productIds) {
      ProductDto productDto = productAppConnect.getProduct(productId);
      cost = cost + productDto.getCost();
      quantity++;
    }
    Order order = new Order(cost, quantity);
    orderService.save(order);
    return orderService.fromOrder(order);
  }
}
