package com.example.demo_docker.model.bo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {

    public static <T> ResponseEntity<SystemResponse<T>> ok() {
        return ResponseEntity.ok(new SystemResponse<>(200, "SUCCESS"));
    }

    public static <T> ResponseEntity<SystemResponse<T>> ok(T body) {
        return ResponseEntity.ok(new SystemResponse<>(200, "SUCCESS", body));
    }

    public static <T> ResponseEntity<SystemResponse<T>> badRequest(String msg) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new SystemResponse<>(400, msg));
    }
}
