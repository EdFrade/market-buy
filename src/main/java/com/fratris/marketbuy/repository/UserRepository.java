package com.fratris.marketbuy.repository;

import com.fratris.marketbuy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByNameContainsIgnoreCaseOrderByNameAsc(String name);
  Optional<User> findByCpf(String cpf);

}
