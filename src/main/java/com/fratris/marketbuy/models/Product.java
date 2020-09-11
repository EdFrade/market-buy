package com.fratris.marketbuy.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @NotEmpty
  @Size(max = 50)
  private String name;

  @Max(500)
  private String description;

  @NotNull
  private Integer quantity;

  @NotNull
  private BigDecimal price;

  @CreationTimestamp
  private LocalDate creationDate;

  @UpdateTimestamp
  private LocalDate updateDate;


  public Product(){

  }

  public Product(Long id, @NotNull @NotEmpty @Size(max = 50) String name, @Max(500) String description, @NotNull Integer quantity, @NotNull BigDecimal price) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.price = price;
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(name, product.name) &&
            Objects.equals(description, product.description) &&
            Objects.equals(quantity, product.quantity) &&
            Objects.equals(price, product.price);
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public LocalDate getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(LocalDate updateDate) {
    this.updateDate = updateDate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, quantity, price);
  }

  @Override
  public String toString() {
    return "Product{" +
            "name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", quantity=" + quantity +
            ", price=" + price +
            '}';
  }

}
