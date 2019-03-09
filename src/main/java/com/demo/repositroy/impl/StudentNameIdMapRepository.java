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
		String student = "{\"firstName\":\"Ankit\",\"lastName\":\"Mathur\",\"classEntity\":{\"currentClass\":1,\"section\":\"SECTION_A\"},\"fatherName\":\"R D Mathur\",\"motherName\":\"Renu Mathur\",\"contactNumber\":\"97177295562\",\"emailId\":\"amathur@gmail.com\",\"dateOfBirth\":{\"day\":8,\"month\":11,\"year\":1993},\"address\":{\"state\":\"Delhi\",\"pinCode\":110028,\"streetName\":\"Naraina vihar\"},\"classRollNo\":1,\"admissionStatus\":\"ACTIVE\",\"admissiononStart\":\"2019-03-03T06:29:56.254+0000\",\"enrollmentId\":1}";
		ObjectMapper objectMapper = new ObjectMapper();
		StudentEntity studentEntity = objectMapper.readValue(student,
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
	public Integer getStudentByNameId(String nameIdString) {
		return Optional.ofNullable(nameIdMap.get(nameIdString)).get();
	}

	@Override
	public void save(String nameIdString,Integer enrollmentId) {
		nameIdMap.put(nameIdString, enrollmentId);
	}
}
