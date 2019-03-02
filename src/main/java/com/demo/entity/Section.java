package com.demo.entity;

public enum Section {
	SECTION_A("A"),
	SECTION_B("B"),
	SECTION_C("C");
	private final String alias;

	Section(String alias) {
		this.alias = alias;
	}

	public String getSectionName(){
		return this.alias;
	}
}
