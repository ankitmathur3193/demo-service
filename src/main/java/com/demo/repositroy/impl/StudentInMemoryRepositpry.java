package com.demo.repositroy.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.datatype.DatatypeConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.demo.entity.StudentEntity;
import com.demo.repositroy.StudentRepository;
import com.demo.utils.DataConstants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class StudentInMemoryRepositpry implements StudentRepository {

	private HashMap<Integer, StudentEntity> students;
	
	public StudentInMemoryRepositpry() {
		this.students = new HashMap<>();
	}

	@PostConstruct
	void init() throws JsonParseException, JsonMappingException, IOException {
		StudentEntity studentEntity = DataConstants.OBJECTMAPPER.readValue(
				DataConstants.STUDENT, StudentEntity.class);
		students.put(studentEntity.getEnrollmentId(), studentEntity);
	}

	@PreDestroy
	void cleanUp() {
		students.clear();
	}

	@Override
	public Optional<StudentEntity> getStudentById(Integer enrollemntId) {
		return Optional.ofNullable((StudentEntity) students.get(enrollemntId));
	}

	@Override
	public Integer save(StudentEntity studentEntity) {
		Integer id = students.size() + 1;
		students.put(id, studentEntity);
		return id;
	}

	@Override
	public Optional<List<StudentEntity>> getStudentsByName(String firstName,
			String lastName) {
		return Optional.ofNullable(students
				.entrySet()
				.stream()
				.filter(student -> student.getValue().getFirstName()
						.equalsIgnoreCase(firstName)
						&& student.getValue().getLastName()
								.equalsIgnoreCase(lastName))
				.map(studentEntry -> studentEntry.getValue())
				.collect(Collectors.toList()));
	}

	@Override
	public Optional<List<StudentEntity>> getStudentByFirstName(String firstName) {
		return Optional.ofNullable(students
				.entrySet()
				.stream()
				.filter(student -> student.getValue().getFirstName()
						.equalsIgnoreCase(firstName))
				.map(studentEntry -> studentEntry.getValue())
				.collect(Collectors.toList()));
	}

}
