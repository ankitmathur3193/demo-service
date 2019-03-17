package com.demo.web.rest.controller;

import java.util.List;

import java.util.stream.Collectors;



import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.StudentEntity;
import com.demo.service.StudentService;
import com.demo.web.rest.assembler.StudentAssembler;
import com.demo.web.rest.resource.StudentRequestResource;
import com.demo.web.rest.resource.StudentResource;
import com.demo.web.rest.resource.StudentResponseResource;
import com.demo.web.rest.resource.UserResource;

@RestController
@RequestMapping("demoservice/v1/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.POST, value = "/student/register", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "Create a student")
	public ResponseEntity<StudentResponseResource> registerStudent(
			@RequestBody @ApiParam("Student Resource") StudentRequestResource studentRequestResource) {
		return new ResponseEntity<>(StudentAssembler.convert(studentService
				.register(studentRequestResource)), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{enrollmentId}", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "Get Student by EnrollmentID")
	public ResponseEntity<StudentResponseResource> getStudentByEnrollmentId(
			@ApiParam("Get student by enrollment id") @PathVariable("enrollmentId") Integer enrollmentId) {
		return new ResponseEntity<>(StudentAssembler.convert(studentService
				.getStudentByEnrollmentId(enrollmentId)), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/search/{firstName}", produces = "application/json; charset=UTF-8")
	@ApiOperation(value = "Get Students by Name")
	public ResponseEntity<List<StudentResponseResource>> getStudentsByName(
			@ApiParam("Get the students by name") @PathVariable("firstName") String firstName,
			@RequestParam(value = "lastName", required = false , defaultValue="") String lastName) {
		return new ResponseEntity<>(studentService
				.getStudentByName(firstName, lastName).stream()
				.map(StudentAssembler::convert).collect(Collectors.toList()),
				HttpStatus.OK);
	}
}
