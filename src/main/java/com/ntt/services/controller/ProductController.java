package com.ntt.services.controller;

import com.ntt.services.model.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
public class ProductController {

  @GetMapping
  public ResponseEntity<List<Product>> getAll() {
    List<Product> productList = new ArrayList<>();

    productList.add(Product.builder().id(1).name("Laptop").category("Technology")
        .price(BigDecimal.valueOf(12000)).build());
    return ResponseEntity.ok(productList);
  }
}
