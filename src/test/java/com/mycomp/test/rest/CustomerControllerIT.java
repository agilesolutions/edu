package com.mycomp.test.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mycomp.test.App;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = App.class)
public class CustomerControllerIT {

	private static final String CONTENT_TYPE = "application/json";
	
	private MockMvc mockMvc;

	@Autowired
	private CustomerController customerController;

	@Before
	public void setup() {

		this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

	}

	@Test
	public void givenCustomerURL_whenMockMVC_thenVerifyResponse() throws Exception {
		final MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/customer")).andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Tweet")).andReturn();
		Assert.assertEquals(CONTENT_TYPE, mvcResult.getResponse().getContentType());
	}

	

	@Test
	public void givenBadRequest_whenMockMVC_thenVerifyResponse() throws Exception {
		final MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/bad")).andDo(print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Tweet")).andReturn();
		Assert.assertEquals(CONTENT_TYPE, mvcResult.getResponse().getContentType());
	}

}
