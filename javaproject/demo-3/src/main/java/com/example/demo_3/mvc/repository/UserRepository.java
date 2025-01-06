package com.example.demo_3.mvc.repository;

import com.example.demo_3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
