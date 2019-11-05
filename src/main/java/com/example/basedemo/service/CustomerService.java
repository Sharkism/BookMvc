package com.example.basedemo.service;

import com.example.basedemo.dao.CustomerMapper;
import com.example.basedemo.pojo.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {

    private CustomerMapper customerMapper;
    @Resource(name = "customerMapper")
    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    public Customer getCustomer(Long id) {
        return customerMapper.getCustomerById(id);
    }

    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }

    public List<Customer> getCustomers() {
        return customerMapper.getAllCustomers();
    }
}
