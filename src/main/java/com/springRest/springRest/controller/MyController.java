package com.springRest.springRest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.springRest.entities.Course;
import com.springRest.springRest.services.CourseService;
import com.springRest.springRest.services.Welcome;

@RestController
public class MyController {
	
	//instantiating Welcome class of service layer
	@Autowired
	private Welcome welcome;
	
	//instantiation the implementation class of interface CourseService will happen via RunTime polmorphism
	@Autowired
	private CourseService courseservice;
	
	
	@PostMapping("/see")
	public ResponseEntity<Map<String,String>> createUser(@RequestHeader(value="Accept") String accept ,@RequestHeader(value="Authorization") String autorization) {
		Map<String,String> u=new HashMap<>();
		u.put("Accept",accept);
		u.put("Authorization", autorization);
		return ResponseEntity.status(HttpStatus.OK).body(u);
		
	}
	

	//using get method request is sent by postman to url-welcome method and controller sends it to service layer 
//	@GetMapping("/welcome")
//	public String welcome() {
//		//response is taken by from service layer and controller presents the information
//		return this.welcome.welcome();
//	}
	
	//using get method request is sent to url-courses to fetch list of courses available
	@GetMapping("/Courses")
	public List<Course> getCourses(){
		return this.courseservice.getCourses();
	}
	
	//using post method request is sent to url-courses to add list of courses
	@PostMapping("/Courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseservice.addCourse(course);	
	}
	
	
	@PutMapping("/Courses")
	public Course updateCourse(@RequestBody Course course) {
		
		return this.courseservice.updateCourse(course);
	}
	
	@DeleteMapping("/Courses/{cid}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable  String cid) {
		
		try {
		  this.courseservice.deleteCourse(Long.parseLong(cid));
		
		  return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
