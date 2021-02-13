package com.springRest.springRest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springRest.springRest.dao.CourseDao;
import com.springRest.springRest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao coursedao;

	List<Course> list;

//	public CourseServiceImpl() {
//		
//		//objects adding to list 
////		 list=new ArrayList<>();
////	list.add(new Course(145,"java mvc","spring boot"));
////	list.add(new Course(222,"hiberanate","Jpa"));
//	}
//
//
	@Override
	public List<Course> getCourses() {

		// return list;
//		
//		//return the list of courses available using jpa using hibernate from database
		return coursedao.findAll();
//				
	}

//
//
	@Override
	public Course addCourse(Course course) {
//
////      list.add(course);
////	  return course;
//		
		coursedao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		 coursedao.save(course);
		 return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
	 Course entity=coursedao.getOne(parseLong);
	 coursedao.delete(entity);
		
	}

	

	
	

}
