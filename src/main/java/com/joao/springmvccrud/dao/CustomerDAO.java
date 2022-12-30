package com.joao.springmvccrud.dao;

import com.joao.springmvccrud.entities.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();
}
