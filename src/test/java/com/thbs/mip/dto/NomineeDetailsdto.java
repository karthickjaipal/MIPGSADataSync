package com.thbs.mip.dto;

public class NomineeDetailsdto {
	String name;
	Integer age;
	String msisdn;
	String relationship;
	String gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "NomineeDetailsdto [name=" + name + ", age=" + age + ", msisdn=" + msisdn + ", relationship="
				+ relationship + ", gender=" + gender + "]";
	}

	

}
