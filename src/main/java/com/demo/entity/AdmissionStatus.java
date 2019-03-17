package com.demo.entity;

public enum AdmissionStatus {
  ACTIVE("active"),
  INACTIVE("inactive"),
  SUSPENDED("suspended");
  
  private final String alias;

 AdmissionStatus(final String alias) {
	this.alias = alias;
}
  
  
  
}
