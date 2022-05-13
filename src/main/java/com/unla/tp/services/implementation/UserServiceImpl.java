package com.unla.tp.services.implementation;

import com.unla.tp.entities.User;
import com.unla.tp.models.UserSignUpRequest;
import com.unla.tp.respositories.RoleRepository;
import com.unla.tp.respositories.UserRepository;
import com.unla.tp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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
    public User createUser(UserSignUpRequest userRequest) {
        User user = new User();

        user.setNombre(userRequest.getNombre());
        user.setApellido(userRequest.getApellido());
        user.setEmail(userRequest.getEmail());
        user.setNroDocumento(userRequest.getNroDocumento());
        user.setTipoDocumento(userRequest.getTipoDocumento());
        user.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
        user.setUsername(userRequest.getUsername());
        user.setRole(roleRepository.getById(userRequest.getRoleId()));

        return userRepository.save(user);
    }

    // private User buildUser(UserSignUpRequest user) {
    // return User.builder()
    // .nombre(user.getNombre())
    // .apellido(user.getApellido())
    // .email(user.getEmail())
    // .nroDocumento(user.getNroDocumento())
    // .tipoDocumento(user.getTipoDocumento())
    // .username(user.getUsername())
    // .password(bCryptPasswordEncoder.encode(user.getPassword())
    // .build();
    // }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findOneByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with username - " + username + ", not found"));
    }
}
