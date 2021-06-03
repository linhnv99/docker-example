package com.example.demo_docker.service;

import com.example.demo_docker.model.bo.SystemResponse;
import com.example.demo_docker.model.in.UserCreate;
import com.example.demo_docker.model.in.UserUpdate;
import com.example.demo_docker.model.out.UserOut;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    ResponseEntity<SystemResponse<List<UserOut>>> getAll();

    ResponseEntity<SystemResponse<UserOut>> create(UserCreate userCreate);

    ResponseEntity<SystemResponse<UserOut>> update(int id, UserUpdate userUpdate);

    ResponseEntity<SystemResponse<UserOut>> delete(int id);
}
