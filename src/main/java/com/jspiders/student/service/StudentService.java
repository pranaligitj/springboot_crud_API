package com.jspiders.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.student.pojo.StudentPOJO;
import com.jspiders.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public StudentPOJO add(StudentPOJO student) {
		StudentPOJO pojo = repository.save(student);
		return pojo;
	}

	public StudentPOJO select(int id) {
		StudentPOJO pojo = repository.findById(id).orElse(null);
		return pojo;
	}


	public void remove(int id) {
		repository.deleteById(id);
	}

	public StudentPOJO update(int id, StudentPOJO student) {
		StudentPOJO  pojo = select(id);
			pojo.setName(student.getName());
			pojo.setEmail(student.getEmail());
			pojo.setCity(student.getCity());
		repository.save(student);
		return pojo;
	}
}
