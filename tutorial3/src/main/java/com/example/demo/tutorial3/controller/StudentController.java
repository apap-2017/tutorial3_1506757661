package com.example.demo.tutorial3.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.tutorial3.model.StudentModel;
import com.example.demo.tutorial3.service.InMemoryStudentService;
import com.example.demo.tutorial3.service.StudentService;

@Controller
public class StudentController {
	private final StudentService studentService;
	
	public StudentController() {
		studentService = new InMemoryStudentService();
	}
	
	@RequestMapping("/student/add")
	public String add (@RequestParam(value = "npm", required = true) String npm,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "gpa", required = true) double gpa) {
		StudentModel student = new StudentModel (npm, name, gpa);
		studentService.addStudent(student);
	
		return "add";
	}

	
/*	
	@RequestMapping("/student/view")
	public String view (Model model, @RequestParam(value="npm", required = true) String npm) {
		StudentModel student = studentService.selectStudent(npm);
		model.addAttribute("student", student);
		return "view";
	}
*/
	
	@RequestMapping("/student/viewall")
	public String viewAll(Model model) {
		List <StudentModel> students = studentService.selectAllStudents();
		model.addAttribute("students", students);
		return "viewall";
	}

	
	@RequestMapping("/student/view")
	public String view (Model model, @RequestParam(value="npm", required = false, defaultValue= "null") String npm) {
		
		if (npm.equals("null")) {
			model.addAttribute("hasil", "NPM kosong");
			return "salah";
		}
		StudentModel student = studentService.selectStudent(npm);
		model.addAttribute("student", student);
		return "view";
	}
	
	@RequestMapping("/student/view/{npm}")
	public String viewPath (@PathVariable String npm, Model model)
	{			
			StudentModel student = studentService.selectStudent(npm);
			if (student == null) {
				model.addAttribute("hasil", "NPM tidak ditemukan");
				return "salah";
			}	
			model.addAttribute("student", student);
			return "view";

	} 
	
	@RequestMapping("/student/delete")
	public String delete (Model model, @RequestParam(value="npm", required = false, defaultValue= "null") String npm) {
		model.addAttribute("hasil", "NPM kosong dan proses delete dibatalkan");
		return "salah";
}
	
	@RequestMapping("/student/delete/{npm}")
	public String deletePath (@PathVariable String npm, Model model)
	{			
			StudentModel student = studentService.selectStudent(npm);
			if (student == null) {
				model.addAttribute("hasil", "NPM tidak ditemukan dan proses delete dibatalkan");
				return "salah";
			}
			studentService.deleteStudent(npm);	
			model.addAttribute("hasil", "Data telah berhasil dihapus");
			return "salah";

	} 
}


			
			
 
