package com.mycomp.test.dto;

public class CustomerDto {
	
	private Long id;
	private Integer age;
	private String gender;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public CustomerDto(Long id, Integer age, String gender) {
		super();
		this.id = id;
		this.age = age;
		this.gender = gender;
	}
	
	

}
