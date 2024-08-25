package com.avisacademico.domain.service.professor;

import com.avisacademico.domain.dto.ProfessorDTO;
import com.avisacademico.domain.model.professor.Professor;
import com.avisacademico.domain.repository.professor.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor createProfessor(ProfessorDTO professorDTO) {
        Professor professor = new Professor(null, professorDTO.getNome());
        return professorRepository.save(professor);
    }

    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }
}