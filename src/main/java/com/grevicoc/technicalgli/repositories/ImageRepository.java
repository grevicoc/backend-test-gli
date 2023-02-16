package com.grevicoc.technicalgli.repositories;

import com.grevicoc.technicalgli.models.dao.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByBreed_Name(String name);
}
