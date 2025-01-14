package com.boa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.entity.Grade;
import com.boa.entity.Professor;
import com.boa.entity.Student;
import com.boa.repo.GradeRepository;
import com.boa.repo.ProfessorRepository;
import com.boa.repo.StudentRepository;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private GradeRepository gradeRepository;


	@PostMapping
	public Professor addGrades(@RequestBody Long id,Grade grade) {
		gradeRepository.save(grade);
	}
	@GetMapping
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping // request mapping change
	public List<Professor> getAllProfessor() {
		return professorRepository.findAll();
	}

	@PostMapping
	public Professor addProfessor(@RequestBody Professor student) {
		return professorRepository.save(student);
	}

	@GetMapping("/{id}")
	public Professor getProfessorById(@PathVariable Long id) {
		return professorRepository.findById(id).orElse(null);
	}

	@PutMapping("/{id}")
	public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor updatedProfessor) {
		if (professorRepository.existsById(id)) {
			updatedProfessor.setId(id);
			return professorRepository.save(updatedProfessor);
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public void deleteProfessor(@PathVariable Long id) {
		professorRepository.deleteById(id);
	}

}
