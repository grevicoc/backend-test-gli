package com.grevicoc.technicalgli.models.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String source;

    @ManyToOne(targetEntity = Breed.class)
    @JoinColumn(name = "id_breed", referencedColumnName = "id")
    private Breed breed;
}
