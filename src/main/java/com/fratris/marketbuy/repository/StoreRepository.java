package com.fratris.marketbuy.repository;

import com.fratris.marketbuy.model.Store;
import com.fratris.marketbuy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
  List<Store> findByNameContainsIgnoreCaseOrderByNameAsc(String name);

}
