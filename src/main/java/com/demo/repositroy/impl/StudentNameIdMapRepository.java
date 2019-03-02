package com.demo.repositroy.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.entity.StudentEntity;
import com.demo.repositroy.StudentNameIdRepository;

@Repository
public class StudentNameIdMapRepository implements StudentNameIdRepository {

	private HashMap<String, Integer> nameIdMap;

	public StudentNameIdMapRepository() {
		nameIdMap = new HashMap<>();
	}

	@Override
	public Integer getStudentByNameId(String nameIdString) {
		return nameIdMap.get(nameIdString);
	}

	@Override
	public void save(String nameIdString,Integer enrollmentId) {
	
		nameIdMap.put(nameIdString, enrollmentId);
	}

}
