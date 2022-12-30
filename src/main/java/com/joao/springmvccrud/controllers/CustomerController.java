package com.joao.springmvccrud.controllers;

import com.joao.springmvccrud.dao.CustomerDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerDAO customerDao;

    public CustomerController(CustomerDAO customerDao) {
        this.customerDao = customerDao;
    }

    @RequestMapping("/list")
    public String getCostumers(Model model) {
        model.addAttribute("customers", customerDao.getCustomers());
        return "list-customers";
    }
}
