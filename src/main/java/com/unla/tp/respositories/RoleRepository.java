package com.unla.tp.respositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.tp.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Serializable> {

}
