package com.jspiders.student.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jspiders.student.pojo.StudentPOJO;
import com.jspiders.student.response.StudentResponse;
import com.jspiders.student.service.StudentService;

import jakarta.persistence.Id;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/add")
	ResponseEntity<StudentResponse> add(@RequestBody StudentPOJO student){
		StudentPOJO pojo = service.add(student);
		
		if (pojo!=null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse(
					"OK", "Student added successfully..!!",pojo,null),HttpStatus.OK);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse(
				"FAIL", "Student data not found",null,null),HttpStatus.BAD_REQUEST);
		
	}

	@GetMapping("/select{id}")
	ResponseEntity<StudentResponse> select(@PathVariable int id){
		StudentPOJO pojo = service.select(id);
		
		if (pojo!=null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse(
					"OK", "Student details found successfully..!!",pojo,null),HttpStatus.FOUND);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse(
				"OK", "Invalid request..!!",null,null),HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/remove{id}")
	ResponseEntity<StudentResponse> remove(@PathVariable int id){
		service.remove(id);
			return new ResponseEntity<StudentResponse>(new StudentResponse(
					"OK", "Student record deleted successfully..!!",null,null),HttpStatus.OK);
		}
	
	@PostMapping("/update{id}")
	ResponseEntity<StudentResponse> update(@PathVariable int id, @RequestBody StudentPOJO student){
		StudentPOJO pojo = service.update(id,student);
		if (pojo!=null) {
			return new ResponseEntity<StudentResponse>(new StudentResponse(
					"OK", "Student updated successfully..!!",pojo,null),HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<StudentResponse>(new StudentResponse(
				"OK", "Invalid request..!!",pojo,null),HttpStatus.BAD_REQUEST);
	}
	
}
