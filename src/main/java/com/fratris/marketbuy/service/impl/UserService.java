package com.fratris.marketbuy.service.impl;

import com.fratris.marketbuy.exception.NotFoundException;
import com.fratris.marketbuy.model.User;
import com.fratris.marketbuy.repository.UserRepository;
import com.fratris.marketbuy.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements GenericService<User, Long> {

  @Autowired
  UserRepository repository;

  @Override
  public User save(User obj) {
    return repository.save(obj);
  }

  @Override
  public void delete(Long id) {
    User user = this.getById(id);
    repository.delete(user);
  }

  @Override
  public List<User> getAll() {
    return repository.findAll();
  }

  @Override
  public User getById(Long id) {
    return repository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
  }

  public List<User> getUserByName(String name){
    return repository.findByNameContainsIgnoreCaseOrderByNameAsc(name);
  }

  public User getUserByCpf(String cpf){
    return repository.findByCpf(cpf).orElseThrow(() -> new NotFoundException("CPF não encontrado"));
  }




}
