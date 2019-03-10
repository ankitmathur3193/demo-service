package com.demo.web.rest.assembler;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.BeanUtils;

import com.demo.entity.StudentEntity;
import com.demo.web.rest.resource.StudentResponseResource;

public class StudentAssembler {
	
	public static StudentResponseResource convert(StudentEntity studentEntity){
		StudentResponseResource studentResponseResource = new StudentResponseResource();
		BeanUtils.copyProperties(studentEntity, studentResponseResource);
		return studentResponseResource;
	}

}
