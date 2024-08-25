package com.avisacademico.domain.repository.professor;


import org.springframework.data.jpa.repository.JpaRepository;
import com.avisacademico.domain.model.professor.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}