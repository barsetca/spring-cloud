package com.cherniak.eurekaorder.service;


import com.cherniak.common.OrderDto;
import com.cherniak.eurekaorder.model.Order;
import com.cherniak.eurekaorder.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OrderService {

  private OrderRepository orderRepository;

  @Autowired
  public void setOrderRepository(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public Optional<Order> findById(Long id) {
    return orderRepository.findById(id);
  }

  public List<Order> findAll() {
    return orderRepository.findAll(Sort.by(Sort.Order.desc("id")));
  }

  @Transactional
  public Order save(Order order) {
    return orderRepository.save(order);
  }

  public List<OrderDto> fromOrdersList() {
    return findAll().stream()
        .map(o -> new OrderDto(o.getId(), o.getCost(), o.getQuantity()))
        .collect(Collectors.toList());
  }

  public OrderDto fromOrder(Order order) {
    return new OrderDto(order.getId(), order.getCost(), order.getQuantity());
  }
}
