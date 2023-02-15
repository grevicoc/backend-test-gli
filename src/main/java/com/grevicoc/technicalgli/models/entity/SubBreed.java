package com.grevicoc.technicalgli.models.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sub_breeds")
public class SubBreed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "sub_breed")
    private String name;

    @ManyToOne(targetEntity = Breed.class)
    @JoinColumn(name = "id_breed", referencedColumnName = "id")
    private Breed breed;
}
