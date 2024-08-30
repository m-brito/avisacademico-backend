package com.avisacademico.domain.repository.professor;


import org.springframework.data.jpa.repository.JpaRepository;
import com.avisacademico.domain.model.professor.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}