package com.fratris.marketbuy.models;



import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;

@Entity
public class Store {

  @NotNull
  @NotEmpty
  @Max(50)
  private String name;

  @Max(250)
  private String description;

  @OneToOne
  private User owner;

  @OneToMany
  @JoinColumn(name = "product_id")
  private Set<Product> products;

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
