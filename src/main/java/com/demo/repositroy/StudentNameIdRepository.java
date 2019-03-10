package com.demo.repositroy;

import java.util.Optional;

import com.demo.entity.StudentEntity;

public interface StudentNameIdRepository {

	public  Optional<Integer> getStudentByNameId(String nameIdString);

	void save(String studentEntity, Integer enrollmentId);;
}
