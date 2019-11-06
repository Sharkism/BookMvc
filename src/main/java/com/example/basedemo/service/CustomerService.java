package com.example.basedemo.service;

import com.example.basedemo.dao.mappers.CustomerMapper;
import com.example.basedemo.pojo.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {

//    private CustomerMapper customerMapper;
//    @Resource(name = "customerMapper")
//    public void setCustomerMapper(CustomerMapper customerMapper) {
//        this.customerMapper = customerMapper;
//    }

    public Customer getCustomer(Long id) {
        return null;
//        return customerMapper.getCustomerById(id);
    }

    public void addCustomer(Customer customer) {
//        customerMapper.addCustomer(customer);
    }

    public List<Customer> getCustomers() {
        return null;
//        return customerMapper.getAllCustomers();
    }
}
