package com.oluwaseyi.TaskManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oluwaseyi.TaskManagement.model.User;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
