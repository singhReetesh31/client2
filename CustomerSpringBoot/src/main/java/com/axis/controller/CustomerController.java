package com.axis.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.entity.Customer;
import com.axis.exception.IdNotFoundException;
import com.axis.service.CustomerService;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	@Autowired
private CustomerService customerService;
	@PostMapping(value="/addCustomer")
	public void addCusomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	@GetMapping(value="/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(),HttpStatus.OK);
	}
	
	@GetMapping(value="/getCustomer/{id}")
	public ResponseEntity<Object> getCustomer(@PathVariable int id){
		try {
			return new ResponseEntity<Object>(customerService.getCustomer(id),HttpStatus.OK);
		}
		catch(Exception e) {
			throw new IdNotFoundException("No customer found with this id");
		}
	}
	
	@DeleteMapping(value="/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable int id) {
		try {
			customerService.getCustomer(id);
			customerService.deleteCustomer(id);
			
		}
		catch(NoSuchElementException e) {
			throw new IdNotFoundException("id not found");
		}
	}
	@ExceptionHandler(value=IdNotFoundException.class)
	public ResponseEntity<Object> IdExceptionHandler(IdNotFoundException e){
		return new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}
