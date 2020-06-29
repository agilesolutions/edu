package com.mycomp.test.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.mycomp.test.model.Customer;

public class CustomerPredicates {
	
	public static Predicate<Customer> isAdultMale() {
		return c -> c.getAge() > 21 && c.getGender().equalsIgnoreCase("M");
	}
	
	public static Predicate<Customer> isAdultFemale() {
		return c -> c.getAge() > 21 && c.getGender().equalsIgnoreCase("F");
	}
	
	
	public static List<Customer> filterEmployes (List<Customer> customers, Predicate<Customer> predicate) {
		
		return customers.stream().filter(predicate).collect(Collectors.toList()
				);
		
	}
	

}
