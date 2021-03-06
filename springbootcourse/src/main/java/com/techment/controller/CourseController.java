package com.techment.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techment.entity.Course;
import com.techment.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService service;
	
	
	@GetMapping("/courses")
	public List<Course> list()
	{
		
		return service.listAll();
	}
	
	
	@PostMapping("/add")
	public String add(@RequestBody Course course) {
	service.save(course);
	
	return "course added";
	}
	
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> get(@PathVariable int id) {
		try {
		Course c = service.get(id);
		return new ResponseEntity<Course>(c, HttpStatus.OK);
		} catch (NoSuchElementException e) {
		return new
		ResponseEntity<Course>(HttpStatus.NOT_FOUND);
		}		
	}
	
	
	@PutMapping("/update/{id}")
	public String update(@RequestBody Course course, @PathVariable int id) {
	try {
	// if the course already exists, update it
	Course c = service.get(id);
	service.save(course);
	return "course updated succefully";
	} catch (NoSuchElementException e) {
	return "Not a valid course id";
	}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCourse(@PathVariable int id) {
	try {
	// if the course already exists, update it
	Course c = service.get(id);
	service.delete(id);
	return "course deleted succefully";
	} catch (NoSuchElementException e) {
	return "Not a valid course id";
	}
	}

	
	
}
