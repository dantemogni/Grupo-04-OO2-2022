package com.unla.tp.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tp.entities.Role;
import com.unla.tp.respositories.RoleRepository;
import com.unla.tp.services.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getByNombre(String nombre) {
        return roleRepository.getByNombre(nombre);
    }

}
