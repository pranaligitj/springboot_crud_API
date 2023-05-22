package com.jspiders.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.student.pojo.StudentPOJO;

public interface StudentRepository extends JpaRepository<StudentPOJO, Integer>{

	StudentPOJO findByName(String name);

	StudentPOJO deleteById(StudentPOJO student);
}
