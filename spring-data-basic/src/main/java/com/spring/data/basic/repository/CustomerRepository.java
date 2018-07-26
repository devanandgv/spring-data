package com.spring.data.basic.repository;

import org.springframework.data.repository.Repository;

import com.spring.data.basic.model.Customer;

public interface CustomerRepository extends Repository<Customer, Long> {

	Customer save(Customer customer);
	Customer findByName(String name);
	
}

