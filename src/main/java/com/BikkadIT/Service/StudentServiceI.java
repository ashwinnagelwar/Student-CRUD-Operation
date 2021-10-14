package com.BikkadIT.Service;

import java.util.List;

import com.BikkadIT.Model.Student;

public interface StudentServiceI {
	
	public Student saveStudent(Student stu);
	public Student getSingleStudent(int id );
	public List<Student> getAllStudent();
	public Student updatdeStudent(Student stu);
	public Student deleteStudent(int id);
	public Student deleteAll();

}
