package com.demo.repositroy.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Repository;

import com.demo.entity.StudentEntity;
import com.demo.repositroy.StudentRepository;
import com.demo.utils.DataConstants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Repository
public class StudentInMemoryRepositpry implements StudentRepository {

	private HashMap<Integer, StudentEntity> students;

	public StudentInMemoryRepositpry() {
		this.students = new HashMap<>();
	}

	@PostConstruct
	void init() throws JsonParseException, JsonMappingException, IOException {
		String student = "{\"firstName\":\"Ankit\",\"lastName\":\"Mathur\",\"classEntity\":{\"currentClass\":1,\"section\":\"SECTION_A\"},\"fatherName\":\"R D Mathur\",\"motherName\":\"Renu Mathur\",\"contactNumber\":\"97177295562\",\"emailId\":\"amathur@gmail.com\",\"dateOfBirth\":{\"day\":8,\"month\":11,\"year\":1993},\"address\":{\"state\":\"Delhi\",\"pinCode\":110028,\"streetName\":\"Naraina vihar\"},\"classRollNo\":1,\"admissionStatus\":\"ACTIVE\",\"admissiononStart\":\"2019-03-03T06:29:56.254+0000\",\"enrollmentId\":1}";
		StudentEntity studentEntity = DataConstants.OBJECTMAPPER.readValue(student, StudentEntity.class);
		students.put(studentEntity.getEnrollmentId(), studentEntity);

	}

	@PreDestroy
	void cleanUp() {
		students.clear();
	}

	@Override
	public StudentEntity getStudentById(Integer enrollemntId) {
		return (StudentEntity) students.get(enrollemntId);
	}

	@Override
	public Integer save(StudentEntity studentEntity) {
		Integer id = students.size() + 1;
		students.put(id, studentEntity);
		return id;
	}

	@Override
	public List<StudentEntity> getStudentsByName(String firstName, String lastName) {
		return students.entrySet().stream()
				.filter(st -> st.getValue().getFirstName().equalsIgnoreCase(firstName)
						&& st.getValue().getLastName().equalsIgnoreCase(lastName))
				.map(x -> x.getValue()).collect(Collectors.toList());
	}

	@Override
	public List<StudentEntity> getStudentByFirstName(String firstName) {
		return students.entrySet().stream().filter(st -> st.getValue().getFirstName().equalsIgnoreCase(firstName))
				.map(x -> x.getValue()).collect(Collectors.toList());
	}

}
