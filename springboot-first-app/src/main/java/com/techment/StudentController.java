package com.techment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	
	//http://localhost:8090/student	
	@GetMapping("/student")
	public Student GetStudent() {		
		return new Student("Krishna","Sahu") ;
	}

	//http://localhost:8090/students
	@GetMapping("/students")
	public List<Student> getStudents(){		
		List<Student>  students = new ArrayList<>();
		students.add(new Student("Anmol","Rahangdale"));
		students.add(new Student("Krish","Sahu"));
		students.add(new Student("Prateek","Lodhi"));
		students.add(new Student("Devesh","Manikpuri"));		
		return students;		
	}
	
	
	//http://localhost:8090/Krish/Sahu
	//Path variable annotations
	@GetMapping("{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName) 
	{	
		return new Student(firstName,lastName);
	} 
	
	//build rest API to handle query parameters 
	//http://localhost:8090/Student/query?firstName=Krish&lastName=Sahu
	
	@GetMapping("/student/query")
	public Student studentQueryparam(@RequestParam(name= "firstName") String firstName,@RequestParam(name = "lastName") String lastName) 
	{	
		return new Student(firstName,lastName);
	} 
	
}
