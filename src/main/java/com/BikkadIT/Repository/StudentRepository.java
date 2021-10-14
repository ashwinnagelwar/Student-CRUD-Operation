package com.BikkadIT.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Serializable>{

}
