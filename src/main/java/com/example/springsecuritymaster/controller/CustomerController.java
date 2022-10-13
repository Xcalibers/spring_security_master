package com.example.springsecuritymaster.controller;

import com.example.springsecuritymaster.dao.CustomerDao;
import com.example.springsecuritymaster.ds.Customer;
import com.example.springsecuritymaster.security.annotations.customer.IsCustomerCreate;
import com.example.springsecuritymaster.security.annotations.customer.IsCustomerDelete;
import com.example.springsecuritymaster.security.annotations.customer.IsCustomerRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@Controller
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @IsCustomerRead
    @GetMapping("/customers")
    public String findAllCustomer(Model model) {
        model.addAttribute("customers", customerDao.findAll());

        return "customers";
    }

    @IsCustomerCreate
    @GetMapping("/create-customer")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @IsCustomerCreate
    @PostMapping("/create-customer")
    public String processCustomer(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-form";
        }
        customerDao.save(customer);
        return "redirect:/customers";
    }

    @IsCustomerDelete
    @GetMapping("/customers/delete")
    public String deleteCustomer(@RequestParam("id") int id) {
        customerDao.deleteById(id);
        return "redirect:/customers";
    }
}
