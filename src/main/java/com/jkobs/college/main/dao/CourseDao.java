package com.jkobs.college.main.dao;

import java.util.List;

import com.jkobs.college.main.entity.Course;

public interface CourseDao {

	public void saveCourse(Course course);
	
	public List<Course> getCourses();
	
	public Course getCourseById(int id);
	
	public void deleteCourse(int id);
}
