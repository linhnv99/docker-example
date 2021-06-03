package com.example.demo_docker.service.impl;

import com.example.demo_docker.model.bo.Response;
import com.example.demo_docker.model.bo.SystemResponse;
import com.example.demo_docker.model.entity.User;
import com.example.demo_docker.model.in.UserCreate;
import com.example.demo_docker.model.in.UserUpdate;
import com.example.demo_docker.model.out.UserOut;
import com.example.demo_docker.repository.UserRepository;
import com.example.demo_docker.service.IUserService;
import com.example.demo_docker.service.mapper.UserMapper;
import com.example.demo_docker.util.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Override
    public ResponseEntity<SystemResponse<List<UserOut>>> getAll() {

        List<User> users = repository.findAll();
        List<UserOut> userOuts = mapper.map(users);

        return Response.ok(userOuts);
    }

    @Override
    public ResponseEntity<SystemResponse<UserOut>> create(UserCreate userCreate) {

        User user = mapper.map(userCreate);

        user = repository.save(user);

        UserOut userOut = mapper.map(user);

        return Response.ok(userOut);
    }

    @Override
    public ResponseEntity<SystemResponse<UserOut>> update(int id, UserUpdate userUpdate) {

        User user = repository.findById(id).orElse(null);

        if (user == null) return Response.badRequest(StringResponse.USER_NOT_EXISTS);

        user = mapper.map(user, userUpdate);

        user = repository.save(user);

        UserOut userOut = mapper.map(user);

        return Response.ok(userOut);
    }

    @Override
    public ResponseEntity<SystemResponse<UserOut>> delete(int id) {

        User user = repository.findById(id).orElse(null);

        if (user == null) return Response.badRequest(StringResponse.USER_NOT_EXISTS);

        repository.deleteById(id);

        return Response.ok();
    }
}
