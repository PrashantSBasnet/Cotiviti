package com.biddingsystem.service.auth;

import com.biddingsystem.entity.Role;
import com.biddingsystem.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.biddingsystem.entity.User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User does not exist with name:" + username);
        }
        return User.builder().username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getRoles().stream()
                        .map(role -> "ROLE_" + role.getRole())
                        .toList().toArray(new String[] {}))
                .build();
    }
}
