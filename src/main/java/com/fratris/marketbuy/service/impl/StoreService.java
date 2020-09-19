package com.fratris.marketbuy.service.impl;

import com.fratris.marketbuy.exception.DataException;
import com.fratris.marketbuy.exception.NotFoundException;
import com.fratris.marketbuy.model.Store;
import com.fratris.marketbuy.model.User;
import com.fratris.marketbuy.repository.StoreRepository;
import com.fratris.marketbuy.repository.UserRepository;
import com.fratris.marketbuy.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class StoreService implements GenericService<Store, Long> {

  @Autowired
  StoreRepository repository;

  @Override
  public Store save(Store obj) {
    Optional<Store> storeExist = repository.findByOwnerId(obj.getOwner().getId());
    if(storeExist.isPresent()){
      throw new DataException("Usuário já possui uma loja vinculada");
    }
    return repository.save(obj);
  }

  public Store update(Store obj){
    return repository.save(obj);
  }

  @Override
  public void delete(Long id) {
    Store store = this.getById(id);
    repository.deleteById(id);
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
