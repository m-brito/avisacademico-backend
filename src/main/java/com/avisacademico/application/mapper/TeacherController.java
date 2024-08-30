package com.avisacademico.application.mapper;

import com.avisacademico.domain.dto.TeacherDTO;
import com.avisacademico.domain.model.professor.Teacher;
import com.avisacademico.domain.service.professor.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Teacher> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = teacherService.createProfessor(teacherDTO);
        return new ResponseEntity<>(teacher, HttpStatus.CREATED);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Teacher> getTeacher(@RequestParam Long id) {
        Teacher teacher = teacherService.getProfessorById(id);
        if (teacher != null) {
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}