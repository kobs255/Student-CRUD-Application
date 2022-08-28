package com.jkobs.college.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class StudentDetails {

	@Id
	@Column(name="id",unique = true)
	private int studentId;
	
	@Column(name="gpa")
	private double gpa;
	
	@Column(name="year")
	private int year;

	public StudentDetails() {}
	
	public StudentDetails(int studentId, double gpa, int year) {
		this.studentId = studentId;
		this.gpa = gpa;
		this.year = year;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "StudentDetails [studentId=" + studentId + ", gpa=" + gpa + ", year=" + year + "]";
	}
}
