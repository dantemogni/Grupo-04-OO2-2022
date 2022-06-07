package com.unla.tp.services;

import java.util.List;

import com.unla.tp.entities.User;
import com.unla.tp.models.UserRequest;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    public User createUser(UserRequest userRequest);

    public User updateUser(UserRequest userRequest);

    public User getByUsername(String username);

    public List<User> getAll();

    public void remove(int id);

    public User findById(int id);

    // METODO PARA UPDATE
    public User save(User user);

}
