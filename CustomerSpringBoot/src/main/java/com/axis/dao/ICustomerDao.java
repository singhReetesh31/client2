package com.axis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.entity.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Integer>{ 

}
