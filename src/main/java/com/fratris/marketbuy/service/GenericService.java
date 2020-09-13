package com.fratris.marketbuy.service;

import java.util.List;

public interface GenericService<T, I> {

  T save(T obj);
  void delete(I id);
  List<T> getAll();
  T getById(I id);


}
