package com.ntt.services.service;

import com.ntt.services.model.Product;
import com.ntt.services.repository.ProductRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public ResponseEntity<List<Product>> getAll() {
    List<Product> productList = productRepository.getAll();
    return ResponseEntity.ok(productList);
  }

  public ResponseEntity<Product> getById(int id) {
    var result = productRepository.getById(id);
    if (result.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(result.get());
  }
}
