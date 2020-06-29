package com.mycomp.test.mapping;

import com.mycomp.test.dto.CustomerDto;
import com.mycomp.test.model.Customer;

public class CustomerMapper implements ObjectMapper<Customer, CustomerDto>{

	@Override
	public CustomerDto mapToDto(Customer c) {
		return new CustomerDto(c.getId(), c.getAge(), c.getGender());
	}

	@Override
	public Customer mapFromDto(CustomerDto d) {
		return new Customer(d.getId(), d.getAge(), d.getGender(),null, null);
	}

}
