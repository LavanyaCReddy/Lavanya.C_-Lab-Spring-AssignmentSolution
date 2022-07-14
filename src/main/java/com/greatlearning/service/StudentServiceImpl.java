package com.greatlearning.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.greatlearning.entity.Student;
import com.greatlearning.repo.IStudentRepository;


@Service
public class StudentServiceImpl implements IStudentService {
	
	
	@Autowired
     IStudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		
		List<Student> students=studentRepository.findAll();
		return students;
	}
	
	@Override
	public Student findById(int theId) {
		
		return studentRepository.findById(theId).get();
	}
	

	@Override
	public void save(Student theStudent) {
		
		studentRepository.save(theStudent);	
	}
	
	@Override
	public void deleteById(int theId) {
		
			studentRepository.deleteById(theId);	
	}
	


	@Override
	public List<Student> searchBy(String firstname,  String country) {
		List<Student> students=studentRepository.findByFirstnameContainsAndCountryContainsAllIgnoreCase(firstname, country);
		return students;

}

}

