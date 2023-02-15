package com.grevicoc.technicalgli.repositories;

import com.grevicoc.technicalgli.models.dao.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BreedRepository extends JpaRepository<Breed, Long> {
    List<Breed> findAll();
}
