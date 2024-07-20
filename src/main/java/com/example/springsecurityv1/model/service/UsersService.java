package com.example.springsecurityv1.model.service;

import com.example.springsecurityv1.model.entity.Users;
import com.example.springsecurityv1.model.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {

    private final UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users user =  usersRepository.findByUsername(username).orElseThrow( () -> new RuntimeException("user not found") );
        List<SimpleGrantedAuthority> roles = Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new User(user.getUsername(), user.getPassword(), roles);
    }
}
