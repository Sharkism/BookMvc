package com.example.basedemo.controller;

import com.example.basedemo.pojo.Customer;
import com.example.basedemo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;
    @Resource(name = "customerService")
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String getCustomers() {
        return customerService.getCustomers().toString();
    }

    @PostMapping("/")
    public String addCustomer(Customer customer) {
        return "ok, but do nothing";
    }

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id).toString();
    }
}
