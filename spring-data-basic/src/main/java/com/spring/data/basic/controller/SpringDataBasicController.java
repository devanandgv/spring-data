package com.spring.data.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.basic.model.Address;
import com.spring.data.basic.model.Customer;
import com.spring.data.basic.repository.AddressRepository;
import com.spring.data.basic.repository.CustomerRepository;

@RestController
@RequestMapping("/v1")
public class SpringDataBasicController {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;

	@GetMapping(path="/name/{name}",produces={"application/json"})
	public @ResponseBody Customer getCustomer(@PathVariable("name") String name) {

		System.out.println("In get customer controller");
		Customer customer = customerRepository.findByName(name);
		Address addr = addressRepository.findByCustomerName(name);
		System.out.println(addr.toString());
		
		System.out.println(customer.toString());
		return customer;
	}

	@PostMapping(consumes={"application/json"},produces={"application/json"})
	public String putCustomer(@RequestBody Customer customer) {

		System.out.println("In put customer controller "+customer.toString());
		Address address = customer.getAddress();
		address.setCustomer(customer);
		addressRepository.save(address);
		Customer cust = customerRepository.save(customer);
		System.out.println(cust.toString());
		return "{\"status\":\"success\"}";
	}
}
