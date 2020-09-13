package com.fratris.marketbuy.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
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
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;

  @NotNull
  @NotEmpty
  @Length(max = 50)
  private String name;

  @Length(max = 500)
  private String description;

  @NotNull
  private Integer quantity;

  @NotNull
  private BigDecimal price;

  @ManyToOne
  @JoinColumn(name = "id_store")
  @NotNull
  @JsonIgnore
  private Store store;

  @CreationTimestamp
  @JsonIgnore
  private LocalDate creationDate;

  @UpdateTimestamp
  @JsonIgnore
  private LocalDate updateDate;


  public Product(){

  }
  public Product(Long id, @NotNull @NotEmpty @Size(max = 50) String name, @Max(500) String description, @NotNull Integer quantity, @NotNull BigDecimal price, @NotNull Store store) {
    this.id = id;
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

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  public Long getId() {
    return id;
  }
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  public void setId(Long id) {
    this.id = id;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
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
