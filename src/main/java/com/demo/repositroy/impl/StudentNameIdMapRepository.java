package com.demo.repositroy.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

import com.demo.entity.StudentEntity;
import com.demo.repositroy.StudentNameIdRepository;
import com.demo.utils.DataConstants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class StudentNameIdMapRepository implements StudentNameIdRepository {

	private HashMap<String, Integer> nameIdMap;
	public StudentNameIdMapRepository() {
		nameIdMap = new HashMap<>();
	}

	@PostConstruct
	void init() throws JsonParseException, JsonMappingException, IOException {
		StudentEntity studentEntity = DataConstants.OBJECTMAPPER.readValue(DataConstants.STUDENT,
				StudentEntity.class);
		String nameId = studentEntity.getFirstName() + "#"
				+ studentEntity.getLastName() + "#"
				+ studentEntity.getDateOfBirth() + "#"
				+ studentEntity.getFatherName();
		nameIdMap.put(nameId, studentEntity.getEnrollmentId());

	}
	
	@PreDestroy
	void cleanUp() {
		nameIdMap.clear();
	}
	
	@Override
	public Optional<Integer> getStudentByNameId(String nameIdString) {
		return Optional.ofNullable(nameIdMap.get(nameIdString));
	}

	@Override
	public void save(String nameIdString,Integer enrollmentId) {
		nameIdMap.put(nameIdString, enrollmentId);
	}
}
