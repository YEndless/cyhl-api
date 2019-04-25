package com.cy.hl.dao;

import com.cy.hl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByEmail(String email);
}
