package com.unla.tp.respositories;

import java.io.Serializable;

import com.unla.tp.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Serializable> {

}
