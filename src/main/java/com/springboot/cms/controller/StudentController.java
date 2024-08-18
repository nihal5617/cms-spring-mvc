package com.springboot.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.cms.model.Student;
import com.springboot.cms.service.impl.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// handler method to handle list students and return model and view
	@GetMapping("/students")
	public String listStudentsInUI(Model model) {
		model.addAttribute("students", studentService.getStudents());
		return "students";
	}

	// handler method for creating new student view
	@GetMapping("/students/form")
	public String studentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	// handler method to handle list students and return model and view
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudent(id));
		return "edit_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute Student student) {
		studentService.createStudent(student);
		return "redirect:/students";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute Student student, Model model) {

		studentService.updateStudent(id, student);
		return "redirect:/students";
	}

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}
}
