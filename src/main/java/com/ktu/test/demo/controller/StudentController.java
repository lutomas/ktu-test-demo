package com.ktu.test.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktu.test.demo.domain.Student;
import com.ktu.test.demo.service.StudentService;

@RestController
public class StudentController {

	private StudentService service;
		
	@Autowired
    public StudentController(StudentService service) {
		super();
		this.service = service;
	}

	@RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/student")
    public List<Student> student() {
        return service.getStudents();
    }
}