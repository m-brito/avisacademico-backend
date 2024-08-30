package com.avisacademico.domain.service.professor;

import com.avisacademico.domain.dto.TeacherDTO;
import com.avisacademico.domain.model.professor.Teacher;
import com.avisacademico.domain.repository.professor.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createProfessor(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher(null, teacherDTO.getNome());
        return teacherRepository.save(teacher);
    }

    public Teacher getProfessorById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }
}