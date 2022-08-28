package com.jkobs.college.main.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jkobs.college.main.entity.Course;
@Repository
public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void saveCourse(Course course) {
		entityManager.persist(course);

	}

	@Override
	public List<Course> getCourses() {
		List<Course> courses = entityManager.createQuery("from Course").getResultList();
		return courses;
	}

	@Override
	public Course getCourseById(int id) {
		Course course = entityManager.find(Course.class, id);
		return course;
	}

	@Override
	public void deleteCourse(int id) {
		entityManager.remove(this.getCourseById(id));

	}

}
