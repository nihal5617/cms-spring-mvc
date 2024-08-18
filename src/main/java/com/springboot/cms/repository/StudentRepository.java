package com.springboot.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.cms.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
