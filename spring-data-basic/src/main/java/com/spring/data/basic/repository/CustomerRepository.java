package com.spring.data.basic.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.data.basic.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Customer findByName(String name);
}

