package com.jkobs.college.main.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkobs.college.main.dao.CourseDao;
import com.jkobs.college.main.entity.Course;
@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;

	@Transactional
	@Override
	public void saveCourse(Course course) {
		courseDao.saveCourse(course);

	}

	@Transactional
	@Override
	public List<Course> getCourses() {
		return courseDao.getCourses();
	}

	@Transactional
	@Override
	public Course getCourseById(int id) {
		return courseDao.getCourseById(id);
	}

	@Transactional
	@Override
	public void deleteCourse(int id) {
		courseDao.deleteCourse(id);

	}

}
