package com.demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConstants {
	public static final ObjectMapper OBJECTMAPPER = new ObjectMapper();
	public static final String STUDENT = "{\"firstName\":\"Ankit\",\"lastName\":\"Mathur\",\"classEntity\":{\"currentClass\":1,\"section\":\"SECTION_A\"},\"fatherName\":\"R D Mathur\",\"motherName\":\"Renu Mathur\",\"contactNumber\":\"97177295562\",\"emailId\":\"amathur@gmail.com\",\"dateOfBirth\":{\"day\":8,\"month\":11,\"year\":1993},\"address\":{\"state\":\"Delhi\",\"pinCode\":110028,\"streetName\":\"Naraina vihar\"},\"classRollNo\":1,\"admissionStatus\":\"ACTIVE\",\"admissiononStart\":\"2019-03-03T06:29:56.254+0000\",\"enrollmentId\":1}";
}
