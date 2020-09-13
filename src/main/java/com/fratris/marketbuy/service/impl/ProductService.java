package com.fratris.marketbuy.service.impl;

import com.fratris.marketbuy.exception.NotFoundException;
import com.fratris.marketbuy.model.Product;
import com.fratris.marketbuy.repository.ProductRepository;
import com.fratris.marketbuy.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService implements GenericService<Product, Long> {

  @Autowired
  ProductRepository repository;

  @Override
  public Product save(Product obj) {
    return repository.save(obj);
  }

  @Override
  public void delete(Long id) {
    Product product = this.getById(id);
    repository.delete(product);
  }

  @Override
  public List<Product> getAll() {
    return repository.findAll();
  }

  @Override
  public Product getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado"));
  }

  public List<Product> getByPrice(BigDecimal min, BigDecimal max){
    return repository.findByPrice(min, max);
  }


}
