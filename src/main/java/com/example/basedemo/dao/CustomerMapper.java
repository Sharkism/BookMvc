package com.example.basedemo.dao;

import com.example.basedemo.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    Customer getCustomerById(Long id);

    void addCustomer(Customer customer);

    List<Customer> getAllCustomers();
}
