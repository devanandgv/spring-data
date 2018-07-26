package com.spring.data.basic.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spring.data.basic.model.Customer;

@Component
@Aspect
public class SpringDataBasicLogger {

	private Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());
	
	@Before("execution(* com.spring.data.basic.controller.SpringDataBasicController.getCustomer(..)) && args(name)")
	public void getCustomerBefore(String name){
		
		logger.info("SpringDataBasicController getCustomer customerName : {}",name);
		
	}
	
	@AfterReturning( pointcut="execution(* com.spring.data.basic.controller.SpringDataBasicController.getCustomer(..))" ,returning="customer")
	public void getCustomerAfter(Customer customer){
		
		logger.info("SpringDataBasicController customer : {}",customer.toString());
		
	}
	@Before("execution(* com.spring.data.basic.controller.SpringDataBasicController.putCustomer(..)) && args(customer)")
	public void putCustomerBefore(Customer customer){
		
		logger.info("SpringDataBasicController putcustomer : {}",customer.toString());
	}
}
