package com.jkobs.college.main.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jkobs.college.main.entity.Course;
import com.jkobs.college.main.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseRestController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return courseService.getCourses();
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourseById(@RequestParam int id) {
		return courseService.getCourseById(id);
	}
	
	@PostMapping("/courses")
	public void addCourse(@RequestBody Course course) {
		course.setId(0);
		courseService.saveCourse(course);
	}
	
	@PutMapping("/courses")
	public void updateCourse(@RequestBody Course course) {
		courseService.saveCourse(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourseById(@RequestParam int id) {
		courseService.deleteCourse(id);
	}
}
