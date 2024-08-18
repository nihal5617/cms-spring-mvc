package com.springboot.cms.service.impl;

import java.util.List;

import com.springboot.cms.model.Student;

public interface StudentService {
	Student createStudent(Student student);

	List<Student> getStudents();

	Student getStudent(Long id);

	Student updateStudent(Long id, Student student);

	void deleteStudent(Long id);
}
