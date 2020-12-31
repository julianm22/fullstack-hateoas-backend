package com.example.hateoas_backend.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Capability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String techStack;
    private Integer numOfDevelopers;
    private Integer numOfAvailableDevelopers;

    public Capability(String techStack, Integer numOfDevelopers, Integer numOfAvailableDevelopers) {
        this.techStack = techStack;
        this.numOfDevelopers = numOfDevelopers;
        this.numOfAvailableDevelopers = numOfAvailableDevelopers;
    }
}