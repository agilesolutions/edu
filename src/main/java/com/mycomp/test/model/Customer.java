package com.mycomp.test.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "age", nullable = false)
	private Integer age;
    @Column(name = "gender")
	private String gender;
    @Column(name = "first_name")
	private String firstName;
    @Column(name = "last_name")
	private String lastName;

	public Customer(Long id, Integer age, String gender, String firstName, String lastName) {
		super();
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
	}

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

}
