package com.demo.repositroy;

import java.util.List;
import java.util.Optional;

import com.demo.entity.StudentEntity;

public interface StudentRepository {

	public Optional<StudentEntity> getStudentById(Integer enrollemntId);
	
	public Optional<List<StudentEntity>> getStudentsByName(String firstName,String lastName);

	public Integer save(StudentEntity studentEntity);
	
	public Optional<List<StudentEntity>> getStudentByFirstName(String firstName);
	
}
