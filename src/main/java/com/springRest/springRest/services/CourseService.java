package com.springRest.springRest.services;

import java.util.List;

import com.springRest.springRest.entities.Course;

//interface which has abstract methods to add courses and show courses
public interface CourseService {

	public List<Course> getCourses();
	
	public Course addCourse(Course course);

	public Course updateCourse(Course course);

	public void deleteCourse(long parseLong);

	
}

