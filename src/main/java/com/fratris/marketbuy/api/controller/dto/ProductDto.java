package com.fratris.marketbuy.api.controller.dto;

import com.fratris.marketbuy.model.Store;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductDto {

  private String name;

  private String description;

  private Integer quantity;

  private BigDecimal price;

  private Long store;

  public ProductDto(String name, String description, Integer quantity, BigDecimal price, Long store) {
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.price = price;
    this.store = store;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Long getStore() {
    return store;
  }

  public void setStore(Long store) {
    this.store = store;
  }
}
