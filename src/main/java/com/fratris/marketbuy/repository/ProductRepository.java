package com.fratris.marketbuy.repository;

import com.fratris.marketbuy.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  @Query(value = "SELECT * FROM product WHERE price >= ?1 AND price <= ?2", nativeQuery = true)
  List<Product> findByPrice(@Param("min")BigDecimal min,@Param("max") BigDecimal max);

}
