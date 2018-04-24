package com.ktu.test.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktu.test.demo.domain.Student;
import com.ktu.test.demo.repo.StudentRepository;

@Service
public class StudentService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private StudentRepository repo;

	@Autowired
	public StudentService(StudentRepository repo) {
		super();
		this.repo = repo;
	}

	public List<Student> getStudents() {
		logger.info("getStudents");
		return repo.findAll();
	}

}
