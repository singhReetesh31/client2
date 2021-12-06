package com.axis.service;
import java.util.List;

import com.axis.entity.Customer;
public interface ICustomerService {
void addCustomer(Customer customer);
List<Customer> getAllCustomer();
Customer getCustomer(int id);
void deleteCustomer(int id);
}
