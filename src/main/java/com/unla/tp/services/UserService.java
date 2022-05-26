package com.unla.tp.services;

import java.util.List;

import com.unla.tp.entities.User;
import com.unla.tp.models.UserSignUpRequest;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User createUser(UserSignUpRequest userRequest);

    public User getByUsername(String username);

    public List<User> getAll();

    public boolean remove(int id);

    public  User findById(int id);

    //METODO PARA UPDATE
    public User save(User user);

}
