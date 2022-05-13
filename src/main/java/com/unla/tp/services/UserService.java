package com.unla.tp.services;

import com.unla.tp.entities.User;
import com.unla.tp.models.UserSignUpRequest;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User createUser(UserSignUpRequest userRequest);
}
