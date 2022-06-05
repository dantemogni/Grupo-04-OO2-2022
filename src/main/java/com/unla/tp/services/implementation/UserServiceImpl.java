package com.unla.tp.services.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.unla.tp.entities.User;
import com.unla.tp.models.UserRequest;
import com.unla.tp.respositories.RoleRepository;
import com.unla.tp.respositories.UserRepository;
import com.unla.tp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User createUser(UserRequest userRequest) {
        User user = new User();

        user.setNombre(capitalize(userRequest.getNombre()));
        user.setApellido(capitalize(userRequest.getApellido()));
        user.setEmail(userRequest.getEmail());
        user.setNroDocumento(userRequest.getNroDocumento());
        user.setTipoDocumento(userRequest.getTipoDocumento());
        user.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
        user.setUsername(userRequest.getUsername());
        user.setRole(roleRepository.getById(userRequest.getRoleId()));
        user.setEnabled(true);

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findOneByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username - " + username + ", not found"));

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(getAuthority(user));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true, true, authorities);
    }

    private GrantedAuthority getAuthority(User model) {
        return new SimpleGrantedAuthority(model.getRole().getAuthority());
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findOneByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username - " + username + ", not found"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void remove(int id) {
        userRepository.deleteById(id);
    }

    // @Override
    // public User findById(int id) {
    // List<User> lst = getAll();
    // int i = 0;
    // User u = null;
    // while (i < lst.size() && u == null) {
    // if (lst.get(i).getId() == id) {
    // u = lst.get(i);
    // }
    // i++;
    // }
    // return u;
    // }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);

    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    @Override
    public User updateUser(UserRequest userRequest) {
        User user = findById(userRequest.getIdUser());

        user.setNombre(capitalize(userRequest.getNombre()));
        user.setApellido(capitalize(userRequest.getApellido()));
        user.setEmail(userRequest.getEmail());
        user.setNroDocumento(userRequest.getNroDocumento());
        user.setTipoDocumento(userRequest.getTipoDocumento());
        user.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
        user.setUsername(userRequest.getUsername());
        // user.setRole(roleRepository.getById(userRequest.getRoleId()));
        //user.setEnabled(true);

        return userRepository.save(user);
    }

}
