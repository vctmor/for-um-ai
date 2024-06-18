package com.amoreira.for_um_ai.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepositry extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);
}
