package com.jkobs.college.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkobs.college.main.dao.StudentDao;
import com.jkobs.college.main.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Transactional
	@Override
	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
	}

	@Transactional
	@Override
	public List<Student> getStudents() {
		return studentDao.getStudents();
	}
	
	@Transactional
	@Override
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}
	
	@Transactional
	@Override
	public void deleteStudent(int id) {
		studentDao.deleteStudent(id);
	}

}
