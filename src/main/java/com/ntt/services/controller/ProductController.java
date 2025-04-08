package com.ntt.services.controller;

import com.ntt.services.model.Product;
import com.ntt.services.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<Product>> getAll() {

    return productService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getById(@PathVariable int id) {

    return productService.getById(id);
  }
}
