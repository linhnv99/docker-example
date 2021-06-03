package com.example.demo_docker.service.mapper;

import com.example.demo_docker.model.entity.User;
import com.example.demo_docker.model.in.UserCreate;
import com.example.demo_docker.model.in.UserUpdate;
import com.example.demo_docker.model.out.UserOut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserOut map(User user) {

        UserOut userOut = new UserOut();

        userOut.setId(user.getId());
        userOut.setName(user.getName());
        userOut.setPhone(user.getPhone());
        userOut.setAge(user.getAge());

        return userOut;
    }

    public List<UserOut> map(List<User> users) {
        return users.stream().map(this::map).collect(Collectors.toList());
    }

    public User map(UserCreate userCreate) {

        User user = new User();
        user.setName(userCreate.getName());
        user.setPhone(userCreate.getPhone());
        user.setAge(userCreate.getAge());

        return user;
    }

    public User map(User user, UserUpdate userUpdate) {

        user.setAge(userUpdate.getAge());
        if (userUpdate.getName() != null && !userUpdate.getName().isEmpty())
            user.setName(userUpdate.getName());
        if (userUpdate.getPhone() != null && !userUpdate.getPhone().isEmpty())
            user.setPhone(userUpdate.getPhone());

        return user;
    }
}
