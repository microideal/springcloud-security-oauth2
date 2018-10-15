package com.microideal.authserver.repository;

import com.microideal.authserver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>{
    User findByUsername(String username);
}
