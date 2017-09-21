package com.example.demo.tutorial3.service;

import java.util.List;

import com.example.demo.tutorial3.model.StudentModel;

public interface StudentService {
	StudentModel selectStudent(String npm);
	
	List<StudentModel> selectAllStudents();
	
	void addStudent(StudentModel student);

	void deleteStudent(String npm);

}