package com.springboot.cms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.cms.model.Student;
import com.springboot.cms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudent(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		Student existingStudent = studentRepository.findById(id).get();
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		return studentRepository.save(existingStudent);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

}
