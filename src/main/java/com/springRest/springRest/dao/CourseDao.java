package com.springRest.springRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springRest.springRest.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long> {

}
