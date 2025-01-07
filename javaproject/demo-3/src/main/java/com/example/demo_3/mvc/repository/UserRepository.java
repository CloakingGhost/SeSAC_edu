package com.example.demo_3.mvc.repository;

import com.example.demo_3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNickname(String nickname);

    List<User> findByAge(int age);

    @Query("SELECT u FROM User u where u.isActive=true ")
    List<User> findByIsActiveTrue();

    List<User> findByEmailContaining(String emailDomain);

    List<User> findByIsActiveFalseAndAgeGreaterThan(int age);
}
