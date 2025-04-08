package com.ntt.services.repository;

import com.ntt.services.model.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component

public class ProductRepository {

  private List<Product> productList;

  public ProductRepository() {
    productList = new ArrayList<>();

    productList.add(Product.builder().id(1).name("Laptop").category("Technology")
        .price(BigDecimal.valueOf(12000)).build());
    productList.add(Product.builder().id(2).name("Smartphone").category("Technology")
        .price(BigDecimal.valueOf(8000)).build());
    productList.add(Product.builder().id(3).name("Tablet").category("Technology")
        .price(BigDecimal.valueOf(6000)).build());
    productList.add(Product.builder().id(4).name("Headphones").category("Accessories")
        .price(BigDecimal.valueOf(1500)).build());
    productList.add(Product.builder().id(5).name("Smartwatch").category("Wearables")
        .price(BigDecimal.valueOf(5000)).build());
    productList.add(Product.builder().id(6).name("Camera").category("Photography")
        .price(BigDecimal.valueOf(10000)).build());
    productList.add(Product.builder().id(7).name("Printer").category("Office Supplies")
        .price(BigDecimal.valueOf(3000)).build());
    productList.add(Product.builder().id(8).name("Monitor").category("Technology")
        .price(BigDecimal.valueOf(7000)).build());
    productList.add(Product.builder().id(9).name("Keyboard").category("Accessories")
        .price(BigDecimal.valueOf(1000)).build());
    productList.add(Product.builder().id(10).name("Mouse").category("Accessories")
        .price(BigDecimal.valueOf(800)).build());
  }

  public List<Product> getAll() {
    return productList;
  }

  public Optional<Product> getById(int id) {
    return Optional.ofNullable(
        productList.stream().filter(p -> p.getId() == id).findFirst().orElse(null));
  }

}
