package com.jaya.test.conversao.repository;

import com.jaya.test.conversao.domain.UserMain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserMain, Long> {
    Optional<UserMain> findUserMainByUsername(String username);
}
