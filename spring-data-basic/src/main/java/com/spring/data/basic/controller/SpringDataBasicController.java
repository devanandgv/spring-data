package com.spring.data.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.basic.model.Customer;
import com.spring.data.basic.repository.CustomerRepository;

@RestController
@RequestMapping("/v1")
public class SpringDataBasicController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping(path = "/name/{name}", produces = { "application/json" })
	public @ResponseBody Customer getCustomer(@PathVariable("name") String name) {

		return customerRepository.findByName(name);
	}

	@PostMapping(consumes = { "application/json" }, produces = { "application/json" })
	public String putCustomer(@RequestBody Customer customer) {

		customerRepository.save(customer);
		return "{\"status\":\"success\"}";
	}
}
