package com.studentmanagement.studentmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.studentmanagement.entity.Student;
import com.studentmanagement.studentmanagement.exception.StudentNotFoundException;
import com.studentmanagement.studentmanagement.repository.StudentRepository;
import com.studentmanagement.studentmanagement.response.GlobalResponse;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	// to display the list of students (get all students)
	public List<Student> allStudent() {
		return studentRepository.findAll();
	}
	// to get a student by id 
	public Student getStudentById(Long id) {
		 Student studentId=studentRepository.findByStudentId(id);
		 
		 if(studentId==null) {
			 throw new StudentNotFoundException();// if student not found then throws exception 
		 }
		 return studentRepository.findByStudentId(id);
	}
	// to add a student 
	public GlobalResponse addStudent(Student student) {
		studentRepository.save(student);
		return new GlobalResponse(true,"Student added sucessfully");
	}
	// to update a student 
	public GlobalResponse updateStudent(Student student) {
		Student studentId=studentRepository.findByStudentId(student.getStudentId());
		if(studentId==null) {
			 throw new StudentNotFoundException();// if student not found then throws exception 
		 }
		
		studentRepository.save(student);
		return new GlobalResponse(true,"Student updated Sucessfully");
	}
	// to delete a student 
	public GlobalResponse deleteStudent(Long studentid) {
		Student deleteStudent=studentRepository.findByStudentId(studentid);
		
		if(deleteStudent==null) {
			throw new StudentNotFoundException();// if student not found then throws exception 
		}
		studentRepository.deleteById(studentid);
		return new GlobalResponse(true,"Student deleted Sucessfully");
	}
}
