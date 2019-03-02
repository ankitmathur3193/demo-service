package com.demo.repositroy.impl;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.demo.entity.StudentEntity;
import com.demo.repositroy.StudentRepository;

@Repository
public class StudentInMemoryRepositpry implements StudentRepository {

	private HashMap<Integer, StudentEntity> students;

	public StudentInMemoryRepositpry() {
		this.students = new HashMap<>();
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
	public List<StudentEntity> getStudentsByName(String firstName,
			String lastName) {
		// TODO Auto-generated method stub
		return students
				.entrySet()
				.stream()
				.filter(st -> st.getValue().getFirstName().equalsIgnoreCase(firstName)
						&& st.getValue().getLastName().equalsIgnoreCase(lastName))
				.map(x -> x.getValue()).collect(Collectors.toList());
	}

	@Override
	public List<StudentEntity> getStudentByFirstName(String firstName) {
		// TODO Auto-generated method stub

		return students.entrySet().stream()
				.filter(st -> st.getValue().getFirstName().equalsIgnoreCase(firstName))
				.map(x -> x.getValue()).collect(Collectors.toList());
	}

}
