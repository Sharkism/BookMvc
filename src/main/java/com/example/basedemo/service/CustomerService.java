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
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    public CustomerService(SqlSessionFactory factory) {
        this.sqlSessionFactory = factory;
    }

    public Customer getCustomer(Long id) {
        SqlSession session = sqlSessionFactory.openSession();
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        Customer customer = customerMapper.getCustomerById(id);
        session.close();
        return customer;
    }

    public void addCustomer(Customer customer) {
//        customerMapper.addCustomer(customer);
    }

    public List<Customer> getCustomers() {
        SqlSession session = sqlSessionFactory.openSession();
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        List<Customer> list = customerMapper.getAllCustomers();
        session.close();
        return list;
    }
}
