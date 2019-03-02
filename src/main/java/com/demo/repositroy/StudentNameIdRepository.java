package com.demo.repositroy;

import com.demo.entity.StudentEntity;

public interface StudentNameIdRepository {

	public  Integer getStudentByNameId(String nameIdString);

	void save(String studentEntity, Integer enrollmentId);;
}
