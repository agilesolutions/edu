package com.mycomp.test.cucumber.stepdefs;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mycomp.test.rest.CustomerController;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerStepDefs extends StepDefs {

	@Autowired
	private CustomerController customerController;

	private MockMvc restCustomerMockMvc;

	@Before
	public void setup() {
		this.restCustomerMockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	@When("I search customer assortment by identifier {int}")
	public void i_search_customer_assortment_by_identifier(Integer id) throws Throwable {
		actions = restCustomerMockMvc.perform(get("/api/customers/" + id).accept(MediaType.APPLICATION_JSON));
	}

	@Then("the customer assortment is found")
	public void the_customer_assortment_is_found() throws Throwable {
		actions.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
	}

	@Then("its assortment title is {string}")
	public void its_assortment_title_is(String title) throws Throwable {
		actions.andExpect(jsonPath("$.title").value(title));
	}

	@When("I search customer rating by id {int}")
	public void i_search_customer_rating_by_id(Integer id) throws Throwable {
        actions = restCustomerMockMvc.perform(get("/api/customers/" + id)
                .accept(MediaType.APPLICATION_JSON));
	}

	@Then("the customer rating is found")
	public void the_customer_rating_is_found() throws Throwable {
        actions
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
	}

	@Then("its rating level is {int}")
	public void its_rating_level_is(Integer rating) throws Throwable {
        actions.andExpect(jsonPath("$.rating").value(rating));
	}

}