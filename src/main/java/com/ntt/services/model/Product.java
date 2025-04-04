package com.ntt.services.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

  private String id;
  private String name;
  private String category;
  private BigDecimal price;
}
