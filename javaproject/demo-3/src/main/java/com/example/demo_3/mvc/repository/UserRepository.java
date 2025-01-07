package com.example.demo_3.mvc.repository;

import com.example.demo_3.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNickname(String nickname);

    Optional<User> findByAge(int age);

    Optional<List<User>> findByActiveTrue();

    Optional<List<User>> findByEmailContaining(String emailDomain);

    Optional<List<User>> findByActiveFalseAndAgeGreaterThan(int age);
}
