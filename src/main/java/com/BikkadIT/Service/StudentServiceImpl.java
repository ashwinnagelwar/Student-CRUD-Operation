package com.BikkadIT.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.Model.Student;
import com.BikkadIT.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServiceI {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student stu) {
		Student stu1=studentRepository.save(stu);
		return stu1;
	}

	@Override
	public Student getSingleStudent(int id) {
		Student stu=studentRepository.findById(id).get();
		return stu;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> stu=(List<Student>) studentRepository.findAll();
		return stu;
	}

	@Override
	public Student updatdeStudent(Student stu) {
		Student stu1 =studentRepository.save(stu);
		return stu1;
	}

	@Override
	public Student deleteStudent(int id) {
		studentRepository.deleteById(id);
		return null;
	}

	@Override
	public Student deleteAll() {
		studentRepository.deleteAll();
		return null;
	}

}
