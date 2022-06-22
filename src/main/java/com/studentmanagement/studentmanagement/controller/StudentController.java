package com.studentmanagement.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentmanagement.studentmanagement.entity.Student;
import com.studentmanagement.studentmanagement.response.GlobalResponse;
import com.studentmanagement.studentmanagement.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	// to get all the students
	@GetMapping("/student/all")
	public List<Student> allStudent(){
		return studentService.allStudent();
	}
	// to get a student with id 
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable Long id){
		return studentService.getStudentById(id);
	}
	// to add a student 
	@PostMapping("/student/add")
	public GlobalResponse addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	// to update a student 
	@PutMapping("/student/update")
	public GlobalResponse updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	// to delete a student 
	@DeleteMapping("/student/{studentid}")
	public GlobalResponse deleteStudent(@PathVariable Long studentid) {
		return studentService.deleteStudent(studentid);
	}
}
