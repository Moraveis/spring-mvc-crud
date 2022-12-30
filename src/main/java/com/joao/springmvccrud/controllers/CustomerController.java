package com.joao.springmvccrud.controllers;

import com.joao.springmvccrud.dao.CustomerDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerDAOImpl customerDao;

    public CustomerController(CustomerDAOImpl customerDao) {
        this.customerDao = customerDao;
    }

    @RequestMapping("/list")
    public String getCostumers(Model model) {
        model.addAttribute("customers", customerDao.getCustomers());
        return "list-customers";
    }
}
