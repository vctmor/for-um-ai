package com.amoreira.for_um_ai.domain.topic.user;

import com.amoreira.for_um_ai.repository.UserRepositry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    private UserRepositry repositry;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return repositry.findByLogin();
    }
}
