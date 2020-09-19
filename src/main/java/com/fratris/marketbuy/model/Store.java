package com.fratris.marketbuy.model;



import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Store {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;

  @NotNull
  @NotEmpty
  @Length(max = 50)
  private String name;

  @Length(max = 250)
  private String description;

  @OneToOne(cascade = CascadeType.ALL)
  private User owner;

  @OneToMany(mappedBy = "store", orphanRemoval = true)
  @JsonIdentityReference(alwaysAsId = true)
  private Set<Product> products = new HashSet<>();

  public Store(){

  }

  public Store(@NotNull @NotEmpty @Max(50) String name, @Max(250) String description, User owner, Set<Product> products) {
    this.name = name;
    this.description = description;
    this.owner = owner;
    this.products = products;
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

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }

  public Set<Product> getProducts() {
    return products;
  }

  public void setProducts(Set<Product> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Store store = (Store) o;
    return Objects.equals(name, store.name) &&
            Objects.equals(description, store.description) &&
            Objects.equals(owner, store.owner) &&
            Objects.equals(products, store.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, owner, products);
  }
}
