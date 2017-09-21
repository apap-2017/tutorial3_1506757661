package com.example.demo.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.tutorial3.model.StudentModel;

public class InMemoryStudentService implements StudentService {
	private static List<StudentModel> studentList = new ArrayList<StudentModel>();

	@Override
	public StudentModel selectStudent(String npm) {
		for (int i = 0; i < studentList.size(); i++) {
			StudentModel cari = studentList.get(i);
			if (cari.getNpm().equals(npm)) {
				return cari;
			}
		}
		return null;
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		return studentList;
	}

	@Override
	public void addStudent(StudentModel student) {
		studentList.add(student);
	}

	@Override
	public void deleteStudent(String npm) {
		for (int i = 0; i < studentList.size(); i++) {
			StudentModel cari = studentList.get(i);
			if (cari.getNpm().equals(npm)) {
				studentList.remove(i);
			}
		}
	}

}
