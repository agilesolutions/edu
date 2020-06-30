package com.mycomp.test.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mycomp.test.model.Customer;
import com.mycomp.test.problem.CustomerNotFoundProblem;

@Controller
public class CustomerController {
	
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        var customer = new Customer(1L, 11, "F", "Tweet", "Tweety");
        return customer;
    }

    @GetMapping("/customers/{name}")
    public Customer getCustomerByName(@PathVariable String name) {
        var customer = new Customer(1L, 11, "F", "Tweet", "Tweety");
        return customer;
    }


    @GetMapping("/customers/notfound/{id}")
    public Customer getCustomerNotExisting(@PathVariable Long id) {
        throw new CustomerNotFoundProblem(id);
    }

}
