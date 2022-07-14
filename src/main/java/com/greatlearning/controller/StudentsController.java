package com.greatlearning.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.entity.Student;
import com.greatlearning.service.IStudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {
	
	
	@Autowired
	private IStudentService studentService;

	
@RequestMapping("/list")
public String listStudents(Model theModel) {
	
	List<Student> theStudents = studentService.findAll();
	
	theModel.addAttribute("Students", theStudents);
	
	return "list-Students";
	
}



	@RequestMapping("/showFormForAdd")
 public String showFormForAdd(Model theModel) {
		
		Student theStudent = new Student();
		
		theModel.addAttribute("Student", theStudent);
		
		return"Student-from";
	}
	
	
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId")int theId, Model theModel) {
		
		Student theStudent = studentService.findById(theId);
		
		theModel.addAttribute("Student", theStudent);
		
		return "Student-form";
	}

	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id,
			@RequestParam("firstname") String firstname,@RequestParam("lastname")String lastname,@RequestParam("course") String course,@RequestParam("country") String country) {

		System.out.println(id);
		Student theStudent;
		if(id!=0)
		{
			theStudent=studentService.findById(id);
			theStudent.setFirstname(firstname);
			theStudent.setLastname(lastname);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
		}
		else
			theStudent=new Student(id, firstname, lastname, course, country);
	
		studentService.save(theStudent);


		
		return "redirect:/students/list";

	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

	
		studentService.deleteById(theId);

	
		return "redirect:/students/list";

	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("firstname") String firstname,
			@RequestParam("country") String country,
			Model theModel) {

		
		if (firstname.trim().isEmpty() && country.trim().isEmpty()) {
			return "redirect:/studens/list";
		}
		else {
			
			List<Student> theStudents =
					studentService.searchBy(firstname, country);

			theModel.addAttribute("Students", theStudents);

			return "list-Students";
		}

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
