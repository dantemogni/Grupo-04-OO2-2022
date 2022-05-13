package com.unla.tp.respositories;

import java.io.Serializable;
import java.util.Optional;

import com.unla.tp.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {
    public Optional<User> findOneByUsername(String username);
}
