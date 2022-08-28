package com.jkobs.college.main.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jkobs.college.main.entity.Student;
import com.jkobs.college.main.service.StudentService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class StudentRestController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students")
	public void saveStudent(@RequestBody Student student) {
		student.setId(0);
		studentService.saveStudent(student);
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/students")
	public void updateStudent(@RequestBody Student student) {
		
		studentService.saveStudent(student);
	}
	
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	}
}
