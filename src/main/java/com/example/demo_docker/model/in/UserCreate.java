package com.example.demo_docker.model.in;

import com.example.demo_docker.anotation.PhoneNumber;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class    UserCreate {

    @NotBlank
    private String name;

    @NotNull
    @Min(1)
    private int age;

    @PhoneNumber
    @NotBlank
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
