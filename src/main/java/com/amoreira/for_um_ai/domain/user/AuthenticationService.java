package com.amoreira.for_um_ai.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepositry repositry;

    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {

        return repositry.findByLogin(login);
    }
}
