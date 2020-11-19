package com.cherniak.eurekaorder.controller;

import com.cherniak.common.ProductDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("eureka-product")
public interface ProductAppConnect {

  @GetMapping("/products/{id}")
  ProductDto getProduct(@PathVariable(value = "id") Long id);

  @GetMapping("/products")
  List<ProductDto> getAllProducts();
}

