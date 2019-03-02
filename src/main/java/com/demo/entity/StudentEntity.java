package com.demo.entity;

import java.util.Date;

public class StudentEntity {

	private String firstName;
	private String lastName;
	private ClassEntity classEntity;
	private String fatherName;
	private String motherName;
	private String contactNumber;
	private String emailId;
	private DateOfBirth dateOfBirth;
	private Address address;
	private Integer classRollNo;
	private AdmissionStatus admissionStatus;
	private Date admissiononStart;
	private Date admissionEnd;
	private Integer enrollmentId;

	public StudentEntity() {
		super();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ClassEntity getClassEntity() {
		return classEntity;
	}
	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public DateOfBirth getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(DateOfBirth dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Integer getClassRollNo() {
		return classRollNo;
	}
	public void setClassRollNo(Integer classRollNo) {
		this.classRollNo = classRollNo;
	}
	public AdmissionStatus getAdmissionStatus() {
		return admissionStatus;
	}
	public void setAdmissionStatus(AdmissionStatus admissionStatus) {
		this.admissionStatus = admissionStatus;
	}
	public Date getAdmissiononStart() {
		return admissiononStart;
	}
	public void setAdmissiononStart(Date admissiononStart) {
		this.admissiononStart = admissiononStart;
	}
	public Date getAdmissionEnd() {
		return admissionEnd;
	}
	public void setAdmissionEnd(Date admissionEnd) {
		this.admissionEnd = admissionEnd;
	}
	public Integer getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(Integer enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
}
