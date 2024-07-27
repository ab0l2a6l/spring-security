package com.example.springsecurityv1.model.service;

import com.example.springsecurityv1.model.entity.Users;
import com.example.springsecurityv1.model.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {

    private final UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return usersRepository
               .findByUsername(username)
               .orElseThrow( () -> new RuntimeException("user not found") );
     }
}
