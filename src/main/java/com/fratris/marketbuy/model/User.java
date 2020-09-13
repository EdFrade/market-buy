package com.fratris.marketbuy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Long id;
  @NotNull
  private String name;
  @NotNull
  @Column(unique = true)
  private String cpf;
  @Email
  @Column(unique = true)
  private String email;
  @NotNull
  @NotEmpty
  @Length(min = 6)
  private String password;
  @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "owner")
  private Store store;
  @JsonIgnore
  @CreationTimestamp
  private LocalDate creationDate;
  @JsonIgnore
  @UpdateTimestamp
  private LocalDate updateDate;

  public User(){

  }

  public User(@NotNull String name, @NotNull String cpf, @Email String email, @NotNull @NotEmpty @Min(6) String password, Store store, LocalDate creationDate, LocalDate updateDate) {
    this.name = name;
    this.cpf = cpf;
    this.email = email;
    this.password = password;
    this.store = store;
    this.creationDate = creationDate;
    this.updateDate = updateDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Store getStore() {
    return store;
  }

  public void setStore(Store store) {
    this.store = store;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id) &&
            Objects.equals(name, user.name) &&
            Objects.equals(cpf, user.cpf) &&
            Objects.equals(email, user.email) &&
            Objects.equals(password, user.password) &&
            Objects.equals(store, user.store) &&
            Objects.equals(creationDate, user.creationDate) &&
            Objects.equals(updateDate, user.updateDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, cpf, email, password, store, creationDate, updateDate);
  }

}
