package com.cherniak.eurekaproduct.controller;

import com.cherniak.common.ProductDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface ProductController {


  @GetMapping("/products/{id}")
  ProductDto getProduct(@PathVariable(value = "id") Long id);

  @GetMapping("/products")
  List<ProductDto> getAll();

}
