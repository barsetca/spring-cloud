package com.cherniak.eurekaproduct.controller;

import com.cherniak.common.ProductDto;
import com.cherniak.eurekaproduct.service.ProductService;
import com.netflix.discovery.EurekaClient;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

  private final EurekaClient eurekaClient;

  private final ProductService productService;

  @Value("${spring.application.name}")
  private String appName;

//    @Value("${userValue}")
//    private String username;

  @Override
  @GetMapping("/products/{id}")
  public ProductDto getProduct(@PathVariable(value = "id") Long id) {
    return productService.getProductById(id);
  }

  @Override
  public List<ProductDto> getAll() {
    return productService.getAllFromProducts();
  }

}
