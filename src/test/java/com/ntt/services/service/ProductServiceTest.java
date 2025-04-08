package com.ntt.services.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ntt.services.model.Product;
import com.ntt.services.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ProductServiceTest {

  private ProductRepository productRepository;

  private List<Product> productList;

  private ProductService productService;

  @BeforeEach
  void setUp() {
    productRepository = mock(ProductRepository.class);
    productList = new ArrayList<>();
    productList.add(Product.builder().id(1).name("Laptop").category("Technology")
        .price(BigDecimal.valueOf(12000)).build());
    productList.add(Product.builder().id(2).name("Smartphone").category("Technology")
        .price(BigDecimal.valueOf(8000)).build());

    productService = new ProductService(productRepository);

  }

  @Test
  void getAll() {

    when(productRepository.getAll()).thenReturn(productList);

    ResponseEntity<List<Product>> result = productService.getAll();
    assertNotNull(productRepository);
    assertNotNull(productService);
    assertNotNull(result);
    assertEquals(HttpStatus.OK, result.getStatusCode());
    assertTrue(result.hasBody());
    assertFalse(result.getBody().isEmpty());
    List<Product> expectedList = result.getBody();
    assertEquals(2, expectedList.size());

  }

  @Test
  void getById() {
  }
}