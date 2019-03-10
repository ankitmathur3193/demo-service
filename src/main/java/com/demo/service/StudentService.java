package com.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.StudentEntity;
import com.demo.exception.BadRequestException;
import com.demo.repositroy.StudentNameIdRepository;
import com.demo.repositroy.StudentRepository;
import com.demo.utils.ExceptionUtils;
import com.demo.web.rest.resource.StudentRequestResource;

@Service
public class StudentService {

	private StudentNameIdRepository studentNameIdRepository;
	private StudentRepository studentRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public StudentService(StudentNameIdRepository studentNameIdRepository,
			StudentRepository studentRepository) {
		this.studentNameIdRepository = studentNameIdRepository;
		this.studentRepository = studentRepository;
	}

	private StudentEntity handle(StudentRequestResource studentRequestResource) {
		StudentEntity studentEntity = new StudentEntity();
		BeanUtils.copyProperties(studentRequestResource, studentEntity);

		String nameId = studentEntity.getFirstName() + "#"
				+ studentEntity.getLastName() + "#"
				+ studentEntity.getDateOfBirth() + "#"
				+ studentEntity.getFatherName();
		Optional<Integer> id = studentNameIdRepository
				.getStudentByNameId(nameId);
		if (!id.isPresent()) {
			ExceptionUtils
					.throwEntityAlreadyExistsException("Student already exists with enrollementId: "
							+ id);
			logger.error("Id is not valid");
		} else {
			studentEntity.setAdmissiononStart(new Date());
			Integer enrollementId = studentRepository.save(studentEntity);
			studentNameIdRepository.save(nameId, enrollementId);
			studentEntity.setEnrollmentId(enrollementId);
		}
		return studentEntity;

	}

	private StudentRequestResource preHandle(
			StudentRequestResource studentRequestResource) {
		if (StringUtils.isEmpty(studentRequestResource.getFirstName())) {
			ExceptionUtils.throwBadRequestException("firstname is not valid");
		}
		return studentRequestResource;
	}

	public StudentEntity register(StudentRequestResource studentRequestResource) {
		return handle(preHandle(studentRequestResource));
	}

	public StudentEntity getStudentByEnrollmentId(Integer enrollmentId) {

		if (enrollmentId == null) {
			ExceptionUtils
					.throwBadRequestException("enrollmentId is not valid");
			logger.error("enrollmentd is not valid");
		}
		Optional<StudentEntity> studentEntity = studentRepository
				.getStudentById(enrollmentId);
		if (!studentEntity.isPresent()) {
			ExceptionUtils
					.throwEntityNotFoundException("student with enrollmentId not present");
		}
		return studentEntity.get();
	}

	public List<StudentEntity> getStudentByName(String firstName,
			String lastName) {
		if (StringUtils.isEmpty(lastName)) {
			return studentRepository.getStudentByFirstName(firstName).get();
		} else {
			return studentRepository.getStudentsByName(firstName, lastName)
					.get();
		}

	}

}
