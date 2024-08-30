package com.avisacademico.application.mapper;

import com.avisacademico.domain.dto.ProfessorDTO;
import com.avisacademico.domain.model.professor.Professor;
import com.avisacademico.domain.service.professor.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastrar-professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody ProfessorDTO professorDTO) {
        Professor professor = professorService.createProfessor(professorDTO);
        return new ResponseEntity<>(professor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessor(@PathVariable Long id) {
        Professor professor = professorService.getProfessorById(id);
        if (professor != null) {
            return new ResponseEntity<>(professor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}