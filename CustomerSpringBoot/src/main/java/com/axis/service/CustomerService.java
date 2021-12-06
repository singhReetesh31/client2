package com.axis.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.dao.ICustomerDao;
import com.axis.entity.Customer;
@Service
public class CustomerService implements ICustomerService{
	@Autowired
private ICustomerDao dao;
	@Override
	public void addCustomer(Customer customer) {
		dao.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return dao.findAll();
	}

	@Override
	public Customer getCustomer(int id) throws NoSuchElementException{
		Customer c=dao.findById(id).get();
		return c;
	}

	@Override
	public void deleteCustomer(int id) {
		dao.deleteById(id);
	}

}
