package com.example.springsecurityv1.config;

import com.example.springsecurityv1.model.entity.Users;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityHelper {
    public static Users getCurrentUser() {
       return (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
