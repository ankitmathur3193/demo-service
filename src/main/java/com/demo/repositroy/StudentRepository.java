package com.demo.repositroy;

import java.util.List;

import com.demo.entity.StudentEntity;

public interface StudentRepository {

	public StudentEntity getStudentById(Integer enrollemntId);
	
	public List<StudentEntity> getStudentsByName(String firstName,String lastName);

	public Integer save(StudentEntity studentEntity);
	
	public List<StudentEntity> getStudentByFirstName(String firstName);
	
}
