package com.jkobs.college.main.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jkobs.college.main.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void saveStudent(Student student) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(student);
	}

	@Override
	public List<Student> getStudents() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Student");
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public Student getStudentById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Student student = session.find(Student.class, id);
		return student;
	}

	@Override
	public void deleteStudent(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("delete from Student where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

}
