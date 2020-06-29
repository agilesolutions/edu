package com.mycomp.test.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycomp.test.model.Customer;

@Controller
public class CustomerController {
	
    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Customer getRandomCustomer() {
        var customer = new Customer(1, 11, "F", "Tweet", "Tweety");
        return customer;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Customer getCustomerByName(@RequestParam("name") String name) {
        var customer = new Customer(1, 11, "F", "Tweet", "Tweety");
        return customer;
    }
    
}
