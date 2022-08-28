package com.jkobs.college.main.dao;

import java.util.List;

import com.jkobs.college.main.entity.Student;

public interface StudentDao {

	public void saveStudent(Student student);
	
	public List<Student> getStudents();
	
	public Student getStudentById(int id);
	
	public void deleteStudent(int id);
}
