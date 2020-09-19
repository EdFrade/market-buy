package com.fratris.marketbuy.api.controller;

import com.fratris.marketbuy.api.controller.dto.UserDto;
import com.fratris.marketbuy.model.User;
import com.fratris.marketbuy.service.impl.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService service;

  private final ModelMapper mapper;

  public UserController(UserService service, ModelMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @PostMapping
  public ResponseEntity<User> post(final @RequestBody User user) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
  }

  @PutMapping("{id}")
  public ResponseEntity<User> update(final @PathVariable Long id, final @Valid @RequestBody UserDto dto){
    User user = service.getById(id);
    mapper.map(dto, user);
    return ResponseEntity.ok(service.update(user));
  }

  @GetMapping
  public ResponseEntity<List<User>> getAll(){
    return ResponseEntity.ok(service.getAll());
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(final @PathVariable Long id){
    service.delete(id);
  }

  @GetMapping("{name}")
  public ResponseEntity<List<User>> getByName(final @PathVariable String name){
    return ResponseEntity.ok(service.getUserByName(name));
  }

  @GetMapping("cpf")
  public ResponseEntity<User> getByCpf(final String cpf){
    return ResponseEntity.ok(service.getUserByCpf(cpf));
  }
}
