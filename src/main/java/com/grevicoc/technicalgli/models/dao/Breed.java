package com.grevicoc.technicalgli.models.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "breeds")
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "breed")
    private String name;
}

