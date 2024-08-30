package com.avisacademico.domain.model.professor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Teacher(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Teacher() {}
}