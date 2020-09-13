package com.fratris.marketbuy.api.controller;

import com.fratris.marketbuy.api.controller.dto.ProductDto;
import com.fratris.marketbuy.model.Product;

import com.fratris.marketbuy.model.Store;
import com.fratris.marketbuy.model.User;
import com.fratris.marketbuy.service.impl.ProductService;
import com.fratris.marketbuy.service.impl.StoreService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService service;

  private final StoreService storeService;

  private final ModelMapper mapper;

  public ProductController(ProductService service, StoreService storeService, ModelMapper mapper) {
    this.service = service;
    this.storeService = storeService;
    this.mapper = mapper;
  }

  @PostMapping
  public ResponseEntity<Product> post(final @RequestBody ProductDto dto) {
    Store store = storeService.getById(dto.getStore());
    Product product = mapper.map(dto, Product.class);
    product.setStore(store);

    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
  }

  @PutMapping("{id}")
  public ResponseEntity<Product> update(final @PathVariable Long id, final @RequestBody Product productRequest){
    Product product = service.getById(id);
    mapper.map(productRequest, product);
    return ResponseEntity.ok(service.save(product));
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAll(){
    return ResponseEntity.ok(service.getAll());
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("{id}")
  public void delete(final @PathVariable Long id){
    service.delete(id);
  }

  @GetMapping("/valor")
  public ResponseEntity<List<Product>> getByPrice(final @RequestParam BigDecimal min, final @RequestParam BigDecimal max){
    return ResponseEntity.ok(service.getByPrice(min, max));
  }

}
