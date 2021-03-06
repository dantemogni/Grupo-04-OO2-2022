package com.unla.tp.respositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.tp.entities.PetitionNote;

@Repository
public interface PetitionRepository extends JpaRepository<PetitionNote, Serializable> {
    public List<PetitionNote> getAllByUsuarioId(int userId);
}
