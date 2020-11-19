package com.cherniak.eurekaorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EurekaFeignOrderApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaFeignOrderApplication.class, args);
  }
}
