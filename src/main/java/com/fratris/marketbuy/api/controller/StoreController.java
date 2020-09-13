package com.fratris.marketbuy.api.controller;

import com.fratris.marketbuy.api.controller.dto.StoreDto;
import com.fratris.marketbuy.api.controller.dto.UpdateStoreDto;
import com.fratris.marketbuy.api.controller.dto.UserDto;
import com.fratris.marketbuy.model.Store;
import com.fratris.marketbuy.model.User;
import com.fratris.marketbuy.repository.StoreRepository;
import com.fratris.marketbuy.service.impl.StoreService;
import com.fratris.marketbuy.service.impl.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

  private final StoreService service;
  private final UserService userService;
  private final ModelMapper mapper;

  public StoreController(StoreService service, UserService userService, ModelMapper mapper) {
    this.service = service;
    this.userService = userService;
    this.mapper = mapper;
  }

  @PostMapping
  public ResponseEntity<Store> post(final @RequestBody StoreDto dto) {
    User user = userService.getById(dto.getOwner());
    Store store = mapper.map(dto, Store.class);
    store.setOwner(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(store));
  }

  @PutMapping("{id}")
  public ResponseEntity<Store> update(final @PathVariable Long id, final @RequestBody UpdateStoreDto dto){
    Store store = service.getById(id);
    mapper.map(dto, store);
    return ResponseEntity.ok(service.save(store));
  }

  @GetMapping
  public ResponseEntity<List<Store>> getAll(){
    return ResponseEntity.ok(service.getAll());
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(final @PathVariable Long id){
    service.delete(id);
  }

  @GetMapping("{name}")
  public ResponseEntity<List<Store>> getByName(final @PathVariable String name){
    return ResponseEntity.ok(service.getUserByName(name));
  }
}
