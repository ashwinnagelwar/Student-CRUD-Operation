package com.BikkadIT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Model.Student;
import com.BikkadIT.Service.StudentServiceI;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceI studentServiceI;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Integer> savStudent(@RequestBody Student student)
	{
		
		Student student1=studentServiceI.saveStudent(student);
		int id=student1.getId();
		
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id)
	{
		Student student=studentServiceI.getSingleStudent(id);
		return new ResponseEntity<Student>(student,HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudent()
	{
		List<Student> studentList=studentServiceI.getAllStudent();
		return new ResponseEntity<List<Student>>(studentList,HttpStatus.FOUND);
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student)
	{
		Student student1=studentServiceI.updatdeStudent(student);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deletStudent(@PathVariable int id)
	{
		String msg=null;
		Student student1=studentServiceI.getSingleStudent(id);
		
		studentServiceI.deleteStudent(id);
		List<Student> studentList=studentServiceI.getAllStudent();
		for(Student stu:studentList)
		{
			if(student1!=stu)
			{
				msg="Your Student with id "+id+"Deleted Successfully";
			}
			else if(student1.equals(stu))
			{
				msg="Sorry your Student with id "+id+"cant be deleted";
			}
		}
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
