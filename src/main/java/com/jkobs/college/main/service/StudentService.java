package com.jkobs.college.main.service;

import java.util.List;

import com.jkobs.college.main.entity.Student;

public interface StudentService {

	public void saveStudent(Student student);
	
	public List<Student> getStudents();
	
	public Student getStudentById(int id);
	
	public void deleteStudent(int id);
}
