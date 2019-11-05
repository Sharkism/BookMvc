package com.example.basedemo.dao.mappers;

import com.example.basedemo.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component("customerMapper")
public interface CustomerMapper {
    Customer getCustomerById(Long id);

    void addCustomer(Customer customer);

    List<Customer> getAllCustomers();
}
