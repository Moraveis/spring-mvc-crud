package com.joao.springmvccrud.services;

import com.joao.springmvccrud.entities.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();
}
