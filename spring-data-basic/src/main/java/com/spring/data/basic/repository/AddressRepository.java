package com.spring.data.basic.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.data.basic.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long>{
	
	Address findByCustomerName(String name);

}
