package com.fratris.marketbuy.service.impl;

import com.fratris.marketbuy.exception.NotFoundException;
import com.fratris.marketbuy.model.Store;
import com.fratris.marketbuy.model.User;
import com.fratris.marketbuy.repository.StoreRepository;
import com.fratris.marketbuy.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class StoreService implements GenericService<Store, Long> {

  @Autowired
  StoreRepository repository;

  @Override
  public Store save(Store obj) {
    return repository.save(obj);
  }

  @Override
  public void delete(Long id) {
    Store store = this.getById(id);
    repository.delete(store);
  }

  @Override
  public List<Store> getAll() {
    return repository.findAll();
  }

  @Override
  public Store getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("Store não encontrado"));
  }

  public List<Store> getUserByName(String name){
    return repository.findByNameContainsIgnoreCaseOrderByNameAsc(name);
  }


}
