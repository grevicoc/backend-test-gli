package com.grevicoc.technicalgli.repositories;

import com.grevicoc.technicalgli.models.dao.Breed;
import com.grevicoc.technicalgli.models.dao.SubBreed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubBreedRepository extends JpaRepository<SubBreed, Long> {
    void deleteSubBreedsByBreed(Breed breed);
}
