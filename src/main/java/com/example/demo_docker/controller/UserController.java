package com.example.demo_docker.controller;

import com.example.demo_docker.model.bo.SystemResponse;
import com.example.demo_docker.model.in.UserCreate;
import com.example.demo_docker.model.in.UserUpdate;
import com.example.demo_docker.model.out.UserOut;
import com.example.demo_docker.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping
    public ResponseEntity<SystemResponse<List<UserOut>>> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<SystemResponse<UserOut>> create(@Valid @RequestBody UserCreate userCreate) {
        return service.create(userCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SystemResponse<UserOut>> update(@PathVariable("id") int id, @Valid @RequestBody UserUpdate userUpdate) {
        return service.update(id, userUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SystemResponse<UserOut>> delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
