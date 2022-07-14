package com.greatlearning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.entity.Student;


@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {
	
	List<Student> findByFirstnameContainsAndCountryContainsAllIgnoreCase(String firstname, String country);

	
}
