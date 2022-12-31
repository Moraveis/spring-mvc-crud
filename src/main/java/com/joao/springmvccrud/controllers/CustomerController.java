package com.joao.springmvccrud.controllers;

import com.joao.springmvccrud.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String getCostumers(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        return "list-customers";
    }
}
