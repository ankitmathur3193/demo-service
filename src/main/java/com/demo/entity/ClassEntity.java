package com.demo.entity;

public class ClassEntity {

	private Integer currentClass;
	private Section section;
   
	public ClassEntity() {
		super();
	}
	
	public ClassEntity(Integer currentClass, Section section) {
		super();
		this.currentClass = currentClass;
		this.section = section;
	}

	public Integer getCurrentClass() {
		return currentClass;
	}


	public void setCurrentClass(Integer currentClass) {
		this.currentClass = currentClass;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

}
