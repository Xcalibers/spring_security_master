package com.example.springsecuritymaster.controller;

import com.example.springsecuritymaster.dao.EmployeeDao;
import com.example.springsecuritymaster.ds.Employee;
import com.example.springsecuritymaster.security.annotations.employees.IsEmployeeAdmin;
import com.example.springsecuritymaster.security.annotations.employees.IsEmployeeCreate;
import com.example.springsecuritymaster.security.annotations.employees.IsEmployeeDelete;
import com.example.springsecuritymaster.security.annotations.employees.IsEmployeeRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @IsEmployeeRead
    @GetMapping("/employees")
    public ModelAndView showEmployees() {
        return new ModelAndView("employees", "employees", employeeDao.findAll());
    }

    @IsEmployeeCreate
    @GetMapping("/createEmployee")
    public String createEmployee(Model model) {

        model.addAttribute("employee", new Employee());
        return "employeeForm";
    }

    @IsEmployeeCreate
    @PostMapping("/create-Employee")
    public String saveEmployee(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/";
        }
        employeeDao.save(employee);
        return "redirect:/employees";
    }

    @IsEmployeeDelete
    @GetMapping("/employees/delete")
    public String deleteEmployee(@RequestParam int id) {
        employeeDao.deleteById(id);
        return "redirect:/employees";
    }


}
