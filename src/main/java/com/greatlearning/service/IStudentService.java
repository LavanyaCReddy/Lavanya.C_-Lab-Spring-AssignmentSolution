package com.greatlearning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.entity.Student;


@Service
public interface IStudentService {
	
	public List<Student> findAll();
	
	public Student findById(int theId);
	
	public void save (Student theStudent);
	
	public void deleteById(int theId);
	
	public List<Student> searchBy(String firstname, String country);

}
