package com.example.demo_docker.repository;

import com.example.demo_docker.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Modifying
    @Transactional
    @Query(name = "DELETE * FROM users WHERE id = ?1", nativeQuery = true)
    void deleteById(int userId);
}
